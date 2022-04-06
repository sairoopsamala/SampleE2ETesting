package com.nk.dao;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators {
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "E:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//driver.get("https://demo.guru99.com/test/selenium-xpath.html");
		//driver.get("https://accounts.google.com/");
		//driver.get("https://www.google.com/");
		driver.get("https://login.yahoo.com");
		/*
		 * WebElement username=driver.findElement(By.name("uid"));
		 * username.sendKeys("sairoop@gmail.com");
		 */
		/* name attribute
		 * if name attribute is not there then we find no such element exception
		 *  */
		
		//driver.findElement(By.name("uid")).sendKeys("sairoop");
		
		/*
		 * WebElement username=driver.findElement(By.name("q"));
		 * username.sendKeys("Selenium"); username.submit(); Thread.sleep(2000);
		 * driver.findElement(By.name("btnk")).click();
		 */
		
		//Thread.sleep(20000);
		
		/* id attribute 
		 * id attribute is unique 
		 */
		
		//driver.findElement(By.id("identifierId")).sendKeys("sairoop@gmail.com");
		
		/* link text */
		
		//driver.findElement(By.linkText("Forgot username?")).click();
		
		/* CSS selector: best possible way to locate complex elements in web page
		 * starts with # and give id value to it */
		/*
		 * driver.findElement(By.cssSelector("#login-username")).sendKeys("sairoop");
		 * Thread.sleep(2000);
		 * driver.findElement(By.cssSelector("#login-signin")).click();
		 */
		
		/* Partial link text instead of giving complete text can provide partial text and search */
		
		//driver.findElement(By.partialLinkText("Forgot user")).click();
		
		/* Xpath */
		
		driver.findElement(By.xpath("//input[@id='login-username']")).sendKeys("sairoop");
		driver.findElement(By.xpath("//input[@id='login-signin']")).click();
	}

}
