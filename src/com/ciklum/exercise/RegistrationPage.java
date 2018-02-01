package com.ciklum.exercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegistrationPage {
	
	private static final String ID_FIRST_NAME_INPUT = "name_3_firstname";
	private static final String ID_LAST_NAME_INPUT = "name_3_lastname";
	private static final String NAME_HOBBY_INPUTS = "input[name='checkbox_5[]']";
	private static final String ID_PHONE_NUMBER_INPUT = "phone_9";
	private static final String ID_USERNAME_INPUT = "username";
	private static final String ID_EMAIL_INPUT = "email_1";
	private static final String ID_PASSWORD_INPUT = "password_2";
	private static final String ID_CONFIRM_PASSWORD_INPUT = "confirm_password_password_2";
	private static final String NAME_SUBMIT_BUTTON = "input[name='pie_submit']";
	private static final String XPATH_REGISTRATION_SUCCESSFUL_MSG = "//p[contains(text(),'Thank you for your registration')]";
	
	private WebDriver driver;
	
	public RegistrationPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void fillFirstName(String firstName) {
		driver.findElement(By.id(ID_FIRST_NAME_INPUT)).sendKeys(firstName);
	}
	
	public void fillLastName(String lastName) {
		driver.findElement(By.id(ID_LAST_NAME_INPUT)).sendKeys(lastName);
	}
	
	public void fillHobbies(Integer index) {
		driver.findElements(By.cssSelector(NAME_HOBBY_INPUTS)).get(index).click();
	}
	
	public void fillPhoneNumber(String phoneNumber) {
		driver.findElement(By.id(ID_PHONE_NUMBER_INPUT)).sendKeys(phoneNumber);
	}
	
	public void fillUsername(String username) {
		driver.findElement(By.id(ID_USERNAME_INPUT)).sendKeys(username);
	}
	
	public void fillEmail(String email) {
		driver.findElement(By.id(ID_EMAIL_INPUT)).sendKeys(email);
	}
	
	public void fillPassword(String password) {
		driver.findElement(By.id(ID_PASSWORD_INPUT)).sendKeys(password);
	}
	
	public void fillPasswordConfirmation(String passwordConfirmation) {
		driver.findElement(By.id(ID_CONFIRM_PASSWORD_INPUT)).sendKeys(passwordConfirmation);
	}
	
	public void clickOnSubmitButton() {
		driver.findElement(By.cssSelector(NAME_SUBMIT_BUTTON)).click();
	}
	
	public Boolean isRegistrationSuccessfulMsgDisplayed() {
		WebElement webElement = driver.findElement(By.xpath(XPATH_REGISTRATION_SUCCESSFUL_MSG));
		return webElement != null ? Boolean.TRUE : Boolean.FALSE;
	}
}
