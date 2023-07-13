package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.utilities;

public class ProductCategoryPage {
	
	public WebDriver driver;
	utilities util;
	
	public ProductCategoryPage(WebDriver idriver)
	{
		driver=idriver;
		PageFactory.initElements(idriver, this);
	}
	
	@FindBy(xpath = "//div[@class='contentpanel']//a[contains(text(),'Shoes')]")
	private WebElement shoes;
	
	@FindBy(xpath = "//a[contains(text(),'Fiorella Purple Peep Toes')]//ancestor::div[@class='fixed_wrapper']//following-sibling::div//div[@class='pricetag jumbotron']//a")
	private WebElement Fiorella_Purple_Peep_Toes_add_cart;
	
	//add item to the cart
		public void add_item_to_cart()
		{	
			shoes.click();
			Fiorella_Purple_Peep_Toes_add_cart.click();
		}

}
