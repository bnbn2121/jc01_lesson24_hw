package com.edu.less17.institute.controller.impl;

import com.edu.less17.institute.controller.Command;
import com.edu.less17.institute.service.Service;
import com.edu.less17.institute.service.ServiceException;
import com.edu.less17.institute.service.ServiceProvider;
import com.edu.less17.institute.util.StringParser;

public class RemoveCourseById implements Command{
	private Service service = ServiceProvider.getService();
	
	@Override
	public String execute(String request) {
		String response = null;
		String data = StringParser.getCommandData(request);
		int id = Integer.valueOf(data.trim());
		try {
		service.removeCourseById(id);
		response = "курс удален";
		} catch (ServiceException e) {
			response = "не удалось удалить курс";
		}
		return response;
	}
}
