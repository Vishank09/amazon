package com.amazon.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.Step;

public class AddressPage {
	@AndroidFindBy(uiAutomator="text(\"Add a New Address\")")
	private WebElement addNewAddress;

	@AndroidFindBy(id="address-ui-widgets-enterAddressFullName")
	private WebElement fullName;

	@AndroidFindBy(id="address-ui-widgets-enterAddressPhoneNumber")
	private WebElement phoneNumber;

	@AndroidFindBy(id="address-ui-widgets-enterAddressPostalCode")
	private WebElement postalCode;

	@AndroidFindBy(id="address-ui-widgets-enterAddressLine1")
	private WebElement addressOne;

	@AndroidFindBy(id="address-ui-widgets-enterAddressLine2")
	private WebElement addressTwo;

	@AndroidFindBy(id="address-ui-widgets-enterAddressCity")
	private WebElement city;

	@AndroidFindBy(id="address-ui-widgets-enterAddressStateOrRegion")
	private WebElement state;

	@AndroidFindBy(uiAutomator="text(\"CHANDIGARH\")")
	private WebElement stateSelect;

	@AndroidFindBy(id="address-ui-widgets-use-as-my-default")
	private WebElement defaultCheckbox;

	@AndroidFindBy(uiAutomator="text(\"Add address\")")
	private WebElement addAddressBtn;

	private AndroidDriver<AndroidElement> driver1;
	public AddressPage(AndroidDriver<AndroidElement> driver){
		this.driver1= driver1;
		PageFactory.initElements(new AppiumFieldDecorator(driver1), this);
	}
	@Step("User has click on add new address button...")
	public void addNewAddressBtn(){
		addNewAddress.click();
	}
	@Step("User has enter the {0} as fullname....")
	public void fullNameField(String fullname){
		fullName.sendKeys(fullname);	
	}
	@Step("User has enter the {0} as a phone number....")
	public void phoneNumberField(String number){
		phoneNumber.sendKeys(number);	
	}
	@Step("User has enter the {0} as a postal code....")
	public void postalCodeField(String postal){
		postalCode.sendKeys(postal);	
	}
	@Step("User has enter the {0} as house number....")
	public void addressOneField(String house){
		addressOne.sendKeys(house);	
	}
	@Step("User has enter the {0} as a sector....")
	public void addressTwoField(String sector){
		addressTwo.sendKeys(sector);	
	}
	@Step("User has enter the {0} as a city....")
	public void cityField(String cityname){
		city.sendKeys(cityname);	
	}
	@Step("User has click on default checkbox...")
	public void defaultCheckboxField(){
		defaultCheckbox.click();
	}
	@Step("User has click on add address button...")
	public void addAddressBtn(){
		addAddressBtn.click();
	}
}
