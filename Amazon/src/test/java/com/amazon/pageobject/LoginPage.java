package com.amazon.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.Step;

public class LoginPage {
	@AndroidFindBy(id="ap_customer_name")
	private WebElement custName;
	
	@AndroidFindBy(id="ap_phone_number")
	private WebElement custPhNumer;
	
	@AndroidFindBy(id="ap_password")
	private WebElement custPassword;
	
	@AndroidFindBy(id="continue")
	private WebElement verifyMobileNumBtn;

	@AndroidFindBy(uiAutomator="text(\"New to Amazon.in? Create an account\")")
	private WebElement createAccountTap;

	private AndroidDriver<AndroidElement> driver1;
	public LoginPage(AndroidDriver<AndroidElement> driver){
		this.driver1= driver1;
		PageFactory.initElements(new AppiumFieldDecorator(driver1), this);
	}
	@Step("User has click on Create Account Button....")
	public void createAccount(){
		createAccountTap.click();
	}
	@Step("User has enter the {0} as a customer name....")
	public void custNameField(String name){
		custName.sendKeys(name);
	}
	@Step("User has enter the {0} as a phone number....")
	public void custPhNumField(String phnumber){
		custPhNumer.sendKeys(phnumber);
	}
	@Step("User has enter the {0} as a password....")
	public void passwordField(String password){
		custPassword.sendKeys(password);
	}
	@Step("User has click on verify mobile number Button....")
	public void mobileNumberBtnTap(){
		verifyMobileNumBtn.click();
	}
}
