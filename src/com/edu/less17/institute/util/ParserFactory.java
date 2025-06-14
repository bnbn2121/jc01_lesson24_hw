package com.edu.less17.institute.util;

import java.util.HashMap;
import java.util.Map;

import com.edu.less17.institute.model.Administrator;
import com.edu.less17.institute.model.Student;
import com.edu.less17.institute.model.Teacher;

public class ParserFactory {

	private static Map<Class<?>, PersonParser> parserMap = new HashMap<>();
	
	static {
		parserMap.put(Student.class, new StudentParser());
		parserMap.put(Administrator.class, new AdministratorParser());
		parserMap.put(Teacher.class, new TeacherParser());
	}

	private ParserFactory() {
	}
	
	public static void registerNewParser(Class<?> personClass, PersonParser parser) {
		parserMap.put(personClass, parser);
	}

	public static PersonParser getParser(Class<?> personClass) {
		return parserMap.get(personClass);
	}
}
