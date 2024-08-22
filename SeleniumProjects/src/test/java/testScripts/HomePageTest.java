
package testScripts;

import java.io.IOException;

import org.automationcore.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import listeners.RetryAnalyzer;
import utilities.ExcelUtility;

public class HomePageTest extends Base {

	//@Test (retryAnalyzer=RetryAnalyzer.class)
	@Test(groups="Sanity")
	public void verifyHomePageTitle() throws IOException {
		driver.get("https://demowebshop.tricentis.com/");
		String actualTitle = driver.getTitle();
		System.out.println("Title is" + " " + actualTitle);
		String expectedTitle="Demo Web Shop";  
		Assert.assertEquals(actualTitle, expectedTitle, "Title mismatch");
	}

	@Test(groups="Smoke")
	public void verifyCommunityPollSelection() {
		driver.get("https://demowebshop.tricentis.com/");
		WebElement communitypoll = driver.findElement(By.xpath("//label[text()=\"Excellent\"]"));
		boolean iscommunitypollselect = communitypoll.isSelected();
		Assert.assertFalse(iscommunitypollselect, "poll button selected");
		communitypoll.click();
	//	iscommunitypollselect = communitypoll.isSelected();
	//	Assert.assertTrue(iscommunitypollselect, "poll button not selected");
		WebElement voteButton = driver.findElement(By.xpath("//input[@class=\"button-2 vote-poll-button\"]"));
		voteButton.click();
		driver.close();
	}

}
