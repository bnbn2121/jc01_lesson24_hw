package com.edu.less17.institute.ui;

import java.util.Scanner;

import com.edu.less17.institute.controller.ControllerByString;

public class ConsoleUI {
	private static ConsoleUI console;
    private ControllerByString controller;
    private static Scanner scanner = new Scanner(System.in);
    private ConsoleCommandProvider consoleCommandProvider;

    private ConsoleUI() {
        this.controller = ControllerByString.getController();
        this.consoleCommandProvider = new ConsoleCommandProvider();
    }

    public static ConsoleUI getConsoleUI() {
        if (console == null) {
            console = new ConsoleUI();
        }
        return console;
    }

	public void start() {
		while (true) {
			System.out.println("\nMenu:");
			System.out.println("1.Add new course");
			System.out.println("2.Show available courses");
			System.out.println("3.Show course by id");
			System.out.println("4.Remove course by id");
			System.out.println("5.Add student to course");
			System.out.println("6.Show students of the course");
			System.out.println("0.Exit");

			int input = userIntInput("enter value:", 6);
			if (input == 0) {
				System.out.println("App stopped");
				break;
			} else {
				String request = consoleCommandProvider.getCommand(input).getStringRequest();
				System.out.println(controller.doAction(request));
			}
		}

	}

	public static String userStringInput(String message) {
		if (message != null) {
			System.out.println(message);
		}
		String input = scanner.nextLine();
		return input;
	}

	public static int userIntInput(String message, int limitMenu) {
		if (message != null) {
			System.out.println(message);
		}
		int input = -1;
		while (true) {
			while (!scanner.hasNextInt()) {
				scanner.nextLine();
			}
			input = scanner.nextInt();
			if (input >= 0 && input <= limitMenu) {
				scanner.nextLine();
				return input;
			} else {
				scanner.nextLine();
				System.out.println("Incorrect input");
			}
		}
	}

}
