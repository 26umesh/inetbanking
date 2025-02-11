package com.inetbanking.testcaes;


import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.intbanking.pageobject.loginpage;

public class TC_logintest_001 extends BaseClass {

	
	@Test
	public void loginTest() throws IOException
	{
		driver.get( baseURL);
		logger.info("Entered user name");
		loginpage ip=new loginpage(driver);
		ip.setUserName(username);
		logger.info("Ented user name");
		ip.setPasword(password);
		logger.info("Entered password");
		ip.clickSubmit();
		logger.info("Entered submit button");
		//System.out.println(driver.getTitle());
		if(driver.getTitle().equals("GTPL Bank Manager HomePage")) {
			Assert.assertTrue(true);
			logger.info("Url opened");
		}
		else {
			captureScreen(driver,"loginTest");
			Assert.assertTrue(false);
			logger.info("Login failed");
		}
	}
}
