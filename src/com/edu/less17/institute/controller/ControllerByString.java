package com.edu.less17.institute.controller;


public class ControllerByString {
	private final CommandProvider commandProvider = new CommandProvider();

	public String doAction(String request) {
		Command command = commandProvider.getCommand(request);
		String response = command.execute(request);
		return response;
	}
}
