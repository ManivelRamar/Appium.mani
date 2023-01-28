package org.max;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class ChromeAppium {
	
	public static AndroidDriver driver;
	public static void main(String[] args) throws MalformedURLException, InterruptedException, AWTException {
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "11");
		cap.setCapability("deviceName", "OnePlus 7T");
		cap.setCapability("udid", "16b0708e");
		cap.setCapability("appPackage", "com.android.chrome");
		cap.setCapability("appActivity", "com.google.android.apps.chrome.Main");
		
		URL url = new URL("http://0.0.0.0:4723/wd/hub");
		
		driver = new AndroidDriver(url,cap);
		
		driver.findElement(By.id("com.android.chrome:id/terms_accept")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("com.android.chrome:id/negative_button")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("com.android.chrome:id/search_box_text")).sendKeys("flipkart");
		
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@text='Flipkart']")).click();
		Thread.sleep(1000);
		WebElement src = driver.findElement(By.xpath("//*[contains(@text,'Search for Products')]"));
		src.click();
		Thread.sleep(2000);
		WebElement search = driver.findElement(By.xpath("//*[@resource-id='input-searchsearchpage-input']"));
		search.sendKeys("apple phone");
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}
}
