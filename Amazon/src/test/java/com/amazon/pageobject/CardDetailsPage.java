package com.amazon.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.Step;

public class CardDetailsPage {
	@AndroidFindBy(id="pp-mWgR4G-185")
	private WebElement cardNumber;
	@AndroidFindBy(id="pp-mWgR4G-189")
	private WebElement expiryMonth;
	@AndroidFindBy(id="pp-mWgR4G-190")
	private WebElement expiryYear;
	@AndroidFindBy(id="pp-nTLAjZ-99")
	private WebElement cvvCode;
	@AndroidFindBy(uiAutomator="text(\"04\")")
	private WebElement aprilMonth;
	@AndroidFindBy(uiAutomator="text(\"2022\")")
	private WebElement yearDrpdwn;
	@AndroidFindBy(uiAutomator="text(\"Add your card\")")
	private WebElement addYourCardBtn;
	@AndroidFindBy(uiAutomator="text(\"Add Debit/Credit/ATM Card\")")
	private WebElement cardCheckbox;
	private AndroidDriver<AndroidElement> driver1;

	public CardDetailsPage(AndroidDriver<AndroidElement> driver){
		this.driver1= driver1;
		PageFactory.initElements(new AppiumFieldDecorator(driver1), this);
	}
	@Step("User has click on cards checkbox...")
	public void cardCheckBoxTap(){
		cardCheckbox.click();
	}
	@Step("User has enter the {0} as a card number....")
	public void cardNumberField(String cardnumber){
		cardNumber.sendKeys(cardnumber);
	}
	@Step("User has click on expiry month dropdown...")
	public void expiryMonth(){
		expiryMonth.click();
	}
	@Step("User has select the month {0} from the dropdown...")
	public void monthSelectDrpdwn(String month){
		WebElement monthdrpdwn = driver1.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"" + month + "\")"));
		monthdrpdwn.click();
	}
	@Step("User has click on expiry year dropdown...")
	public void expiryYear(){
		expiryYear.click();
	}
	@Step("User has select the year {0} from the dropdown...")
	public void drpdwnYear(String year){
		WebElement yeardrpdwn = driver1.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"" + year + "\")"));
		yeardrpdwn.click();
	}
	@Step("User has click on add your card button...")
	public void addYourCardBtn(){
		addYourCardBtn.click();
	}
	@Step("User has enter the {0} as a card number....")
	public void cvvCodeField(String cvv){
		cvvCode.sendKeys(cvv);
	}
}
