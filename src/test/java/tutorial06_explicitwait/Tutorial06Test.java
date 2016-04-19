package tutorial06_explicitwait;

// http://www.softwaretestinghelp.com/selenium-webdriver-waits-selenium-tutorial-15/

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Tutorial06Test {
	
	private static WebDriver driver;
	private static String username = "tomsmith";
	private static String password = "SuperSecretPassword!";

	@BeforeClass
	public static void setup() {
		driver = new FirefoxDriver();
	}

	@AfterClass
	public static void teardown() {
		driver.close();
		driver.quit();
	}

	@Test
	public void validLogin_HerokuApp() {

		System.out.println("Navigating to: http://the-internet.herokuapp.com/login");
		driver.get("http://the-internet.herokuapp.com/login");

		System.out.println("Waiting for page to load...");
		new WebDriverWait(driver, 10).until(ExpectedConditions.titleIs("The Internet"));

		// Verify: Correct Page is loaded.
		assertThat(driver.getTitle()).isEqualTo("The Internet");

		WebElement txtUsername = driver.findElement(By.id("username"));
		txtUsername.sendKeys(username);

		WebElement txtPassword = driver.findElement(By.id("password"));
		txtPassword.sendKeys(password);

		WebElement submitButton = driver.findElement(By.cssSelector("[type='submit'][class='radius']"));
		submitButton.click();

		System.out.println("Waiting for page to load...");
		new WebDriverWait(driver, 10).until(ExpectedConditions.titleIs("The Internet"));

		// Verify: Correct Page is loaded.
		assertThat(driver.getTitle()).isEqualTo("The Internet");

		// Verify: URL contains the correct string.
		assertThat(driver.getCurrentUrl()).contains("/secure");

		// Verify: Logout button should be there.  (example of visibilityOf())
		WebElement logoutButton = driver.findElement(By.cssSelector("[class='button secondary radius']"));
		System.out.println("Waiting for logout button to load...");
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(logoutButton));
		
		// Verify the logout button is visible and click able.  (example of elementToBeClickable())
		new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.cssSelector("i.icon-2x.icon-signout")));
		
		// Verify: Logged in message should be there.		(example of visibilityOfElementLocated())
		WebElement loginMessage = driver.findElement(By.cssSelector("div#flash"));
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#flash")));
		assertThat(loginMessage.getText()).contains("You logged into a secure area!");
		
		// Verify: Logged in message should contain certain text.   (example of textToBePresentInElement())
		new WebDriverWait(driver, 10).until(ExpectedConditions.textToBePresentInElement(loginMessage, "You logged into a secure area!"));
		
		// Verify: Title should contain certain text.		(example of titleIs())
		new WebDriverWait(driver, 10).until(ExpectedConditions.titleIs("The Internet"));
	}

}
