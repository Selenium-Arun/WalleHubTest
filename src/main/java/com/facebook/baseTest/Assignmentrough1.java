package com.facebook.baseTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignmentrough1 {

	public static void main(String[] args)  {
		WebDriver driver;
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		System.setProperty("webdriver.chrome.driver",
				"E:\\Selenium_project\\WalletHubTest\\src\\main\\resources\\driver\\chromedriver.exe");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.facebook.com/");
		driver.findElement(By.id("email")).sendKeys("yourusername");
		driver.findElement(By.id("pass")).sendKeys("Yourpassword");
		driver.findElement(By.id("loginbutton")).click();
		driver.findElement(By.xpath("//div[contains(text(),'on your mind')]")).click();
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//*[@class='_1mf _1mj']")));
		act.sendKeys("Hello");
		act.build().perform();
		WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Post']"))).click();

	}

}
