package com.edu.less17.institute.util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.edu.less17.institute.model.TrainingCourse;

public class CourseReader {

//	public String getData(String path) throws IOException {
//		StringBuilder sb = new StringBuilder();
//		String tempString;
//		try (BufferedReader bReader = new BufferedReader(new InputStreamReader(new FileInputStream(path)))) {
//			while ((tempString = bReader.readLine()) != null) {
//				sb.append(tempString).append("\n");
//			}
//		} catch (IOException e) {
//			throw e;
//		}
//		return sb.toString();
//	}

	public List<TrainingCourse> getCourses(String path) throws IOException {
		List<TrainingCourse> courses = new ArrayList<TrainingCourse>();
		try (BufferedReader bReader = new BufferedReader(new InputStreamReader(new FileInputStream(path)))) {
			StringBuilder sb = new StringBuilder();
			String tempString;
			while ((tempString = bReader.readLine()) != null) {
				if (tempString.startsWith("***")) {
					TrainingCourse course = CourseParser.getCourseFromString(sb.toString());
					courses.add(course);
					sb.setLength(0);
					continue;
				} else {
					sb.append(tempString).append("\n");
				}
			}
		} catch (IOException e) {
			throw e;
		}
		return courses;
	}

}
