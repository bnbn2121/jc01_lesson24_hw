package com.edu.less17.institute.repository;

import java.util.List;

import com.edu.less17.institute.model.TrainingCourse;

public interface CourseRepository {
	void saveCourse(TrainingCourse course) throws DaoException;
	void removeCourseById(int id) throws DaoException;
	List<TrainingCourse> getCourses() throws DaoException;
	TrainingCourse getCourseById(int id) throws DaoException;

}
