package Chethan.tests;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import Chethan.TestComponents.BaseTest;
import Chethan.TestComponents.Retry;
import Chethan.pageobjects.CartPage;
import Chethan.pageobjects.ProductCatalog;

public class ErrorValidationsTest extends BaseTest{

	@Test(groups= {"ErrorHandling"}, retryAnalyzer = Retry.class)
	public void loginErrorValidation() throws IOException {

		loginPage.loginApplication("pavan@gmail.com", "Password");
		Assert.assertEquals("Incorrect email or password.", loginPage.getErrorMessage());

	}
	
	@Test
	public void productErrorValidation() throws IOException {
		
	String productName = "ZARA COAT 3";

	ProductCatalog productCatalog = loginPage.loginApplication("pavanpractise@gmail.com", "Password@1");

	List<WebElement> products = productCatalog.getProductList();
	productCatalog.addProductToCart(productName);
	CartPage cartPage = productCatalog.goToCart();

	Boolean match = cartPage.getAllCartProducts("ZARA COAT 33");
	Assert.assertFalse(match);
	
	}

}
