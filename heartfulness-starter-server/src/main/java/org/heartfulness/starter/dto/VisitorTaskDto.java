package org.heartfulness.starter.dto;

import java.util.ArrayList;
import java.util.List;

import com.google.protobuf.ByteString;

public class VisitorTaskDto {

    private String taskName;
    
    private String taskDescription;
    
    private List<ByteString> uploadedPhotos; 
    
    private List<ByteString> uploadedVideos;
    
    private List<ByteString> uploadedAudios;

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getTaskDescription() {
		return taskDescription;
	}

	public void setTaskDescription(String taskDescription) {
		this.taskDescription = taskDescription;
	}

	public List<ByteString> getUploadedPhotos() {
		return uploadedPhotos;
	}

	public void setUploadedPhotos(List<ByteString> uploadedPhotos) {
		this.uploadedPhotos = uploadedPhotos;
	}

	public List<ByteString> getUploadedVideos() {
		return uploadedVideos;
	}

	public void setUploadedVideos(List<ByteString> uploadedVideos) {
		this.uploadedVideos = uploadedVideos;
	}

	public List<ByteString> getUploadedAudios() {
		return uploadedAudios;
	}

	public void setUploadedAudios(List<ByteString> uploadedAudios) {
		this.uploadedAudios = uploadedAudios;
	}
   
    
}
