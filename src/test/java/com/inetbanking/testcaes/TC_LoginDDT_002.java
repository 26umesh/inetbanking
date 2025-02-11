package com.inetbanking.testcaes;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetbanking.utillities.XLUtillites;
import com.intbanking.pageobject.loginpage;

public class TC_LoginDDT_002 extends BaseClass {
	@Test(dataProvider="Logindata")
	public void loginDDT(String user,String pwd) throws InterruptedException {
		loginpage ip=new loginpage(driver);
		ip.setUserName(user);
		logger.info("user name provided");
		ip.setPasword(pwd);
		logger.info("paswd provided");
		ip.clickSubmit();
		Thread.sleep(3000);
		
		if(isAlertPresent()==true) {
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.warn("login failed");
		}
		else {
			Assert.assertTrue(true);
			logger.info("login passed");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			ip.clicklogout();
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
		}
		
		
	}
	
	public boolean isAlertPresent() {
		try
		{
			driver.switchTo().alert();
			return true;
		}
		catch(NoAlertPresentException e) {
			return false;
			
			
		}
	}
	
	
	
	@DataProvider(name="Logindata")
	String [][] getData() throws IOException{
		String path="C:\\Users\\UMESH KACHHAWA\\eclipse-workspace2019\\inetbankingV1\\src\\test\\java\\com\\intenbanking\\testdata\\login details.xlsx";
		int rowum=XLUtillites.getRowCount(path, "Sheet1");
		int cocount=XLUtillites.getCellCount(path, "Sheet1", 1);
		
		String logindata[][]=new String[rowum][cocount];
		for(int i=1;i<=rowum;i++) {
			for(int j=0;j<cocount;j++) {
				logindata[i-1][j]=XLUtillites.getCellData(path, "Sheet1", i, j);
			}
			
		}
		return logindata;
		
	}
	

}
