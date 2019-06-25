package com.WebOrder.pages;

import java.util.Properties;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.WebOrder.utils.BaseClass;

public class HomePage extends BaseClass {
@FindBy(css="div.login_info")
public WebElement login_info;


public HomePage() {
	PageFactory.initElements(driver, this);
}
}
