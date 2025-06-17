package com.edu.less17.institute.util;

import java.util.List;

import com.edu.less17.institute.model.CourseMember;
import com.edu.less17.institute.model.Listener;
import com.edu.less17.institute.model.Person;
import com.edu.less17.institute.model.Staff;
import com.edu.less17.institute.model.TrainingCourse;
import com.edu.less17.institute.util.ParserFactory.PersonType;

public class CourseParser {
	private CourseParser() {
	}

	public static TrainingCourse getCourseFromString(String stringCourseData) {
		if (stringCourseData == null) {
			return null;
		}
		TrainingCourse course = new TrainingCourse();
		String[] dataArray = stringCourseData.split("\n");
		for (String oneLine : dataArray) {
			oneLine = oneLine.trim();
			if (oneLine.startsWith("id")) {
				course.setId(Integer.valueOf(oneLine.substring(4)));
				continue;
			}
			if (oneLine.startsWith("specialization")) {
				course.setSpecialization(oneLine.substring(16));
				continue;
			}
			String startLineWith = oneLine.split("\\|")[0].trim().toUpperCase();
			if (PersonType.contains(startLineWith)) {
				CourseMember member = ParserFactory.getParser(PersonType.valueOf(startLineWith))
						.parseFromString(oneLine);
				course.addCourseMember(member);
				continue;
			}
		}
		return course;
	}

	public static String getStringData(TrainingCourse course) {
		if (course == null) {
			return null;
		}
		StringBuilder sb = new StringBuilder();
		sb.append("Course data:\n");
		sb.append(String.format("id: %d\n", course.getId()));
		sb.append(String.format("specialization: %s\n", course.getSpecialization()));
		sb.append("staff:\n");
		for (CourseMember s : course.getCourseMembers()) {
			if (s instanceof Staff) {
				PersonType type = PersonType.valueOf(s.getClass().getSimpleName().toUpperCase());
				sb.append(ParserFactory.getParser(type).parseToString((Person) s)).append("\n");
			}
		}
		sb.append("students:\n");
		for (CourseMember s : course.getCourseMembers()) {
			if (s instanceof Listener) {
				PersonType type = PersonType.valueOf(s.getClass().getSimpleName().toUpperCase());
				sb.append(ParserFactory.getParser(type).parseToString((Person) s)).append("\n");
			}
		}
		sb.append("***\n");
		return sb.toString();
	}

	public static String getStringData(List<TrainingCourse> courses) {
		StringBuilder sb = new StringBuilder();
		for (TrainingCourse course : courses) {
			sb.append(getStringData(course));
		}
		return sb.toString();
	}

	public static String getStringStudents(List<Listener> listeners) {
		StringBuilder sb = new StringBuilder();
		for (Listener listener : listeners) {
			PersonType type = PersonType.valueOf(listener.getClass().getSimpleName().toUpperCase());
			sb.append(ParserFactory.getParser(type).parseToString((Person) listener)).append("\n");
		}
		return sb.toString();
	}
}
