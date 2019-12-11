package com.sonatype.service;

interface RegressionTranslation {

	default String regressionNumberConversion(int number) {

		String words = "";
		boolean andWordFlag = false;

		if (number == 0) {
			return Constants.zero;
		}

		if (number < 0) {
			String numberStr = "" + number;
			numberStr = numberStr.substring(1);
			return Constants.minus + regressionNumberConversion(Integer.parseInt(numberStr));
		}

		if ((number / 1000000000) > 0) {
			words += regressionNumberConversion(number / 1000000000) + Constants.billion;
			number %= 1000000000;
			andWordFlag = true;
		}

		if ((number / 1000000) > 0) {
			words += regressionNumberConversion(number / 1000000) + Constants.million;
			number %= 1000000;
			andWordFlag = true;
		}
		if ((number / 1000) > 0) {
			words += regressionNumberConversion(number / 1000) + Constants.thousand;
			number %= 1000;
			andWordFlag = true;
		}
		if ((number / 100) > 0) {
			words += regressionNumberConversion(number / 100) + Constants.hundred;
			number %= 100;
			andWordFlag = true;
		}

		if (number > 0) {
			if (number < 20) {
				if (andWordFlag) {
					words += "and ";
				}
				words += Constants.onesNumberConversion.get(number) + " ";
			} else {
				if (andWordFlag) {
					words += "and ";
				}
				words += Constants.tensNumberConversion.get(number / 10) + " ";
				if ((number % 10) > 0) {
					if (andWordFlag) {

					}
					words += Constants.onesNumberConversion.get(number % 10) + " ";
				}
			}
		}

		return words;

	}
}
