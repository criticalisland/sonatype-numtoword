package com.sonatype.selenium;

import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.chrome.ChromeDriver;

public class AutoTest implements SeleniumTests {


	public boolean getInputTitleTest(String url) {
		WebDriver driver = new ChromeDriver();
		// launch browser and direct it to the Base URL
		driver.get(Constants.baseUrl);

		// get the actual value of the title
		String actualTitle = driver.getTitle();

		/*
		 * compare the actual title of the page with the expected one and print the
		 * result as "Passed" or "Failed"
		 */
		if (actualTitle.contentEquals(Constants.expectedTitleInput)) {
			System.out.println("Test Passed!");
		} else {
			System.out.println("Test Failed:" + actualTitle);
		}

		// close Fire fox
		driver.close();
		return true;
	}

	public boolean getInvalidOutputPageTest(String url) {
		WebDriver driver = new ChromeDriver();
		// launch browser and direct it to the Base URL
		driver.get(Constants.baseUrl);

		// get the actual value of the title
		String actualTitle = driver.getTitle();

		/*
		 * compare the actual title of the page with the expected one and print the
		 * result as "Passed" or "Failed"
		 */
		if (actualTitle.contentEquals(Constants.expectedTitleInput)) {
			System.out.println("Test Passed!");
		} else {
			System.out.println("Test Failed:" + actualTitle);
		}

		// close Fire fox
		driver.close();
		return true;
	}

	public static void main(String[] args) {
		/*
		 * Starting Firefox 35, you need to use gecko driver created by Mozilla to use
		 * Web Driver. Selenium 3.0, gecko and firefox has compatibility issues
		 * declaration and instantiation of objects/variables
		 * System.setProperty("webdriver.firefox.marionette","C:\\geckodriver.exe");
		 * this is for Windows OS WebDriver driver = new FirefoxDriver();
		 */
		SeleniumTests in = new AutoTest();
		in.getInputTitleTest(Constants.baseUrl);
		in.getInvalidOutputPageTest(Constants.baseUrl);
	}

}
