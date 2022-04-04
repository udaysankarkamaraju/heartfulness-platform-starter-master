package org.heartfulness.starter.domain.service;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.xml.parsers.ParserConfigurationException;

import org.heartfulness.starter.domain.exception.ErrorCode;
import org.heartfulness.starter.domain.exception.InvalidRequestException;
import org.heartfulness.starter.domain.model.VisitorTask;
import org.heartfulness.starter.domain.model.VisitorTaskRepository;
import org.heartfulness.starter.dto.VisitorTaskDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.xml.sax.SAXException;

import com.google.protobuf.ByteString;

@Service
public class VisitorTaskServiceImpl implements VisitorTaskService{

    @Autowired
    CloudStorageService cloudStorageService;

    @Autowired
    VisitorTaskRepository visitorTaskRepository;

	@Override
	public VisitorTask add(VisitorTaskDto task) {
		VisitorTask visitorTask = new VisitorTask();
		visitorTask.setTaskName(task.getTaskName());
		visitorTask.setTaskDescription(task.getTaskDescription());
		visitorTask.setUploadedPhotos(new ArrayList<String>());
		visitorTask.setUploadedVideos(new ArrayList<String>());
		visitorTask.setUploadedAudios(new ArrayList<String>());
		visitorTask = mediaUpload(task, visitorTask);

		return visitorTaskRepository.save(visitorTask);
		

	}

    private VisitorTask mediaUpload(VisitorTaskDto task, VisitorTask visitorTask) {
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
			// TODO Auto-generated catch block
			e.printStackTrace();
			//throw new InvalidRequestException(ErrorCode.MEDIA_FAILURE, "Media cannot be added .");
		}
        return visitorTask;
    }

	@Override
	public VisitorTask delete(Long taskId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VisitorTask get(Long taskId) {
		// TODO Auto-generated method stub
		Optional<VisitorTask> visitorTask = visitorTaskRepository.findById(taskId);
		return visitorTask.get();
	}

	@Override
	public List<VisitorTask> getAllTasks() {
		List<VisitorTask> visitorTask = (List<VisitorTask>) visitorTaskRepository.findAll();
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
