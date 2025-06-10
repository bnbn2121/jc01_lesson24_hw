package com.edu.less17.institute.util;

public class CommandParser {
	public static String getCommandName(String request) {
		String commandName = request;
		String delimeter = "\n";
		int indexDelimeter = request.indexOf(delimeter);
		if (indexDelimeter != -1) {
			commandName = request.substring(0, request.indexOf(delimeter));
		}
		return commandName;
	}

	public static String getCommandData(String request) {
		String command = null;
		String delimeter = "\n";
		int indexDelimeter = request.indexOf(delimeter);
		if (indexDelimeter != -1) {
			command = request.substring(request.indexOf(delimeter) + 1);
		}
		return command;
	}

}
