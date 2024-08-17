package testScripts;

import java.io.IOException;

import org.automationcore.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import utilities.ExcelUtility;
import utilities.RandomDataUtility;

public class RegisterPageTest extends Base {
	/*
	@Test
	public void verifyUserRegistration()  {
		driver.get("https://demowebshop.tricentis.com/register");
		//  Excel read //
		String fnameExcel=ExcelUtility.getStringData(0, 0, "RegisterPage");
		String lastNameExcel=ExcelUtility.getStringData(1, 0, "RegisterPage");
		String newEmail=ExcelUtility.getStringData(2, 0, "RegisterPage");
		String newPass=ExcelUtility.getIntegerData(3, 0, "RegisterPage");

		WebElement radiobuttonMale = driver.findElement(By.xpath("//input[@id='gender-male']"));
		boolean isButtonselected = radiobuttonMale.isSelected();
		Assert.assertFalse(isButtonselected, "checkbox selected");
		radiobuttonMale.click();
		isButtonselected = radiobuttonMale.isSelected();
		Assert.assertTrue(isButtonselected, "checkbox not selected");
		WebElement firstName = driver.findElement(By.xpath("//input[@id=\"FirstName\"]"));
		firstName.sendKeys(fnameExcel);
		WebElement lastName = driver.findElement(By.xpath("//input[@id=\"LastName\"]"));
		lastName.sendKeys(lastNameExcel);
		WebElement emailButton = driver.findElement(By.xpath("//input[@id=\"Email\"]"));
		emailButton.sendKeys(newEmail);
		WebElement passwordButton = driver.findElement(By.xpath("//input[@id=\"Password\"]"));
		passwordButton.sendKeys(newPass);
		WebElement confirmPasswordButton = driver.findElement(By.xpath("//input[@id=\"ConfirmPassword\"]"));
		confirmPasswordButton.sendKeys(newPass);
		WebElement registerButton = driver.findElement(By.xpath("//input[@id=\"register-button\"]"));
		registerButton.click();
		// assertion//
	//	String expectedRegistrtionResult = newEmail;
		WebElement actualRegistrtionResultShow = driver
				.findElement(By.xpath("//a[text()=\"ranju2001@gmail.com\"]"));
		String actualRegistrtionResult = actualRegistrtionResultShow.getText();
		Assert.assertEquals(actualRegistrtionResult, newEmail, "Registration Unsuccessfull");
	//	driver.close();

	}
	    */
	////////////faker data//////////

	public void verifyRegisterPage() {

		driver.get("https://demowebshop.tricentis.com/register");
		String firstNameFake=RandomDataUtility.getFirstName();
		String lastNameFake=RandomDataUtility.getLastName();
		String emailIdFake=firstNameFake+"."+lastNameFake+"@"+"yahoo.com";
		String passwordFake=firstNameFake+"."+lastNameFake;


		WebElement radiobuttonMale = driver.findElement(By.xpath("//input[@id='gender-male']"));
		boolean isButtonselected = radiobuttonMale.isSelected();
		Assert.assertFalse(isButtonselected, "checkbox selected");
		radiobuttonMale.click();
		isButtonselected = radiobuttonMale.isSelected();
		Assert.assertTrue(isButtonselected, "checkbox not selected");
		WebElement firstName = driver.findElement(By.xpath("//input[@id=\"FirstName\"]"));
		firstName.sendKeys(firstNameFake);
		WebElement lastName = driver.findElement(By.xpath("//input[@id=\"LastName\"]"));
		lastName.sendKeys(lastNameFake);
		WebElement emailButton = driver.findElement(By.xpath("//input[@id=\"Email\"]"));
		emailButton.sendKeys(emailIdFake);
		WebElement passwordButton = driver.findElement(By.xpath("//input[@id=\"Password\"]"));
		passwordButton.sendKeys(passwordFake);
		WebElement confirmPasswordButton = driver.findElement(By.xpath("//input[@id=\"ConfirmPassword\"]"));
		confirmPasswordButton.sendKeys(passwordFake);
		WebElement registerButton = driver.findElement(By.xpath("//input[@id=\"register-button\"]"));
		registerButton.click();
		
	//	driver.close();

	
	}

}
