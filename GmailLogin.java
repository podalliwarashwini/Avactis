package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GmailLogin {
	WebDriver driver;

	
	public void f() throws InterruptedException {
		driver.get("https://mail.google.com/mail/");

		driver.findElement(By.cssSelector("#Email")).sendKeys("podalliwar.ashwini@gmail.com");

		driver.findElement(By.cssSelector("#next")).click();

		driver.findElement(By.cssSelector("#passwd")).sendKeys("gargi@2013");

		driver.findElement(By.cssSelector("#signIn")).click();

		Thread.sleep(5000);

		driver.findElement(By.cssSelector(".aic.z0 div")).click();

		driver.findElement(By.cssSelector(".oj div textarea")).sendKeys("podalliwar.ashwini@gmail.com");

		driver.findElement(By.cssSelector(".aoD.az6 input")).sendKeys("sending email");

		String actualPageTitle = driver.getTitle();
		System.out.println("Actual Title is" + actualPageTitle);

	}

	@BeforeMethod
	public void beforeMethod() {
		driver = new ChromeDriver();
		driver.get("https://mail.google.com/mail/");
	}

	@AfterMethod
	public void afterMethod() throws InterruptedException {
		Thread.sleep(3000);

	}

}
