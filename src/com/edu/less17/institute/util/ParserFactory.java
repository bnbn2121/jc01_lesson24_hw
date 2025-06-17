package com.edu.less17.institute.util;

import java.util.HashMap;
import java.util.Map;

public class ParserFactory {

	private static Map<PersonType, PersonParser> parserMap = new HashMap<>();
	
	public static enum PersonType {
		STUDENT,
		TEACHER,
		ADMINISTRATOR;
		
		public static boolean contains(String value) {
	        for (PersonType type : PersonType.values()) {
	            if (type.name().equals(value)) {
	                return true;
	            }
	        }
	        return false;
	    }
	}
	
	static {
		parserMap.put(PersonType.STUDENT, new StudentParser());
		parserMap.put(PersonType.ADMINISTRATOR, new AdministratorParser());
		parserMap.put(PersonType.TEACHER, new TeacherParser());
	}

	private ParserFactory() {
	}
	
	public static void registerNewParser(PersonType personType, PersonParser parser) {
		parserMap.put(personType, parser);
	}

	public static PersonParser getParser(PersonType personType) {
		return parserMap.get(personType);
	}
}
