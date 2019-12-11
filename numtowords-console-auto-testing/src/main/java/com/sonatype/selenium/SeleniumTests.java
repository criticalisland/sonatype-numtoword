package com.sonatype.selenium;

interface SeleniumTests {

	boolean getInputTitleTest(String url);
	boolean getValidOutputPageTest(String url);
	boolean getInvalidInputPageTest(String url);
	boolean getInvalidOutputPageTest(String url);
	boolean getInvalidInputPage5Test(String url);
	boolean getInvalidInputPage6Test(String url);
	boolean getInvalidInputPage7Test(String url);
	boolean getInvalidInputPage8Test(String url);
}
