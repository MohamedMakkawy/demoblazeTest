package demoblazeTest.demoblazeTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePagePOM extends ElementHelper{

	private String productName = "";
	
	public HomePagePOM(WebDriver driver) {
		super(driver);
	}
	
	//Locators	
	private By LaptopsCategoryPath = By.xpath("//*[text()='Laptops']");
	private By LaptopNamePath = By.xpath("//*[text()='"+productName+"']");
	private By NavigateToHomePagePath = By.id("nava");
	private By NavigateToCartPagePath = By.xpath("//*[text()='Cart']");
	
	//Action Methods
	public void buyProduct(String productName)
	{
		this.productName=productName;
		LaptopNamePath = By.xpath("//*[text()='"+productName+"']");
		clickElement(LaptopsCategoryPath);
		clickElement(LaptopNamePath);
	}
	
	public void navigateToHomePage()
	{
		clickElement(NavigateToHomePagePath);
	}
	public void navigateToCartPage()
	{
		clickElement(NavigateToCartPagePath);
	}
	
}
