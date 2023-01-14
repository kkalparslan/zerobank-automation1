package com.zerobank.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    @FindBy(xpath = "//button[@id='signin_button']")
    public WebElement signinButton_loc;

    @FindBy(xpath = "//input[@id='user_login']")
    public WebElement username_loc;

    @FindBy(xpath = "//input[@id='user_password']")
    public WebElement password_loc;

    @FindBy(xpath = "//input[@class='btn btn-primary']")
    public WebElement loginButton_loc;

    @FindBy(xpath = "//div[@class='alert alert-error']")
    public WebElement errorMsj_loc;




}
