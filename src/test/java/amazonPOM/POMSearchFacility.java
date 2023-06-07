package amazonPOM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AmazonBaseP.BaseAmazonClass;

public class POMSearchFacility extends BaseAmazonClass{
	
	// For search box
	@FindBy(id="nav-logo-sprites") WebElement Amazonlogo;
	@FindBy(id="twotabsearchtextbox") WebElement Searchbox;
	@FindBy(id="nav-search-submit-button") WebElement Searchicon;
	@FindBy(id="") WebElement Seachbox;
	@FindBy(id="") WebElement Seahbox;
	@FindBy(id="") WebElement Srchbox;
	
	
	public POMSearchFacility() {
		PageFactory.initElements(driver,this);
		
	}
	
	public void searchbyKeyword(String keyword) throws InterruptedException {
		Thread.sleep(1000);
		Amazonlogo.click();
		Thread.sleep(1000);
		Searchbox.sendKeys(keyword);
		Thread.sleep(1000);
		Searchicon.click();
		Thread.sleep(1000);
	}
	
	
	
	
	
	
}
