package com.inetbanking.testcaes;

import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.intbanking.pageobject.Addcustomerpage;
import com.intbanking.pageobject.loginpage;



public class Tc_AddcustomerTest_00 extends BaseClass {
	
	@Test
	public void addNewCustomer() throws InterruptedException, IOException {
		loginpage ip=new loginpage(driver);
		ip.setUserName(username);
		logger.info("Ented user name");
		ip.setPasword(password);
		logger.info("Entered password");
		ip.clickSubmit();
		
		Thread.sleep(300);
		Addcustomerpage addcust=new Addcustomerpage(driver);
		
		 addcust.clickAddNewCustomer();
		 
		 logger.info("providing customer details....");
			
			
			addcust.custName("Umesh");
			addcust.custgender("male");
			addcust.custdob("10","15","1985");
			Thread.sleep(5000);
			addcust.custaddress("INDIA");
			addcust.custcity("HYD");
			addcust.custstate("AP");
			addcust.custpinno("5000074");
			addcust.custtelephoneno("987890091");
			
			 String email=randomestring()+"@gmail.com";
			addcust.custemailid(email);
			addcust.custpassword("abcdef");
			addcust.custsubmit();
			logger.info("validation started....");
			
			boolean res=driver.getPageSource().contains("Customer Registered Successfully!!!");
			
			if(res==true)
			{
				Assert.assertTrue(true);
				logger.info("test case passed....");
				
			}
			else
			{
				logger.info("test case failed....");
				captureScreen(driver,"addNewCustomer");
				Assert.assertTrue(false);
			}
				
		
		
	}

	
	
	
}
