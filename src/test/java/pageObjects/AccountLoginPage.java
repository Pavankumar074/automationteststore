package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.utilities;

public class AccountLoginPage {
	
	public WebDriver driver;
	utilities util;
	
	public AccountLoginPage(WebDriver idriver)
	{
		driver=idriver;
		PageFactory.initElements(idriver, this);
	}

	@FindBy(xpath = "//input[@type='radio']")
	private WebElement register_account_radio_button;
	
	@FindBy(xpath = "//button[@title='Continue']")
	private WebElement continue_button;
	
	@FindBy(id = "loginFrm_loginname" )
	private WebElement existing_login_username;
	
	@FindBy(id="loginFrm_password")
	private WebElement existing_user_password;
	
	@FindBy(xpath = "//button[@title='Login']")
	private WebElement Login_button;
	
	//Method to click on continue if want to create a new customer
	public void click_on_continue_for_new_customer()
	{
		util= new utilities();
		if(register_account_radio_button.isSelected())
		{
			continue_button.click();
		}
		else
		{
			register_account_radio_button.click();
			continue_button.click();
		}
	}
	
	public void login(String loginName, String Password)
	{
		existing_login_username.sendKeys(loginName);
		existing_user_password.sendKeys(Password);
		Login_button.click();
	}
	
	
	
	
	
	
	
}
