package com.nk.dao;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class GoogleTitleTest {

WebDriver driver; 
	
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "E:\\chromedriver.exe");
		driver= new ChromeDriver();//launch chrome
		driver.manage().window().maximize();//maximize window
		driver.manage().deleteAllCookies();// delete all the cookies
		
		//dynamic wait
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://www.google.com"); //enter URL
			}
	
	@Test()
	public void googleTitleTest() {
		String title = driver.getTitle();
		System.out.println(title);
		
		Assert.assertEquals(title, "Google123", "title is not matched");
	}
	
	@Test
	public void googleLogoTest() {
		boolean b = driver.findElement(By.xpath("//*[@alt='Google']")).isDisplayed();
		Assert.assertTrue(b);
		Assert.assertEquals(b,true);
	}
	
	@AfterMethod
	public void tearMethod() {
		driver.quit();
	}
	
}
