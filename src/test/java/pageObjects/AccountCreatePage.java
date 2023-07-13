package pageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.utilities;

public class AccountCreatePage {
	
	public WebDriver driver;
	utilities util;
	
	public AccountCreatePage(WebDriver idriver)
	{
		driver=idriver;
		PageFactory.initElements(idriver, this);
		util = new utilities();
	}
	
	@FindBy(id="AccountFrm_firstname")
	private WebElement first_name;
	
	@FindBy(id="AccountFrm_lastname")
	private WebElement last_name;
	
	@FindBy(id="AccountFrm_email")
	private WebElement email;
	
	@FindBy(id="AccountFrm_address_1")
	private WebElement address1;
	
	@FindBy(id="AccountFrm_city")
	private WebElement city;
	
	@FindBy(xpath="//select[@name='zone_id']")
	private WebElement state_dropdown;
	
	@FindBy(id="AccountFrm_postcode")
	private WebElement zipcode;
	
	@FindBy(xpath="//select[@name='country_id']")
	private WebElement country_dropdown;
	
	@FindBy(id="AccountFrm_loginname")
	private WebElement login_name;
	
	@FindBy(id="AccountFrm_password")
	private WebElement password;
	
	@FindBy(id="AccountFrm_confirm")
	private WebElement password_confirm;
	
	@FindBy(xpath = "//input[@type='checkbox']")
	private WebElement privacy_policy_checkbox;
	
	@FindBy(xpath = "//button[@title='Continue']")
	private WebElement continue_button;
	
		//Enter personal details
		public void enter_personal_details(String FirstName, String LastName, String Email)
		{
			first_name.sendKeys(FirstName);
			last_name.sendKeys(LastName);
			email.sendKeys(Email);
		}
		
		//Enter address details
		public void enter_address_details(String Address1, String Country, String State, String City, String Zipcode)
		{
			address1.sendKeys(Address1);
			city.sendKeys(City);
			zipcode.sendKeys(Zipcode);
			util.select_visibletext(country_dropdown, Country);
			util.select_visibletext(state_dropdown, State);	
		}
		
		//Login using Username and password
		public void enter_Login_details(String LoginName, String Password, String Confirm_password)
		{
			login_name.sendKeys(LoginName);
			password.sendKeys(Password);
			password_confirm.sendKeys(Confirm_password);
		}
		
		//click on privacy policy checkbox
		public void click_privacy_policy_checkbox()
		{
			privacy_policy_checkbox.click();
		}
		
		//click on continue button
		public void click_continue()
		{
			continue_button.click();
		}
		
		


}
