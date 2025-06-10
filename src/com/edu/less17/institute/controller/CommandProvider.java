package com.edu.less17.institute.controller;

import java.util.HashMap;
import java.util.Map;

import com.edu.less17.institute.controller.impl.*;
import com.edu.less17.institute.util.CommandParser;

public class CommandProvider {
	private final Map<CommandName, Command> map;

	public CommandProvider() {
		map = new HashMap<CommandName, Command>();
		map.put(CommandName.SAVECOURSE, new SaveCourse());
		map.put(CommandName.CONDUCTLESSON, new ConductLesson());
		map.put(CommandName.GETCOURSES, new GetCourses());
		map.put(CommandName.REMOVECOURSEBYID, new RemoveCourseById());
		map.put(CommandName.GETSTUDENTSBYALPHABET, new GetStudentsByAlphabet());
		map.put(CommandName.GETSTUDENTSBYAVERAGEGRADE, new GetStudentsByAverageGrade());
		map.put(CommandName.GETCOURSEBYID, new GetCourseById());
		map.put(CommandName.ADDSTUDENT, new AddStudent());
	}

	public Command getCommand(String request) {
		CommandName commandName = CommandName.valueOf(CommandParser.getCommandName(request).toUpperCase());
		Command command = map.get(commandName);
		return command;
	}
}
