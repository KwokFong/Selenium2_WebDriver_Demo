package tutorial04_dropdown;

// http://www.softwaretestinghelp.com/selenium-select-class-selenium-tutorial-13/

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

public class Tutorial04Test {
	
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
	public void testFindDropDowns(){

		driver.get("file://F:/GitHub_kwokfong/Selenium2_WebDriver_Demo/Selenium2_WebDriver_Demo/TestDropDown.html");
		new WebDriverWait(driver, 10).until(ExpectedConditions.titleContains("Testing Select Class"));
		
		// Find Color DropDown
		WebElement ddnColor = driver.findElement(By.id("SelectID_One"));
		Select selectColor = new Select(ddnColor);
		selectColor.selectByValue("greenvalue");
		
		// Verification
		assertThat(selectColor.getFirstSelectedOption().getText()).isEqualTo("Green");
		
		
		// Find Fruit DropDown
		WebElement ddnFruit = driver.findElement(By.id("SelectID_Two"));
		Select selectFruit = new Select(ddnFruit);
		selectFruit.selectByVisibleText("Lime");
		
		// Verification
		assertThat(selectFruit.getFirstSelectedOption().getText()).isEqualTo("Lime");
		
		
		// Find Animal DropDown
//		WebElement ddnAnimal = driver.findElement(By.id("SelectID_Three"));
		Select selectAnimal = new Select(driver.findElement(By.id("SelectID_Three")));
		selectAnimal.selectByIndex(2);
		
		// Verification
		assertThat(selectAnimal.getFirstSelectedOption().getText()).isEqualTo("Mouse");
	}
}
