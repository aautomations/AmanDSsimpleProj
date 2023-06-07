package AmazonBaseP;

import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import timeUtil.Timeutil;

public class BaseAmazonClass {
	
	public static Properties prop= new Properties();
	public static WebDriver driver;
	
	public BaseAmazonClass() {
		
		try { 
		FileInputStream file= new FileInputStream("E:\\Java Workspace\\AmazonProject\\src\\test\\java\\envvariables\\APConfig.properties");
		prop.load(file);
	}
		catch(FileNotFoundException e ) {
			e.printStackTrace();
		}
		catch(IOException a) {
			a.printStackTrace();
		}
}
	public static void startup() {
		String browsername = prop.getProperty("browsers");
		if(browsername.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if(browsername.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver","chromedriver.exe");
			ChromeOptions op = new ChromeOptions();
			op.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(op);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Timeutil.timepage, TimeUnit.SECONDS);
		driver.get(prop.getProperty("urls"));
		
		
	}
	
	}
	
	
	
	
}