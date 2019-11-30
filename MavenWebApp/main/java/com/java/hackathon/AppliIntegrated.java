package com.java.hackathon;
import org.openqa.selenium.WebDriver;

import com.applitools.eyes.*;
import com.applitools.eyes.selenium.ClassicRunner;
import com.applitools.eyes.selenium.Eyes;


public class AppliIntegrated {
	
	public static WebDriver driver;

	public static void main(String[] args) {
		
	
	// Initialize the Runner for your test.
	EyesRunner runner = new ClassicRunner();
	// Initialize the eyes SDK
	Eyes eyes = new Eyes(runner);
	// Change the APPLITOOLS_API_KEY API key with yours
	eyes.setApiKey("APPLITOOLS_API_KEY");
	eyes.open(driver, "Demo App", "Smoke Test", new RectangleSize(800, 600));
	// Navigate the browser to the "ACME" demo app.
	driver.get("https://demo.applitools.com");
	eyes.checkWindow("Login Window");

	// End the test.
	eyes.close();
	// Close the browser.
	driver.quit();
	}

}
