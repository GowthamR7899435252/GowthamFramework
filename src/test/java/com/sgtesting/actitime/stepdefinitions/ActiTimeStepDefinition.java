package com.sgtesting.actitime.stepdefinitions;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import com.sgtesting.actitime.utility.ApplicationDependent;
import com.sgtesting.actitime.utility.ApplicationIndependent;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ActiTimeStepDefinition {
	public static WebDriver oBrowser=null;
	public static POMpages actiTimePage=null;
	public static Logger log=LogManager.getLogger(ActiTimeStepDefinition.class);

	/**
	 * Author:
	 * Reviewed By:
	 * Parameters:
	 * Purpose:
	 * Description:
	 */
	@Given("^Launch the application$")
	public void Launch_the_application()
	{
		try
		{
			log.info("Launch the application");
			String path=System.getProperty("user.dir");
			System.setProperty("webdriver.chrome.driver", path+"\\Library\\drivers\\chromedriver.exe");
			oBrowser=new ChromeDriver();
			actiTimePage=new POMpages(oBrowser);
			oBrowser.manage().window().maximize();
			ApplicationIndependent.waitFor(2L);
			log.info("The Application has launched successfully");
		}catch(Exception e)
		{
			log.error("There is an error occurance during the execution of Launch Application "+e);
		}
	}

	/**
	 * Author:
	 * Reviewed By:
	 * Parameters:
	 * Purpose:
	 * Description:
	 */
	@And("^Navigate to the url of the application$")
	public void Navigate_to_the_url_of_the_application()
	{
		try
		{
			log.info("Navigate to the url of the application");
			oBrowser.get("https://facegenie-ams-school.web.app/");
			ApplicationIndependent.waitFor(3L);
			ApplicationDependent.getScreenshot(oBrowser, "C:\\Eclipse Workspace" +
					"\\Projects\\ActiTimeAutomation\\ScreenShots\\pics.jpg");
			log.info("Navigate to the url of the application has performed successfully");
		}catch(Exception e)
		{
			log.error("There is an error occurance during the execution of Navigate_to_the_url_of_the_application "+e);
		}
	}

	/**
	 * Author:
	 * Reviewed By:
	 * Parameters:
	 * Purpose:
	 * Description:
	 */
	@When("^Login using valid credentials$")
	public void Login_using_valid_credentials(DataTable credentials)
	{  
		try
		{
			log.info("Login using valid credentials");
			List<Map<String,String>> data=credentials.asMaps(String.class, String.class);
			for (int i=0;i<data.size();i++)
			{
				actiTimePage.getUserName().sendKeys(data.get(i).get("username"));
				actiTimePage.getPassword().sendKeys(data.get(i).get("password"));
				ApplicationIndependent.waitFor(2);
				ApplicationDependent.getScreenshot(oBrowser, "C:\\Eclipse Workspace" +
						"\\Projects\\ActiTimeAutomation\\ScreenShots\\usernameandpassword.jpg");
				actiTimePage.getLoginBtn().click();
				ApplicationIndependent.waitFor(12);
			}
			log.info("Login using valid credentials by providing valid credentails");
		}catch(Exception e)
		{
			log.error("There is an error occurance during the execution of Login_using_valid_credentials "+e);
		}
	}

	@Then("^i validated homepage$")
	public void the_Home_page_should_display()
	{
		try
		{
			log.info("the Home page should display");
			Assert.assertTrue(ApplicationDependent.isObjectPresent(oBrowser,By.xpath("//div" +
					"[@class='MuiToolbar-root MuiToolbar-gutters MuiToolbar-regular css-e7x0wp']//div//img")));
			ApplicationIndependent.waitFor(5);
			log.info("The Validation of Display of face giene has matched successfulyy");
		}catch(Exception e)
		{
			log.error("There is an error occurance during the execution of the_Home_page_should_display "+e);
		}
	}

	@And("^i clicked logout$")
	public void i_clicked_logout()
	{
		try
		{
			log.info("clicking logout button");
			actiTimePage.getLogoutLink().click();
			ApplicationIndependent.waitFor(3);
			log.info("clicked logout button successfully");
		}
		catch (Exception e)
		{
			e.printStackTrace();
			log.error("not logged from face giene");
		}
	}

	@When("^i clicked ok button$")
	public void When_i_clicked_ok_button()
	{
		try {
			log.info("clicking ok button ");
			ApplicationDependent.getScreenshot(oBrowser, "C:\\Eclipse Workspace" +
					"\\Projects\\ActiTimeAutomation\\ScreenShots\\clickingokbutton.jpg");
			actiTimePage.getlogoutokbutton().click();
			ApplicationIndependent.waitFor(10);
			log.info("clicked ok button successfully");
		}
		catch (Exception e)
		{
			e.printStackTrace();
			log.error("did not cliked ok button ");
		}
	}

	@Then("^i landed on login page and validated it$")
	public void i_validated_login_page()
	{
		try {
			log.info("logging out of application");
			Assert.assertTrue(ApplicationDependent.isObjectPresent(oBrowser,By.xpath("(//img" +
					"[@alt='Facegenie-logo'])[1]")));
			log.info("succesfully landed on login page");
			ApplicationDependent.getScreenshot(oBrowser, "C:\\Eclipse Workspace" +
					"\\Projects\\ActiTimeAutomation\\ScreenShots\\loginpage.jpg");
			ApplicationIndependent.waitFor(3);
			System.out.println("test");
		}
		catch (Exception e)
		{
			e.printStackTrace();
			log.error("did not logged out , logout test case failed");
		}
	}

	@And("^i closed the browser$")
	public void i_closed_the_browser()
	{
		try {
			log.info("closing application");
			oBrowser.close();
			log.info("closed browser successfully ");
		}
		catch (Exception e)
		{
			e.printStackTrace();
			log.error("did not closed browser");
		}
	}
}
