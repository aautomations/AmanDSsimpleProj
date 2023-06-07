package amazonPOM;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;
import org.testng.Assert;

import AmazonBaseP.BaseAmazonClass;

public class POMYourAccount extends BaseAmazonClass {
	
	//Your Account module
	@FindBy(css="#nav-al-your-account > a:nth-child(2) > span") WebElement YourAccount;
	
	//Your Orders module
	@FindBy(css="#a-page > div.a-container > div > div:nth-child(2) > div:nth-child(1) > a > div > div > div > div.a-column.a-span9.a-span-last > div > span") WebElement YourOrders;
	@FindBy(css="#a-page > section > div > div.a-section.a-spacing-medium.page-tabs > ul > li:nth-child(2) > a") WebElement BuyAgain;
	@FindBy(css="#a-page > section > div > div.a-section.a-spacing-medium.page-tabs > ul > li:nth-child(3) > a") WebElement NotYetShipped;
	@FindBy(css="#a-page > section > div > div.a-section.a-spacing-medium.page-tabs > ul > li:nth-child(4) > a") WebElement CancelledOrders;
	
	//Your Address module
	@FindBy(css="#a-page > div.a-container > div > div:nth-child(3) > div:nth-child(1) > a > div > div > div > div.a-column.a-span9.a-span-last > h2") WebElement YourAddresses;
	@FindBy(id="ya-myab-plus-address-icon") WebElement AddAddress;
	@FindBy(css="#address-ui-widgets-countryCode > span > span") WebElement CountryRegion;
	@FindBy(id="address-ui-widgets-countryCode-dropdown-nativeId_37") WebElement SelectCanada;
	@FindBy(id="address-ui-widgets-enterAddressFullName") WebElement FullName;
	@FindBy(id="address-ui-widgets-enterAddressPhoneNumber") WebElement PhoneNumber;
	@FindBy(id="address-ui-widgets-enterAddressLine1") WebElement AddressL1;
	@FindBy(id="address-ui-widgets-enterAddressLine2") WebElement AddressL2;
	@FindBy(id="address-ui-widgets-enterAddressCity") WebElement City;
	@FindBy(css="#address-ui-widgets-enterAddressStateOrRegion > span > span") WebElement ProvinceTerritory;
	@FindBy(id="address-ui-widgets-enterAddressStateOrRegion-dropdown-nativeId_8") WebElement SelectProvince;
	@FindBy(id="address-ui-widgets-enterAddressPostalCode") WebElement PostalCode;
	@FindBy(id="address-ui-widgets-use-as-my-default") WebElement MakeDefault;
	@FindBy(css="#address-ui-widgets-enterAddressFormContainer > div.a-row.a-expander-container.a-expander-inline-container.address-ui-widgets-desktop-delivery-instructions-expander > a > span > span") WebElement DeliveryInstructions;
	@FindBy(name="preferredDeliveryLocationOTHER") WebElement DelOption;
	@FindBy(css="#address-ui-widgets-form-submit-button > span > input") WebElement AddAddressLast;
	
	//Login and Security
	@FindBy(css="#a-page > div.a-container > div > div:nth-child(2) > div:nth-child(2) > a > div > div > div > div.a-column.a-span9.a-span-last > div > span") WebElement LoginSecurity;
	@FindBy(id="ap_password") WebElement Passwrd;
	@FindBy(id="signInSubmit") WebElement Sign;
	
	//Your Payments
	@FindBy(css="#a-page > div.a-container > div > div:nth-child(3) > div:nth-child(2) > a > div > div > div > div.a-column.a-span9.a-span-last > h2") WebElement YourPayments;
	@FindBy(xpath="//*[@id=\"pp-Skb4pq-14\"]/span/input") WebElement AddPayMethod;
	@FindBy(css="#pp-6pBs11-26 > span > input") WebElement AddCard;
	@FindBy(id="pp-Wcv5Kz-16") WebElement CardNmbr;
	@FindBy(id="pp-Wcv5Kz-18") WebElement NameOnCard;
	@FindBy(css="#pp-Wcv5Kz-22 > span > span > span") WebElement ExpMonth;
	@FindBy(id="pp-Wcv5Kz-19_4") WebElement SelectMonth;
	@FindBy(css="#pp-Wcv5Kz-23 > span > span") WebElement ExpYear;
	@FindBy(id="pp-Wcv5Kz-21_1") WebElement SelectYear;
	@FindBy(id="pp-Wcv5Kz-25") WebElement SecrCode;
	@FindBy(css="#pp-Wcv5Kz-31 > span > input") WebElement AddYourCard;
	
	
	
