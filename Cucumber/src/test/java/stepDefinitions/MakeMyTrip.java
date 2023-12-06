package stepDefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;

public class MakeMyTrip {
	WebDriver driver;
	WebDriverWait wait;

	@Given("EdgeDriver must be opened")
	public void edge_driver_must_be_opened() {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, Duration.ofSeconds(3   ));
	}

	@Then("User need to enter into the MakeMyTrip page")
	public void user_need_to_enter_into_the_make_my_trip_page() {
		driver.get("https://www.makemytrip.com/");

		// Perform click on Popup
		WebElement popup = driver.findElement(By.xpath("//span[@class='commonModal__close']"));
		wait.until(ExpectedConditions.visibilityOf(popup)).click();

	}

	@Then("user need to click on flights")
	public void user_need_to_click_on_flights() throws InterruptedException {
		// Click on flight tab

		WebElement flightstab = driver.findElement(By.xpath("//span[text()='Flights']"));
		wait.until(ExpectedConditions.visibilityOf(flightstab)).click();

		WebElement radiobutton = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[text()='Round Trip']")));
		radiobutton.click();
	}

	@Then("user need to select from and to details")
	public void user_need_to_select_from_and_to_details() {
		// Locate elements for the From Location

		WebElement from = driver.findElement(By.xpath("//span[text()='From']"));
		wait.until(ExpectedConditions.visibilityOf(from)).click();
		WebElement search = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='From']")));
		search.sendKeys("Hyderabad");
		WebElement hyd = driver.findElement(By.xpath("//p[text()='Hyderabad, India']"));
		wait.until(ExpectedConditions.elementToBeClickable(hyd)).click();

		// Locate elements for the To Location

		WebElement to = driver.findElement(By.xpath("//span[text() = 'To']"));
		wait.until(ExpectedConditions.visibilityOf(to)).click();
		WebElement find = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='To']")));
		find.sendKeys("MAA");
		WebElement chennai = driver.findElement(By.xpath("//p[text()='Chennai, India']"));
		wait.until(ExpectedConditions.elementToBeClickable(chennai)).click();

	}

	@Then("user need to select the departure and return date")
	public void user_need_to_select_the_departure_and_return_date() {
		WebElement startdate = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@aria-label='Wed Oct 25 2023']")));
		startdate.click();
		WebElement enddate = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@aria-label='Sat Nov 04 2023']")));
		enddate.click();

	}

	@Then("user need to click search button")
	public void user_need_to_click_search_button() {
		WebElement finalsearch = driver.findElement(By.xpath("//a[text()='Search']"));
		wait.until(ExpectedConditions.elementToBeClickable(finalsearch)).click();

	}

	@Then("user should be able to see the search results")
	public void user_should_be_able_to_see_the_search_results() {

		String title = driver.getTitle();
		if (title.contains("makeMytrip")) {

			Assert.assertTrue(title.contains("makemytrip"));
			System.out.println("The Search page is displayed as expected");

		} else {

			System.out.println("The Search page is not displayed as expected");
		}
		
		driver.close();
	}
}
