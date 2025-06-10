package com.edu.less17.institute.controller.impl;

import com.edu.less17.institute.controller.Command;
import com.edu.less17.institute.model.Student;
import com.edu.less17.institute.model.TrainingCourse;
import com.edu.less17.institute.service.Service;
import com.edu.less17.institute.service.ServiceException;
import com.edu.less17.institute.service.ServiceProvider;
import com.edu.less17.institute.util.CommandParser;
import com.edu.less17.institute.util.ParserFactory;
import com.edu.less17.institute.util.PersonParser;

public class AddStudent implements Command {
	private Service service = ServiceProvider.getService();

	@Override
	public String execute(String request) {
		String response = null;
		String data = CommandParser.getCommandData(request);
		String[] dataArray = data.split("\n");
		PersonParser parser = ParserFactory.getParser(Student.class);
		Student student = (Student) parser.parseFromString(dataArray[0]);
		int courseId = Integer.valueOf(dataArray[1].trim());
		try {
			TrainingCourse course = service.getCourseById(courseId);
			if (course == null) {
				response = "not correct id";
			} else {
				service.addStudent(student, course);
				service.saveCourse(course);
				response = "Student added";
			}
		} catch (ServiceException e) {
			response = "Failed to add student";
		}
		return response;
	}

}
