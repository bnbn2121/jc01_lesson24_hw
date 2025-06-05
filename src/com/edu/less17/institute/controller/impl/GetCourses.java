package com.edu.less17.institute.controller.impl;

import com.edu.less17.institute.controller.Command;
import com.edu.less17.institute.service.Service;
import com.edu.less17.institute.service.ServiceException;
import com.edu.less17.institute.service.ServiceProvider;

public class GetCourses implements Command {
	private Service service = ServiceProvider.getService();

	@Override
	public String execute(String request) {
		String response = null;
		try {
		service.getCourses();
		response = "Получен список курсов";
		} catch (ServiceException e) {
			response = "Ошибка при получении списка курсов";
		}
		return response;
	}
}
