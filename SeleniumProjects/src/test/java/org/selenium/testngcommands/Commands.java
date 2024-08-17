package org.selenium.testngcommands;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.automationcore.Base;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Commands extends Base {
	@Test
	public void verifyHomePageTitle() {
		driver.get("https://demowebshop.tricentis.com");
		String actualTitle = driver.getTitle();
		// System.out.println("Title is" + " " + actualTitle)
/////////assertions///////
		String expectedTitle = "Demo Web Shop";
		Assert.assertEquals(actualTitle, expectedTitle, "Title mismatch");
	}

	@Test
	public void loginpage() {
		driver.get("https://demowebshop.tricentis.com/login");
		WebElement emailButton = driver.findElement(By.id("Email"));
		emailButton.sendKeys("rkrishnendu96@gmail.com");
		WebElement passwordButton = driver.findElement(By.id("Password"));
		passwordButton.sendKeys("123456789");
		WebElement remembermeCheckbox = driver.findElement(By.id("RememberMe"));
		boolean isCheckboxSelected = remembermeCheckbox.isSelected();
		// System.out.println("Checkbox selected before click" + " " +
		// isCheckboxSelected);
		remembermeCheckbox.click();
		// isCheckboxSelected = remembermeCheckbox.isSelected();
		System.out.println("Checkbox selected after click" + " " + isCheckboxSelected);
		WebElement loginButton = driver.findElement(By.xpath("//input[@class='button-1 login-button']"));
		loginButton.click();
		String expectedEmailId = "rkrishnendu96@gmail.com";
		WebElement mailId = driver.findElement(By.xpath("//a[text()='rkrishnendu96@gmail.com']"));
		String actualEmailId = mailId.getText();
		Assert.assertEquals(actualEmailId, expectedEmailId, "login failed");
	}

	@Test
	public void registerPage() {
		driver.get("https://demowebshop.tricentis.com/register");
		WebElement radiobuttonMale = driver.findElement(By.xpath("//input[@id='gender-male']"));
		boolean isButtonselected = radiobuttonMale.isSelected();
		Assert.assertFalse(isButtonselected, "checkbox selected"); // assertfalse applied for checkbox
		// System.out.println("male element before selected" + " " + isButtonselected);
		radiobuttonMale.click();
		isButtonselected = radiobuttonMale.isSelected();
		Assert.assertTrue(isButtonselected, "checkbox not selected"); // asserttrue applied for checkbox
		// System.out.println("male element after selected" + " " + isButtonselected);
		WebElement firstName = driver.findElement(By.xpath("//input[@id=\"FirstName\"]"));
		firstName.sendKeys("Krishnendu");
		WebElement lastName = driver.findElement(By.xpath("//input[@id=\"LastName\"]"));
		lastName.sendKeys("R");
		WebElement emailButton = driver.findElement(By.xpath("//input[@id=\"Email\"]"));
		emailButton.sendKeys("rkrishnendu86@gmail.com");
		WebElement passwordButton = driver.findElement(By.xpath("//input[@id=\"Password\"]"));
		passwordButton.sendKeys("123456789");
		WebElement confirmPasswordButton = driver.findElement(By.xpath("//input[@id=\"ConfirmPassword\"]"));
		confirmPasswordButton.sendKeys("123456789");
		WebElement registerButton = driver.findElement(By.xpath("//input[@id=\"register-button\"]"));
		registerButton.click();

	}

	@Test
	public void swaglabLoginPage() {
		driver.get("https://www.saucedemo.com/");
		WebElement emailButton = driver.findElement(By.id("user-name"));
		emailButton.sendKeys("standard_user");
		WebElement passwordButton = driver.findElement(By.id("password"));
		passwordButton.sendKeys("secret_sauce");
		WebElement loginButton = driver.findElement(By.id("login-button"));
		loginButton.click();
/////////assertions///////
		String expectText = "Swag Labs";
		WebElement swagTextShow = driver.findElement(By.xpath("//div[@class='app_logo']"));
		String actualText = swagTextShow.getText();
		Assert.assertEquals(actualText, expectText, "invalid login");
	}

	@Test
	public void verifyJavaScriptExecutor() {
		driver.get("https://demowebshop.tricentis.com/");
		JavascriptExecutor js = (JavascriptExecutor) driver; // create executor reference
		// button with sendkey
		js.executeScript("document.getElementById(\"newsletter-email\").value='rkrishnendu76@gmail.com'");
		// button with click
		js.executeScript("document.getElementById(\"newsletter-subscribe-button\").click()");

	}

	@Test
	public void verifyScroll() {
		driver.get("https://demowebshop.tricentis.com/");
		JavascriptExecutor js = (JavascriptExecutor) driver; // create executor reference
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)"); // fully vertical scroll
		// js.executeScript("window.scrollBy(0,1000)");

	}

	///// waits/////
	@Test
	public void verifyWaitCommands() {
		driver.get("https://demoqa.com/alerts");
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)) // created implicit wait
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // created explicit wait
		WebElement clickmeButton = driver.findElement(By.id("timerAlertButton"));
		clickmeButton.click();
		wait.until(ExpectedConditions.alertIsPresent()); // call the wait,check the alert is present using method alertIsPresent
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	@Test
	public void verifyFluentWait() {
		driver.get("https://demoqa.com/alerts");
		JavascriptExecutor js = (JavascriptExecutor) driver; // create executor reference
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)"); // fully vertical scroll
		WebElement clickmeButton = driver.findElement(By.id("timerAlertButton"));
		FluentWait fluentwait = new FluentWait(driver);
		fluentwait.withTimeout(Duration.ofSeconds(20)); // method withTimeOut
		fluentwait.pollingEvery(Duration.ofSeconds(2));  //frequently checked using method pollingEvery
		fluentwait.ignoring(NoSuchElementException.class);  //ignore NoSuchElement case using method ignoring
		clickmeButton.click();
		fluentwait.until(ExpectedConditions.alertIsPresent());  //conditions applied
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}
}
