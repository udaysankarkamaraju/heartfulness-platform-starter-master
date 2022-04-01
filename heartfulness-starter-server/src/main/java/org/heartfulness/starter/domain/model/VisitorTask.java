package org.heartfulness.starter.domain.model;

import java.time.Instant;
import java.util.ArrayList;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import org.heartfulness.starter.util.InstantToLongConverter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class VisitorTask {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long taskId;

    @Column(name="task_name")
    private String taskName;
    
    @Column(name="task_description")
    private String taskDescription;

    @Column(name="task_createdby")
    private String taskCreatedBy;

    @Column(name = "created_date", updatable = false)
    @CreatedDate
    @Convert(converter = InstantToLongConverter.class)
    private Instant createdDate;

    @Column(name = "completed_date")
    @Convert(converter = InstantToLongConverter.class)
    private Instant completedDate;

    @Column(name="upload_photo")
    @Lob
    private ArrayList<String> uploadedPhotos; 
    
    @Column(name="upload_video")
    @Lob
    private ArrayList<String> uploadedVideos;

    @Column(name="voice_recorder")
    @Lob
    private ArrayList<String> uploadedAudios;

	public Long getTaskId() {
		return taskId;
	}

	public void setTaskId(Long taskId) {
		this.taskId = taskId;
	}

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

}
