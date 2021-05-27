package com.test.raj.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.test.raj.utils.WebdriverManager;

public class PersonalInformationPage extends BasePage {

	public PersonalInformationPage(WebdriverManager driverManager) {
		super(driverManager);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//*[@class='login']")
	public WebElement signInLink;
	
	@FindBy(id ="email")
	public WebElement userName;
	
	@FindBy(id ="passwd")
	public WebElement password;
	
	@FindBy(id= "SubmitLogin")
	public WebElement signInButton;
	
	@FindBy(xpath= "//*[text()='My personal information']")
	public WebElement personalInformationButton;
	
	@FindBy(id= "firstname")
	public WebElement firstName;
	
	@FindBy(id= "old_passwd")
	public WebElement currentPassword;
	
	@FindBy(name="submitIdentity")
	public WebElement saveButton;
	
	@FindBy(xpath= "//div[@class='box']/p")
	public WebElement successMessage;
	
}
