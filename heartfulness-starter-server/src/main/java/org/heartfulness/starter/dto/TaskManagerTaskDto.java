package org.heartfulness.starter.dto;

import java.util.ArrayList;
import java.util.List;

import org.heartfulness.starter.interfaces.grpc.GreenKhana.RepeatMode;
import org.heartfulness.starter.interfaces.grpc.GreenKhana.TaskPriority;

import com.google.protobuf.ByteString;

public class TaskManagerTaskDto {

    public String taskName;
    
    public String taskDescription;

    public ArrayList<String> subTaskDescription;

    public List<ByteString> uploadedPhotos; 
    
    public List<ByteString> uploadedVideos;

    public List<ByteString> uploadedAudios;

    public Integer supervisorId;

    public String supervisorName;
    
    public String taskEndDate;
    
    public RepeatMode repeatMode;

    public TaskPriority taskPriority;

    public String location;

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

    public ArrayList<String> getSubTaskDescription() {
        return subTaskDescription;
    }

    public void setSubTaskDescription(ArrayList<String> subTaskDescription) {
        this.subTaskDescription = subTaskDescription;
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

    public Integer getSupervisorId() {
        return supervisorId;
    }

    public void setSupervisorId(Integer supervisorId) {
        this.supervisorId = supervisorId;
    }

    public String getSupervisorName() {
        return supervisorName;
    }

    public void setSupervisorName(String supervisorName) {
        this.supervisorName = supervisorName;
    }

    public String getTaskEndDate() {
        return taskEndDate;
    }

    public void setTaskEndDate(String taskEndDate) {
        this.taskEndDate = taskEndDate;
    }

    public RepeatMode getRepeatMode() {
        return repeatMode;
    }

    public void setRepeatMode(RepeatMode repeatMode) {
        this.repeatMode = repeatMode;
    }

    public TaskPriority getTaskPriority() {
        return taskPriority;
    }

    public void setTaskPriority(TaskPriority taskPriority) {
        this.taskPriority = taskPriority;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

}
