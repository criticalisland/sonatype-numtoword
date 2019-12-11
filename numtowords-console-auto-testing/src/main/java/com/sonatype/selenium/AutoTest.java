package com.sonatype.selenium;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AutoTest implements SeleniumTests {
	static boolean continueTestFlag = true;

	public boolean getInputTitleTest(String url) {
		WebDriver driver = new ChromeDriver();

		// launch browser and direct it to the Base URL
		driver.get(url);

		// get the actual value of the title
		String actualTitle = driver.getTitle();

		/*
		 * compare the actual title of the page with the expected one and print the
		 * result as "Passed" or "Failed"
		 */
		if (actualTitle.contentEquals(Constants.expectedTitleInput)) {
			System.out.println("Test #1 Passed!");
		} else {
			System.out.println("Test #1 Failed:" + actualTitle);
		}

		// close Chrome browser
		driver.close();
		return true;
	}

	public boolean getValidOutputPageTest(String url) {
		WebDriver driver = new ChromeDriver();
		// launch browser and direct it to the Base URL
		driver.get(url);

		// get the actual value of the title
		WebElement numberTextBox = driver.findElement(By.id("inputNumber"));
		numberTextBox.sendKeys(Constants.test2Input);
		WebElement submitButton = driver.findElement(By.id("submitButton"));
		submitButton.click();

		String actualTitle = driver.getTitle();
		if (actualTitle.contentEquals(Constants.expectedTitleOutputTest2)) {
			System.out.println("Test #2 Passed!");
		} else {
			System.out.println("Test #2 Failed:" + actualTitle);
		}

		// close Chrome browser
		driver.close();
		return true;
	}

	public boolean getInvalidInputPageTest(String url) {
		WebDriver driver = new ChromeDriver();
		// launch browser and direct it to the Base URL
		driver.get(url);

		// get the actual value of the title
		WebElement numberTextBox = driver.findElement(By.id("inputNumber"));
		numberTextBox.sendKeys("Constants.test3Input");
		WebElement submitButton = driver.findElement(By.id("submitButton"));
		submitButton.click();

		String actualTitle = driver.getTitle();
		if (actualTitle.contentEquals(Constants.expectedTitleInput)) {
			System.out.println("Test #3 Passed!");
		} else {
			System.out.println("Test #3 Failed:" + actualTitle);
		}

		// close Chrome browser
		driver.close();
		return true;
	}

	public boolean getInvalidOutputPageTest(String url) {
		WebDriver driver = new ChromeDriver();
		// launch browser and direct it to the Base URL
		driver.get(url);

		// get the actual value of the title
		WebElement numberTextBox = driver.findElement(By.id("inputNumber"));
		numberTextBox.sendKeys(Constants.test4Input);
		WebElement submitButton = driver.findElement(By.id("submitButton"));
		submitButton.click();

		String actualTitle = driver.getTitle();
		if (actualTitle.contentEquals(Constants.expectedTitleInvalid)) {
			System.out.println("Test #4 Passed!");
		} else {
			System.out.println("Test #4 Failed:" + actualTitle);
		}

		// close Chrome browser
		driver.close();
		return true;
	}

	public boolean getInvalidInputPage5Test(String url) {
		WebDriver driver = new ChromeDriver();
		// launch browser and direct it to the Base URL
		driver.get(url);

		// get the actual value of the title
		WebElement numberTextBox = driver.findElement(By.id("inputNumber"));
		numberTextBox.sendKeys(Constants.test5Input);
		WebElement submitButton = driver.findElement(By.id("submitButton"));
		submitButton.click();

		String actualTitle = driver.getTitle();
		if (actualTitle.contentEquals(Constants.expectedTitleOutputTest5)) {
			System.out.println("Test #5 Passed!");
		} else {
			System.out.println("Test #5 Failed:" + actualTitle);
		}

		// close Chrome browser
		driver.close();
		return true;
	}

	public boolean getInvalidInputPage6Test(String url) {
		WebDriver driver = new ChromeDriver();
		// launch browser and direct it to the Base URL
		driver.get(url);

		// get the actual value of the title
		WebElement numberTextBox = driver.findElement(By.id("inputNumber"));
		numberTextBox.sendKeys(Constants.test6Input);
		WebElement submitButton = driver.findElement(By.id("submitButton"));
		submitButton.click();

		String actualTitle = driver.getTitle();
		if (actualTitle.contentEquals(Constants.expectedTitleInput)) {
			System.out.println("Test #6 Passed!");
		} else {
			System.out.println("Test #6 Failed:" + actualTitle);
		}

		// close Chrome browser
		driver.close();
		return true;
	}

	public boolean getInvalidInputPage7Test(String url) {
		WebDriver driver = new ChromeDriver();
		// launch browser and direct it to the Base URL
		driver.get(url);

		// get the actual value of the title
		WebElement numberTextBox = driver.findElement(By.id("inputNumber"));
		numberTextBox.sendKeys(Constants.test7Input);
		WebElement submitButton = driver.findElement(By.id("submitButton"));
		submitButton.click();

		String actualTitle = driver.getTitle();
		if (actualTitle.contentEquals(Constants.expectedTitleInput)) {
			System.out.println("Test #7 Passed!");
		} else {
			System.out.println("Test #7 Failed:" + actualTitle);
		}

		// close Chrome browser
		driver.close();
		return true;
	}

	public boolean getInvalidInputPage8Test(String url) {
		WebDriver driver = new ChromeDriver();
		// launch browser and direct it to the Base URL
		driver.get(url);

		// get the actual value of the title
		WebElement numberTextBox = driver.findElement(By.id("inputNumber"));
		numberTextBox.sendKeys(Constants.test8Input);
		WebElement submitButton = driver.findElement(By.id("submitButton"));
		submitButton.click();

		String actualTitle = driver.getTitle();
		if (actualTitle.contentEquals(Constants.expectedTitleInput)) {
			System.out.println("Test #8 Passed!");
		} else {
			System.out.println("Test #8 Failed:" + actualTitle);
		}

		// close Chrome browser
		driver.close();
		return true;
	}

	@SuppressWarnings("null")
	public static void main(String[] args) {
		/*
		 * Starting Firefox 35, you need to use gecko driver created by Mozilla to use
		 * Web Driver. Selenium 3.0, gecko and firefox has compatibility issues
		 * declaration and instantiation of objects/variables
		 * System.setProperty("webdriver.firefox.marionette","C:\\geckodriver.exe");
		 * this is for Windows OS 
		 * WebDriver driver = new FirefoxDriver();
		 * Use the above line instead of WebDriver driver = new ChromeDriver();
		 * You may face time out issues in some machines
		 */
		String confFile = "applicationContext.xml";
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(confFile);
		HostNameAPI hostConfig = (HostNameAPI) context.getBean("hostURLapi");
		context.close();

		URL url = null;
		try {
			url = new URL(hostConfig.hostName);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block

			System.out.println("Error connection:" + url.getHost() + e);

			e.printStackTrace();
			continueTestFlag = false;

		}
		while (continueTestFlag) {
			SeleniumTests in = new AutoTest();
			in.getInputTitleTest(hostConfig.hostName);
			in.getValidOutputPageTest(hostConfig.hostName);
			in.getInvalidInputPageTest(hostConfig.hostName);
			in.getInvalidOutputPageTest(hostConfig.hostName);
			in.getInvalidInputPage5Test(hostConfig.hostName);
			in.getInvalidInputPage6Test(hostConfig.hostName);
			in.getInvalidInputPage7Test(hostConfig.hostName);
			in.getInvalidInputPage8Test(hostConfig.hostName);
			continueTestFlag = false;
			System.out.println("All Tests Completed");
		}
	}

}
