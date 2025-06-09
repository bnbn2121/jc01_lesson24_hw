package com.edu.less17.institute.util;

import java.util.HashMap;
import java.util.Map;

import com.edu.less17.institute.model.Administrator;
import com.edu.less17.institute.model.Student;
import com.edu.less17.institute.model.Teacher;

public class ParserFactory {

	private static Map<Class<?>, PersonParser> parserMap = new HashMap<>();

	private ParserFactory() {
	}

	public static PersonParser getParser(Class<?> personClass) throws IllegalArgumentException {
		if (personClass == Student.class) {
			if (!parserMap.containsKey(Student.class)) {
				parserMap.put(Student.class, new StudentParser());
			}
			return parserMap.get(Student.class);
		} else if (personClass == Administrator.class) {
			if (!parserMap.containsKey(Administrator.class)) {
				parserMap.put(Administrator.class, new AdministratorParser());
			}
			return parserMap.get(Administrator.class);
		} else if (personClass == Teacher.class) {
			if (!parserMap.containsKey(Teacher.class)) {
				parserMap.put(Teacher.class, new TeacherParser());
			}
			return parserMap.get(Teacher.class);
		}
		throw new IllegalArgumentException("Неизвестный тип Person: " + personClass.getSimpleName());
	}
}
