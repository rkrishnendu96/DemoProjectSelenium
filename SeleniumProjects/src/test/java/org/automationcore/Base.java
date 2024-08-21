package org.automationcore;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class Base {
	public WebDriver driver;

	public void initializeBrowser(String browser) {
		if (browser.equals("Chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equals("FireFox")) {
			driver = new FirefoxDriver();
		} else if (browser.equals("Edge")) {
			driver = new EdgeDriver();
		} else {
			throw new RuntimeException("Invalid Browser");
		}
		driver.manage().window().maximize();
	}

	@BeforeMethod(alwaysRun = true)     //for xml file
	@Parameters("browser")               // for xml file select second import parameter
	public void setBrowser(String browserName) {
		initializeBrowser(browserName);
	}
	@AfterMethod(alwaysRun = true)     //for xml file
	public void closeBrowser(ITestResult result) throws IOException {
		if(result.getStatus()==ITestResult.FAILURE) {     //if result and failure equal take screenshot
			takeScreenShot(result);  // method calling
		}
		driver.quit();
	}
	public void takeScreenShot(ITestResult result) throws IOException {
		TakesScreenshot takesscreenshot=(TakesScreenshot) driver;   //takescreenshot reference created
		File screenshot=takesscreenshot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot,new File("./Screenshot/"+result.getName()+".png")); //file created, folder selected, convert to png
	}

	
}
