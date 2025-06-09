package com.edu.less17.institute.repository;

import java.io.IOException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

import com.edu.less17.institute.main.Main;
import com.edu.less17.institute.model.TrainingCourse;
import com.edu.less17.institute.util.CourseReader;
import com.edu.less17.institute.util.CourseWriter;

public class FileCourseRepository implements CourseRepository {

	URL location = Main.class.getProtectionDomain().getCodeSource().getLocation();
	private final String DATA_PATH = location.getPath() + "resources/courseData.txt";
	private CourseWriter writer = new CourseWriter();
	private CourseReader reader = new CourseReader();

	public FileCourseRepository() {
	}

	public void saveCourse(TrainingCourse course) throws DaoException {
		List<TrainingCourse> courses = getCourses();
		boolean courseResaved = false;
		for (int i = 0; i < courses.size(); i++) {
			if (courses.get(i).getId() == course.getId()) {
				courses.set(i, course);
				courseResaved=true;
			}
		}
		if(!courseResaved) {
			courses.add(course);
		}
		try {
			writer.writeToFile(courses, DATA_PATH);
		} catch (IOException e) {
			throw new DaoException(e);
		}
	}

	public void removeCourseById(int id) throws DaoException {
		List<TrainingCourse> courses = null;
		try {
			courses = reader.getCourses(DATA_PATH);
			Iterator<TrainingCourse> iterator = courses.iterator();
			while (iterator.hasNext()) {
				TrainingCourse course = iterator.next();
				if (course.getId() == id) {
					iterator.remove();
				}
			}
			writer.writeToFile(courses, DATA_PATH);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public List<TrainingCourse> getCourses() throws DaoException {
		List<TrainingCourse> courses = null;
		try {
			courses = reader.getCourses(DATA_PATH);
		} catch (IOException e) {
			throw new DaoException(e);
		}
		return courses;
	}

	public TrainingCourse getCourseById(int id) throws DaoException {
		for (TrainingCourse course : getCourses()) {
			if (id == course.getId()) {
				return course;
			}
		}
		return null;
	}

}
