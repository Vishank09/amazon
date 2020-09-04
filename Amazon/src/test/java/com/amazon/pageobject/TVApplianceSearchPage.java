package com.amazon.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import com.amazon.generic.WaitStatementLib;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.Step;

public class TVApplianceSearchPage {
	@AndroidFindBy(uiAutomator="text(\"53,999.00\")")
	private WebElement itemPrice;

	@AndroidFindBy(id="Cart")
	private WebElement cartIcon;
	
	@AndroidFindBy(uiAutomator="text(\"TCL 163.96 cm (65 inches)  AI 4K UHD Certified Android Smart LED TV 65P8 (Black) (2019 Model)\")")
	private WebElement tclTV;
	
	@AndroidFindBy(uiAutomator="text(\"Add to Cart\")")
	private WebElement addToCart;
	
	@AndroidFindBy(uiAutomator="text(\"DONE\")")
	private WebElement doneBtn;
	
	String itemname;
	String itemprice;
	private AndroidDriver<AndroidElement> driver1;

	public TVApplianceSearchPage(AndroidDriver<AndroidElement> driver){
		this.driver1= driver1;
		PageFactory.initElements(new AppiumFieldDecorator(driver1), this);
	}
	@Step("User has click on TCL TV link....")
	public void tclTVDataTap() {
		WaitStatementLib.explicitlyWaitVisibilityOf(driver1, 20, tclTV);
		tclTV.click();
	}
	@Step("User has store the item name....")
	public String itemName(){
		itemname =	tclTV.getText();
		return itemname;
	}
	@Step("User has verify TV name is same as he has selected....")
	public void verifyTVName(){
		String exptvname= tclTV.getText();
		Assert.assertEquals(itemName(), exptvname, "The TV name is not same as expected");
		Reporter.log("The TV name is same as expected", true);		
	}
	@Step("User has store the item price....")
	public String itemPrice(){
		itemprice =	itemPrice.getText();
		return itemprice;
	}
	@Step("User has scroll to click on add to cart button....")
	public void addToCartScroll(){
		TouchActions action = new TouchActions(driver1);
		action.scroll(addToCart, 38, 1490);
		action.perform();
	}
	@Step("User has click on Done button....")
	public void doneBtnTap() {
		WaitStatementLib.explicitlyWaitVisibilityOf(driver1, 20, doneBtn);
		doneBtn.click();
	}
	@Step("User has click on cart icon present on the top right corner....")
	public void cartIconTap() {
		WaitStatementLib.explicitlyWaitElementToBeSelected(driver1, 20, cartIcon);
		cartIcon.click();
	}
	
}
