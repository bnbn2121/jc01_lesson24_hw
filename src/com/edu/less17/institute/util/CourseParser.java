package com.edu.less17.institute.util;

import java.util.List;

import com.edu.less17.institute.model.Administrator;
import com.edu.less17.institute.model.Person;
import com.edu.less17.institute.model.Staff;
import com.edu.less17.institute.model.Student;
import com.edu.less17.institute.model.Teacher;
import com.edu.less17.institute.model.TrainingCourse;

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
			if (oneLine.startsWith("Student")) {
				Student student = null;
				student = (Student) ParserFactory.getParser(Student.class).parseFromString(oneLine);
				course.addStudent(student);
				continue;
			}
			if (oneLine.startsWith("Teacher")) {
				Teacher teacher = null;
				teacher = (Teacher) ParserFactory.getParser(Teacher.class).parseFromString(oneLine);
				course.addStaff(teacher);
				continue;
			}
			if (oneLine.startsWith("Administrator")) {
				Administrator administrator = null;
				administrator = (Administrator) ParserFactory.getParser(Administrator.class).parseFromString(oneLine);
				course.addStaff(administrator);
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
		for (Staff s : course.getStaff()) {
			sb.append(ParserFactory.getParser(s.getClass()).parseToString((Person) s)).append("\n");
		}
		sb.append("students:\n");
		for (Student s : course.getStudents()) {
			sb.append(ParserFactory.getParser(s.getClass()).parseToString(s)).append("\n");
		}
		sb.append("***\n");
		return sb.toString();
	}

	public static String getStringData(List<TrainingCourse> courses) {
		StringBuilder sb = new StringBuilder();
		for (TrainingCourse course : courses) {
			sb.append("Course data:\n");
			sb.append(String.format("id: %d\n", course.getId()));
			sb.append(String.format("specialization: %s\n", course.getSpecialization()));
			sb.append("staff:\n");
			for (Staff s : course.getStaff()) {
				sb.append(ParserFactory.getParser(s.getClass()).parseToString((Person) s)).append("\n");
			}
			sb.append("students:\n");
			for (Student s : course.getStudents()) {
				sb.append(ParserFactory.getParser(s.getClass()).parseToString(s)).append("\n");
			}
			sb.append("***\n");
		}
		return sb.toString();
	}

	public static String getStringStudents(List<Student> students) {
		StringBuilder sb = new StringBuilder();
		for (Student student : students) {
			sb.append(ParserFactory.getParser(student.getClass()).parseToString(student)).append("\n");
		}
		return sb.toString();
	}
}
