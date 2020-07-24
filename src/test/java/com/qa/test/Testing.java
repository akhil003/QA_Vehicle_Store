package com.qa.test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Testing {

	WebDriver driver;
	//	ExtentHtmlReporter htmlReporter;
	//	 * 
	//	 * ExtentReports extent; //helps to generate the logs in test report. ExtentTest
	//	 * test; ExtentTest logger;
	//	 */

	//	public void startReport(String OS, String browser) {
	//		// initialize the HtmlReporter
	//		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") +"/test-output/extentreport.html");
	//
	//		//initialize ExtentReports and attach the HtmlReporter
	//		extent = new ExtentReports();
	//		extent.attachReporter(htmlReporter);
	//		htmlReporter.config().setReportName("Test Report");
	//
	//	}

	@BeforeMethod

	public void openBrowser() {

		System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\akhiil.shukla\\\\Downloads\\\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://localhost:8585/SampleServlet/");

	}

	@Test(groups={"Regression" })

	public void verifyPageTitle() {

		String actualTitle = driver.getTitle();
		String expectedTitle = "Vehicle Store";
		if (actualTitle.equalsIgnoreCase(expectedTitle))
			System.out.println("Title Matched");
		else
			System.out.println("Title didn't match");
	}

	@Test(groups={"Regression" })

	public void verifyHomePageHeader()

	{
		WebElement headerText = driver.findElement(By.xpath("//h1[contains(text(),'Select the type of Vehicle')]"));
		String text = headerText.getText();
		if (text.contains("Select the type of Vehicle")) {
			System.out.println("Expected Header is obtained");
		} else {
			System.out.println("Expected Header is not obtained");
		}

	}

	@Test(groups={"Regression" })

	public void verify_SubmitButton() throws InterruptedException {
		driver.findElement(By.xpath("//html//body//center//form//input")).click();
		Thread.sleep(5000);
	}

	@Test(groups={"Regression" })

	public void verify_VehicleListOfValues() {
		WebElement dropdown = driver.findElement(By.xpath("//select[@name='Type']"));
		Select list = new Select(dropdown);
		List<WebElement> dropdown_list = list.getOptions();
		for (int i = 0; i < dropdown_list.size(); i++) {
			String dropdown_value = dropdown_list.get(i).getText();
			System.out.println(dropdown_value);
		}

		System.out.println("Test case for Group Regression");

	}

	@Test(groups={"Smoke"})

	public void verifySubmitButton() throws InterruptedException {
		driver.findElement(By.xpath("//html//body//center//form//input")).click();
		Thread.sleep(5000);
	}

	@Test(groups={"Smoke"})

	public void verifyVehicleListOfValues() {
		WebElement dropdown = driver.findElement(By.xpath("//select[@name='Type']"));
		Select list = new Select(dropdown);
		List<WebElement> dropdown_list = list.getOptions();
		for (int i = 0; i < dropdown_list.size(); i++) {
			String dropdown_value = dropdown_list.get(i).getText();
			System.out.println(dropdown_value);
		}

		System.out.println("Test case for Group Smoke");

	}

	@AfterMethod

	public void tearDown() {

		driver.quit();

	}
}
