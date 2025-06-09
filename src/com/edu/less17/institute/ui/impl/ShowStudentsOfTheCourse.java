package com.edu.less17.institute.ui.impl;

import com.edu.less17.institute.controller.CommandName;
import com.edu.less17.institute.ui.ConsoleCommand;
import com.edu.less17.institute.ui.ConsoleUI;

public class ShowStudentsOfTheCourse implements ConsoleCommand {

	@Override
	public String getStringRequest() {
		StringBuilder sb = new StringBuilder();
		int courseId = ConsoleUI.userIntInput("enter course id to show student", 9999);
		int choice = ConsoleUI.userIntInput("" + "1. by alphabet\n" + "2. by average grade\n", 2);
		if (choice == 1) {
			sb.append(CommandName.GETSTUDENTSBYALPHABET).append("\n");
		} else if (choice == 2) {
			sb.append(CommandName.GETSTUDENTSBYAVERAGEGRADE).append("\n");
		}
		sb.append(courseId);
		String request = sb.toString();
		return request;
	}
}
