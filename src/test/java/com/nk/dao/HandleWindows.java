package com.nk.dao;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleWindows {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();//launch chrome
		driver.get("https://www.naukri.com/");
		
		String parent = driver.getWindowHandle();//to get parent window handle name		
		System.out.println("Parent window id id:"+parent);
		
		//driver.findElement(By.xpath("//a[contains(@href,'http://www.google.com')]")).click();
		
		Set<String> allWindows = driver.getWindowHandles();
		ArrayList<String> tabs = new ArrayList<>(allWindows);
		driver.switchTo().window(tabs.get(2));
		driver.close();
		driver.switchTo().window(tabs.get(1));
		driver.close();
		driver.switchTo().window(tabs.get(0));
		System.out.println("Title of parent window is:"+driver.getTitle());
		
	}

}
