package com.edu.less17.institute.repository;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.edu.less17.institute.main.Main;
import com.edu.less17.institute.model.TrainingCourse;
import com.edu.less17.institute.util.ReaderFromFile;
import com.edu.less17.institute.util.WriterToFile;

public class FileCourseRepository implements CourseRepository {

	URL location = Main.class.getProtectionDomain().getCodeSource().getLocation();
	private final String DATA_PATH = location.getPath() + "resources/courseData.txt";
	private WriterToFile writer = new WriterToFile();
	private ReaderFromFile reader = new ReaderFromFile();

	public FileCourseRepository() {
	}

	public void addCourse(TrainingCourse course) throws DaoException {
		if (!isPresent(course)) {
			writeCourseToFile(course, true);
		}
	}

	public boolean isPresent(TrainingCourse course) throws DaoException {
		for (TrainingCourse someCourse : getCourses()) {
			if (someCourse.equals(course)) {
				return true;
			}
		}
		return false;
	}

	public void writeCourseToFile(TrainingCourse course, boolean rewrite) throws DaoException {
		try {
			writer.writeCourseToFile(course, DATA_PATH, rewrite);
		} catch (IOException e) {
			throw new DaoException(e);
		}
	}

	public void removeCourseById(int id) throws DaoException {
		Iterator<TrainingCourse> iterator = getCourses().iterator();
		int i = 0;
		while (iterator.hasNext()) {
			TrainingCourse course = (TrainingCourse) iterator.next();
			if (course.getId() == id) {
				iterator.remove();
			} else {
				if (i == 0) {
					writeCourseToFile(course, false);
				} else {
					writeCourseToFile(course, true);
				}
			}
		}
	}

	public List<TrainingCourse> getCourses() throws DaoException {
		List<TrainingCourse> courses = new ArrayList<TrainingCourse>();
		try {
			String data = reader.getData(DATA_PATH);
			String[] dataArray = data.split("\n");
			StringBuilder sb = new StringBuilder();
			for (String tempString : dataArray) {
				if (tempString.trim().isEmpty() && sb.length() > 0) {
					courses.add(new TrainingCourse().getCourseFromString(sb.toString()));
					sb.setLength(0);
				} else {
					sb.append(tempString).append("\n");
				}
			}
			if (sb.length() > 0) {
				courses.add(new TrainingCourse().getCourseFromString(sb.toString()));
				sb.setLength(0);
			}
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
