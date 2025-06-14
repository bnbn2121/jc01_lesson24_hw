package com.edu.less17.institute.model;

import java.util.Comparator;

public class ComparatorByAvearageGrade implements Comparator<Listener> {

	@Override
	public int compare(Listener o1, Listener o2) {
		return Double.compare(o1.getAverageGrade(), o2.getAverageGrade());
	}

}
