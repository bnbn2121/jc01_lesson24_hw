package com.edu.less17.institute.util;

import com.edu.less17.institute.model.CourseMember;
import com.edu.less17.institute.model.Person;

public interface PersonParser {
	String parseToString(Person s);

	CourseMember parseFromString(String personData);
}
