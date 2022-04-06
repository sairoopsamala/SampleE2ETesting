package com.nk.dao;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTableHandle {

		public static void main(String[] args) {
			WebDriver driver = new ChromeDriver();//launch chrome
			
			driver.manage().window().maximize();//maximize window
			driver.manage().deleteAllCookies();// delete all the cookies
			
			//dynamic wait
			driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			driver.get("https://www.w3schools.com/html/html_tables.asp"); //enter URL
			
			//*[@id="customers"]/tbody/tr[2]/td[1]
			//*[@id="customers"]/tbody/tr[3]/td[1]
			//*[@id="customers"]/tbody/tr[4]/td[1]
			//*[@id="customers"]/tbody/tr[7]/td[1]
			
			List<WebElement> rows = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr"));
			int rowCount = rows.size();
			System.out.println("Total rows in web table : " + rowCount);
			
			String beforeXpath = "//*[@id='customers']/tbody/tr[";
			String afterXpath = "]/td[1]";
			
			for(int i=2;i<= rowCount; i++)
			{
				String actualXpath = beforeXpath + i + afterXpath;
				WebElement element = driver.findElement(By.xpath(actualXpath));
				System.out.println(element.getText());
				if(element.getText().equals("Island Trading")) {
					System.out.println("company name :" + element.getText() + "is found" + "at position : " + (i - 1));
					break;
				}
			}
			
			System.out.println("********************");
			
			//*[@id="customers"]/tbody/tr[2]/td[2]
			String afterXpathContact = "]/td[1]";
			for(int i=2;i<= rowCount; i++)
			{
				String actualXpath = beforeXpath + i + afterXpathContact;
				WebElement element = driver.findElement(By.xpath(actualXpath));
				System.out.println(element.getText());
			}
			
			System.out.println("************************");
			
			String afterXpathCountry = "]/td[3]";
			for(int i=2;i<= rowCount; i++)
			{
				String actualXpath = beforeXpath + i + afterXpathCountry;
				WebElement element = driver.findElement(By.xpath(actualXpath));
				System.out.println(element.getText());
			}
			
			System.out.println("************************");

		
		
		//handle webtable columns:
		//*[@id="customers"]/tbody/tr[1]/th[1]
		//*[@id="customers"]/tbody/tr[1]/th[2]
		//*[@id="customers"]/tbody/tr[1]/th[3]
		
		String colBeforeXpath = "//*[@id='customers']/tbody/tr[1]/th[";
		String colAfterXpath = "]";
		List<WebElement> cols = driver.findElements(By.xpath("//*[@id='customers']/tbody/tr[1]/th"));
		int colCount = cols.size();
		System.out.println("Total number of columns are: "+colCount);
		
		System.out.println("Columns values are : ");
		for(int i=1; i<=colCount; i++)
		{
			WebElement element = driver.findElement(By.xpath(colBeforeXpath+i+colAfterXpath));
			String colText = element.getText();
			System.out.println(colText);
		}
		}
		
}
