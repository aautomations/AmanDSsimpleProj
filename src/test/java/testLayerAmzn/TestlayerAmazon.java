package testLayerAmzn;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import AmazonBaseP.BaseAmazonClass;
import amazonPOM.POMSearchFacility;
import amazonPOM.POMShoppingCart;
import amazonPOM.POMYourAccount;
import amazonPOM.POMlogin;

public class TestlayerAmazon extends BaseAmazonClass{

	POMlogin log;
	POMYourAccount logg;
	POMSearchFacility word;
	POMShoppingCart cart;
	Assert check;
	public TestlayerAmazon () {
		super();
	}
	@BeforeSuite
	public void initialsetup() {
		startup();
		log= new POMlogin();
	}
	
	@BeforeTest
	public void enteremail() throws Exception  {
		log.typeEmail("amandeepsingh10145@gmail.com");
		log.typePassword("toMT0m!5");
	}
	
	
	  @BeforeMethod public void yraccount() throws InterruptedException {
	  POMYourAccount logg = new POMYourAccount(); logg.youraccount(); }
	 
	 
	@Test(priority=1, groups="Your Account", enabled=true)
	public void YourOrders() throws InterruptedException {
		logg = new POMYourAccount();
		logg.YourOrders();
		Thread.sleep(2000);
		logg.buyagain();
		Thread.sleep(2000);
		logg.notyetshipped();
		Thread.sleep(2000);
		logg.cancelledorders();
	}
	@Test(priority=2,groups="Your Account", enabled=true)
	public void YourAddresses() throws InterruptedException {
		logg = new POMYourAccount();
		logg.youraddresses();
		logg.fullname("Romy");
		logg.phn("6477645566");
		logg.adrln1("Great lakes dr");
		logg.adrln2("40");
		logg.city("Brampton");
		logg.province();
		logg.postalcode("L6R2K7");
		logg.otheropts();		
		
	}
	@Test(priority=3, groups="Your Account", enabled= true)
	public void LoginSecurity() throws InterruptedException {
		logg = new POMYourAccount();
		logg.loginsecurity();
		
	}
	@Test(priority=4,groups="Your Account", enabled=false)
	public void YourPayments() throws InterruptedException {
		logg = new POMYourAccount();
		logg.yourpayments();
		logg.addcardnumber("5555555555554444");
		logg.addnameoncard("Amanda");
		logg.expdate();
	}
	@Test(priority=5, enabled= true)
	public void Search() throws InterruptedException {
		word= new POMSearchFacility();
		word.searchbyKeyword("mobile phone");
		word.filter();
		word.sort();
		word.searchbyKeyword("mobile phone");
		word.relevantproducts();
		
		
	}
	
	@Test(priority=6, enabled= true)
	public void ShoppingCart() throws InterruptedException {
		
		  word= new POMSearchFacility(); 
		  word.searchbyKeyword("mobile phone");
		 
		cart = new POMShoppingCart();
		cart.shopcart();
		cart.checkout();
		cart.removecloseopen();
		startup();
		log= new POMlogin();
		log.typeEmail("amandeepsingh10145@gmail.com");
		log.typePassword("toMT0m!5");
		cart.opencart();
		
		
	}
		
	
	@AfterTest
	public void close() throws InterruptedException {
		Thread.sleep(3000);
		log.logout();
		Thread.sleep(2000);
		driver.close();
	}	
	
		
}
