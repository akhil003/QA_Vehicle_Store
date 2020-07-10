package com.qa.test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class VehicleJunit {

	WebDriver driver;  


	@Test

	public void openBrowser() {



		System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\akhiil.shukla\\\\Downloads\\\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://localhost:8585/SampleServlet/"); 

	}

	@Test

	public void verifySubmitButton() throws InterruptedException {
		driver.findElement(By.xpath("//html//body//center//form//input")).click(); 
		Thread.sleep(5000);
	}


	@Test

	public void verifyPageTitle() {
		String actualTitle = driver.getTitle();
		String expectedTitle = "Vehicle Store";
		if(actualTitle.equalsIgnoreCase(expectedTitle))
			System.out.println("Title Matched");
		else
			System.out.println("Title didn't match");   
	}


	@Test

	public void verifyHomePageHeader() {
		WebElement headerText = driver.findElement(By.xpath("//h1[contains(text(),'Select the type of Vehicle')]"));
		String text = headerText.getText();
		if(text.contains("Select the type of Vehicle")){
			System.out.println("Expected Header is obtained");
		} 
		else {
			System.out.println("Expected Header is not obtained");
		}

	}


	@Test
	

	public void verifyVehicleListOfValues() {
		WebElement dropdown = driver.findElement(By.xpath("//select[@name='Type']"));
		Select list = new Select(dropdown);
		List<WebElement> dropdown_list = list.getOptions();
		for (int i = 0; i < dropdown_list.size(); i++) {
			String dropdown_value = dropdown_list.get(i).getText();
			System.out.println(dropdown_value);
		}      


	}



	

}

