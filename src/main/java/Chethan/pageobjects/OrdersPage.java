package Chethan.pageobjects;

import java.util.Collection;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Chethan.AbstractComponents.AbstractComponent;

public class OrdersPage extends AbstractComponent {
	
	WebDriver driver;
	
	public OrdersPage(WebDriver driver) {
		
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(css =".cartSection h3")
	List<WebElement> cartItems;
	
	@FindBy(css =".totalRow button")
	WebElement checkoutButton;
	
	@FindBy(css = "tr td:nth-child(3)")
	private List<WebElement> productNames;
	
//	List<WebElement> cartItems = driver.findElements(By.cssSelector(".cartSection h3"));
//	Boolean match = cartItems.stream().anyMatch(cart -> cart.getText().equals(productName));
//	
	
	public Boolean verifyOrderDisplay(String productName) {
		
		Boolean match = productNames.stream().anyMatch(cart -> cart.getText().equals(productName));
		return match;
		
	}
	
}
