package pageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.utilities;

public class RegisterPage {
	
	public WebDriver driver;
	utilities util;
	
	public RegisterPage(WebDriver idriver)
	{
		driver=idriver;
		PageFactory.initElements(idriver, this);
	}

	@FindBy(xpath = "//a[contains(text(),'Login or register')]")
	private WebElement register;
	
	@FindBy(xpath = "//input[@type='radio']")
	private WebElement register_account_radio_button;
	
	@FindBy(xpath = "//button[@title='Continue']")
	private WebElement continue_button;
	
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
	
	@FindBy(xpath ="//p[contains(text(),'Congratulations! Your new account has been successfully created!')]")
	private WebElement succesfully_account_created_msg;
	
	@FindBy(xpath = "//a[@title='Continue']")
	private WebElement continue_button_after_creating_new_account;
	
	@FindBy(xpath = "//div[contains(text(),'Welcome back')]")
	private WebElement loggedin_user_name;
	
	@FindBy(id = "loginFrm_loginname" )
	private WebElement existing_login_username;
	
	@FindBy(id="loginFrm_password")
	private WebElement existing_user_password;
	
	@FindBy(xpath = "//button[@title='Login']")
	private WebElement Login_button;
	
	@FindBy(xpath = "//ul[@class='nav-pills categorymenu']//a[contains(text(),'Apparel & accessories')]")
	private WebElement apparel_and_accessories;
	
	@FindBy(xpath = "//div[@class='contentpanel']//a[contains(text(),'Shoes')]")
	private WebElement shoes;
	
	@FindBy(xpath = "//a[contains(text(),'Fiorella Purple Peep Toes')]//ancestor::div[@class='fixed_wrapper']//following-sibling::div//div[@class='pricetag jumbotron']//a")
	private WebElement Fiorella_Purple_Peep_Toes_add_cart;
	
	@FindBy(xpath = "//a[@class='cart']")
	private WebElement add_to_cart;
	
	@FindBy(xpath="//table[@class='table table-striped table-bordered']//a[contains(text(),'Fiorella Purple Peep Toes')]")
	private WebElement added_item_in_cart;
	
	
	//click on register or Login button
	public void click_on_login_or_register()
	{
		register.click();
	}
	
	//Enter personal details
	public void enter_personal_details(String FirstName, String LastName, String Email)
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
		//state_dropdown.click();
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
	
	//click on continue button after new account created
	public void continue_after_new_account_created()
	{
		continue_button_after_creating_new_account.click();
	}
	
	//get successfully created account message
	public String new_accout_created_successful_message()
	{
		String succesful_msg=succesfully_account_created_msg.getText();
		return succesful_msg;
	}
	
	//Validate login username
	public boolean Welcome_logged_user_displayed()
	{
		boolean flag=loggedin_user_name.isDisplayed();
		return flag;
	}
	
	//login with valid credentials
	public void login(String loginName, String Password)
	{
		existing_login_username.sendKeys(loginName);
		existing_user_password.sendKeys(Password);
		Login_button.click();
	}
	
	//add item to the cart
	public void add_item_to_cart()
	{	
		apparel_and_accessories.click();
		shoes.click();
		Fiorella_Purple_Peep_Toes_add_cart.click();
		add_to_cart.click();
	}
	
	//validate added item in the cart
	public boolean validate_added_item_reflecting_in_cart()
	{
		boolean flag=added_item_in_cart.isDisplayed();
		return flag;
	}

	
}
