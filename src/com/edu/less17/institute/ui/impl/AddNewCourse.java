package com.edu.less17.institute.ui.impl;

import com.edu.less17.institute.controller.CommandName;
import com.edu.less17.institute.ui.ConsoleCommand;
import com.edu.less17.institute.ui.ConsoleUI;

public class AddNewCourse implements ConsoleCommand{

	@Override
	public String getStringRequest() {
			StringBuilder sb = new StringBuilder();
			sb.append(CommandName.SAVECOURSE).append("\n");
			sb.append("Course data:\n");
			int id = ConsoleUI.userIntInput("enter id:", 9999);
			String specialization = ConsoleUI.userStringInput("enter specialization:");
			sb.append(String.format("id: %d\n", id));
			sb.append(String.format("specialization: %s\n", specialization));
			sb.append("***\n\n");
			String request = sb.toString();
			return request;
	}

}
