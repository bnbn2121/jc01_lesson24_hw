package com.edu.less17.institute.util;

import com.edu.less17.institute.model.Person;
import com.edu.less17.institute.model.Teacher;

public class TeacherParser implements PersonParser {

	@Override
	public String parseToString(Person person) {
		Teacher teacher = (Teacher) person;
		return String.format("%15s | %s | %s", teacher.getClass().getSimpleName(), teacher.getName(),
				teacher.getSpecialization());
	}

	@Override
	public Teacher parseFromString(String personData) {
		Teacher teacher = new Teacher();
		String[] data = personData.split("\\|");
		teacher.setName(data[1].trim());
		teacher.setSpecialization(data[2].trim());
		return teacher;
	}
}
