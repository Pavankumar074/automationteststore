package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.utilities;

public class ProductPage {
	
	public WebDriver driver;
	utilities util;
	
	public ProductPage(WebDriver idriver)
	{
		driver=idriver;
		PageFactory.initElements(idriver, this);
	}
	
	@FindBy(xpath = "//a[@class='cart']")
	private WebElement add_to_cart;
	
	//click on add to cart button
	public void click_on_add_to_cart_button()
	{
		add_to_cart.click();
	}
	
	

}
