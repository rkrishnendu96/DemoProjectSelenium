package testScripts;

import java.io.IOException;

import org.automationcore.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import dataprovider.DataProviders;
import utilities.ExcelUtility;

public class LoginPageTest extends Base {
	@Test(groups={"Smoke","Regression"})
	public void userLoginWithVAlidCredentials()  {
		driver.get("https://demowebshop.tricentis.com/login");
		String emailIdExcel=ExcelUtility.getStringData(0, 0, "LoginPage"); // excel reading
		String passwordExcel=ExcelUtility.getIntegerData(0, 1, "LoginPage");
		WebElement email = driver.findElement(By.xpath("//input[@id=\"Email\"]"));
		email.sendKeys(emailIdExcel);
		WebElement password = driver.findElement(By.xpath("//input[@id=\"Password\"]"));
		password.sendKeys(passwordExcel);
		WebElement login = driver.findElement(By.xpath("//input[@class=\"button-1 login-button\"]"));
		login.click();
		///assertion//
	//	String expectedLoginResult = "rkrishnendu96@gmail.com";
		WebElement actualLoginResultShow = driver.findElement(By.xpath("//a[text()=\"rkrishnendu96@gmail.com\"]"));
		String actualLoginResult = actualLoginResultShow.getText();
		Assert.assertEquals(actualLoginResult, emailIdExcel, "invalid login");
	}

	///// data provider /////
	@Test (dataProvider="invalidUserCredentials",dataProviderClass=DataProviders.class)
	public void userLoginWithinvalidCredentials(String username, String userPassword)  {
		driver.get("https://demowebshop.tricentis.com/login");
		WebElement email = driver.findElement(By.xpath("//input[@id=\"Email\"]"));
		email.sendKeys(username);
		WebElement password = driver.findElement(By.xpath("//input[@id=\"Password\"]"));
		password.sendKeys(userPassword);
		WebElement login = driver.findElement(By.xpath("//input[@class=\"button-1 login-button\"]"));
		login.click();
		// assertion//Excel reading//
		String expectedLoginResult=ExcelUtility.getStringData(4, 0, "LoginPage"); // excel reading
		WebElement actualLoginResultShow = driver
				.findElement(By.xpath("//span[text()=\"Login was unsuccessful. Please correct the errors and try again.\"]"));
		String actualLoginResult = actualLoginResultShow.getText();
		Assert.assertEquals(actualLoginResult, expectedLoginResult, "Valid login");
	//	driver.close();

	}

}
