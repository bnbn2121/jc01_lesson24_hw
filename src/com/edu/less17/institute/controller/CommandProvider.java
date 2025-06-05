package com.edu.less17.institute.controller;

import java.util.HashMap;
import java.util.Map;

import com.edu.less17.institute.controller.impl.AddCourse;
import com.edu.less17.institute.controller.impl.ConductLesson;
import com.edu.less17.institute.controller.impl.GetCourses;
import com.edu.less17.institute.controller.impl.RemoveCourseById;
import com.edu.less17.institute.util.StringParser;

public class CommandProvider {
	private final Map<CommandName, Command> map;
	
	public CommandProvider() {
		map = new HashMap<CommandName, Command>();
		map.put(CommandName.ADDCOURSE, new AddCourse());
		map.put(CommandName.CONDUCTLESSON, new ConductLesson());
		map.put(CommandName.GETCOURSES, new GetCourses());
		map.put(CommandName.REMOVECOURSEBYID, new RemoveCourseById());
	}
	
	public Command getCommand(String request) {
		CommandName commandName = CommandName.valueOf(StringParser.getCommandName(request).toUpperCase());
		Command command = map.get(commandName);
		return command;
	}
}
