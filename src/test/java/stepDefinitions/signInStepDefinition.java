package stepDefinitions;

import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import helper.LoggerHelper;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.AccountCreatePage;
import pageObjects.AccountDashboardPage;
import pageObjects.AccountLoginPage;
import pageObjects.AccountSuccessPage;
import pageObjects.CheckOutPage;
import pageObjects.ProductCategoryPage;
import pageObjects.ProductPage;


public class signInStepDefinition {
	
	public WebDriver driver;
	public AccountCreatePage acp;
	public AccountDashboardPage adp;
	public AccountLoginPage alp;
	public AccountSuccessPage asp;
	public CheckOutPage cop;
	public ProductCategoryPage pcp;
	public ProductPage pp;
	
	
	Logger log = LoggerHelper.getLogger(signInStepDefinition.class);
	

	//Method to launch browser
	@Given("User launches Chrome browser")
	public void user_launches_chrome_browser() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options= new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		
	    //System.setProperty("wedriver.chrome.driver",System.getProperty("use")+"//Drivers/chromedrive.exe" );
	    driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    acp=new AccountCreatePage(driver);
	    adp=new AccountDashboardPage(driver);
	    alp=new AccountLoginPage(driver);
	    asp=new AccountSuccessPage(driver);
	    cop=new CheckOutPage(driver);
	    pcp=new ProductCategoryPage(driver);
	    pp=new ProductPage(driver);
	    
	}
	
	//Method to launch url
	@When("User opens url {string}")
	public void user_opens_url(String url) {
	    driver.get(url);
	}
	
	//Method to click on signIn
	@When("clicks on signIn")
	public void clicks_on_sign_in() {
	    adp.click_on_login_or_register();
	    alp.click_on_continue_for_new_customer();
	}
	
	//Method to enter personal details
	@When("User registers as new customer by entering personal details {string} {string} {string}")
	public void user_registers_as_new_customer_by_entering_personal_details(String firstName, String lastName, String email) {
	    acp.enter_personal_details(firstName, lastName, email);
	}
	
	//Method to enter address details
	@When("enters address details {string} {string} {string} {string} {string}")
	public void enters_address_details(String address1, String country, String state, String city, String zipcode) {
	    acp.enter_address_details(address1, country, state, city, zipcode);
	}
	
	//Method to enter login details
	@When("enters Login detais {string} {string} {string}")
	public void enters_login_detais(String LoginName, String password, String confirm_password) {
	  acp.enter_Login_details(LoginName, password, confirm_password);
	}
	
	//Method to click on accept privacy policy
	@When("accepts the privacy policy")
	public void accepts_the_privacy_policy() {
	    acp.click_privacy_policy_checkbox();
	}
	
	//Method to click on continue button
	@When("Clicks on continue")
	public void clicks_on_continue() {
	    acp.click_continue();
	}
	
	//Method to Validate account created successfully message
	@Then("User Would see Account created successfully message")
	public void user_would_see_account_created_successfully_message() {
	    String expected_succesful_msg=asp.new_accout_created_successful_message();
	    String actual_succesful_message="Congratulations! Your new account has been successfully created!";
	    Assert.assertEquals(actual_succesful_message, expected_succesful_msg);
	    boolean user_displayed=adp.welcome_logged_user_displayed();
	    Assert.assertTrue(user_displayed);
	    
	}
	
	//Method to login as registered user
	@When("User logs in as returned customer by entering username {string} and password {string}")
	public void user_logs_in_as_returned_customer_by_entering_username_and_password(String loginName, String password) {
	    adp.click_on_login_or_register();
	    alp.login(loginName, password);
	}
	
	//Method to add item in the cart
	@When("adds item to the cart")
	public void adds_item_to_the_cart() {
		adp.click_on_Appareal_and_accessories();
		pcp.add_item_to_cart();
		pp.click_on_add_to_cart_button();
		
		
	}
	
	//Method to validate added item is reflecting in the cart
	@Then("Added item should reflect in the cart")
	public void added_item_should_reflect_in_the_cart() {
	    boolean added_item_reflecting_in_cart=cop.validate_added_item_reflecting_in_cart();
	    Assert.assertTrue(added_item_reflecting_in_cart);
	}
	
	
	@AfterStep
	public void endTest(Scenario scenario) {
		if (scenario.isFailed()) {

			try {
				log.info(scenario.getName() + " is Failed");
				final byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
				scenario.attach(screenshot, "image/png", scenario.getName());
			} catch (WebDriverException e) {
				e.printStackTrace();
			}

		} else {
			try {
				log.info(scenario.getName() + " is pass");
				final byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
				scenario.attach(screenshot, "image/png", scenario.getName());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		//driver.quit();
	}
	
	@After
	public void tear_down()
	{
		driver.quit();
	}

}
