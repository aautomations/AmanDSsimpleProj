package amazonPOM;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import AmazonBaseP.BaseAmazonClass;

public class POMSearchFacility extends BaseAmazonClass {

	// For search box
	@FindBy(id = "nav-logo-sprites")	WebElement Amazonlogo;
	@FindBy(id = "twotabsearchtextbox")	WebElement Searchbox;
	@FindBy(id = "nav-search-submit-button")	WebElement Searchicon;
	
	// For relevant and pagination
	@FindBy(xpath="//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[69]/div/div/span/a[3]") WebElement Nextbutton;

	// For Filtration
	@FindBy(css = "#p_89\\/Samsung > span > a > div > label > i") WebElement brand;
	@FindBy(css = "#p_36\\/12035764011 > span > a > span")	WebElement price;
	
	// For Sorting
	@FindBy(css="#a-autoid-4-announce > span.a-dropdown-prompt") WebElement Sortby;
	@FindBy(id = "s-result-sort-select_3")	WebElement AvgCstReview;
	

	public POMSearchFacility() {
		PageFactory.initElements(driver, this);

	}

	public void searchbyKeyword(String keyword) throws InterruptedException {
		Thread.sleep(3000);
		Amazonlogo.click();
		Thread.sleep(1000);
		Searchbox.sendKeys(keyword);
		Thread.sleep(1000);
		Searchicon.click();
		System.out.println("Search box was able to search product.");
		Thread.sleep(2000);

	}
	public void filter() throws InterruptedException {
				
		brand.click();
		System.out.println("Was able to select brand for filtration.");
		Thread.sleep(1000);
		 JavascriptExecutor js= (JavascriptExecutor)driver;
		 js.executeScript("arguments[0].scrollIntoView();",price);
		Thread.sleep(1000);
		price.click();
		System.out.println("Was able to select price range for filtration.");
		Thread.sleep(1000);

	}

	public void sort() throws InterruptedException {
		Thread.sleep(2000);
		Sortby.click();
		Thread.sleep(1000);
		AvgCstReview.click();
		System.out.println("Was able to sort by Average Customer Review for sorting.");
		Thread.sleep(1000);
		
	}
	
	public void relevantproducts() throws InterruptedException {
		
	List <WebElement> products = driver.findElements(By.xpath("//div[@class='a-section a-spacing-base']")); 
	
	 JavascriptExecutor js= (JavascriptExecutor)driver;
	 js.executeScript("arguments[0].scrollIntoView();",Nextbutton);
	Thread.sleep(1000);
	for(WebElement text : products) 
	{
		
	  System.out.println(text.getText());
	  System.out.println("**********************");
	  }
	 
	 System.out.println("Number of products on page 1 :" + products.size()); 
	 System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
	 Thread.sleep(1000);
	 Nextbutton.click();
	 Thread.sleep(1000);
	 
	 products = driver.findElements(By.xpath("//div[@class='a-section a-spacing-base']")); 
	WebElement nextbuttons = driver.findElement(By.xpath("//a[@class = 's-pagination-item s-pagination-next s-pagination-button s-pagination-separator']"));	
	 JavascriptExecutor fs= (JavascriptExecutor)driver;
	 fs.executeScript("arguments[0].scrollIntoView();",nextbuttons);
	Thread.sleep(1000);
	for(WebElement text : products) 
	{
		
	  System.out.println(text.getText());
	  System.out.println("**********************");
	  }
	 
	 System.out.println("Number of products on page 2 :" + products.size()); 
	 System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
	 Thread.sleep(1000);
	 System.out.println("Checked for relevancy, product information and number of products per page.");
	 Thread.sleep(1000);
			
	}
	
	



}
