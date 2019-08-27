package com.facebook.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.facebook.baseTest.TestBase;

public class FaceBookPost extends TestBase {
	
	//Object Repository
	
	@FindBy (id = "email")
	WebElement u_email;
	
	@FindBy(id="pass")
	WebElement u_password;
	
	@FindBy (id="loginbutton")
	WebElement lgn_btn;
	
	@FindBy (xpath="//div[contains(text(),'on your mind')]")
	WebElement enablepostfield;
	
	@FindBy (xpath="//*[@class='_1mf _1mj']")
	WebElement postfield;
	
	@FindBy(xpath= "//span[text()='Post']")
	WebElement post_btn;
	
	public FaceBookPost() {
		PageFactory.initElements(driver, this);
	}
	
	
	public void fb_login(String username, String password) {
		u_email.sendKeys(username);
		u_password.sendKeys(password);
		lgn_btn.click();
	}
	
	public void postData() {
		enablepostfield.click();
		Actions action =new Actions(driver);
		action.moveToElement(postfield);
		action.click();
		action.sendKeys("Hello");
		action.build();
		action.perform();
		
		WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.elementToBeClickable(post_btn)).click();
		
	}
	

}
