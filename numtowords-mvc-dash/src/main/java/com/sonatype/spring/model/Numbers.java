package com.sonatype.spring.model;

import javax.persistence.Entity;
import javax.validation.constraints.Pattern;

@Entity
public class Numbers {

	@Pattern(regexp = "[0-9]{1,10}|[0-9]{1,3},[0-9]{1,3}|[0-9]{1,3},[0-9]{1,3},[0-9]{1,3}|[0-9]{1,3},[0-9]{1,3},[0-9]{1,3},[0-9]{1,3}|-[0-9]{1,10}|-[0-9]{1,3},[0-9]{1,3}|-[0-9]{1,3},[0-9]{1,3},[0-9]{1,3}|-[0-9]{1,3},[0-9]{1,3},[0-9]{1,3},[0-9]{1,3}", message = "Please enter valid number format like 123,456 or -567890")
	public String numberStr;

	public static String numberWords;
	public static String instancesName;
	
	public String getNumberStr() {
		return numberStr;
	}

	public void setNumberStr(String numberStr) {

		this.numberStr = numberStr;
	}

	public String getNumberWords() {
		return numberWords;
	}

	public void setNumberWords(String numberWords) {
		Numbers.numberWords = numberWords;
	}
	
	public String getIntancesName() {
		return instancesName;
	}

	public void setIntancesName(String instancesName) {
		Numbers.instancesName = instancesName;
	}
	
}
