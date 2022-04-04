package org.heartfulness.starter.domain.service;

import org.heartfulness.starter.domain.model.VisitorTask;
import org.heartfulness.starter.dto.TaskManagerTaskDto;

public interface TaskManagerService {

    VisitorTask createNewTask(TaskManagerTaskDto taskManagerTaskDto);
    
    
}
