package com.sonatype.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Tests for API end-point service inputs based on given boundary conditions
 * 
 * @author Selva Vadivel
 * 
 */

@SpringBootTest
class NumtoWordsApplicationTests {

	@Test
	void testZero() {
		assertEquals(NumToWordsApplication.giveWords("0"), "Zero ");
	}

	@Test
	void testSingleDigitNumber() {
		assertEquals(NumToWordsApplication.giveWords("9"), "Nine ");
	}

	@Test
	void testTeensNumber() {
		assertEquals(NumToWordsApplication.giveWords("15"), "Fifteen ");
	}

	@Test
	void testThreeDigitWithOnesWithoutTens() {
		assertEquals(NumToWordsApplication.giveWords("501"), "Five hundred and one ");
	}

	@Test
	void testThreeDigitWithoutOnesWithTens() {
		assertEquals(NumToWordsApplication.giveWords("511"), "Five hundred and eleven ");
	}

	@Test
	void testLargeNumberWithoutOnesWithoutTens() {
		assertEquals(NumToWordsApplication.giveWords("1000000"), "One million ");
	}

	@Test
	void testNegativeAndMinimumNumberWithComma() {
		assertEquals(NumToWordsApplication.giveWords("-2,147,483,647"),
				"Minus two billion one hundred and forty seven million four hundred and eighty three thousand six hundred and forty seven ");
	}

	@Test
	void testMaximumNumberWithoutComma() {
		assertEquals(NumToWordsApplication.giveWords("2147483647"),
				"Two billion one hundred and forty seven million four hundred and eighty three thousand six hundred and forty seven ");
	}

	@Test
	void testInvalidCharacterDecimal() {
		assertEquals(NumToWordsApplication.giveWords("1000.00"), "Invalid");
	}

	@Test
	void testInvalidCharacterPositive() {
		assertEquals(NumToWordsApplication.giveWords("+1000000000"), "Invalid");
	}

	@Test
	void testInvalidComma() {
		assertEquals(NumToWordsApplication.giveWords("100,00"), "Invalid");
	}

	@Test
	void testNegativeOutofRange() {
		assertEquals(NumToWordsApplication.giveWords("-2147483648"), "Invalid");
	}

	@Test
	void testMaxOutofRange() {
		assertEquals(NumToWordsApplication.giveWords("2147483648"), "Invalid");
	}

}
