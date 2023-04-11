package scripts;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Test
public class GmailNewTab {
	WebDriver driver;

	public void openInnewTab() throws InterruptedException {

		Actions builder = new Actions(driver);

		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("https://mail.google.com/mail/");
		// String clicklink = Keys.chord(Keys.CONTROL, Keys.ENTER);
		// driver.findElement(By.xpath("//a[text()='Gmail']")).sendKeys(clicklink);
		// driver.findElement(By.linkText("a")).sendKeys("Gmail login" + Keys.ENTER);
		// *[@id="gb"]/div[2]/div[3]/div[1]/div/div[1]/a
		// get window handles of open window1
		//String parentHandle = driver.getWindowHandle();
		//System.out.println("parent window -" + parentHandle);
		//Set<String> handles = driver.getWindowHandles();
		//for (String handle : handles) {
			//if (!handle.equals(parentHandle)) {
				//driver.switchTo().window(handle);
				//Thread.sleep(3000);
		String Parentwindowhandle = driver.getWindowHandle();
		Set<String> allopenWindowsByThisDriver1 = driver.getWindowHandles();
		for (String oneWindow : allopenWindowsByThisDriver1) {
			if (!oneWindow.equals(Parentwindowhandle)) {
				driver.switchTo().window(oneWindow);

				driver.findElement(By.xpath("//a[text()='Sign in']")).click();
				driver.findElement(By.xpath("//input[@type='email']")).sendKeys("ketanvj@gmail.com");
				driver.close();
				driver.findElement(By.xpath("//a[text()='Sign in']")).click();
				driver.findElement(By.xpath("//*[@id=\"input\"]")).sendKeys("selenium is easy" + Keys.ENTER);
				builder.sendKeys(Keys.ENTER).build().perform();

			}
		}
	}

	@BeforeMethod
	public void beforeMethod() throws InterruptedException {
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(ops);

		driver.get("https://www.google.com/");
		driver.manage().window().maximize();

		Thread.sleep(3000);
	}

	@AfterMethod
	public void afterMethod() {
	}

}
