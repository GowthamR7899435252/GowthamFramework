package com.sgtesting.actitime.stepdefinitions;

import cucumber.api.java.zh_cn.假如;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class POMpages {
	
	public POMpages(WebDriver oBrowser)
	{
		PageFactory.initElements(oBrowser, this);
	}

	@FindBy(xpath = "//input[@id='email']")
	private WebElement username;
	public WebElement getUserName()
	{
		return username;
	}


	@FindBy(xpath = "//input[@id='password']")
	private WebElement pwd;
	public WebElement getPassword()

	{
		return pwd;
	}
	
	@FindBy(xpath="//button[normalize-space()='Log In']")
	private WebElement oLogin;
	public WebElement getLoginBtn()
	{
		return oLogin;
	}

	@FindBy(xpath = "//button[normalize-space()='Ok']")
	private WebElement logoutokbutton;
	public WebElement getlogoutokbutton()
	{
		return logoutokbutton;
	}
	@FindBy(xpath="//span[normalize-space()='Log Out']")
	private WebElement oLogout;
	public WebElement getLogoutLink()
	{
		return oLogout;
	}

}
