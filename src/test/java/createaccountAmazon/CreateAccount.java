package createaccountAmazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class CreateAccount {
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		ChromeOptions op = new ChromeOptions();
		op.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(op);
		driver.get("https://www.amazon.ca/");
		Actions action= new Actions(driver);
		action.moveToElement(driver.findElement(By.id("nav-link-accountList"))).build().perform();
		driver.findElement(By.cssSelector("#nav-flyout-ya-newCust > a")).click();
		driver.findElement(By.id("ap_customer_name")).sendKeys("Aman Singh");
		driver.findElement(By.id("ap_email")).sendKeys("amanaman@gmail.com");
		driver.findElement(By.id("ap_password")).sendKeys("Singh345");
		driver.findElement(By.id("ap_password_check")).sendKeys("Singh345");	
		Thread.sleep(1000);
		driver.close();
		
		
	}

}
