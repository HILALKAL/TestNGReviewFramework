package com.WebOrder.utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseClass {

	public static WebDriver driver;
	
	@BeforeMethod(alwaysRun = true)
	
	public static void setUpDriver() {
		
		ConfigsReader.readProperties(Constans.CREDENTIALS_FILEPATH);
		String browser=ConfigsReader.getProperties("browser");
		String url=ConfigsReader.getProperties("url");
	
		if (browser.equalsIgnoreCase("chrome")) {
			
			System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
			driver = new ChromeDriver();
			
		} else if (browser.equalsIgnoreCase("firefox")) {
			
			System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver.exe");
			driver = new FirefoxDriver();
			
		}else if (browser.equalsIgnoreCase("ie")) {
            System.setProperty("webdriver.ie.driver", "src/test/resources/drivers/IEDriverServer.exe");
            driver=new InternetExplorerDriver();
        
        }
		else {
			System.out.println("browser given is wrong");
		}
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(url);
		
	}
	@AfterMethod
	public static void tearDown() {
		driver.close();
	}
}
