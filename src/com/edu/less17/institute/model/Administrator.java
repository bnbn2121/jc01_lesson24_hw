package com.edu.less17.institute.model;

public class Administrator extends Person implements Staff {

	public Administrator() {
	}

	public Administrator(String name) {
		super(name);
	}

	@Override
	public String lessonAction() {
		return administrate();
	}

	private String administrate() {
		String actionResult = "I'm administrating (" + getClass().getSimpleName() + " " + getName() + ")";
		return actionResult;
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Administrator []";
	}

}
