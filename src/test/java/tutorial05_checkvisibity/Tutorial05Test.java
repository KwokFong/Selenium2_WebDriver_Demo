package tutorial05_checkvisibity;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

// http://www.softwaretestinghelp.com/webdriver-commands-selenium-tutorial-14/

public class Tutorial05Test {

	static WebDriver driver;
	
	@BeforeClass
	public static void setup(){
		driver = new FirefoxDriver();
	}
	
	@AfterClass
	public static void cleanup(){
		driver.close();
		driver.quit();
	}
	
	@Test
	public void testLocateByCSS_Id(){

		driver.get("http://duckduckgo.com");
		new WebDriverWait(driver, 10).until(ExpectedConditions.titleContains("DuckDuckGo"));
		
		// Find Web Element 
		WebElement txtSearchBox = driver.findElement(By.id("search_form_input_homepage"));
		
		// Verifications
		assertThat(txtSearchBox).isNotNull();
		assertThat(txtSearchBox.isDisplayed()).isTrue();
		
		// Type some text into Google Search Textbox
		txtSearchBox.clear();
		txtSearchBox.sendKeys("Selenium");
		
		WebElement btnSearch = driver.findElement(By.id("search_button_homepage"));
		assertThat(btnSearch).isNotNull();
		assertThat(btnSearch.isDisplayed()).isTrue();		
		assertThat(btnSearch.isEnabled()).isTrue();	
		
		btnSearch.click();
		
		// Verification
		String resultURL = driver.getCurrentUrl();
		assertThat(resultURL).isEqualTo("https://duckduckgo.com/?q=Selenium&ia=answer");
	}
}
