package com.amazon.generic;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
public class BaseLib {
	public AndroidDriver<AndroidElement> driver1;
	DesiredCapabilities capabilities = new DesiredCapabilities();
	@BeforeTest
	public void setUp() throws MalformedURLException  
	{
		capabilities.setCapability("deviceName", "Shubham verma");
		capabilities.setCapability(CapabilityType.VERSION, "9");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("appPackage", "com.amazon.mShop.android.shopping");
		capabilities.setCapability("appActivity","com.amazon.mShop.home.HomeActivity");
		capabilities.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, true);
		capabilities.setCapability("newCommandTimeout", "1500000");
		capabilities.setCapability("noReset", "false");
			driver1 = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);		
	}
	@AfterMethod
	public void postCondition(ITestResult result) throws InterruptedException{
		if (result.isSuccess()){
		}
		else{
			ScreenshotLib slib = new ScreenshotLib();
			String fileName = result.getMethod().getMethodName();
			slib.getScreenShot(driver1,fileName);
		}
	}
	@AfterTest
	public void quitClass() throws InterruptedException{
		//driver1.closeApp();
		Reporter.log("App closed",true);
	}
}
