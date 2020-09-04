package com.amazon.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.Step;

public class AddToCartPage {

	@AndroidFindBy(uiAutomator="text(\"Proceed to Buy\")")
	private WebElement proceed;
	@AndroidFindBy(uiAutomator="text(\"Continue\")")
	private WebElement continueBtn;
	@AndroidFindBy(uiAutomator="text(\"2 - 6 PM\")")
	private WebElement timeslotBtn;
	private AndroidDriver<AndroidElement> driver1;

	public AddToCartPage(AndroidDriver<AndroidElement> driver){
		this.driver1= driver1;
		PageFactory.initElements(new AppiumFieldDecorator(driver1), this);
	}
	@Step("User has click on proceed to buy button...")
	public void proceedToBuyBtn(){
		proceed.click();
	}
	@Step("User has click on continue button...")
	public void continueBtn(){
		continueBtn.click();
	}
	@Step("User has select on time slot for installation of TV...")
	public void timeSlotBtn(){
		timeslotBtn.click();
	}
}
