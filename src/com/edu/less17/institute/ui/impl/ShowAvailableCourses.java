package com.edu.less17.institute.ui.impl;

import com.edu.less17.institute.controller.CommandName;
import com.edu.less17.institute.ui.ConsoleCommand;

public class ShowAvailableCourses implements ConsoleCommand {

	@Override
	public String getStringRequest() {
		StringBuilder sb = new StringBuilder();
		sb.append(CommandName.GETCOURSES);
		String request = sb.toString();
		return request;
	}

}
