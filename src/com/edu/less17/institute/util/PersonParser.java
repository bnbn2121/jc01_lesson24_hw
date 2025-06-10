package com.edu.less17.institute.util;

import com.edu.less17.institute.model.Person;

public interface PersonParser {
	String parseToString(Person s);

	Person parseFromString(String personData);
}
