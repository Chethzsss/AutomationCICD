package Chethan.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Chethan.pageobjects.CartPage;
import Chethan.pageobjects.OrdersPage;

public class AbstractComponent {
	
	WebDriver driver;
	
	public AbstractComponent(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(css = "[routerlink*='cart']")
	WebElement cartButton;
	
	@FindBy(css = "[routerlink*='myorders']")
	WebElement orderButton;

	public void waitForTheElementToAppear(By findBy) {
		
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	
	}
	
	public void waitForTheWebElementToAppear(WebElement findBy) {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(findBy));
		
		}
	
	public void waitForTheElementToDisappear(WebElement element) {
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	wait.until(ExpectedConditions.invisibilityOf(element));
	
	}
	
	public CartPage goToCart() {
		
		cartButton.click();
		CartPage cartPage = new CartPage(driver);
		return cartPage;
		
	}
	
	public OrdersPage goToOrders() {
		
		orderButton.click();
		OrdersPage ordersPage = new OrdersPage(driver);
		return ordersPage;
		
	}
	
}
