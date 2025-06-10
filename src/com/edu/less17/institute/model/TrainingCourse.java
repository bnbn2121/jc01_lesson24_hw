package com.edu.less17.institute.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class TrainingCourse {
	private String specialization;
	private int id;
	private List<Student> students;
	private List<Staff> staff;

	public TrainingCourse() {
		this.specialization = "No specialization";
		this.id = 0;
		this.students = new ArrayList<Student>();
		this.staff = new ArrayList<Staff>();
	}

	public TrainingCourse(String specialization, int id, List<Student> students, List<Staff> staff) {
		this.specialization = specialization;
		this.id = id;
		this.students = students;
		this.staff = staff;
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

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public List<Staff> getStaff() {
		return staff;
	}

	public void setStaff(List<Staff> staff) {
		this.staff = staff;
	}

	public void addStudent(Student student) {
		if (!students.contains(student)) {
			students.add(student);
		} else {
			throw new RuntimeException("Не удалось добавить студента");
		}
	}

	public void addStaff(Staff newStaff) {
		boolean isPresent = false;
		for (Staff s : staff) {
			if (s.getClass().isInstance(newStaff) || newStaff.getClass().isInstance(s)) {
				isPresent = true;
				break;
			}
		}
		if (!isPresent) {
			staff.add(newStaff);
		} else {
			throw new RuntimeException("Не удалось добавить сотрудника");
		}
	}

	public String getInfo() {
		StringBuilder sb = new StringBuilder();
		sb.append("Course data:\n");
		sb.append(String.format("id: %d\n", id));
		sb.append(String.format("specialization: %s\n", specialization));
		sb.append("staff:\n");
		for (Staff s : staff) {
			Person p = (Person) s;
			sb.append(p.getName()).append(" (").append(p.getClass().getSimpleName()).append(")").append("\n");
		}
		sb.append("students:\n");
		for (Person p : students) {
			sb.append(p.getName()).append(" (").append(p.getClass().getSimpleName()).append(")").append("\n");
		}
		return sb.toString();
	}

	public String conductLesson() {
		StringBuilder sb = new StringBuilder();
		for (CourseMember member : staff) {
			sb.append(member.lessonAction()).append("\n");
		}
		for (CourseMember member : students) {
			sb.append(member.lessonAction()).append("\n");
		}
		sb.append("the lesson is done\n");
		return sb.toString();
	}

	public double getAverageCourseGrade() {
		double sum = 0;
		for (Student s : students) {
			sum += s.getAverageGrade();
		}
		double result = ((int) (sum / students.size() * 10)) / 10.0;
		return result;
	}

	public List<Student> getStudentsByAlphabet() {
		List<Student> sortedStudents = new ArrayList<Student>(students);
		Collections.sort(sortedStudents, new ComparatorByAlphabet());
		return sortedStudents;
	}

	public List<Student> getStudentsByAverageGrade() {
		List<Student> sortedStudents = new ArrayList<Student>(students);
		Collections.sort(sortedStudents, new ComparatorByAvearageGrade());

		return sortedStudents;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, specialization, staff, students);
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
		return id == other.id && Objects.equals(specialization, other.specialization)
				&& Objects.equals(staff, other.staff) && Objects.equals(students, other.students);
	}

	@Override
	public String toString() {
		return "TrainingCourse [" + (specialization != null ? "specialization=" + specialization + ", " : "") + "id="
				+ id + ", " + (students != null ? "students=" + students + ", " : "")
				+ (staff != null ? "staff=" + staff : "") + "]";
	}

}
