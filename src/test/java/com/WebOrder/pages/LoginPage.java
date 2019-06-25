package com.WebOrder.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.WebOrder.utils.BaseClass;
import com.WebOrder.utils.CommonMethods;
import com.WebOrder.utils.ConfigsReader;

public class LoginPage extends BaseClass{
	
@FindBy(xpath="//input[contains(@id,'username')]")
public WebElement username;

@FindBy(css="input[id$='password']")
public WebElement password;

@FindBy(css="input[id$='login_button']")
public WebElement loginbtn;

public LoginPage() {
	PageFactory.initElements(driver,this);
}

public void loginmethod(String uname,String pass) {
	CommonMethods.sendText(username,uname);
	CommonMethods.sendText(password,pass);
	CommonMethods.click(loginbtn);
}
	
}
