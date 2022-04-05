package org.heartfulness.starter.domain.service;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.heartfulness.starter.domain.model.VisitorTask;
import org.heartfulness.starter.dto.TaskManagerTaskDto;
import org.xml.sax.SAXException;

public interface TaskManagerService {

    VisitorTask createNewTask(TaskManagerTaskDto taskManagerTaskDto);
    
    VisitorTask uploadFiles(VisitorTask visitorTask, byte[] file, String fileExtension)
            throws IOException, ParserConfigurationException, SAXException;
}
