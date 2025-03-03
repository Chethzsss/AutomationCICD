package Chethan.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Chethan.AbstractComponents.AbstractComponent;

public class CartPage extends AbstractComponent {
	
	WebDriver driver;
	
	public CartPage(WebDriver driver) {
		
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(css =".cartSection h3")
	List<WebElement> cartItems;
	
	@FindBy(css =".totalRow button")
	WebElement checkoutButton;
	
//	List<WebElement> cartItems = driver.findElements(By.cssSelector(".cartSection h3"));
//	Boolean match = cartItems.stream().anyMatch(cart -> cart.getText().equals(productName));
//	
	
	public Boolean getAllCartProducts(String productName) {
		
		Boolean match = cartItems.stream().anyMatch(cart -> cart.getText().equals(productName));
		return match;
		
	}
	
	public Checkout goToCheckOut() {
		
		checkoutButton.click();
		return new Checkout(driver);
		
	}
	
}
