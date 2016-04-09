package tutorial01_helloworld;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Tutorial01 {

	private static WebDriver firefox;

	@BeforeClass
	public static void setup() {
		firefox = new FirefoxDriver();
	}

	@AfterClass
	public static void teardown() {
		firefox.close();
		firefox.quit();
	}

	@Test
	public void navigateToGoogle() {
		firefox.get("http://www.google.com");

		assertThat(firefox.getTitle()).startsWith("Google");
//		assertThat(firefox.getTitle()).startsWith("XGoogle");
	}

}
