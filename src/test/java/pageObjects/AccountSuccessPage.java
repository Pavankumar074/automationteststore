package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.utilities;

public class AccountSuccessPage {
	
	public WebDriver driver;
	utilities util;
	
	public AccountSuccessPage(WebDriver idriver)
	{
		driver=idriver;
		PageFactory.initElements(idriver, this);
	}

	@FindBy(xpath ="//p[contains(text(),'Congratulations! Your new account has been successfully created!')]")
	private WebElement succesfully_account_created_msg;
	
	@FindBy(xpath = "//a[@title='Continue']")
	private WebElement continue_button_after_creating_new_account;
	
	//get successfully created account message
		public String new_accout_created_successful_message()
		{
			String succesful_msg=succesfully_account_created_msg.getText();
			return succesful_msg;
		}
		
	//click on continue button after new account created
		public void continue_after_new_account_created()
		{
			continue_button_after_creating_new_account.click();
		}	
}
