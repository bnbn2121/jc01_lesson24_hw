package com.edu.less17.institute.controller.impl;

import com.edu.less17.institute.controller.Command;
import com.edu.less17.institute.model.TrainingCourse;
import com.edu.less17.institute.service.Service;
import com.edu.less17.institute.service.ServiceException;
import com.edu.less17.institute.service.ServiceProvider;
import com.edu.less17.institute.util.CommandParser;
import com.edu.less17.institute.util.CourseParser;

public class SaveCourse implements Command {
	private Service service = ServiceProvider.getService();

	@Override
	public String execute(String request) {
		String response = null;
		String data = CommandParser.getCommandData(request);
		TrainingCourse course = CourseParser.getCourseFromString(data);
		try {
			service.saveCourse(course);
			response = "Курс добавлен";
		} catch (ServiceException e) {
			response = "Ошибка при добавлении курса";
		}
		return response;
	}

}
