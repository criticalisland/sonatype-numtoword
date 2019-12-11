package com.sonatype.service;

import java.util.HashMap;

public final class Constants {
	public static final String empty = "";
	public static final String err = "Invalid";
	public static final String zero = "Zero ";
	public static final String space = " ";
	public static final String plus = "+";
	public static final String minus = "minus ";
	public static final String billion = "billion ";
	public static final String million = "million ";
	public static final String thousand = "thousand ";
	public static final String hundred = "hundred ";

	public static final HashMap<Integer, String> onesNumberConversion = new HashMap<>();

	static {
		onesNumberConversion.put(1, "one");
		onesNumberConversion.put(2, "two");
		onesNumberConversion.put(3, "three");
		onesNumberConversion.put(4, "four");
		onesNumberConversion.put(5, "five");
		onesNumberConversion.put(6, "six");
		onesNumberConversion.put(7, "seven");
		onesNumberConversion.put(8, "eight");
		onesNumberConversion.put(9, "nine");
		onesNumberConversion.put(10, "ten");
		onesNumberConversion.put(11, "eleven");
		onesNumberConversion.put(12, "twelve");
		onesNumberConversion.put(13, "thirteen");
		onesNumberConversion.put(14, "fourteen");
		onesNumberConversion.put(15, "fifteen");
		onesNumberConversion.put(16, "sixteen");
		onesNumberConversion.put(17, "seventeen");
		onesNumberConversion.put(18, "eighteen");
		onesNumberConversion.put(19, "nineteen");
	}

	public static final HashMap<Integer, String> tensNumberConversion = new HashMap<>();

	static {
		tensNumberConversion.put(1, "ten");
		tensNumberConversion.put(2, "twenty");
		tensNumberConversion.put(3, "thirty");
		tensNumberConversion.put(4, "forty");
		tensNumberConversion.put(5, "fifty");
		tensNumberConversion.put(6, "sixty");
		tensNumberConversion.put(7, "seventy");
		tensNumberConversion.put(8, "eighty");
		tensNumberConversion.put(9, "ninety");
	}

}
