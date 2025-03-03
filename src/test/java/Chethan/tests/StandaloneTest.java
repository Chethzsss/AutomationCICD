package Chethan.tests;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Chethan.TestComponents.BaseTest;
import Chethan.pageobjects.CartPage;
import Chethan.pageobjects.Checkout;
import Chethan.pageobjects.ConfirmationPage;
import Chethan.pageobjects.OrdersPage;
import Chethan.pageobjects.ProductCatalog;

public class StandaloneTest extends BaseTest {

	String productName = "ZARA COAT 3";

	@Test(dataProvider = "getData", groups = "Purchase")
	public void submitOrder(HashMap<String, String> input) throws IOException {

		ProductCatalog productCatalog = loginPage.loginApplication(input.get("email"), input.get("password"));

		List<WebElement> products = productCatalog.getProductList();
		productCatalog.addProductToCart(input.get("product"));
		CartPage cartPage = productCatalog.goToCart();

		Boolean match = cartPage.getAllCartProducts(input.get("product"));
		Assert.assertTrue(match);

		Checkout checkoutPage = cartPage.goToCheckOut();
		checkoutPage.selectCountry("india");
		ConfirmationPage confirmationPage = checkoutPage.submitOrder();

		String confirmationMessage = confirmationPage.getConfirmationMessage();
		AssertJUnit.assertTrue(confirmationMessage.equalsIgnoreCase("Thankyou for the order."));

	}

	@Test(dependsOnMethods = { "submitOrder" })
	public void orderHistoryTest() {

		ProductCatalog productCatalog = loginPage.loginApplication("pavanpractise@gmail.com", "Password@1");
		OrdersPage ordersPage = productCatalog.goToOrders();
		Assert.assertTrue(ordersPage.verifyOrderDisplay(productName));

	}

	// Extent Reports

	@DataProvider
	public Object[][] getData() throws IOException {

		List<HashMap<String, String>> data = getJsonDataToMap(
				System.getProperty("user.dir") + "//src//test//java//Chethan//Data//PurchaseOrder.json");
		return new Object[][] { { data.get(0) }, { data.get(1) } };

	}

}

//HashMap<String, String> hashMap = new HashMap<String, String>();
//hashMap.put("email", "pavanpractise@gmail.com");
//hashMap.put("password", "Password@1");
//hashMap.put("product", "ZARA COAT 3");
//
//HashMap<String, String> hashMap1 = new HashMap<String, String>();
//hashMap1.put("email", "pavanpractise@grr.la");
//hashMap1.put("password", "Password@1");
//hashMap1.put("product", "ADIDAS ORIGINAL");
