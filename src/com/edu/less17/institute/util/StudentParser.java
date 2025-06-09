package com.edu.less17.institute.util;

import java.util.ArrayList;

import com.edu.less17.institute.model.Person;
import com.edu.less17.institute.model.Student;

public class StudentParser implements PersonParser {

	public String parseToString(Person person) {
		Student student = (Student) person;
		return String.format("%8s | %14s | %7s | %s", student.getClass().getSimpleName(), student.getName(),
				student.getGroup(), student.getGrades());
	}

	@Override
	public Student parseFromString(String personData) {
		Student student = new Student();
		String[] data = personData.split("\\|");
		student.setName(data[1].trim());
		student.setGroup(data[2].trim());
		if (!(data[3].trim().equals("null")||data[3].trim().equals("[]"))) {
			String[] gradesArray = data[3].trim().substring(1, data[3].trim().length() - 1).split(", ");
			ArrayList<Integer> grades = new ArrayList<Integer>();
			for (String s : gradesArray) {
				grades.add(Integer.valueOf(s));
			}
			student.setGrades(grades);
		}
		return student;
	}

}
