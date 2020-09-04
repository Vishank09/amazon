package com.amazon.generic;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class ScreenshotLib {

	public void getScreenShot(WebDriver driver, String fileName){
		String FILE_SEPARATOR = File.separator;
		String FILE_PATH = System.getProperty("user.dir")+FILE_SEPARATOR+"screenshot_folder"+FILE_SEPARATOR+fileName +".png";

		EventFiringWebDriver efw= new EventFiringWebDriver(driver);
		File srcFile = efw.getScreenshotAs(OutputType.FILE);

		File desFile = new File(FILE_PATH);
		try
		{
			FileUtils.copyFile(srcFile, desFile);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
}
