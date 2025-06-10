package com.edu.less17.institute.controller.impl;

import com.edu.less17.institute.controller.Command;
import com.edu.less17.institute.model.TrainingCourse;
import com.edu.less17.institute.service.Service;
import com.edu.less17.institute.service.ServiceException;
import com.edu.less17.institute.service.ServiceProvider;
import com.edu.less17.institute.util.CommandParser;
import com.edu.less17.institute.util.CourseParser;

public class GetCourseById implements Command {
	private Service service = ServiceProvider.getService();

	@Override
	public String execute(String request) {
		String response = null;
		String data = CommandParser.getCommandData(request);
		int id = Integer.valueOf(data.trim());
		TrainingCourse course = null;
		try {
			course = service.getCourseById(id);
			response = CourseParser.getStringData(course);
			if (response == null) {
				response = "not correct data";
			}
		} catch (ServiceException e) {
			response = "failed to get the course";
		}
		return response;
	}

}
