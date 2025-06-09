package com.edu.less17.institute.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Student extends Person {
	private List<Integer> grades;
	private String group;

	public Student() {
		super();
		this.grades = new ArrayList<>();
		this.group = "Неизвестная группа";
	}

	public Student(String name, String group) {
		super(name);
		this.group = group;
		this.grades = hardcodeInitGrades();
	}

	public List<Integer> getGrades() {
		return grades;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public void setGrades(ArrayList<Integer> grades) {
		this.grades = grades;
	}
	
	@Override
	public void lessonAction() {
		study();
	}

	private void study() {
		System.out.println("я учусь (" + getClass().getSimpleName() + " " + getName() + ")");
	}

	public double getAverageGrade() {
		int sum = 0;
		for (int grade : grades) {
			sum += grade;
		}
		double result = ((int) (sum * 10.0 / grades.size())) / 10.0;
		return result;
	}

	public String getInfo() {
		return String.format("%s - %.1f", getName(), getAverageGrade());
	}

	public void addGrade(int grade) {
		grades.add(grade);
	}
	
	public void obfuscateName() {
		this.setName("Данные скрыты");
	}

	private List<Integer> hardcodeInitGrades() {
		List<Integer> grades = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			grades.add((int) (Math.random() * 10 + 1));
		}
		return grades;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(grades);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return Objects.equals(grades, other.grades);
	}

	@Override
	public String toString() {
		return "Student [" + (grades != null ? "grades=" + grades : "") + "]";
	}

}
