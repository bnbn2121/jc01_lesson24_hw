package com.edu.less17.institute.repository;

public class CourseRepositoryException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CourseRepositoryException() {
		super();
	}

	public CourseRepositoryException(String message, Exception e) {
		super(message, e);
	}

	public CourseRepositoryException(String message) {
		super(message);
	}

	public CourseRepositoryException(Exception e) {
		super(e);
	}

}
