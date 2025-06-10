package com.edu.less17.institute.model;

import java.util.Objects;

public class Teacher extends Person implements Staff {
	private String specialization;

	public Teacher() {
		super();
		specialization = "нет данных";
	}

	public Teacher(String name, String specialization) {
		super(name);
		this.specialization = specialization;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	@Override
	public String lessonAction() {
		return teach();
	}

	private String teach() {
		String actionResult = "I'm teaching (" + getClass().getSimpleName() + " " + getName() + ")";
		return actionResult;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(specialization);
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
		Teacher other = (Teacher) obj;
		return Objects.equals(specialization, other.specialization);
	}

	@Override
	public String toString() {
		return "Teacher [" + (specialization != null ? "specialization=" + specialization : "") + "]";
	}

}
