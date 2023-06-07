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
import amazonPOM.POMYourAccount;
import amazonPOM.POMlogin;

public class TestlayerAmazon extends BaseAmazonClass{

	POMlogin log;
	POMYourAccount logg;
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
	
  @BeforeMethod 
  	public void yraccount() throws InterruptedException {
	  POMYourAccount logg = new POMYourAccount(); 
	  logg.youraccount(); }
	 
	@Test(priority=1, groups="Your Account", enabled=false)
	public void yourorders() throws InterruptedException {
		logg = new POMYourAccount();
		logg.yourorders();
		Thread.sleep(2000);
		logg.buyagain();
		Thread.sleep(2000);
		logg.notyetshipped();
		Thread.sleep(2000);
		logg.cancelledorders();
	}
	@Test(priority=2,groups="Your Account", enabled=false)
	public void youradress() throws InterruptedException {
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
	@Test(priority=3, groups="Your Account", enabled= false)
	public void loginsec() throws InterruptedException {
		logg = new POMYourAccount();
		logg.loginsecurity();
		
	}
	@Test(priority=4,groups="Your Account", enabled=true)
	public void yrpayment() throws InterruptedException {
		logg = new POMYourAccount();
		logg.yourpayments();
		logg.addcardnumber("5555555555554444");
		logg.addnameoncard("A");
		logg.expdate();
	}
	@Test(priority=5, enabled= false)
	public void searchh() throws InterruptedException {
		POMSearchFacility word= new POMSearchFacility();
		word.searchbyKeyword("mobile");
		
	}
	
	
	
	
	@AfterTest
	public void close() throws InterruptedException {
		Thread.sleep(3000);
		log.logout();
		Thread.sleep(2000);
		driver.close();
	}	
	
	
	
	
	
}
