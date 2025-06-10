package com.edu.less17.institute.controller.impl;

import com.edu.less17.institute.controller.Command;
import com.edu.less17.institute.model.TrainingCourse;
import com.edu.less17.institute.service.Service;
import com.edu.less17.institute.service.ServiceException;
import com.edu.less17.institute.service.ServiceProvider;
import com.edu.less17.institute.util.CommandParser;

public class RemoveCourseById implements Command {
	private Service service = ServiceProvider.getService();

	@Override
	public String execute(String request) {
		String response = null;
		String data = CommandParser.getCommandData(request);
		int id = Integer.valueOf(data.trim());
		try {
			TrainingCourse course = service.getCourseById(id);
			if (course == null) {
				response = "not correct id";
			} else {
				service.removeCourseById(id);
				response = "course removed";
			}
		} catch (ServiceException e) {
			response = "failed to delete course";
		}
		return response;
	}
}
