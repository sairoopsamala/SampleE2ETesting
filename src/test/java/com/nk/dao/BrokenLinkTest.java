package com.nk.dao;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinkTest {

	public static void main(String[] args) throws InterruptedException, MalformedURLException, IOException {

		System.setProperty("webdriver.chrome.driver", "E:\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();//launch chrome
		
		driver.manage().window().maximize();//maximize window
		driver.manage().deleteAllCookies();// delete all the cookies
		
		//dynamic wait
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("https://www.freecrm.com/"); //enter URL
		
		driver.findElement(By.name("username")).sendKeys("sairoop");
		driver.findElement(By.name("password")).sendKeys("Password@123");
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		driver.switchTo().frame("mainpanel");
		
		//links -- //a href<http://www.google.com>
		//images -- //img href <http://www.test.com>
		
		//1.get the list of all the links and images:
		List<WebElement> linkList = driver.findElements(By.tagName("a"));
		linkList.addAll(driver.findElements(By.tagName("img")));
		
		System.out.println("size of active links and images--->"+linkList.size());
		
		List<WebElement> activeLinks = new ArrayList<WebElement>();
		
		//2. iterate linksList : exclude all the links/images - doesnot have any href attribute
		for(int i=0; i<linkList.size(); i++)
		{
			if(linkList.get(i).getAttribute("href") !=null && (!linkList.get(i).getAttribute("href").contains("Javascript")))
			{
				activeLinks.add(linkList.get(i));
			}
		}
		
		//get the size of active links list:
		System.out.println("size of active links and images--->"+activeLinks.size());
		
		//3. check the href url, with httpconnection api:
		//200-- ok
		//404 -- not found
		//500 -- internal error
		//400 -- bad request
		for(int j=0; j<activeLinks.size(); j++)
		{
			HttpURLConnection connection = (HttpURLConnection) new URL(activeLinks.get(j).getAttribute("href")).openConnection();
			
			connection.connect();
			String response = connection.getResponseMessage(); //ok
			connection.disconnect();
			System.out.println(activeLinks.get(j).getAttribute("href") +"--->"+response);
		}
	}

}
