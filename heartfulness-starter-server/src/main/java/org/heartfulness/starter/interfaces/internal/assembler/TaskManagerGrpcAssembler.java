package org.heartfulness.starter.interfaces.internal.assembler;

import java.util.ArrayList;
import java.util.List;

import org.heartfulness.starter.domain.model.VisitorTask;
import org.heartfulness.starter.dto.TaskManagerTaskDto;
import org.heartfulness.starter.interfaces.grpc.GreenKhana;
import org.heartfulness.starter.interfaces.grpc.GreenKhana.TaskManagerTaskPostResponse;
import org.springframework.util.StringUtils;

public class TaskManagerGrpcAssembler {

    public static TaskManagerTaskDto fromGrpc(GreenKhana.CreateNewTaskPost grpcTMTask) {
        TaskManagerTaskDto taskManagerTaskDto = new TaskManagerTaskDto();
        
        if(!StringUtils.isEmpty(grpcTMTask.getTaskName())) {
            taskManagerTaskDto.setTaskName(grpcTMTask.getTaskName());
        }

        if(!StringUtils.isEmpty(grpcTMTask.getTaskDescription())) {
            taskManagerTaskDto.setTaskDescription(grpcTMTask.getTaskDescription());
        }

        if(!StringUtils.isEmpty(grpcTMTask.getUploadPhotoList())) {
            taskManagerTaskDto.setUploadedPhotos(grpcTMTask.getUploadPhotoList());
        }
        
        if(!StringUtils.isEmpty(grpcTMTask.getUploadVideoList())) {
            taskManagerTaskDto.setUploadedVideos(grpcTMTask.getUploadVideoList());
        }
        
        if(!StringUtils.isEmpty(grpcTMTask.getVoiceRecorderList())) {
            taskManagerTaskDto.setUploadedAudios(grpcTMTask.getVoiceRecorderList());
        }
        
        if(!StringUtils.isEmpty(grpcTMTask.getSubTaskDescriptionList())) {
            ArrayList<String> alist = new ArrayList<>();
            alist.addAll(grpcTMTask.getSubTaskDescriptionList());
            taskManagerTaskDto.setSubTaskDescription(alist);
        }
        if(!StringUtils.isEmpty(grpcTMTask.getSupervisorId())) {
            taskManagerTaskDto.setSupervisorId(grpcTMTask.getSupervisorId());
        }
        if(!StringUtils.isEmpty(grpcTMTask.getSupervisorName())) {
        taskManagerTaskDto.setSupervisorName(grpcTMTask.getSupervisorName());
        }
        if(!StringUtils.isEmpty(grpcTMTask.getLocation())) {
        taskManagerTaskDto.setLocation(grpcTMTask.getLocation());
        }
        if(!StringUtils.isEmpty(grpcTMTask.getRepeatMode())) {
        taskManagerTaskDto.setRepeatMode(grpcTMTask.getRepeatMode());
        }
        if(!StringUtils.isEmpty(grpcTMTask.getTaskEndDate())) {
        taskManagerTaskDto.setTaskEndDate(grpcTMTask.getTaskEndDate());
        }
        if(!StringUtils.isEmpty(grpcTMTask.getTaskPriority())) {
        taskManagerTaskDto.setTaskPriority(grpcTMTask.getTaskPriority());
        }
        return taskManagerTaskDto;
    }

    public static TaskManagerTaskPostResponse toGrpc(VisitorTask visitorTask) {
        return GreenKhana.TaskManagerTaskPostResponse.newBuilder()
                .setTaskId(visitorTask.getTaskId()).build();
    }

}
