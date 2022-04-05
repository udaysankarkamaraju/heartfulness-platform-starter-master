package org.heartfulness.starter.domain.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.heartfulness.starter.interfaces.grpc.GreenKhana.RepeatMode;
import org.heartfulness.starter.interfaces.grpc.GreenKhana.TaskPriority;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "supervisordetails")
public class SupervisorDetails {

    @Id
    private Integer supervisorId;

    @Column(name="supervisor_name")
    private String supervisorName;
    
    @Column(name="task_end_date")
    private String taskEndDate;
    
    @Column(name="repeat_mode")
    private RepeatMode repeatMode;

    @Column(name="task_priority")
    private TaskPriority taskPriority;

    @Column
    private String location;

    @Column(name="upload_photo")
    @Lob
    private ArrayList<String> uploadedPhotos; 
    
    @Column(name="upload_video")
    @Lob
    private ArrayList<String> uploadedVideos;

    @Column(name="voice_recorder")
    @Lob
    private ArrayList<String> uploadedAudios;

    @OneToMany(targetEntity=VisitorTask.class,cascade = CascadeType.ALL, 
            fetch = FetchType.LAZY, orphanRemoval = true)
    private List<VisitorTask> visitorTask = new ArrayList<VisitorTask>();

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
