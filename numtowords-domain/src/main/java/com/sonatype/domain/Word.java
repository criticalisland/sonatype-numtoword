package com.sonatype.domain;

public class Word {

	private String numberInputStr;
	private String words;
	private String instanceName;

	public Word() {	
	}
	
	public String getNumberInputStr() {
		return numberInputStr;
	}

	public void setNumberInputStr(String numberInputStr) {
		this.numberInputStr = numberInputStr;
	}

	public String getWords() {
		return words;
	}

	public void setWords(String words) {
		this.words = words;
	}

	public String getInstanceName() {
		return instanceName;
	}

	public void setInstanceName(String instanceName) {
		this.instanceName = instanceName;
	}

	
	
	@Override
	public String toString() {
		return "{" + "\"number\"=\"" + numberInputStr + "\", \"words\"=\"" + words + "\"" + ", \"instaneName\"=\""
				+ instanceName + "\"}";
	}
}
