package com.amazon.pageobject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.Step;

public class CheckOutPage extends TVApplianceSearchPage{
	@AndroidFindBy(uiAutomator="text(\"Proceed to Buy\")")
	private WebElement proceed;
	
	@AndroidFindBy(uiAutomator="text(\"TCL 163.96 cm (65 inches)  AI 4K UHD Certified Android Smart LED TV 65P8 (Black) (2019 Model)\")")
	private WebElement tvName;
	
	@AndroidFindBy(uiAutomator="text(\"53,999.00\")")
	private WebElement tvPrice;
	
	private AndroidDriver<AndroidElement> driver1;

	public CheckOutPage(AndroidDriver<AndroidElement> driver){
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver1), this);
	}
	@Step("User has click on proceed Button....")
	public void proceedToBuyBtn(){
		proceed.click();
	}
	@Override
	public void tclTVDataTap() {
		// TODO Auto-generated method stub
		super.tclTVDataTap();
	}
	@Override
	public void verifyTVName() {
		// TODO Auto-generated method stub
		super.verifyTVName();
	}
	@Override
	public String itemName() {
		// TODO Auto-generated method stub
		return super.itemName();
	}
	@Override
	public String itemPrice() {
		// TODO Auto-generated method stub
		return super.itemPrice();
	}
	@Step("User has verify the item name on checkout page....")
	public void verifyTVNameCheckout(){
		String expname=tvName.getText();
		Assert.assertEquals(itemName(), expname, "The TV name is not same");		
	}
	@Step("User has verify the item price on checkout page....")
	public void verifyTVPriceCheckout(){
		String expprice=tvPrice.getText();
		Assert.assertEquals(itemPrice(), expprice, "The TV name is not same");		
	}
}
