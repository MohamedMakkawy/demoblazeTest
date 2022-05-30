package demoblazeTest.demoblazeTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDescriptionPOM extends ElementHelper{
	
	 	
	public ProductDescriptionPOM(WebDriver driver) {
		super(driver);
	}
	//Locators
	private By AddToCartPath = By.xpath("//*[text()='Add to cart']");
	
	//Action Methods

	public void addToCart () throws InterruptedException
	{
		clickElement(AddToCartPath);
		acceptAlertPopUp();
	}
}
