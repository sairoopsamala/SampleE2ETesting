package com.nk.dao;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import junit.framework.Assert;

public class dropdown {
	public static void main(String[] args) throws InterruptedException {
	
		System.setProperty("webdriver.chrome.driver", "E:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//driver.get("http://ebay.com");
		//driver.get("https://guide.blazemeter.com/hc/en-us");
		//driver.get("https://app.hubspot.com/login");
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		driver.findElement(By.xpath("//*[@class='_6ltg']//*[text()='Create New Account']")).click();
		WebElement month_dropdown = driver.findElement(By.id("month"));
		Select month_dd = new Select(month_dropdown);
		
		// It will select April
		
//		month_dd.selectByIndex(3);
		
		Thread.sleep(3000);
		
		/*WebElement day_dropdown = driver.findElement(By.id("day"));
		Select day_dd = new Select(day_dropdown);
		
		//It will select day 4th
		day_dd.selectByValue("4");
		
		Thread.sleep(3000);
		
		WebElement year_dropdown = driver.findElement(By.id("year"));
		Select year_dd = new Select(year_dropdown);
		
		
		//It will select Year
		year_dd.selectByVisibleText("2021");*/
//======================================================================================================
		/*
		 * WebElement selected_value = month_dd.getFirstSelectedOption(); //checking the
		 * selected option
		 * System.out.println("Before selection selected values is "+selected_value.
		 * getText()); // printing the selected option
		 * 
		 * month_dd.selectByIndex(3); Thread.sleep(3000); WebElement selected_value1 =
		 * month_dd.getFirstSelectedOption(); //checking the selected option
		 * System.out.println("After selection selected values is "+selected_value1.
		 * getText()); // printing the selected option
		 */
		
//======================================================================================================

		//checking total number of months 
		
		List<WebElement> month_list = month_dd.getAllSelectedOptions();
		int total_month = month_list.size();
		
		Assert.assertEquals(total_month,  12);
		
		System.out.println("Total month count is:"+total_month);
		
		for(WebElement ele: month_list)
		{
			String month_name = ele.getText();
			System.out.println("Months are ==="+month_name);
		}
}
}
