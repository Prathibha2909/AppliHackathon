package com.java.hackathon;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class Traditional {
	
	public static WebDriver driver;
	
	public static String ELEMENT_Username= "//input[@id='username']"; 
	public static String ELEMENT_Password= "//input[@id='password']";
	public static String ELEMENT_Login= "//button[@id='log-in']";
	public static String ELEMENT_ErorMsg= "//div[@class='alert alert-warning']";
	public static String UN = "admin";
	public static String PW = "admin";
	public static String ELEMENT_Amount = "//th[@id='amount']";
	public static String ELEMENT_CompareExpenses = "//a[@id='showExpensesChart']";
	public static String ELEMENT_AmountSort ="//span[text()='Today']";
	public static String ELEMENT_ExpenseChart ="//canvas[@id='canvas']";
	public static String IMAGE_FlashSale ="//img[@src='img/flashSale.gif']";
	public static String IMAGE_FlashSale2 ="//img[@src='img/flashSale2.gif']";
	
	
	public static void enterUserCredentials(String UN, String PW) {
		
		driver.findElement(By.xpath(ELEMENT_Username)).clear();
		driver.findElement(By.xpath(ELEMENT_Username)).sendKeys(UN);
		driver.findElement(By.xpath(ELEMENT_Password)).clear();
		driver.findElement(By.xpath(ELEMENT_Password)).sendKeys(PW);
		System.out.println("Entered the usercredentials");
		
	}
	
	public static void clickLogin() {

		driver.findElement(By.xpath(ELEMENT_Login)).click();
		System.out.println("Login clicked");
	}
		
	public static void errorMsg() {
		
		String actualMsg = "must be present";
		String errorMessage = driver.findElement(By.xpath(ELEMENT_ErorMsg)).getText();
		System.out.println(errorMessage);
		if (errorMessage.contains(actualMsg)) {
			
			System.out.println("Error message is displayed");
		}else
			System.out.println("error message not displayed");
		
	}
	
	public static void amountSort() {
		
		driver.findElement(By.xpath(ELEMENT_Amount)).click();
		String Amount= driver.findElement(By.xpath(ELEMENT_AmountSort)).getText();
		System.out.println(Amount);
		if (Amount.contains("Today")) {
			System.out.println("Amount is sorted");
		}else
			System.out.println("Amount not sorted");
	}
	
	public static void ExpenseChart() {
		
		driver.findElement(By.xpath(ELEMENT_CompareExpenses)).click();
		WebElement chart = driver.findElement(By.xpath(ELEMENT_ExpenseChart));
		if(chart.isDisplayed()) {
			System.out.println("chart is displayed");
		}else
			System.out.println("chart is not displayed");
	}
	
	public static void flashGif() {
		
		WebElement Image1 =driver.findElement(By.id(IMAGE_FlashSale));
		WebElement Image2 =driver.findElement(By.id(IMAGE_FlashSale2));
		if(Image1.isDisplayed() && Image2.isDisplayed()) {
			System.out.println("image is displayed");
		}else
			System.out.println("image is not displayed");
		}
public static void closeBrowser() {
		
		driver.quit();
		System.out.println("Browser closed");
	}
	
		
	@Test(priority = 1)
	public static void hackathonTest1() throws Exception {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\PrathibhaDas\\Documents\\Selenium_Canara\\MavenWebApp\\main\\chromedriver.exe");
  	    ChromeOptions options = new ChromeOptions();	
		options.addArguments("--start-maximized");   					  
		driver = new ChromeDriver(options);
		driver.get("https://demo.applitools.com/hackathon.html?showAd=true");
		Thread.sleep(2000);
		enterUserCredentials("abc", "");
		clickLogin();
		errorMsg();
		Thread.sleep(2000);
		//TakeScreenShot(driver, 3);
		
		
	}
	
	
	@Test(priority = 2)
	public void hackathonLogin2() throws Exception
	{
		enterUserCredentials("", "abc");
		clickLogin();
		errorMsg();
		Thread.sleep(2000);		
	}
	
	@Test(priority = 3)
	public void hackathonLogin3( ) throws Exception {
		enterUserCredentials("abc", "abc");
		clickLogin();
		Thread.sleep(2000);
		flashGif();
		amountSort();
		ExpenseChart();
		closeBrowser();
	}
	
	
		
		
	@AfterMethod	
	public static void takeScreenShot() throws IOException {
		System.out.println("Capturing Screen Shot....");
		TakesScreenshot ss = (TakesScreenshot) driver;
		File screenShot = ss.getScreenshotAs(OutputType.FILE);
		String pattern = "yyyy-MM-dd";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String date = simpleDateFormat.format(new Date());
		FileUtils.copyFile(screenShot,
				new File("C:\\Users\\PrathibhaDas\\Documents\\Selenium_Canara\\MavenWebApp\\Screenshot\\" + "Test" + date+ ".png"));
	}
	
		}
	

	
	


