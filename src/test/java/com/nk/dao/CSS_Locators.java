package com.nk.dao;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CSS_Locators {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "E:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//driver.get("http://ebay.com");
		driver.get("https://guide.blazemeter.com/hc/en-us");
		//driver.get("https://app.hubspot.com/login");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
//		driver.findElement(By.cssSelector("#gh-ac")).sendKeys("Oneplus9");
//		driver.findElement(By.cssSelector("#gh-btn")).click();
//		js.executeScript("window.scrollBy(0,300)");
		
		//driver.findElement(By.linkText("Getting Started")).click();
		//driver.findElement(By.xpath("//img[@alt='logo'")).isDisplayed();
//		driver.findElement(By.cssSelector("input#username.form-control.private-form_control.login-email")).click();
//		driver.findElement(By.cssSelector("input[id='username'][type='email']")).click();
//		driver.findElement(By.xpath("//input[@id='username' and @type='email'")).click(); //xpath
//		driver.findElement(By.cssSelector("input[id*='user'")).sendKeys("sairoop"); //contains text
//		driver.findElement(By.cssSelector("id=test_123")).click(); //dynamic css selectors
//		driver.findElement(By.cssSelector("input[id^='user']")).click(); //starting the text
//		driver.findElement(By.cssSelector("input[id$='name']")).click(); // ending the text
//		driver.findElement(By.cssSelector("div.private-form_input-wrapper,input#username")).click(); // comma 
//		driver.findElement(By.cssSelector("ul#categories>li:first-of-type")).click(); // first of type
//		driver.findElement(By.cssSelector("ul#categories>li:last-of-type")).click(); // last of type
//		driver.findElement(By.cssSelector("ul#categories>li:nth-of-type(4)")).click(); // nth of type
//		driver.findElement(By.cssSelector("ul#categories>li:first-of-type(n)")).click(); // all
		driver.findElement(By.cssSelector("ul#categories>li:nth-of-type(3)+li")).click(); // sibling of element

		

	}
}
