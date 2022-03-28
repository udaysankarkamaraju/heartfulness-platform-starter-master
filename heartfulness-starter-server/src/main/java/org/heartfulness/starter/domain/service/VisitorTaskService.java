package org.heartfulness.starter.domain.service;

import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.heartfulness.starter.domain.model.VisitorTask;
import org.heartfulness.starter.dto.VisitorTaskDto;
import org.xml.sax.SAXException;

public interface VisitorTaskService {

	VisitorTask add(VisitorTaskDto task);

	VisitorTask delete(Long taskId);

	VisitorTask get(Long taskId);

	List<VisitorTask> getAllTasks();

	VisitorTask uploadFiles(VisitorTask visitorTask, byte[] file, String fileExtension)
			throws IOException, ParserConfigurationException, SAXException;

}
