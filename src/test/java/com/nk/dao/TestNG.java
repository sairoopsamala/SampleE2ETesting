package com.nk.dao;

import org.junit.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNG {

	/*
	 * @BeforeSuite -- setup system property for chrome
@BeforeTest -- login method
@BeforeClass --launch Chrome Browser

@BeforeMethod -- enter URL
@Test -- google title test
@AfterMethod -- Logout from app

@BeforeMethod -- enter URL
@Test -- google title test2
@AfterMethod -- Logout from app

@AfterTest -- deleteAllCookies

PASSED: googleTitleTest
PASSED: googleTitleTest2

===============================================
    Default test
    Tests run: 2, Failures: 0, Skips: 0
===============================================

@AfterSuite -- generate test report
	 */
	
	
	//Pre-conditions annotations-- starting with  @Before
	
	@BeforeSuite //1
	public void setUp() {
		System.out.println("@BeforeSuite -- setup system property for chrome");
	}
	
	@BeforeTest
	public void login() {
		System.out.println("@BeforeTest -- login method");
	}
	
	@BeforeClass
	public void launchBrowser() {
		System.out.println("@BeforeClass --launch Chrome Browser");
	}
	
	/*
	 * @BeforMethod
	 * @Test -1
	 * @AfterMethod
	 * 
	 * @beforeTest
	 * @Test -2
	 * @AfterMethod
	 * 
	 * 
	 */
	
	@BeforeMethod
	public void enterURL() {
		System.out.println("@BeforeMethod -- enter URL");
	}
	
	//test cases--starting with @Test
	
	@Test
	public void googleTitleTest() {
		System.out.println("@Test -- google title test");
	}
	
	@Test
	public void googleTitleTest2() {
		System.out.println("@Test -- google title test2");
	}

	
	//post conditions -- starting with @After
	
	@AfterMethod
	public void logOut()
	{
		System.out.println("@AfterMethod -- Logout from app");
	}
	
	@AfterTest
	public void deleteAllCookies() {
		System.out.println("@AfterTest -- deleteAllCookies");
	}
	
	@AfterClass
	public void closeBrowser(){
		System.out.println("@AfterClass -- Close Browser");
		
	}
	
	@AfterSuite
	public void generateTestReport() {
		System.out.println("@AfterSuite -- generate test report");
	}
}
