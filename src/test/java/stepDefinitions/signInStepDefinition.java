package stepDefinitions;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.RegisterPage;

public class signInStepDefinition {
	
	public WebDriver driver;
	public RegisterPage rp;
	
	
	//Method to launch browser
	@Given("User launches Chrome browser")
	public void user_launches_chrome_browser() {
	    System.setProperty("wedriver.chrome.driver",System.getProperty("use")+"//Drivers/chromedriver.exe" );
	    driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    rp= new RegisterPage(driver);
	    
	}
	
	//Method to launch url
	@When("User opens url {string}")
	public void user_opens_url(String url) {
	    driver.get(url);
	}
	
	//Method to click on signIn
	@When("clicks on signIn")
	public void clicks_on_sign_in() {
	    rp.click_on_login_or_register();
	}
	
	//Method to enter personal details
	@When("User registers as new customer by entering personal details {string} {string} {string}")
	public void user_registers_as_new_customer_by_entering_personal_details(String firstName, String lastName, String email) {
	    rp.enter_personal_details(firstName, lastName, email);
	}
	
	//Method to enter address details
	@When("enters address details {string} {string} {string} {string} {string}")
	public void enters_address_details(String address1, String country, String state, String city, String zipcode) {
	    rp.enter_address_details(address1, country, state, city, zipcode);
	}
	
	//Method to enter login details
	@When("enters Login detais {string} {string} {string}")
	public void enters_login_detais(String LoginName, String password, String confirm_password) {
	  rp.enter_Login_details(LoginName, password, confirm_password);
	}
	
	//Method to click on accept privacy policy
	@When("accepts the privacy policy")
	public void accepts_the_privacy_policy() {
	    rp.click_privacy_policy_checkbox();
	}
	
	//Method to click on continue button
	@When("Clicks on continue")
	public void clicks_on_continue() {
	    rp.click_continue();
	}
	
	//Method to Validate account created successfully message
	@Then("User Would see Account created successfully message")
	public void user_would_see_account_created_successfully_message() {
	    String expected_succesful_msg=rp.new_accout_created_successful_message();
	    String actual_succesful_message="Congratulations! Your new account has been successfully created!";
	    Assert.assertEquals(actual_succesful_message, expected_succesful_msg);
	    boolean user_displayed=rp.Welcome_logged_user_displayed();
	    Assert.assertTrue(user_displayed);
	    
	}
	
	//Method to login as registered user
	@When("User logs in as returned customer by entering username {string} and password {string}")
	public void user_logs_in_as_returned_customer_by_entering_username_and_password(String loginName, String password) {
	    rp.click_on_login_or_register();
	    rp.login(loginName, password);
	}
	
	//Method to add item in the cart
	@When("adds item to the cart")
	public void adds_item_to_the_cart() {
	   rp.add_item_to_cart();
	}
	
	//Method to validate added item is reflecting in the cart
	@Then("Added item should reflect in the cart")
	public void added_item_should_reflect_in_the_cart() {
	    boolean added_item_reflecting_in_cart=rp.validate_added_item_reflecting_in_cart();
	    Assert.assertTrue(added_item_reflecting_in_cart);
	}
	
	
	//Method will execute after each scenario
	@After
	public void tear_down()
	{
		driver.quit();
	}
	
	@AfterStep
	public void addScreenshot(Scenario scenario)
	{
		if(scenario.isFailed())
		{
			final byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", scenario.getName());
			
		}
	}

}
