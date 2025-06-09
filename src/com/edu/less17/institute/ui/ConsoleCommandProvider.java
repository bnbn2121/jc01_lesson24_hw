package com.edu.less17.institute.ui;

import java.util.HashMap;
import java.util.Map;

import com.edu.less17.institute.ui.impl.AddNewCourse;
import com.edu.less17.institute.ui.impl.AddStudentToCourse;
import com.edu.less17.institute.ui.impl.RemoveCourseById;
import com.edu.less17.institute.ui.impl.ShowAvailableCourses;
import com.edu.less17.institute.ui.impl.ShowCourseById;
import com.edu.less17.institute.ui.impl.ShowStudentsOfTheCourse;

public class ConsoleCommandProvider {
private final Map<Integer, ConsoleCommand> map;
	
	public ConsoleCommandProvider() {
		map = new HashMap<Integer, ConsoleCommand>();
		map.put(1, new AddNewCourse());
		map.put(2, new ShowAvailableCourses());
		map.put(3, new ShowCourseById());
		map.put(4, new RemoveCourseById());
		map.put(5, new AddStudentToCourse());
		map.put(6, new ShowStudentsOfTheCourse());
		
	}
	
	public ConsoleCommand getCommand(int id) {
		ConsoleCommand command = map.get(id);
		return command;
	}
}
