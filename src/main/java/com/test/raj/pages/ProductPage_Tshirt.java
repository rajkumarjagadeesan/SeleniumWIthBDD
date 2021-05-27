package com.test.raj.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.test.raj.utils.WebdriverManager;

public class ProductPage_Tshirt extends BasePage{
	
	public ProductPage_Tshirt(WebdriverManager webDriverManager) {
        super(webDriverManager);
    }

	
	@FindBy(xpath = "(//a[@title='T-shirts'])[2]")
	public WebElement tShirtTab;
	
	@FindBy(xpath= "//img[@title='Faded Short Sleeve T-shirts']")
	public WebElement product;
	
	@FindBy(xpath = "//*[text()='Add to cart']")
	public WebElement addToCartButton;
	
	@FindBy(xpath = "(//*[contains(text(),'Proceed to checkout')])[last()]")
	public WebElement proceedToCheckoutButton;
	
	@FindBy(id = "cgv")
	public WebElement termsAndConditionCheckbox;
	
	@FindBy(xpath = "//a[@title='Pay by bank wire']")
	public WebElement paymentMethod_BankWireButton;
	
	@FindBy(xpath = "//*[text()='I confirm my order']")
	public WebElement confirmOrderButton;
	
	@FindBy(xpath = "//a[@title='Back to orders']")
	public WebElement backToOrdersButton;
	
	@FindBy(xpath = "//*[@id='center_column']/div")
	public WebElement orderSummary;
	
	@FindBy(xpath= "//*[@id='order-list']/tbody/tr[1]/td[1]")
	public WebElement orderHistoryTableLatestOrder;
	  
    public String getOrderID() {
    	String orderSummaryText = orderSummary.getText();
    	String orderID = orderSummaryText.substring(orderSummaryText.indexOf("order reference")+16, orderSummaryText.indexOf("order reference")+25);
    	return orderID;
    }
    
    
    public void moveToTshirtImage() {
    	moveToProductImage(product);
    }
    
    public String getLatestOrderID() {
    	return orderHistoryTableLatestOrder.getText();
    }
}
