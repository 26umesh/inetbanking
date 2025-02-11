package com.inetbanking.utillities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {
	Properties pro;
	public ReadConfig() {
		File src=new File("./Configuration/config.properties");
		
		try {
			FileInputStream fis=new FileInputStream(src);
			pro=new Properties();
			try {
				pro.load(fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public String getapplicationURL()
	{
		String url=pro.getProperty("baseURL");
		return url;
	}
	
	public String getapplicationusername()
	{
		String username=pro.getProperty("username");
		return username;
	}
	
	public String getapplicationpassword()
	{
		String password=pro.getProperty("password");
		return password;
	}
	
	public String getchromepath()
	{
		String chromepath=pro.getProperty("chromepath");
		return chromepath;
	}
	
	public String getfirefoxpath()
	{
		String firefoxpath=pro.getProperty("firefoxpath");
		return firefoxpath;
	}
	
	public String getiepath()
	{
		String iepath=pro.getProperty("iepath");
		return iepath;
	}
	
	
	
}
