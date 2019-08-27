package com.facebook.pageobject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.facebook.baseTest.TestBase;

public class ReviewPage extends TestBase{
	
	@FindBy(xpath="//div[@class='brgm-button brgm-user brgm-list-box']/span")
	WebElement username;
	
	@FindBy(xpath = "//div[@class='btn rvc-continue-btn']")
	WebElement cont_btn;

	@FindBy(xpath="//a[contains(text(),'Profile')]")
	WebElement profile;
	
	@FindBy(xpath="//div[@class='profilenav']/ul/li[3]/a")
	WebElement reviewbtn;
	
	@FindBy(xpath="//div[@class='reviews']/div[1]/p[2]")
	WebElement reviewtext;
	
	public ReviewPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String reviewcheck() {
		cont_btn.click();
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,-500)");
		Actions action= new Actions(driver);
		action.moveToElement(username).perform();
		profile.click();
		reviewbtn.click();
	return	reviewtext.getText();
		
	}
	
}
