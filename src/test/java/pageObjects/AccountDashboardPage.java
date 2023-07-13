package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.utilities;

public class AccountDashboardPage {
	
	public WebDriver driver;
	utilities util;
	
	public AccountDashboardPage(WebDriver idriver)
	{
		driver=idriver;
		PageFactory.initElements(idriver, this);
	}
	
	
	@FindBy(xpath = "//a[contains(text(),'Login or register')]")
	private WebElement register;
	
	@FindBy(xpath = "//div[contains(text(),'Welcome back')]")
	private WebElement loggedin_user_name;
	
	@FindBy(xpath = "//ul[@class='nav-pills categorymenu']//a[contains(text(),'Apparel & accessories')]")
	private WebElement apparel_and_accessories;
	
	
	//click on register or Login button
	public void click_on_login_or_register()
	{
		register.click();
	}
	
	//Validate login username
	public boolean welcome_logged_user_displayed()
	{
		boolean flag=loggedin_user_name.isDisplayed();
		return flag;
	}
	
	//Click on apparel and accessories
	public void click_on_Appareal_and_accessories()
	{
		apparel_and_accessories.click();
	}
	
	


}
