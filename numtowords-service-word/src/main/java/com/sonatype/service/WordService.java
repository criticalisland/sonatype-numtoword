package com.sonatype.service;

import com.amazonaws.util.EC2MetadataUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sonatype.domain.Word;

@Component
public class WordService implements IWordService {

	private NumToWordSysSetting systemSetting;

	@Autowired
	public WordService(NumToWordSysSetting systemSetting) {
		this.systemSetting = systemSetting;
	}

	@Override
	public Word getWordJSON(String wordNum) {

		Word word = new Word();
		word.setNumberInputStr(wordNum);
		word.setWords(NumToWordsApplication.giveWords(wordNum).trim());

		try {
			word.setInstanceName(systemSetting.getInstanceName() + ": ID:" + EC2MetadataUtils.getInstanceId());

			/*
			 * EC2 Instance ID is retrieved to trace load balancing and auto-scaling.
			 * Removing this feature will help reduce size of the generated jar file.
			 */
		} catch (Exception e) {

			word.setInstanceName(systemSetting.getInstanceName() + ": ID:" + "");
			e.printStackTrace();
		}

		return word;
	}

}
