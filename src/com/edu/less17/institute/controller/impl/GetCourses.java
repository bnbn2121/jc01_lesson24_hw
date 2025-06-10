package com.edu.less17.institute.controller.impl;

import java.util.List;

import com.edu.less17.institute.controller.Command;
import com.edu.less17.institute.model.TrainingCourse;
import com.edu.less17.institute.service.Service;
import com.edu.less17.institute.service.ServiceException;
import com.edu.less17.institute.service.ServiceProvider;
import com.edu.less17.institute.util.CourseParser;

public class GetCourses implements Command {
	private Service service = ServiceProvider.getService();

	@Override
	public String execute(String request) {
		String response = null;
		List<TrainingCourse> courses = null;
		try {
			courses = service.getCourses();
			response = CourseParser.getStringData(courses);
		} catch (ServiceException e) {
			response = "Error getting list of courses";
		}
		return response;
	}
}
