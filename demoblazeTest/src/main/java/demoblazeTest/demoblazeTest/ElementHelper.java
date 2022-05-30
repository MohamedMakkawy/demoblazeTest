package demoblazeTest.demoblazeTest;

import java.time.Duration;

import static org.testng.AssertJUnit.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementHelper {
	
	private WebElement element;
	private WebDriver driver; 
	private WebDriverWait wait;
	
	public ElementHelper(WebDriver driver)
	{
		this.driver=driver;
		wait = new WebDriverWait(this.driver,Duration.ofSeconds(15));
	}
	public void clickElement(By by){
		wait.until(ExpectedConditions.elementToBeClickable(by));
		element = driver.findElement(by);
		element.click();
	}
	public void sendKeysElement(By by , String value)
	{
		wait.until(ExpectedConditions.elementToBeClickable(by));
		element = driver.findElement(by);
		element.sendKeys(value);
	}
	
	public void waitForElementToBeInvisible(By by){
		wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
	}
	
	public void assertion (By by , String expected)
	{
		wait.until(ExpectedConditions.elementToBeClickable(by));
		element = driver.findElement(by);
	  assertEquals(element.getText(),expected);
	}
	
	public String getText(By by) {
		
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		String textValue = element.getText();
		return textValue;
	}
	
	public void acceptAlertPopUp() {
		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();
	}
	
}
