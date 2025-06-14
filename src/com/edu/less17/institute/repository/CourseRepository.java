package com.edu.less17.institute.repository;

import java.util.List;

import com.edu.less17.institute.model.TrainingCourse;

public interface CourseRepository {
	void saveCourse(TrainingCourse course) throws CourseRepositoryException;

	void removeCourseById(int id) throws CourseRepositoryException;

	List<TrainingCourse> getCourses() throws CourseRepositoryException;

	TrainingCourse getCourseById(int id) throws CourseRepositoryException;

}
