package org.max;

import java.awt.AWTException;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class MyntraAppium {
	public static AndroidDriver driver;
	public static void main(String[] args) throws MalformedURLException, InterruptedException, AWTException {
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "11");
		cap.setCapability("deviceName", "OnePlus 7T");
		cap.setCapability("udid", "16b0708e");
		cap.setCapability("appPackage", "com.myntra.android");
		cap.setCapability("appActivity", "com.myntra.android.SplashActivity");
		
		URL url = new URL("http://0.0.0.0:4723/wd/hub");
		
		driver = new AndroidDriver(url,cap);
	
		driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"tabButton_profile\"]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@text='LOG IN/SIGN UP']")).click();
		Thread.sleep(1000);
		WebElement phone = driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"mobile\"]"));
		phone.sendKeys("9874563210");
		
		driver.findElement(By.xpath("//*[@text='CONTINUE']")).click();
	}
}
	
	
