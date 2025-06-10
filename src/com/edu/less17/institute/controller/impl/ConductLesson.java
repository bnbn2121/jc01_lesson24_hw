package com.edu.less17.institute.controller.impl;

import com.edu.less17.institute.controller.Command;
import com.edu.less17.institute.service.Service;
import com.edu.less17.institute.service.ServiceException;
import com.edu.less17.institute.service.ServiceProvider;
import com.edu.less17.institute.util.CommandParser;

public class ConductLesson implements Command {
	private Service service = ServiceProvider.getService();

	@Override
	public String execute(String request) {
		String response = null;
		String data = CommandParser.getCommandData(request);
		int id = Integer.valueOf(data.trim());
		try {
			response = service.conductLesson(id);
		} catch (ServiceException e) {
			response = "failed to conduct the lesson";
		}
		return response;
	}
}
