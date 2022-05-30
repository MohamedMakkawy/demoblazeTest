package demoblazeTest.demoblazeTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPOM extends ElementHelper{
	

	public CartPOM(WebDriver driver) {
		super(driver);
	}
	
	//Locators	
	private By DeleteProductPath = By.xpath("//tr//td[text()='Dell i7 8gb']//following::td[2]/a");
	private By ProductPricePath = By.xpath("//tr//td[text()='Sony vaio i5']//following::td[1]");
	private By placeOrderPath = By.xpath("//button[text()='Place Order']");
	private By NamePath = By.id("name");
	private By CountryPath = By.id("country");
	private By CityPath = By.id("city");
	private By CreditCardPath = By.id("card");
	private By MonthPath = By.id("month");
	private By YearPath = By.id("year");  
	private By PurchaseButtonPath = By.xpath("//button[text()='Purchase']");
	private By PurchaseDetailsPath = By.xpath("//p[@class = 'lead text-muted ']");
	
	//Action Methods
	public void deleteProduct(String productName)
	{
		clickElement(DeleteProductPath);
		waitForElementToBeInvisible(DeleteProductPath);
	}
	
	public void placeOrder()
	{
		clickElement(placeOrderPath);
	}
	public void purchase() 
	{
		sendKeysElement(NamePath, "Mohamed");
		sendKeysElement(CountryPath, "Spain");
		sendKeysElement(CityPath, "Seville");
		sendKeysElement(CreditCardPath, "123456789");
		sendKeysElement(MonthPath, "August");
		sendKeysElement(YearPath, "1993");
		clickElement(PurchaseButtonPath);
	}
	public String getProductPrice()
	{
		return getText(ProductPricePath);
	}
	public void getPurchaseDetails()
	{
		getPurchaseId();
		getPurchaseAmount();
	}
	public void getPurchaseId()
	{
		String[] keyValuePairs = getText(PurchaseDetailsPath).split("\n"); 
		System.out.println(keyValuePairs[0]);
	}
	public String getPurchaseAmount()
	{
		String[] keyValuePairs = getText(PurchaseDetailsPath).split("\n"); 
		String ampunt = keyValuePairs[1];
		ampunt = ampunt.replaceAll("Amount: ","");
		return ampunt = ampunt.replaceAll(" USD","");
	}
	
	
}
