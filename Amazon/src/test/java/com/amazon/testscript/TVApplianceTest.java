package com.amazon.testscript;

import org.testng.annotations.Test;

import com.amazon.generic.BaseLib;
import com.amazon.generic.ExcelUtilityLib;
import com.amazon.pageobject.AddToCartPage;
import com.amazon.pageobject.AddressPage;
import com.amazon.pageobject.CardDetailsPage;
import com.amazon.pageobject.CheckOutPage;
import com.amazon.pageobject.HomePage;
import com.amazon.pageobject.LoginPage;
import com.amazon.pageobject.TVApplianceSearchPage;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class TVApplianceTest extends BaseLib{
	String amazonsheet="amazon";
	@Test(priority=1)
	@Severity(SeverityLevel.CRITICAL)
	@Description("Test Case Description: To verify the item name and price must same on checkout screen")
	@Story("Story Name: To check item name and price functionality")
	public void verifyItemNameAndPrice()  {
		LoginPage login = new LoginPage(driver1);
		login.createAccount();
		login.custNameField(ExcelUtilityLib.getKeyValue(amazonsheet, "username-valid", "username"));
		login.custPhNumField(ExcelUtilityLib.getKeyValue(amazonsheet, "phonenumber-valid", "phonenumber"));
		login.passwordField(ExcelUtilityLib.getKeyValue(amazonsheet, "password-valid", "password"));
		login.mobileNumberBtnTap();
		HomePage home = new HomePage(driver1);
		home.searchBoxTap();
		home.enterSearchData(ExcelUtilityLib.getKeyValue(amazonsheet, "search-TV", "TV-Name"));
		home.tvTap();
		TVApplianceSearchPage search = new TVApplianceSearchPage(driver1);
		search.tclTVDataTap();
		search.itemName();
		search.verifyTVName();
		search.addToCartScroll();
		search.doneBtnTap();
		search.cartIconTap();
		AddToCartPage cart =new AddToCartPage(driver1);
		search.itemPrice();
		cart.proceedToBuyBtn();
		AddressPage address =new AddressPage(driver1);
		address.addNewAddressBtn();
		address.fullNameField(ExcelUtilityLib.getKeyValue(amazonsheet, "valid-fullname", "fullname"));
		address.phoneNumberField(ExcelUtilityLib.getKeyValue(amazonsheet, "valid-phonenumber", "phonenumber"));
		address.postalCodeField(ExcelUtilityLib.getKeyValue(amazonsheet, "valid-postalcode", "postalcode"));
		address.addressOneField(ExcelUtilityLib.getKeyValue(amazonsheet, "valid-addressone", "addressone"));
		address.addressTwoField(ExcelUtilityLib.getKeyValue(amazonsheet, "valid-addresstwo", "addresstwo"));
		address.defaultCheckboxField();
		address.addNewAddressBtn();
		cart.continueBtn();
		cart.continueBtn();
		CardDetailsPage card =new CardDetailsPage(driver1);
		card.cardCheckBoxTap();
		card.cardNumberField(ExcelUtilityLib.getKeyValue(amazonsheet, "valid-cardNumber", "cardnumber"));
		card.expiryMonth();
		card.monthSelectDrpdwn(ExcelUtilityLib.getKeyValue(amazonsheet, "valid-month", "month"));
		card.expiryYear();
		card.drpdwnYear(ExcelUtilityLib.getKeyValue(amazonsheet, "valid-year", "year"));
		card.addYourCardBtn();
		card.cvvCodeField(ExcelUtilityLib.getKeyValue(amazonsheet, "valid-cvv", "cvv"));
		cart.continueBtn();
		CheckOutPage checkout = new CheckOutPage(driver1);
		checkout.verifyTVNameCheckout();
		checkout.verifyTVPriceCheckout();		
	}
}