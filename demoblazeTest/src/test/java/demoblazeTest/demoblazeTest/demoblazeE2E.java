package demoblazeTest.demoblazeTest;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class demoblazeE2E extends TestBase {

	private HomePagePOM homePagePOM;
	private ProductDescriptionPOM productDescriptionPOM;
	private CartPOM cartPOM;

	@BeforeTest
	public void beforeTest() {

		homePagePOM = new HomePagePOM(driver);
		productDescriptionPOM = new ProductDescriptionPOM(driver);
		cartPOM = new CartPOM(driver);
	}

	@Test
	public void BuyNewLaptopTest() throws InterruptedException {
		
		homePagePOM.buyProduct("Sony vaio i5");
		productDescriptionPOM.addToCart();
		homePagePOM.navigateToHomePage(); 
		homePagePOM.buyProduct("Dell i7 8gb");
		productDescriptionPOM.addToCart();
		homePagePOM.navigateToCartPage();
		cartPOM.deleteProduct("Dell i7 8gb");
		String productPrice = cartPOM.getProductPrice();
		cartPOM.placeOrder();
		cartPOM.purchase();
		cartPOM.getPurchaseDetails();
		assertEquals(cartPOM.getPurchaseAmount(), productPrice);
	}

	@AfterTest
	public void afterTest() {
		driver.close();
	}
}
