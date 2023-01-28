package org.max;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.appium.java_client.android.AndroidDriver;

public class AppiumCalc {

	public static AndroidDriver driver;
	ExtentReports extent;
	ExtentTest test;
	
	@BeforeClass
	public void calc() throws MalformedURLException {
		
		ExtentSparkReporter report = new ExtentSparkReporter("./target/CalcReport.html");
		extent = new ExtentReports();
		extent.attachReporter(report);
		test = extent.createTest("Android", "Calculator functions");
		
		DesiredCapabilities d = new DesiredCapabilities();
		d.setCapability("platformName", "Android");
		d.setCapability("platformVersion", "11");
		d.setCapability("deviceName", "OnePlus 7T");
		d.setCapability("udid", "16b0708e");
		d.setCapability("appPackage", "com.oneplus.calculator");
		d.setCapability("appActivity", "com.oneplus.calculator.Calculator");

		URL u = new URL("http://0.0.0.0:4723/wd/hub");
		driver = new AndroidDriver(u, d);	
	}

	@Test(priority = 1)
	public void firstValue() {
		
		driver.findElement(By.id("com.oneplus.calculator:id/digit_5")).click();
		driver.findElement(By.id("com.oneplus.calculator:id/digit_6")).click();
		test.log(Status.PASS, "Entered First value to perform calculation");
	}

	@Test(priority = 2)
	public void action() {
		driver.findElement(By.id("com.oneplus.calculator:id/op_add")).click();
		test.log(Status.PASS, "Entered function to perform calculation");
	}

	@Test(priority = 3)
	public void secondValue() {
		driver.findElement(By.id("com.oneplus.calculator:id/digit_7")).click();
		driver.findElement(By.id("com.oneplus.calculator:id/digit_4")).click();
		test.log(Status.PASS, "Entered second value to perform calculation");
	}

	@Test(priority = 4)
	public void equals() {
		driver.findElement(By.id("com.oneplus.calculator:id/eq")).click();
		test.log(Status.PASS, "Equals to check the final value of calculation");
	}

	@Test(priority = 5)
	public void screenShot() throws IOException {
		TakesScreenshot tss = (TakesScreenshot) driver;
		File source = tss.getScreenshotAs(OutputType.FILE);
		File destination = new File("./Images/Calc.png");
		FileUtils.copyFile(source, destination);
		test.log(Status.PASS, "Screenshot captured and stored in project");
	}

	@BeforeMethod
	public void startTime() {
		Date d = new Date();
		System.out.println(d);
	}

	@AfterMethod
	public void closeTime() {
		Date d = new Date();
		System.out.println(d);
	}

	@AfterClass
	public void closeWindow() {
		extent.flush();
		driver.quit();
	}
}
