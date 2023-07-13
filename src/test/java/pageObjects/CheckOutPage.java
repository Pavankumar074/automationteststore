package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.utilities;

public class CheckOutPage {

	public WebDriver driver;
	utilities util;
	
	public CheckOutPage(WebDriver idriver)
	{
		driver=idriver;
		PageFactory.initElements(idriver, this);
	}
	
	@FindBy(xpath="//table[@class='table table-striped table-bordered']//a[contains(text(),'Fiorella Purple Peep Toes')]")
	private WebElement added_item_in_cart;
	
	//validate added item in the cart
	public boolean validate_added_item_reflecting_in_cart()
	{
		boolean flag=added_item_in_cart.isDisplayed();
		return flag;
	}
}
