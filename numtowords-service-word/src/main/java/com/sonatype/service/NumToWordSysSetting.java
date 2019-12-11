package com.sonatype.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class NumToWordSysSetting {

	@Value("${appInstance.name}")
	private String instanceName;

	public String getInstanceName() {
		return instanceName;
	}

}
