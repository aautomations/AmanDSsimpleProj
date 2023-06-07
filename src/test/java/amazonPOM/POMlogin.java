package amazonPOM;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AmazonBaseP.BaseAmazonClass;
import timeUtil.Timeutil;

public class POMlogin extends BaseAmazonClass {

	
	@FindBy(id="ap_email") WebElement Email;
	@FindBy(id="continue") WebElement Continue;
	@FindBy(id="ap_password") WebElement Password;
	@FindBy(css="#authportal-main-section > div:nth-child(2) > div > div > div > form > div > div:nth-child(7) > div > div > label > div > label > input[type=checkbox]") WebElement Checkbox;
	@FindBy(id="signInSubmit") WebElement SignIn;
	@FindBy(css="#nav-item-signout > span") WebElement logout;
	
	public POMlogin () {
		PageFactory.initElements(driver, this);
		
	}
	
	public void typeEmail(String email) throws InterruptedException {
		Actions action= new Actions(driver);
		action.moveToElement(driver.findElement(By.id("nav-link-accountList"))).build().perform();
		driver.findElement(By.cssSelector("#nav-flyout-ya-signin > a > span")).click();
		driver.manage().timeouts().pageLoadTimeout(Timeutil.timepage, TimeUnit.SECONDS);
		Email.sendKeys(email);
		Thread.sleep(1000);
		Continue.click();
		Thread.sleep(1000);
		
	}
	
	public void typePassword(String password) throws InterruptedException {
		Password.sendKeys(password);
		Thread.sleep(1000);
		Checkbox.click();
		Thread.sleep(1000);
		SignIn.click();
		Thread.sleep(1000);
		Actions action= new Actions(driver);
		action.moveToElement(driver.findElement(By.id("nav-link-accountList-nav-line-1"))).build().perform();
		String title = driver.findElement(By.id("nav-link-accountList-nav-line-1")).getText();
		System.out.println(title + " - Welcome Message displayed");
		/*
		 * Actions action= new Actions(driver);
		 * action.moveToElement(driver.findElement(By.id("nav-link-accountList"))).build
		 * ().perform(); boolean result =
		 * driver.findElement(By.linkText("nav-link-accountList-nav-line-1")).
		 * isDisplayed(); System.out.println(result);
		 */
	}
	public void logout() throws InterruptedException {
		Actions action= new Actions(driver);
		action.moveToElement(driver.findElement(By.id("nav-link-accountList-nav-line-1"))).build().perform();
		Thread.sleep(1500);
		logout.click();
	}
	
	
	
	
	
}
