package com.edu.less17.institute.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class TrainingCourse {
	private String specialization;
	private int id;
	private List<CourseMember> courseMembers;
	

	public TrainingCourse() {
		this.specialization = "No specialization";
		this.id = 0;
		this.courseMembers = new ArrayList<CourseMember>();
	}

	public TrainingCourse(String specialization, int id, List<CourseMember> courseMembers) {
		this.specialization = specialization;
		this.id = id;
		this.courseMembers = courseMembers;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<CourseMember> getCourseMembers() {
		return courseMembers;
	}

	public void setCourseMembers(List<CourseMember> courseMembers) {
		this.courseMembers = courseMembers;
	}
	
	public void addCourseMember(CourseMember member) {
		if (member instanceof Listener) {
			addMemberToCourse(member);
		} else {
			boolean isPresent = false;
			for (CourseMember staffMember : courseMembers) {
				if (staffMember.getClass().isInstance(member) || member.getClass().isInstance(staffMember)) {
					isPresent = true;
					break;
				}
			}
			if (!isPresent) {
				courseMembers.add(member);
			} else {
				throw new RuntimeException("This staff type is already present");
			}
		}
	}
	
	private void addMemberToCourse(CourseMember courseMember) {
		if (!courseMembers.contains(courseMember)) {
			courseMembers.add(courseMember);
		} else {
			throw new RuntimeException("This person is already present");
		}
	}
	
	public List<Listener> getListeners() {
		List<Listener> listeners = new ArrayList<Listener>();
		for (CourseMember member : courseMembers) {
			if (member instanceof Listener) {
				listeners.add((Listener) member);
			}
		}
		return listeners;
	}
	
	public List<Staff> getStaff() {
		List<Staff> staff = new ArrayList<Staff>();
		for (CourseMember member : courseMembers) {
			if (member instanceof Staff) {
				staff.add((Staff) member);
			}
		}
		return staff;
	}

	public String conductLesson() {
		StringBuilder sb = new StringBuilder();
		for (CourseMember member : courseMembers) {
			sb.append(member.lessonAction()).append("\n");
		}
		sb.append("the lesson is done\n");
		return sb.toString();
	}

	public double getAverageCourseGrade() {
		double sum = 0;
		List<Listener> listeners= getListeners();
		for (Listener listener : listeners) {
			sum += listener.getAverageGrade();
		}
		double result = ((int) (sum / listeners.size() * 10)) / 10.0;
		return result;
	}

	public List<Listener> getStudentsByAlphabet() {
		List<Listener> sortedListeners = new ArrayList<Listener>(getListeners());
		Collections.sort(sortedListeners, new ComparatorByAlphabet());
		return sortedListeners;
	}

	public List<Listener> getStudentsByAverageGrade() {
		List<Listener> sortedListeners = new ArrayList<Listener>(getListeners());
		Collections.sort(sortedListeners, new ComparatorByAvearageGrade());
		return sortedListeners;
	}

	@Override
	public int hashCode() {
		return Objects.hash(courseMembers, id, specialization);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TrainingCourse other = (TrainingCourse) obj;
		return Objects.equals(courseMembers, other.courseMembers) && id == other.id
				&& Objects.equals(specialization, other.specialization);
	}

	@Override
	public String toString() {
		return "TrainingCourse [" + (specialization != null ? "specialization=" + specialization + ", " : "") + "id="
				+ id + ", " + (courseMembers != null ? "courseMembers=" + courseMembers : "") + "]";
	}

	

	

}
