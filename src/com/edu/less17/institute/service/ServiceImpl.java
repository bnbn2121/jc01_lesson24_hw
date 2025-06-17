package com.edu.less17.institute.service;

import java.util.List;

import com.edu.less17.institute.model.CourseMember;
import com.edu.less17.institute.model.Listener;
import com.edu.less17.institute.model.Student;
import com.edu.less17.institute.model.TrainingCourse;
import com.edu.less17.institute.repository.CourseRepository;
import com.edu.less17.institute.repository.CourseRepositoryProvider;
import com.edu.less17.institute.util.CourseParser;
import com.edu.less17.institute.repository.CourseRepositoryException;

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

	public TrainingCourse createTrainingCourse(String specialization, int id, List<CourseMember> courseMembers) {
		TrainingCourse trainingCourse = new TrainingCourse(specialization, id, courseMembers);
		return trainingCourse;
	}

	public TrainingCourse createTrainingCourse() {
		TrainingCourse trainingCourse = new TrainingCourse();
		return trainingCourse;
	}

	public void saveCourse(TrainingCourse course) throws ServiceException {
		try {
			courses.saveCourse(course);
		} catch (CourseRepositoryException e) {
			throw new ServiceException(e);
		}
	}

	public void removeCourseById(int id) throws ServiceException {
		try {
			courses.removeCourseById(id);
		} catch (CourseRepositoryException e) {
			throw new ServiceException(e);
		}
	}

	public List<TrainingCourse> getCourses() throws ServiceException {
		try {
			return courses.getCourses();
		} catch (CourseRepositoryException e) {
			throw new ServiceException(e);
		}
	}

	public String conductLesson(int id) throws ServiceException {
		try {
			TrainingCourse course = courses.getCourseById(id);
			return course.conductLesson();
		} catch (CourseRepositoryException e) {
			throw new ServiceException(e);
		}
	}

	public String getCourseInfo(TrainingCourse course) {
		return CourseParser.getStringData(course);
	}

	public List<Listener> getStudentsByAlphabet(TrainingCourse course) {
		return course.getStudentsByAlphabet();
	}

	public List<Listener> getStudentsByAverageGrade(TrainingCourse course) {
		return course.getStudentsByAverageGrade();
	}

	public TrainingCourse getCourseById(int idCourse) throws ServiceException {
		TrainingCourse currentCourse = null;
		try {
			currentCourse = courses.getCourseById(idCourse);
		} catch (CourseRepositoryException e) {
			throw new ServiceException(e);
		}
		return currentCourse;
	}

	public void addStudent(Student student, TrainingCourse course) {
		course.addCourseMember(student);
	}

}
