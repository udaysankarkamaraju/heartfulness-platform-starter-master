package org.heartfulness.starter.dto;

import java.util.ArrayList;

import org.heartfulness.starter.interfaces.grpc.GreenKhana.RepeatMode;
import org.heartfulness.starter.interfaces.grpc.GreenKhana.TaskPriority;

public class TaskManagerTaskDto {

    public String taskName;
    
    public String taskDescription;

    public ArrayList<String> subTaskDescription;

    public ArrayList<String> uploadedPhotos; 
    
    public ArrayList<String> uploadedVideos;

    public ArrayList<String> uploadedAudios;

    public Integer supervisorId;

    public String supervisorName;
    
    public Integer taskEndDate;
    
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

    public ArrayList<String> getUploadedPhotos() {
        return uploadedPhotos;
    }

    public void setUploadedPhotos(ArrayList<String> uploadedPhotos) {
        this.uploadedPhotos = uploadedPhotos;
    }

    public ArrayList<String> getUploadedVideos() {
        return uploadedVideos;
    }

    public void setUploadedVideos(ArrayList<String> uploadedVideos) {
        this.uploadedVideos = uploadedVideos;
    }

    public ArrayList<String> getUploadedAudios() {
        return uploadedAudios;
    }

    public void setUploadedAudios(ArrayList<String> uploadedAudios) {
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

    public Integer getTaskEndDate() {
        return taskEndDate;
    }

    public void setTaskEndDate(Integer taskEndDate) {
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
