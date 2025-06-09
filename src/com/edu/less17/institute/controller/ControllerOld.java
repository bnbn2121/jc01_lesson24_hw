package com.edu.less17.institute.controller;

import java.util.List;

import com.edu.less17.institute.model.Staff;
import com.edu.less17.institute.model.Student;
import com.edu.less17.institute.model.TrainingCourse;
import com.edu.less17.institute.service.Service;
import com.edu.less17.institute.service.ServiceException;
import com.edu.less17.institute.service.ServiceProvider;

public class ControllerOld {
private static ControllerOld instance = new ControllerOld();
private Service service = ServiceProvider.getService();
	
	private ControllerOld() {
	}
	
	public static ControllerOld getInstance() {
		return instance;
	}

	public static TrainingCourse createTrainingCourse(String specialization, int id, List<Student> students, List<Staff> staff) {
		TrainingCourse trainingCourse = new TrainingCourse(specialization, id, students, staff);
		return trainingCourse;
	}
	
	public static TrainingCourse createTrainingCourse() {
		TrainingCourse trainingCourse = new TrainingCourse();
		return trainingCourse;
	}
	
	public void saveCourse(TrainingCourse course) throws ServiceException {
		service.saveCourse(course);
	}
	
	public void removeCourseById(int id) throws ServiceException {
		service.removeCourseById(id);
	}
	
	public List<TrainingCourse> getCourses() throws ServiceException {
		return service.getCourses();
	}
	
	public void conductLesson(int id) throws ServiceException {
		service.conductLesson(id);
	}
	
	public String getCourseInfo(TrainingCourse course) {
		return service.getCourseInfo(course);
	}
	
	public String getStudentsByAlphabet(TrainingCourse course) {
		return service.getStudentsByAlphabet(course);
	}
	
	public String getStudentsByAverageGrade(TrainingCourse course) {
		return service.getStudentsByAverageGrade(course);
	}
	
	public TrainingCourse getCourseById(int idCourse) throws ServiceException {
		TrainingCourse currentCourse = service.getCourseById(idCourse);
		return currentCourse;
	}
	
	public void addStudent(Student student, int idCourse) throws ServiceException {
		TrainingCourse currentCourse = service.getCourseById(idCourse);
		if (currentCourse!=null) {
			currentCourse.addStudent(student);
		}
	}
}
