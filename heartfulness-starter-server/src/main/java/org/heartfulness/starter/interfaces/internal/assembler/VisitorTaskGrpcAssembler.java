package org.heartfulness.starter.interfaces.internal.assembler;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.heartfulness.starter.domain.model.VisitorTask;
import org.heartfulness.starter.dto.VisitorTaskDto;
import org.heartfulness.starter.interfaces.grpc.GreenKhana;
import org.heartfulness.starter.interfaces.grpc.GreenKhana.VisitorTaskGetResponse;
import org.heartfulness.starter.interfaces.grpc.GreenKhana.VisitorTaskList;
import org.heartfulness.starter.interfaces.grpc.GreenKhana.VisitorTaskPostRequest;
import org.heartfulness.starter.interfaces.grpc.GreenKhana.VisitorTaskPostResponse;
import org.springframework.util.StringUtils;

public class VisitorTaskGrpcAssembler {

    public static VisitorTaskPostResponse toGrpc(VisitorTask visitorTask) {
        return GreenKhana.VisitorTaskPostResponse.newBuilder()
        		.setTaskId(visitorTask.getTaskId()).build();

    }

    public static VisitorTaskGetResponse toGrpc(List<VisitorTask> visitorTasks) {
    	
    	List<VisitorTaskList> aList = new ArrayList<>();

    	for(VisitorTask vtList : visitorTasks) {
    		aList.add(VisitorTaskList.newBuilder()
    		.setTaskId(vtList.getTaskId())
    		.setTaskName(vtList.getTaskName())
    		.setTaskDescription(vtList.getTaskDescription())
    		.setTaskmanagerName("")
    		.setTaskmanagerCommentDate("")
    		.setTaskmanagerComments("")
    		.addAllUploadPhoto(vtList.getUploadedPhotos())
    		.addAllUploadVideo(vtList.getUploadedVideos())
    		.addAllVoiceRecorder(vtList.getUploadedAudios()).build());
    	}
        return GreenKhana.VisitorTaskGetResponse.newBuilder().addAllMyTaskRequest(aList).build();
    }

    public static VisitorTaskDto fromGrpc(GreenKhana.VisitorTaskPostRequest grpcVisitorTask) {
    	VisitorTaskDto visitorTaskDto = new VisitorTaskDto();

        if(!StringUtils.isEmpty(grpcVisitorTask.getTaskName())) {
        	visitorTaskDto.setTaskName(grpcVisitorTask.getTaskName());
        }

        if(!StringUtils.isEmpty(grpcVisitorTask.getTaskDescription())) {
        	visitorTaskDto.setTaskDescription(grpcVisitorTask.getTaskDescription());
        }

        if(!StringUtils.isEmpty(grpcVisitorTask.getUploadPhotoList())) {
        	visitorTaskDto.setUploadedPhotos(grpcVisitorTask.getUploadPhotoList());
        }
        
        if(!StringUtils.isEmpty(grpcVisitorTask.getUploadVideoList())) {
        	visitorTaskDto.setUploadedVideos(grpcVisitorTask.getUploadVideoList());
        }
        
        if(!StringUtils.isEmpty(grpcVisitorTask.getVoiceRecorderList())) {
        	visitorTaskDto.setUploadedAudios(grpcVisitorTask.getVoiceRecorderList());
        }
        
        return visitorTaskDto;
    }
}
