package com.amazon.generic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitStatementLib {
	public static final int Implicit_Wait=20;
	public static final int Thread_Wait_8=8000;
	public static final int Thread_Wait_4=4000;
	public static final int Thread_Wait_2=2000;
	public static final int Thread_Wait_6=6000;

	public static void implicitlyWaitForSecond(WebDriver driver){
		driver.manage().timeouts().implicitlyWait(Implicit_Wait, TimeUnit.SECONDS);
	}
	public static void implicitlyWaitForMinute(WebDriver driver,int time){
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.MINUTES);
	}
	public static void explicitlyWaitForClickable(WebDriver driver,int time, WebElement element){
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	public static void explicitlyWaitVisibilityOf(WebDriver driver,int time, WebElement element){
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public static void explicitlyWaitElementToBeSelected(WebDriver driver,int time, WebElement element){
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.elementToBeSelected(element));
	}
	public static void explicitlyWaitInvisibilityOf(WebDriver driver,int time, WebElement element){
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.invisibilityOf(element));
	}
	public static void explicitlyWaitpresenceOfElementLocated(WebDriver driver,int time,By locator){
		WebDriverWait wait = new WebDriverWait(driver, time);
		//By locator = null;
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	public static void threadSleepOfEightSec() throws InterruptedException{
		Thread.sleep(Thread_Wait_8);
	}
	public static void threadSleepOfSixSec() throws InterruptedException{
		Thread.sleep(Thread_Wait_6);
	}
	public static void threadSleepOfFourSec() throws InterruptedException{
		Thread.sleep(Thread_Wait_4);
	}
	public static void threadSleepOfTwoSec() throws InterruptedException{
		Thread.sleep(Thread_Wait_2);
	}
	public static void pageLoadTime(WebDriver driver) throws InterruptedException{
		  driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
	}
}

