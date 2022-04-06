package com.inetbanking.testcases;

import java.io.IOException;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.AddCustomerPage;
import com.inetbanking.pageObjects.LoginPage;

public class TC_AddCustomerTest_003 extends BaseClass {

	@Test
	public void addNewCustomer() throws InterruptedException, IOException {
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		logger.info("user name provided");
		
		lp.setPassword(password);
		logger.info("Password provided");
		
		lp.clickSubmit();
		
		Thread.sleep(3000);
		
		AddCustomerPage addcust = new AddCustomerPage(driver);
		addcust.clickAddNewCustomer();
		logger.info("Providing customer details...");
		addcust.custName("Sairoop");
		addcust.custgender("male");
		addcust.custdob("10", "15", "1985");
		Thread.sleep(3000);
		addcust.custaddress("INDIA");
		addcust.custcity("HYD");
		addcust.custstate("AP");
		addcust.custpinno("530028");
		addcust.custtelephoneno("567894322");
		String email = randomString()+"@gmail.com";
		addcust.custemailid(email);
		addcust.custpassword("acdef");
		addcust.custsubmit();
		
		Thread.sleep(3000);
		logger.info("Validation started....");
		
		boolean res = driver.getPageSource().contains("Customer Registered Successfully!!!");
		
		if(res == true)
		{
			Assert.assertTrue(true);
			logger.info("test case passed...");
		}
		else
		{
			logger.info("testcase Failed...");
			captureScreen(driver, "addNewCustomer");
			Assert.assertTrue(false);
		}
	}
	
	
}
