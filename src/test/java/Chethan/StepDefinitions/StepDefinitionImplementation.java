package Chethan.StepDefinitions;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.AssertJUnit;

import Chethan.TestComponents.BaseTest;
import Chethan.pageobjects.CartPage;
import Chethan.pageobjects.Checkout;
import Chethan.pageobjects.ConfirmationPage;
import Chethan.pageobjects.LoginPage;
import Chethan.pageobjects.ProductCatalog;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitionImplementation extends BaseTest {

	public LoginPage loginPage;
	public ProductCatalog productCatalog;
	public ConfirmationPage confirmationPage;
	
	@Given("User is in the Ecommerce login page")
	public void User_is_in_the_Ecommerce_login_page() throws IOException {
		loginPage = launchApplication();
	}
	
	@Given("^Login with username (.+) and password (.+)$")
	public void login_with_username_and_password(String username, String password) {
		
		productCatalog = loginPage.loginApplication(username, password);
		
	}
	
	 @When("^I add product (.+) to Cart$")
	 public void i_add_product_to_cart(String productName) {
		 
		 	List<WebElement> products = productCatalog.getProductList();
			productCatalog.addProductToCart(productName);
		 
	 }
	 
	 @When("^Checkout productname (.+) and submit the order$")
	 public void checkout_submit_order(String productName) {
		 
		 	CartPage cartPage = productCatalog.goToCart();
		 	Boolean match = cartPage.getAllCartProducts(productName);
			Assert.assertTrue(match);
			Checkout checkoutPage = cartPage.goToCheckOut();
			checkoutPage.selectCountry("india");
			confirmationPage = checkoutPage.submitOrder();
		 
	 }
	 
	 @Then("{string} message is displayed in Confirmation Page")
	 public void message_displayed_confirmation_page(String string) {
		 
		 	String confirmationMessage = confirmationPage.getConfirmationMessage();
		 	Assert.assertTrue(confirmationMessage.equalsIgnoreCase(string));
		 	driver.close();		 
	 }
	 
	 @Then("{string} message is displayed in login Page")
	 public void message_displayed_login_page(String string1) {
		 
			Assert.assertEquals(string1, loginPage.getErrorMessage());
		 	driver.close();		 
	 }
	 
	
}
