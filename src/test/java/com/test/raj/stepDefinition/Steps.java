package com.test.raj.stepDefinition;

import com.test.raj.pages.PersonalInformationPage;
import com.test.raj.pages.ProductPage_Tshirt;
import com.test.raj.utils.WebdriverManager;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Steps {	
    WebdriverManager driverManager;
    PersonalInformationPage personalInformationPage;
    ProductPage_Tshirt productPage_Tshirt;
    public String orderID;
    
    public Steps(WebdriverManager driverManager){
        this.driverManager = driverManager;
    }
	
	@Given("the user is on the home page")
	public void the_user_is_on_the_home_page() {
		driverManager.getDriver().get("http://automationpractice.com/");
        personalInformationPage = new PersonalInformationPage(driverManager);
        productPage_Tshirt = new ProductPage_Tshirt(driverManager);
	}

	@When("the user logs in with (.*) (.*)$")
	public void the_user_is_logs_in_with_and_(String userName, String password) {
		personalInformationPage.signInLink.click();
		personalInformationPage.userName.sendKeys(userName);
		personalInformationPage.password.sendKeys(password);
		personalInformationPage.signInButton.click();  
	}

	@When("the user orders a tshirt")
	public void the_user_orders_a_tshirt() {
		productPage_Tshirt.tShirtTab.click();
		productPage_Tshirt.moveToTshirtImage();
		productPage_Tshirt.addToCartButton.click();
		for(int i=0; i<3; i++) {
			productPage_Tshirt.proceedToCheckoutButton.click();
		}
		productPage_Tshirt.termsAndConditionCheckbox.click();
		productPage_Tshirt.proceedToCheckoutButton.click();
		productPage_Tshirt.paymentMethod_BankWireButton.click();
		productPage_Tshirt.confirmOrderButton.click();
		orderID = productPage_Tshirt.getOrderID();
		System.out.println("The Order ID is " + orderID);
		
	}

	@Then("the order should be available in the order history table.")
	public void the_order_should_be_available_in_the_order_history_table() {
		productPage_Tshirt.backToOrdersButton.click();
		System.out.println("The Order ID in Order history table is " + productPage_Tshirt.getLatestOrderID());
		Assert.assertTrue(productPage_Tshirt.getLatestOrderID().equalsIgnoreCase(orderID));
	}
	
	@When("the user updates the first name as (.*)$")
	public void the_user_updates_the_first_name_on_the_personal_information_page(String updatedFirstName) {
		personalInformationPage.personalInformationButton.click();
		personalInformationPage.firstName.clear();
		personalInformationPage.firstName.sendKeys(updatedFirstName);
		personalInformationPage.currentPassword.sendKeys("Test123");
		personalInformationPage.saveButton.click();
	}

	@Then("the information should be updated successfully.")
	public void the_information_should_be_updated_successfully() {
		personalInformationPage.successMessage.isDisplayed();
		Assert.assertTrue(personalInformationPage.successMessage.getText().contains("successfully updated"));
	}
	
    @After
    public void closeSession(){
        driverManager.getDriver().quit();
    }

}
