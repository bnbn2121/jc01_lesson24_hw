package com.edu.less17.institute.ui.impl;

import com.edu.less17.institute.controller.CommandName;
import com.edu.less17.institute.ui.ConsoleCommand;
import com.edu.less17.institute.ui.ConsoleUI;

public class RemoveCourseById implements ConsoleCommand {

	@Override
	public String getStringRequest() {
		StringBuilder sb = new StringBuilder();
		sb.append(CommandName.REMOVECOURSEBYID).append("\n");
		sb.append(ConsoleUI.userIntInput("enter course id:", 9999));
		String request = sb.toString();
		return request;
	}

}
