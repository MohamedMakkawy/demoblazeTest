package demoblazeTest.demoblazeTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {
	
	WebDriver driver;
	
	
	public TestBase() {
	
	
		//Add chrome driver exe file in the system properties
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir")+"/chromedriver.exe");
		//new object from CHrome Driver
		driver=new ChromeDriver();
		driver.navigate().to("https://www.demoblaze.com/index.html");
		driver.manage().window().maximize();
	
		
	}
}
