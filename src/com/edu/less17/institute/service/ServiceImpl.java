package com.edu.less17.institute.service;

import java.util.List;

import com.edu.less17.institute.model.Staff;
import com.edu.less17.institute.model.Student;
import com.edu.less17.institute.model.TrainingCourse;
import com.edu.less17.institute.repository.CourseRepository;
import com.edu.less17.institute.repository.CourseRepositoryProvider;
import com.edu.less17.institute.repository.DaoException;

public class ServiceImpl implements Service {
	private CourseRepository courses;

	{
		courses = CourseRepositoryProvider.getCourseRepository();
	}

	public ServiceImpl() {
	}

	public ServiceImpl(CourseRepository courses) {
		this.courses = courses;
	}

	public CourseRepository getCourseRepository() {
		return courses;
	}

	public void setCourseRepository(CourseRepository courses) {
		this.courses = courses;
	}

	public static TrainingCourse createTrainingCourse(String specialization, int id, List<Student> students,
			List<Staff> staff) {
		TrainingCourse trainingCourse = new TrainingCourse(specialization, id, students, staff);
		return trainingCourse;
	}

	public static TrainingCourse createTrainingCourse() {
		TrainingCourse trainingCourse = new TrainingCourse();
		return trainingCourse;
	}

	public void addCourse(TrainingCourse course) throws ServiceException {
		try {
			courses.addCourse(course);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
	}

	public void removeCourseById(int id) throws ServiceException {
		try {
			courses.removeCourseById(id);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
	}

	public List<TrainingCourse> getCourses() throws ServiceException {
		try {
			return courses.getCourses();
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
	}

	public void conductLesson(int id) throws ServiceException {
		try {
			TrainingCourse course = courses.getCourseById(id);
			course.conductLesson();
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
	}

	public String getCourseInfo(TrainingCourse course) {
		return course.getInfo();
	}

	public String getStudentsByAlphabet(TrainingCourse course) {
		return course.getStudentsByAlphabet();
	}

	public String getStudentsByAverageGrade(TrainingCourse course) {
		return course.getStudentsByAverageGrade();
	}

	public TrainingCourse getCourseById(int idCourse) throws ServiceException {
		TrainingCourse currentCourse = null;
		try {
			currentCourse = courses.getCourseById(idCourse);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
		return currentCourse;
	}

	public void addStudent(Student student, int idCourse) throws ServiceException {
		TrainingCourse currentCourse = null;
		try {
			currentCourse = courses.getCourseById(idCourse);
			if (currentCourse != null) {
				currentCourse.addStudent(student);
			}
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
	}

}
