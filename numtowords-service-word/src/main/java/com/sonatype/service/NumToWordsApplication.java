package com.sonatype.service;

import java.util.Scanner;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NumToWordsApplication implements RegressionTranslation {

	public static String giveWords(String strInput) {

		int number = 0;

		RegressionTranslation in = new NumToWordsApplication();

		if (strInput == "") {
			return Constants.empty;
		}

		if (strInput.contains(Constants.space) || strInput.startsWith(Constants.plus)) {
			return Constants.err; // this validation is needed as scanner.nextInt() below processes this as valid
									// otherwise.
		}

		Scanner scanner = new Scanner(strInput);

		try {

			number = scanner.nextInt();
			// values from -2,147,483,647 to 2,147,483,647 are only valid for Java integer
			// and by nextInt()

			if (number == 0) {
				return Constants.zero;
			} else {
				String words = in.regressionNumberConversion(number);

				return words.substring(0, 1).toUpperCase() + words.substring(1);
			}

		} catch (Exception e) {

			return Constants.err;

		} finally {
			scanner.close();
		}
	}

}