	public POMYourAccount () {
		PageFactory.initElements(driver, this);
		
	}
	
	public void youraccount() throws InterruptedException {
		Actions action= new Actions(driver);
		action.moveToElement(driver.findElement(By.id("nav-link-accountList-nav-line-1"))).build().perform();
		/*
		 * String title =
		 * driver.findElement(By.id("nav-link-accountList-nav-line-1")).getText();
		 * System.out.println(title + " - Welcome Message displayed");
		 */
		YourAccount.click();
		Thread.sleep(2000);
			
	}
	public void yourorders() throws InterruptedException {
		YourOrders.click();
		Thread.sleep(2000);
	}
	
	public void buyagain() {
		boolean buyag = BuyAgain.isDisplayed();
		System.out.println(buyag);
		BuyAgain.click();
	}
	public void notyetshipped() throws InterruptedException {
		driver.navigate().back();
		Thread.sleep(1000);
		boolean nys = NotYetShipped.isDisplayed();
		System.out.println(nys);
		NotYetShipped.click();
	}
	public void cancelledorders() throws InterruptedException {
		driver.navigate().back();
		Thread.sleep(2000);
		boolean cancelled = CancelledOrders.isDisplayed();
		System.out.println(cancelled);
		CancelledOrders.click();
		Thread.sleep(2000);
		driver.navigate().back();
	}
	public void youraddresses() throws InterruptedException {
		YourAddresses.click();
		Thread.sleep(1500);
		AddAddress.click();
		Thread.sleep(1500);		
		CountryRegion.click(); 
		Thread.sleep(1500); 
		SelectCanada.click();
				
		/* Select obj = new Select(CountryRegion); obj.selectByVisibleText("Canada"); */
		 
		Thread.sleep(1500);
	}
	public void fullname(String flname) throws InterruptedException {
		FullName.sendKeys(flname);
		Thread.sleep(1500);
	}
	public void phn(String number) throws InterruptedException {
		PhoneNumber.sendKeys(number);
		Thread.sleep(1500);
	}
	public void adrln1(String adln1) throws InterruptedException {	
		AddressL1.sendKeys(adln1);
		Thread.sleep(1500);
	}
	public void adrln2(String adln2) throws InterruptedException {	
		AddressL2.sendKeys(adln2);
		Thread.sleep(1500);
	}
	public void city(String cityy) throws InterruptedException {
		City.sendKeys(cityy);
		Thread.sleep(1500);
	}
	public void province() throws InterruptedException {
		ProvinceTerritory.click();
		Thread.sleep(1500);
		SelectProvince.click();
		Thread.sleep(1500);
	}
	public void postalcode(String pcode) throws InterruptedException {
		PostalCode.sendKeys(pcode);
		Thread.sleep(1500);
	}
	public void otheropts() throws InterruptedException {
		MakeDefault.click();
		Thread.sleep(1500);
		DeliveryInstructions.click();
		Thread.sleep(1500);
		DelOption.click();
		Thread.sleep(1500);
		DeliveryInstructions.click();
		Thread.sleep(1500);
		AddAddressLast.click();
		Thread.sleep(1500);
	}
		
	public void loginsecurity() throws InterruptedException {
		LoginSecurity.click();
		Thread.sleep(1000);
		driver.navigate().back();
		Thread.sleep(1000);				
	}
	
	public void yourpayments() throws InterruptedException {
		YourPayments.click();
		Thread.sleep(1000);
		WebElement frame= driver.findElement(By.id("pp-Skb4pq-14"));
		driver.switchTo().frame(frame);
		AddPayMethod.click();
		SoftAssert chk = new SoftAssert();
		chk.assertAll();
		Thread.sleep(1000);
		AddCard.click();
		Thread.sleep(1000);
	}
	public void addcardnumber(String cnumber) throws InterruptedException {
		CardNmbr.sendKeys(cnumber);
		Thread.sleep(1000);
	}
	public void addnameoncard(String cname) throws InterruptedException {
		NameOnCard.sendKeys(cname);
		Thread.sleep(1000);				
	}
	public void expdate() throws InterruptedException {
		ExpMonth.click();
		Thread.sleep(1000);	
		SelectMonth.click();
		Thread.sleep(1000);	
		ExpYear.click();
		Thread.sleep(1000);	
		SelectYear.click();
		Thread.sleep(1000);
		SecrCode.click();
		Thread.sleep(1000);
		AddYourCard.click();
		Thread.sleep(1000);
		
	}
	
	
}
