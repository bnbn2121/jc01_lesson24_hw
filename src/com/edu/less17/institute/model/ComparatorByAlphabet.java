package com.edu.less17.institute.model;

import java.util.Comparator;

public class ComparatorByAlphabet implements Comparator<Listener> {

	@Override
	public int compare(Listener l1, Listener l2) {
		Person p1 = (Person) l1;
		Person p2 = (Person) l2;
		return p1.getName().compareToIgnoreCase(p2.getName());
	}

}
