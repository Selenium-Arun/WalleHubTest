package com.facebook.baseTest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Test2 {
	public static void main(String[] args) throws IOException {
		WebDriver driver;
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		System.setProperty("webdriver.chrome.driver",
				"E:\\Selenium_project\\WalletHubTest\\src\\main\\resources\\driver\\chromedriver.exe");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://wallethub.com/profile/test-insurance-company-13732055i");
		WebElement loginbtn = driver.findElement(By.xpath("//span[@class='brgm-button brgm-signup']"));
		loginbtn.click();

		WebElement loginid = driver.findElement(By.xpath("//input[@placeholder='Email Address']"));
		loginid.sendKeys("arun.singh10@outlook.com");
		WebElement password = driver.findElement(By.xpath("//input[@placeholder='Password']"));
		password.sendKeys("Arun@123");
		WebElement lgnbtn = driver.findElement(By.xpath("//span[contains(text(),'Login')]"));
		lgnbtn.click();
		// scroll to stars
		WebElement reviewstars = driver
				.findElement(By.xpath("//review-star[@class='rvs-svg']//div[@class='rating-box-wrapper']"));

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", reviewstars);

		// select Start
		driver.findElement(By.xpath("//review-star[@class='rvs-svg']/div[@class='rating-box-wrapper']/*[5]")).click();
		
		//click on select
		driver.findElement(By.xpath("//span[contains(text(),'Select...')]")).click();
		
		// selecting value from dropdown
		List<WebElement> list = driver.findElements(By.xpath("//div[@class='dropdown second opened']/ul/li"));
		for (int i = 0; i < list.size(); i++) {
			String val = list.get(i).getText();
			if (val.contains("Health Insurance")) {
				list.get(i).click();
				break;
			}
		}
		
		//write review
		String TestFile = "\\src\\main\\java\\config\\TestData.txt";
		File file1 = new File(System.getProperty("user.dir")+TestFile);
		System.out.println(file1.toString());
		FileReader fr =  new FileReader(file1);
		BufferedReader br = new BufferedReader(fr);
		String content = br.readLine();
	WebElement reviewArea=driver.findElement(By.xpath("//textarea[@placeholder='Write your review...']"));
	reviewArea.sendKeys(content);
	//submit button
	driver.findElement(By.xpath("//div[@class='sbn-action semi-bold-font btn fixed-w-c tall']")).click();
	
	//continue
	driver.findElement(By.xpath("//div[@class='btn rvc-continue-btn']")).click();
	((JavascriptExecutor) driver).executeScript("window.scrollBy(0,-500)");
	WebElement username= driver.findElement(By.xpath("//div[@class='brgm-button brgm-user brgm-list-box']/span"));
	//((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", username);
	Actions action= new Actions(driver);
	action.moveToElement(username).perform();
	
	driver.findElement(By.xpath("//a[contains(text(),'Profile')]")).click();
	//click on reviewtab
	
	driver.findElement(By.xpath("//div[@class='profilenav']/ul/li[3]/a")).click();
	
	String text=driver.findElement(By.xpath("//div[@class='reviews']/div[1]/p[2]")).getText();
	
	if(text!=null) {
		System.out.println("review posted");
	}
	
	System.out.println("Succcessfull");
	
	
	}

}
