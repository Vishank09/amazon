package com.amazon.pageobject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.PageFactory;

import com.amazon.generic.WaitStatementLib;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.Step;

public class HomePage {

	@AndroidFindBy(id="com.amazon.mShop.android.shopping:id/rs_search_src_text")
	private WebElement searchFieldTap;

	@AndroidFindBy(uiAutomator="text(\"Search\")")
	private WebElement searchData;

	@AndroidFindBy(uiAutomator="text(\"65 inch tv\")")
	private WebElement inchTV;

	
	String samsung;
	private AndroidDriver<AndroidElement> driver1;

	public HomePage(AndroidDriver<AndroidElement> driver){
		this.driver1= driver1;
		PageFactory.initElements(new AppiumFieldDecorator(driver1), this);
	}
	@Step("User has tap on search box....")
	public void searchBoxTap(){
		TouchActions action = new TouchActions(driver1);
		action.singleTap(searchFieldTap);
		action.perform();
	}
	@Step("User has enter the data {0} need to be search...")
	public void enterSearchData(String data){
		searchData.sendKeys(data);
	}
	@Step("User has click on the data after the search operation....")
	public void tvTap() {
		WaitStatementLib.explicitlyWaitVisibilityOf(driver1, 20, inchTV);
		inchTV.click();
	}
	
	
}

