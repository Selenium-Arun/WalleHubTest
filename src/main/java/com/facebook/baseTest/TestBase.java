package com.facebook.baseTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class TestBase {

	public	static WebDriver driver;
	public	static Properties prop;
	static File file;
	/*String TestFile = "\\src\\main\\java\\config\\TestData.txt";
	File reviewfile1;
	FileReader fr;
	BufferedReader br;
public	String content;*/

	public TestBase()  {
		try {
			prop = new Properties();
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+
					"\\src\\main\\java\\config\\config.properties");
		  	prop.load(fis);
			 
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/*reviewfile1= new File(System.getProperty("user.dir")+TestFile);
		 try {
			fr =  new FileReader(reviewfile1);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 br = new BufferedReader(fr);
		 try {
			content = br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		
	}
	
	public static void initialization() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		String browsername=prop.getProperty("browser");
		 file = new File("\\src\\main\\resources\\driver\\chromedriver.exe");
		
		if(browsername.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+file);
			driver = new ChromeDriver(options);
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		
	}

 
	
	}
	

/*
WebDriver driver;
	public void setup() {
		File file = new File("\\src\\main\\resources\\driver\\chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
		driver = new ChromeDriver();
		
		driver.get("https://www.facebook.com/");
	WebElement email=driver.findElement(By.id("email"));
	email.sendKeys("Test");
	}



*/