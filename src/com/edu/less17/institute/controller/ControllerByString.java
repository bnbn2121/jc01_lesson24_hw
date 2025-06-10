package com.edu.less17.institute.controller;

public class ControllerByString {
	private static final ControllerByString controller = new ControllerByString();
	private static final CommandProvider commandProvider = new CommandProvider();

	public ControllerByString() {
	}

	public static ControllerByString getController() {
		return controller;
	}

	public String doAction(String request) {
		Command command = commandProvider.getCommand(request);
		String response = command.execute(request);
		return response;
	}
}
