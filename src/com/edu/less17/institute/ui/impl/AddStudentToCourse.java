package com.edu.less17.institute.ui.impl;

import com.edu.less17.institute.controller.CommandName;
import com.edu.less17.institute.model.Student;
import com.edu.less17.institute.ui.ConsoleCommand;
import com.edu.less17.institute.ui.ConsoleUI;

public class AddStudentToCourse implements ConsoleCommand {

	@Override
	public String getStringRequest() {
		StringBuilder sb = new StringBuilder();
		sb.append(CommandName.ADDSTUDENT).append("\n");
		String studentName = ConsoleUI.userStringInput("enter student's name");
		String studentGroup = ConsoleUI.userStringInput("enter student's group");
		sb.append(String.format("%8s | %14s | %7s | %.1f | %s", Student.class.getSimpleName(), studentName,
				studentGroup, null, null));
		sb.append("\n");
		int courseId = ConsoleUI.userIntInput("enter course id to add student", 9999);
		sb.append(courseId);
		String request = sb.toString();
		return request;
	}

}
