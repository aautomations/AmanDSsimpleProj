package amazonPOM;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import AmazonBaseP.BaseAmazonClass;

public class POMShoppingCart extends BaseAmazonClass {

	// For Shopping cart
	@FindBy(id="nav-cart") WebElement Cart;
	@FindBy(css="#search > div.s-desktop-width-max.s-desktop-content.s-wide-grid-style-t1.s-opposite-dir.s-wide-grid-style.sg-row > div.sg-col-20-of-24.s-matching-dir.sg-col-16-of-20.sg-col.sg-col-8-of-12.sg-col-12-of-16 > div > span.rush-component.s-latency-cf-section > div.s-main-slot.s-result-list.s-search-results.sg-row > div:nth-child(10) > div > div > div > div > div.a-section.a-spacing-small.puis-padding-left-small.puis-padding-right-small > div.a-section.a-spacing-none.a-spacing-top-small.s-title-instructions-style > h2 > a > span") WebElement card1;
	@FindBy(id="add-to-cart-button") WebElement Addtocartbutton;
	@FindBy(id="nav-cart-text-container") WebElement gotocartbutton;
	@FindBy(id ="a-autoid-1-announce") WebElement Qty;
	@FindBy(id="quantity_3") WebElement qty3;
	@FindBy(css="#sc-subtotal-amount-activecart > span") WebElement cost;
	
	 // For Checkout
	  
	  
	  @FindBy(name="proceedToRetailCheckout") WebElement proceedtocheckout;
	  
	  @FindBy(css="#address-list > div > div:nth-child(1) > div > fieldset:nth-child(1) > div.a-row.address-row.list-address-selected > span > div > label > input[type=radio]") WebElement selectaddress;
	  @FindBy(css="#shipToThisAddressButton > span > input") WebElement shiptothisaddressbutton;
	 
	  //For delete,close and open browser
	  @FindBy(xpath="//span[@class='a-size-small sc-action-delete']") WebElement deletepfromcart;
	  @FindBy(css="#sc-active-cart > div > div > div > h1") WebElement emptycart;
	  @FindBy(css="#nav-al-your-account > a:nth-child(2) > span") WebElement YourAccount; 
	
	public POMShoppingCart() {
		PageFactory.initElements(driver, this);
		
	}
	
	public void shopcart() throws InterruptedException {
		
		Thread.sleep(1000);
		driver.get("https://www.amazon.ca/Samsung-Galaxy-A03s-Black-32GB/dp/B09Q5T4RTX/ref=sr_1_5?crid=Z6UEV6ZUXZOJ&keywords=mobile+phone&qid=1686279486&s=electronics&sprefix=%2Celectronics%2C78&sr=1-5&ufe=app_do%3Aamzn1.fos.71722c10-739d-471b-befb-3e4b9bf7d0d6");
		Thread.sleep(1000);
		Addtocartbutton.click();
		Thread.sleep(2000);
		System.out.println("Was able to add product to Shopping cart.");
		gotocartbutton.click();
		Thread.sleep(1000);
		String costprice1 = cost.getText();
		Thread.sleep(1000);
		System.out.println("Cost of 1 product:" + costprice1);
		Thread.sleep(1000);
		Qty.click();
		Thread.sleep(1000);
		qty3.click();
		Thread.sleep(1000);
		String costprice3 = cost.getText();
		Thread.sleep(1000);
		System.out.println("Cost of 3 products:" + costprice3);
		Thread.sleep(1000);
		System.out.println("Was able to update the total price of product by changing the quantity of product in Shopping cart.");
		
		driver.get("https://www.amazon.ca/Samsung-Galaxy-A03s-Black-32GB/dp/B09Q5T4RTX/ref=sr_1_5?crid=Z6UEV6ZUXZOJ&keywords=mobile+phone&qid=1686279486&s=electronics&sprefix=%2Celectronics%2C78&sr=1-5&ufe=app_do%3Aamzn1.fos.71722c10-739d-471b-befb-3e4b9bf7d0d6");
		Thread.sleep(1000);
		Addtocartbutton.click();
		Thread.sleep(2000);
		System.out.println("Was able to add another same product to Shopping cart.");
		gotocartbutton.click();
		Thread.sleep(1000);
		String qty4 = Qty.getText();
		System.out.println("Quantity of products now after adding 1 same product:" + qty4);
		Thread.sleep(1000);
		System.out.println("Was able to update the total quantity of product in Shopping cart.");
		String costprice4 = cost.getText();
		System.out.println("Cost of products now after adding 1 same product:" + costprice4);
		Thread.sleep(1000);
		System.out.println("Was able to update the total price of product after adding another product in Shopping cart.");
		Thread.sleep(1000);
		
		
	}
	public void checkout() throws InterruptedException {
		
		proceedtocheckout.click();
		Thread.sleep(1000);
		System.out.println("Was able to navigate to Checkout.");
		selectaddress.click();
		Thread.sleep(1000);
		shiptothisaddressbutton.click();
		Thread.sleep(1000);
		driver.navigate().back();
		Thread.sleep(1000);
		driver.navigate().back();
		Thread.sleep(1000);
		
	}
	public void removecloseopen() throws InterruptedException {
		Thread.sleep(1000);
		gotocartbutton.click();
		Thread.sleep(1000);
		Thread.sleep(1000);
		deletepfromcart.click();
		Thread.sleep(3000);
		System.out.println("Now cart is empty.");
		Thread.sleep(3000);
		driver.get("https://www.amazon.ca/Samsung-Galaxy-A03s-Black-32GB/dp/B09Q5T4RTX/ref=sr_1_5?crid=Z6UEV6ZUXZOJ&keywords=mobile+phone&qid=1686279486&s=electronics&sprefix=%2Celectronics%2C78&sr=1-5&ufe=app_do%3Aamzn1.fos.71722c10-739d-471b-befb-3e4b9bf7d0d6");
		Thread.sleep(2000);
		Addtocartbutton.click();
		Thread.sleep(2000);
		gotocartbutton.click();
		Thread.sleep(2000);
		driver.quit();
		Thread.sleep(3000);
	}
	
	public void opencart() throws InterruptedException {
		
		Thread.sleep(3000);
		Actions action= new Actions(driver);
		action.moveToElement(driver.findElement(By.id("nav-link-accountList-nav-line-1"))).build().perform();
		Thread.sleep(1000);
		YourAccount.click(); 
		Thread.sleep(1000);		
		gotocartbutton.click();
		Thread.sleep(3000);
				
	}
	
}
