package com.ciklum.exercise;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test {
	
	static final String[] USERS = {"Jan van Dam", "Chack Norris", "Klark n Kent", "John Daw", "Bat Man", "Tim Los", "Dave o Core", "Pay Pal", "Lazy Cat", "Jack & Johnes"};
	static final String DEMOQA_REGISTRATION_URL = "http://demoqa.com/registration/"; 
	static final Integer USERS_TO_REGISTER = 5;
	static final String ASSERT_PAGE_IS_NOT_CORRECT_MSG = "Page loaded doesn´t match the navigated URL.";
	static final String ASSERT_STRUCTURES_SIZE_DO_NOT_MATCH = "Constant USERS and auxiliar structure usersList must match.";
	static final String ASSERT_REGISTRATION_NOT_SUCCESSFUL_MSG = "There were a problem during the registration process";
	
	private WebDriver driver;
	private List<User> usersList;
	private RegistrationPage registrationPage;
	
	public Test() {
		driver = new ChromeDriver();
		registrationPage = new RegistrationPage(driver);
		createUsersList();
	}
	
	public void execute() {
		for(int i = 0; i<USERS_TO_REGISTER; i++) {
			loadRegistrationPage();
			User user = chooseRandomUser();
			register(user);
		}
		printNotRegisteredUsersFromTheList();
		closeBrowserWindow();
	}
	
	private void createUsersList() {
		usersList = new ArrayList<User>();
		for(int i=0; i<USERS.length; i++) {
			usersList.add(new User(USERS[i]));
		}
	}
	
	private void loadRegistrationPage() {
		driver.get(DEMOQA_REGISTRATION_URL);
		assert isURLNavigatedCorrectly() : ASSERT_PAGE_IS_NOT_CORRECT_MSG;
	}
	
	private User chooseRandomUser() {
		Boolean chosen = Boolean.FALSE;
		User user = null;
		while(!chosen){
			int i = Integer.parseInt(ExerciseUtils.getRandomPositiveInteger(1, 9));
			if(!usersList.get(i).isRegistered()) {
				user = usersList.get(i);
				break;
			}
		}
		return user;
	}
	
	private void register(User user) {
		registrationPage.fillFirstName(user.getFirstName());
		registrationPage.fillLastName(user.getSecondName());
		String hobbyIndex = ExerciseUtils.getRandomPositiveInteger(1, 2);
		registrationPage.fillHobbies(Integer.parseInt(hobbyIndex));
		String phoneNumber = ExerciseUtils.getRandomPositiveInteger(10, 9);
		registrationPage.fillPhoneNumber(phoneNumber);
		String username = ExerciseUtils.getRandomAlphanumericString(6, 35);
		registrationPage.fillUsername(username);
		String email = ExerciseUtils.getRandomAlphanumericString(4, 35) + '@' + ExerciseUtils.getRandomAlphanumericString(4, 35) + '.' + ExerciseUtils.getRandomAlphanumericString(3, 25); //last part forwarding the dot should be only chars 
		registrationPage.fillEmail(email);
		String password = ExerciseUtils.getRandomAlphanumericString(8, 35);
		registrationPage.fillPassword(password);
		registrationPage.fillPasswordConfirmation(password);
		registrationPage.clickOnSubmitButton();
		assert registrationPage.isRegistrationSuccessfulMsgDisplayed() : ASSERT_REGISTRATION_NOT_SUCCESSFUL_MSG;
		user.isRegistered(Boolean.TRUE);
	}
	
	private void printNotRegisteredUsersFromTheList() {
		assert USERS.length == usersList.size() : ASSERT_STRUCTURES_SIZE_DO_NOT_MATCH; 
		for(int i=0; i<USERS.length; i++) {
			if(!usersList.get(i).isRegistered()) {
				System.out.println(USERS[i]);
			}
		}
	}
	
	private Boolean isURLNavigatedCorrectly() {
		return driver.getCurrentUrl().equals(DEMOQA_REGISTRATION_URL);
	}
	
	private void closeBrowserWindow(){
		driver.quit();
	}
}
