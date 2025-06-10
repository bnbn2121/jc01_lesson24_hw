package com.edu.less17.institute.controller.impl;

import com.edu.less17.institute.controller.Command;
import com.edu.less17.institute.model.TrainingCourse;
import com.edu.less17.institute.service.Service;
import com.edu.less17.institute.service.ServiceException;
import com.edu.less17.institute.service.ServiceProvider;
import com.edu.less17.institute.util.CommandParser;
import com.edu.less17.institute.util.CourseParser;

public class GetStudentsByAverageGrade implements Command {
	private Service service = ServiceProvider.getService();

	@Override
	public String execute(String request) {
		StringBuilder sb = new StringBuilder();
		String response = null;
		String data = CommandParser.getCommandData(request);
		int id = Integer.valueOf(data.trim());
		TrainingCourse course = null;
		try {
			course = service.getCourseById(id);
			sb.append("students by alphabet:\n");
			sb.append(CourseParser.getStringStudents(service.getStudentsByAverageGrade(course)));
			response = sb.toString();
		} catch (ServiceException e) {
			response = "failed to get list of students";
		}
		return response;
	}
}
