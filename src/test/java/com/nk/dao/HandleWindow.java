package com.nk.dao;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleWindow {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();//launch chrome
		driver.get("http://seleniumpractise.blogspot.in/2017/07/multiple-window-examples.html");
		
		String parent = driver.getWindowHandle();//to get parent window handle name		
		System.out.println("Parent window id id:"+parent);
		
		driver.findElement(By.xpath("//a[contains(@href,'http://www.google.com')]")).click();
		
		Set<String> allWindows = driver.getWindowHandles();
		
		int count = allWindows.size();
		
		System.out.println("Total window:"+count);
		
		for(String child:allWindows)
		{
			if(!parent.equalsIgnoreCase(child))
			{
				driver.switchTo().window(child);
				driver.findElement(By.name("q")).sendKeys("Selenium Webdriver");
				
				Thread.sleep(3000);
				
				driver.close();
			}
		}
		driver.switchTo().window(parent);
		
		System.out.println("Parent window title is "+driver.getTitle());
	}

}
