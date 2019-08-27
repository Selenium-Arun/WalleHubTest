package com.facebook.pageobject;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.facebook.baseTest.TestBase;

public class WallethubReview extends TestBase {

	// OR
	@FindBy(xpath = "//span[@class='brgm-button brgm-signup']")
	WebElement lgnpage_btn;

	@FindBy(xpath = "//input[@placeholder='Email Address']")
	WebElement wallethub_uname;
	@FindBy(xpath = "//input[@placeholder='Password']")
	WebElement wallethub_password;

	@FindBy(xpath = "//span[contains(text(),'Login')]")
	WebElement lgn_btn;

	@FindBy(xpath = "//review-star[@class='rvs-svg']//div[@class='rating-box-wrapper']")
	WebElement reviewstars;

	@FindBy(xpath = "//review-star[@class='rvs-svg']/div[@class='rating-box-wrapper']/*[5]")
	WebElement ratingstars;

	@FindBy(xpath = "//span[contains(text(),'Select...')]")
	WebElement selectmenu;

	@FindBy(xpath = "//div[@class='dropdown second opened']/ul/li")
	List<WebElement> policylist;

	@FindBy(xpath = "//textarea[@placeholder='Write your review...']")
	WebElement reviewArea;

	@FindBy(xpath = "//div[@class='sbn-action semi-bold-font btn fixed-w-c tall']")
	WebElement submitbtn;

	// TestData



	public WallethubReview() {
		super();
		PageFactory.initElements(driver, this);
	}

	public void wh_login(String user, String pass) {
		lgnpage_btn.click();
		wallethub_uname.sendKeys(user);
		wallethub_password.sendKeys(pass);
		lgn_btn.click();

	}

	public void selectreviewStars() {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", reviewstars);
		ratingstars.click();
	}

	public void writereview(String review) {
		selectmenu.click();
		for (int i = 0; i < policylist.size(); i++) {
			String val = policylist.get(i).getText();
			if (val.contains("Health Insurance")) {
				policylist.get(i).click();
				break;
			}
		}

		reviewArea.sendKeys(review);
		submitbtn.click();

	}

}
