package org.heartfulness.starter.domain.service;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

import javax.xml.parsers.ParserConfigurationException;

import org.heartfulness.starter.domain.model.SupervisorDetails;
import org.heartfulness.starter.domain.model.SupervisorDetailsRepository;
import org.heartfulness.starter.domain.model.VisitorTask;
import org.heartfulness.starter.domain.model.VisitorTaskRepository;
import org.heartfulness.starter.dto.TaskManagerTaskDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.xml.sax.SAXException;

import com.google.protobuf.ByteString;

@Service
public class TaskManagerServiceImpl implements TaskManagerService{

    @Autowired
    CloudStorageService cloudStorageService;

    @Autowired
    VisitorTaskRepository visitorTaskRepository;
    
    @Autowired
    SupervisorDetailsRepository supervisorDetailsRepository;

    @Override
    public VisitorTask createNewTask(TaskManagerTaskDto taskManagerTaskDto) {
        
        VisitorTask visitorTask = new VisitorTask();
        SupervisorDetails supervisorDetails=new SupervisorDetails();
        visitorTask.setTaskName(taskManagerTaskDto.getTaskName());
        visitorTask.setTaskDescription(taskManagerTaskDto.getTaskDescription());
        visitorTask.setUploadedPhotos(new ArrayList<String>());
        visitorTask.setUploadedVideos(new ArrayList<String>());
        visitorTask.setUploadedAudios(new ArrayList<String>());
        visitorTask.setSubTaskDescription(taskManagerTaskDto.getSubTaskDescription());
        supervisorDetails.setSupervisorId(taskManagerTaskDto.getSupervisorId());
        supervisorDetails.setSupervisorName(taskManagerTaskDto.getSupervisorName());
        supervisorDetails.setTaskEndDate(taskManagerTaskDto.getTaskEndDate());
        supervisorDetails.setRepeatMode(taskManagerTaskDto.getRepeatMode());
        supervisorDetails.setTaskPriority(taskManagerTaskDto.getTaskPriority());
        supervisorDetails.setLocation(taskManagerTaskDto.getLocation());
        visitorTask.setSupervisorDetails(supervisorDetailsRepository.save(supervisorDetails));
        visitorTask = mediaUpload(taskManagerTaskDto, visitorTask);
        
        visitorTask = visitorTaskRepository.save(visitorTask);
        return visitorTask;
    }

    private VisitorTask mediaUpload(TaskManagerTaskDto task, VisitorTask visitorTask) {
        try {
        for(ByteString file: task.getUploadedPhotos()) {
                visitorTask = uploadFiles(visitorTask, file.toByteArray(), "jpeg");
        }
        for(ByteString file: task.getUploadedVideos()) {

                visitorTask = uploadFiles(visitorTask, file.toByteArray(), "mp4");

        }
        for(ByteString file: task.getUploadedAudios()) {

                visitorTask = uploadFiles(visitorTask, file.toByteArray(), "mp3");

        }
        } catch (IOException | ParserConfigurationException | SAXException e) {

            e.printStackTrace();
            //throw new InvalidRequestException(ErrorCode.MEDIA_FAILURE, "Media cannot be added .");
        }
        return visitorTask;
    }

    @Override
    @Transactional
    public VisitorTask uploadFiles(VisitorTask visitorTask, byte[] file, String fileExtension)
            throws IOException, ParserConfigurationException, SAXException {

        String fileName = UUID.randomUUID().toString() + "." + fileExtension;
        cloudStorageService.uploadToCloudStorage(fileName, new ByteArrayInputStream(file), true);

        String url = cloudStorageService.getFileURL(fileName);
        if(fileExtension.equals("jpeg")) {
            visitorTask.getUploadedPhotos().add(url);
        } else if(fileExtension.equals("mp4")) {

            visitorTask.getUploadedVideos().add(url);
        } else if(fileExtension.equals("mp3")) {
  
            visitorTask.getUploadedAudios().add(url);
        }
        return visitorTask;
    }

}
