package com.edu.less17.institute.util;

import com.edu.less17.institute.model.Administrator;
import com.edu.less17.institute.model.Person;

public class AdministratorParser implements PersonParser {

	@Override
	public String parseToString(Person person) {
		Administrator administrator = (Administrator) person;
		return String.format("%15s | %s", administrator.getClass().getSimpleName(), administrator.getName());
	}

	@Override
	public Administrator parseFromString(String personData) {
		Administrator administrator = new Administrator();
		String[] data = personData.split("\\|");
		administrator.setName(data[1].trim());
		return administrator;
	}
}
