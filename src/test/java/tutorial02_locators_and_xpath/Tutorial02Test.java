package tutorial02_locators_and_xpath;

// http://www.softwaretestinghelp.com/using-selenium-xpath-and-other-locators-selenium-tutorial-5/

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

// http://www.softwaretestinghelp.com/using-selenium-xpath-and-other-locators-selenium-tutorial-5/

public class Tutorial02Test {
	
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
	public void testLocateById(){

		driver.get("http://accounts.google.com");
		new WebDriverWait(driver, 10).until(ExpectedConditions.titleContains("Sign in"));
		
		// Find Web Element by id
		WebElement txtEmail = driver.findElement(By.id("Email"));
		
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
	public void testLocateByClassName(){

		driver.get("http://accounts.google.com");
		new WebDriverWait(driver, 10).until(ExpectedConditions.titleContains("Sign in"));
		
		// Find Web Element by className
		WebElement linkNeedHelp = driver.findElement(By.className("need-help"));
		
		// Verifications
		assertThat(linkNeedHelp).isNotNull();
		assertThat(linkNeedHelp.getText()).isEqualTo("Need help?");
	}
	
	@Test
	public void testLocateByName(){

		driver.get("http://accounts.google.com");
		new WebDriverWait(driver, 10).until(ExpectedConditions.titleContains("Sign in"));
		
		// Find Web Element by name
		WebElement btnNext = driver.findElement(By.name("signIn"));
		
		// Verifications
		assertThat(btnNext).isNotNull();
		assertThat(btnNext.getTagName()).isEqualTo("input");
		assertThat(btnNext.getAttribute("type")).isEqualTo("submit");
	}
	
	@Test
	public void testLocateByHyperlinkText(){

		driver.get("http://accounts.google.com");
		new WebDriverWait(driver, 10).until(ExpectedConditions.titleContains("Sign in"));
		
		// Find Web Element by linkText
		WebElement lnkCreateAccount = driver.findElement(By.linkText("Create account"));
		
		// Verifications
		assertThat(lnkCreateAccount).isNotNull();
		assertThat(lnkCreateAccount.getTagName()).isEqualTo("a");
	}
	
	@Test
	public void testFindEmailByXPath(){
		
		driver.get("http://accounts.google.com");
		new WebDriverWait(driver, 10).until(ExpectedConditions.titleContains("Sign in"));
		
		// Find Web Element by XPath
		WebElement txtEmail = driver.findElement(By.xpath(".//*[@id='Email']"));
		
		// Verifications:
		assertThat(txtEmail).isNotNull();
		assertThat(txtEmail.getAttribute("name")).isEqualTo("Email");
		assertThat(txtEmail.getAttribute("placeholder")).isEqualTo("Enter your email");
		assertThat(txtEmail.getTagName()).isEqualTo("input");
	}
	
	@Test
	public void testFindLinkByXPath(){
		
		driver.get("http://accounts.google.com");
		new WebDriverWait(driver, 10).until(ExpectedConditions.titleContains("Sign in"));
		
		// Find Web Element by XPath
		WebElement lnkNeedHelp = driver.findElement(By.xpath(".//*[@id='gaia_firstform']/div/a"));
		
		// Verifications:
		assertThat(lnkNeedHelp).isNotNull();
		assertThat(lnkNeedHelp.getText()).isEqualTo("Need help?");
	}
	
	@Test
	public void testFindLabelByXPath(){
		
		driver.get("http://accounts.google.com");
		new WebDriverWait(driver, 10).until(ExpectedConditions.titleContains("Sign in"));
		
		// Find Web Element by XPath
		WebElement lblGoogleSignIn = driver.findElement(By.xpath("html/body/div/div[2]/div[1]/h2"));
		
		// Verifications:
		assertThat(lblGoogleSignIn).isNotNull();
		assertThat(lblGoogleSignIn.getText()).isEqualTo("Sign in with your Google Account");
	}

}
