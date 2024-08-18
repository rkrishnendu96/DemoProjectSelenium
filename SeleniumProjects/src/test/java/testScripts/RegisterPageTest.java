package testScripts;

import org.automationcore.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import utilities.RandomDataUtility;

public class RegisterPageTest extends Base {
	
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
