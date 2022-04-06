package com.nk.dao;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GoogleTest {

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
	
	@Test(priority=1, groups="Title Test")
	public void googleTitleTest() {
		String title = driver.getTitle();
		System.out.println(title);
	}
	
	@Test(priority=2,groups="Logo")
	public void googleLogoTest()
	{
		boolean b = driver.findElement(By.xpath("//*[@alt='Google']")).isDisplayed();
	}
	
	@Test(priority=3, groups="Link Test")
	public void mailLinkTest() {
		boolean b = driver.findElement(By.linkText("Gmail")).isDisplayed();
	}
	
	@Test(priority=4,groups="test")
	public void Test3() 
	{
		System.out.println("test1");	
	}
	
	@Test(priority=5,groups="test")
	public void Test4() 
	{
		System.out.println("test4");	
	}
	
	@Test(priority=6,groups="test")
	public void Test5() 
	{
		System.out.println("test5");	
	}
	
	@AfterMethod
	public void tearMethod() {
		driver.quit();
	}
}
