package com.assessment.maven;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MakeMyTrip {
	WebDriver driver;

	WebDriverWait wait;

	@BeforeMethod
	public void flightTickets() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.makemytrip.com/");
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, Duration.ofSeconds(3));
	}

	@Test
	public void bookingFlights() {

		// Perform click on Popup

		WebElement popup = driver.findElement(By.xpath("//span[@class='commonModal_close']"));
		wait.until(ExpectedConditions.visibilityOf(popup)).click();

		// Click on flight tab

		WebElement flightstab = driver.findElement(By.xpath("//span[text()='Flights']"));
		wait.until(ExpectedConditions.visibilityOf(flightstab)).click();
		WebElement radiobutton = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[text()='Round Trip']")));
		radiobutton.click();

		// Locate elements for the From Location

		WebElement from = driver.findElement(By.xpath("//span[text()-'From']"));
		wait.until(ExpectedConditions.visibilityOf(from)).click();
		WebElement search = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder-'From']")));
		search.sendKeys("Hyderabad");
		WebElement hyd = driver.findElement(By.xpath("(//li[@id='react-autowhatever-1-section-0-item-0*1)"));
		wait.until(ExpectedConditions.elementToBeClickable(hyd)).click();

		// Locate elements for the To Location

		WebElement to = driver.findElement(By.xpath("//span[text() = 'To']"));
		wait.until(ExpectedConditions.visibilityOf(to)).click();
		WebElement find = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='To']")));
		find.sendKeys("MAA");
		WebElement chennai = driver.findElement(By.xpath("//p[text()-Chennai, India']"));
		wait.until(ExpectedConditions.elementToBeClickable(chennai)).click();

		// Locate elements for Start and end date

		WebElement startdate = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@aria-label='Sun Nov 19 2023']")));
		startdate.click();
		WebElement enddate = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@aria-label='Sun Nov 26 2023']")));
		enddate.click();

		WebElement finalsearch = driver.findElement(By.xpath("//a[text()='Search']"));
		wait.until(ExpectedConditions.elementToBeClickable(finalsearch)).click();

		String title = driver.getTitle();

		if (title.contains("makeMytrip")) {

			AssertJUnit.assertTrue(title.contains("makemytrip"));

			System.out.println("The Search page is displayed as expected");

		} else {

			System.out.println("The Search page is not displayed as expected");

		}
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}
