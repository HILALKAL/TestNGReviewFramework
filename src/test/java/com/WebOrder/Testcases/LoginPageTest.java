package com.WebOrder.Testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.WebOrder.pages.HomePage;
import com.WebOrder.pages.LoginPage;
import com.WebOrder.utils.BaseClass;
import com.WebOrder.utils.ConfigsReader;

public class LoginPageTest extends BaseClass {
	
	@Test
	public void testlogin() {
		LoginPage login=new LoginPage();
		login.loginmethod(ConfigsReader.getProperties("username"), ConfigsReader.getProperties("password"));                    
		
		HomePage home=new HomePage();
		Assert.assertTrue(home.login_info.isDisplayed());
		
	}

}
