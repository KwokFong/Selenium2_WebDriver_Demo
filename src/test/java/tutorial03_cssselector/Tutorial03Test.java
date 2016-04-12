package tutorial03_cssselector;

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

//www.softwaretestinghelp.com/css-selector-selenium-locator-selenium-tutorial-6/

public class Tutorial03Test {
	
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

		driver.get("http://accounts.google.com");
		new WebDriverWait(driver, 10).until(ExpectedConditions.titleContains("Sign in"));
		
		// Find Web Element by cssSelector id
		WebElement txtEmail = driver.findElement(By.cssSelector("input#Email"));
		
		// Verifications
		assertThat(txtEmail).isNotNull();
		assertThat(txtEmail.getAttribute("name")).isEqualTo("Email");
		assertThat(txtEmail.getAttribute("placeholder")).isEqualTo("Enter your email");
		assertThat(txtEmail.getTagName()).isEqualTo("input");
		
		// Type some text into Email
		txtEmail.sendKeys("SampleEmailLogin");
		
		// Verification
		assertThat(txtEmail.getAttribute("value")).isEqualTo("SampleEmailLogin");
	}
	
	@Test
	public void testLocateByCSS_Class(){
		
		driver.get("http://accounts.google.com");
		new WebDriverWait(driver, 10).until(ExpectedConditions.titleContains("Sign in"));
		
		// Find Web Element by cssSelector: class
		WebElement lblOneGoogleAccount = driver.findElement(By.cssSelector("p.tagline"));
		
		// Verifications:
		assertThat(lblOneGoogleAccount).isNotNull();
		assertThat(lblOneGoogleAccount.getText()).isEqualTo("One Google Account for everything Google");
	}
	
	@Test
	public void testLocateByCSS_Attributes(){
		
		driver.get("http://accounts.google.com");
		new WebDriverWait(driver, 10).until(ExpectedConditions.titleContains("Sign in"));
		
		// Find Web Element by cssSelector: attributes
		WebElement btnNext = driver.findElement(By.cssSelector("input[type='submit'][value='Next']"));
		
		// Verifications:
		assertThat(btnNext).isNotNull();
		assertThat(btnNext.getTagName()).isEqualTo("input");
		assertThat(btnNext.getAttribute("type")).isEqualTo("submit");
	}
	
	@Test
	public void testLocateByCSS_Id_Attributes(){

		driver.get("http://accounts.google.com");
		new WebDriverWait(driver, 10).until(ExpectedConditions.titleContains("Sign in"));
		
		// Find Web Element by cssSelector id + attribute
		WebElement txtEmail = driver.findElement(By.cssSelector("input#Email[placeholder='Enter your email']"));
		
		// Verifications
		assertThat(txtEmail).isNotNull();
		assertThat(txtEmail.getAttribute("name")).isEqualTo("Email");
		assertThat(txtEmail.getAttribute("placeholder")).isEqualTo("Enter your email");
		assertThat(txtEmail.getTagName()).isEqualTo("input");
		
		// Type some text into Email
		txtEmail.sendKeys("LocateByIDAndAttribute");
		
		// Verification
		assertThat(txtEmail.getAttribute("value")).isEqualTo("LocateByIDAndAttribute");
	}
	
	@Test
	public void testLocateByCSS_Class_Attributes(){

		driver.get("http://accounts.google.com");
		new WebDriverWait(driver, 10).until(ExpectedConditions.titleContains("Sign in"));
		
		// Find Web Element by cssSelector class + attribute
		WebElement btnNext = driver.findElement(By.cssSelector("input.rc-button-submit[type='submit'][value='Next']"));
		
		// Verifications:
		assertThat(btnNext).isNotNull();
		assertThat(btnNext.getTagName()).isEqualTo("input");
		assertThat(btnNext.getAttribute("type")).isEqualTo("submit");
	}
	
	@Test
	public void testLocateByCSS_Attribute_Substring(){

		driver.get("http://accounts.google.com");
		new WebDriverWait(driver, 10).until(ExpectedConditions.titleContains("Sign in"));
		
		// Find Web Element by cssSelector: Attribute Prefix Match
		WebElement txtEmail = driver.findElement(By.cssSelector("input[name^='Ema']"));
		
		// Verifications
		assertThat(txtEmail).isNotNull();
		assertThat(txtEmail.getAttribute("name")).isEqualTo("Email");
		assertThat(txtEmail.getAttribute("placeholder")).isEqualTo("Enter your email");
		assertThat(txtEmail.getTagName()).isEqualTo("input");
		
		// Find Web Element by cssSelector: Attribute Suffix Match
		txtEmail = null;
		txtEmail = driver.findElement(By.cssSelector("input[placeholder$=' email']"));
		
		// Verifications
		assertThat(txtEmail).isNotNull();
		assertThat(txtEmail.getAttribute("name")).isEqualTo("Email");
		assertThat(txtEmail.getAttribute("placeholder")).isEqualTo("Enter your email");
		assertThat(txtEmail.getTagName()).isEqualTo("input");
		
		// Find Web Element by cssSelector: Attribute Substring Match
		txtEmail = null;
		txtEmail = driver.findElement(By.cssSelector("input[placeholder*=' your ']"));
		
		// Verifications
		assertThat(txtEmail).isNotNull();
		assertThat(txtEmail.getAttribute("name")).isEqualTo("Email");
		assertThat(txtEmail.getAttribute("placeholder")).isEqualTo("Enter your email");
		assertThat(txtEmail.getTagName()).isEqualTo("input");
	}
	

}
