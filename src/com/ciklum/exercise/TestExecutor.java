package com.ciklum.exercise;

public class TestExecutor {
	final static String CHROME_DRIVER_LOCATION = "lib/chromedriver.exe";
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_LOCATION);
		Test test = new Test();
		test.execute();
	}
}
