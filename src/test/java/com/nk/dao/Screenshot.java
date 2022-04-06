package com.nk.dao;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.nk.commons.FileUtils;

public class Screenshot {
	
	public static void copyFile(File src, File file2) {
		// TODO Auto-generated method stub
		
	}

	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "E:\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();//launch chrome
		
		driver.manage().window().maximize();//maximize window
		driver.manage().deleteAllCookies();// delete all the cookies
		
		//dynamic wait
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.get("http://www.google.com");
		
		//take screenshot and store as a file format
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		//now copy the screenshot to desired location using copyfile // method
		Screenshot.copyFile(src, new File("E:/Sairoop/MySeleniumSessionsClasses/src/test/java/com/nk/dao/google.png"));
		
		
		
	}

}
