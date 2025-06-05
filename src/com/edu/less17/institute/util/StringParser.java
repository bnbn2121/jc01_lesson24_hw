package com.edu.less17.institute.util;

public class StringParser {
	public static String getCommandName(String request) {
		String delimeter = "\n";
		String commandName = request.substring(0,request.indexOf(delimeter));
		return commandName;
	}
	public static String getCommandData(String request) {
		String delimeter = "\n";
		String command = request.substring(request.indexOf(delimeter)+1);
		return command;
	}
	
	
}
