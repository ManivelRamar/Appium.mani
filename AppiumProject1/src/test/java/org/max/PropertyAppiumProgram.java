package org.max;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class PropertyAppiumProgram {

	public static AndroidDriver driver;
	public static void main(String[] args) throws IOException, InterruptedException {
		DesiredCapabilities cap = new DesiredCapabilities();
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("./appiumData.properties");
		prop.load(fis);
		cap.setCapability("platformName",prop.getProperty("platformName") );
		cap.setCapability("platformVersion",prop.getProperty("platformVersion") );
		cap.setCapability("deviceName",prop.getProperty("deviceName") );
		cap.setCapability("udid",prop.getProperty("udid") );
		cap.setCapability("appPackage",prop.getProperty("appPackage") );
		cap.setCapability("appActivity",prop.getProperty("appActivity") );
		
		URL url = new URL("http://0.0.0.0:4723/wd/hub/");
		driver = new AndroidDriver(url, cap);
		
		driver.findElement(By.xpath(prop.getProperty("profile"))).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("login"))).click();
		Thread.sleep(1000);
		WebElement phone = driver.findElement(By.xpath(prop.getProperty("number")));
		phone.sendKeys("9874563210");
		
		driver.findElement(By.xpath(prop.getProperty("submit"))).click();
		

	}

}
