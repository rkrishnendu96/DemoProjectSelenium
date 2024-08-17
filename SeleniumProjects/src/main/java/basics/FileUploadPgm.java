package basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUploadPgm {

	public void verifyFileUpload() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.guru99.com/test/upload/");
		WebElement choosefileButton = driver.findElement(By.id("uploadfile_0"));
		choosefileButton.sendKeys("C:\\eclipse\\SeleniumProjects\\src\\main\\resources\\seleniumfileupload\\Text.txt");
		WebElement checkBox = driver.findElement(By.id("terms"));
		checkBox.click();
		WebElement submitButton = driver.findElement(By.id("submitbutton"));
		submitButton.click();

	}

	public static void main(String[] args) {
		FileUploadPgm obj = new FileUploadPgm();
		obj.verifyFileUpload();

	}

}