package com.facebook.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.facebook.baseTest.TestBase;
import com.facebook.pageobject.FaceBookPost;

public class FacebookTest extends TestBase{
	FaceBookPost fbpost;
	
	public FacebookTest() {
		super();
	}
	@BeforeMethod
	public void setUp() {
		initialization();
		driver.get(prop.getProperty("url"));
		fbpost = new FaceBookPost(); 
	}
	
	@Test
	public void post_fb_Data() {
		System.out.println(prop.getProperty("username")+ "=="+prop.getProperty("password"));
		fbpost.fb_login(prop.getProperty("username"), prop.getProperty("password"));
		fbpost.postData();
	}
	
	@AfterMethod
	public void teardown() {
		driver.close();
		driver.quit();
	}

}
