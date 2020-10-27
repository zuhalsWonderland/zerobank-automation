package com.zerobank.pages;


import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(css = "button#signin_button")
    public WebElement signInButton;


    @FindBy(css = "input#user_login")
    public WebElement username;

    @FindBy(css = "input#user_password")
    public WebElement password;


    @FindBy(xpath = "//input[@type='submit']")
    public WebElement submit;

    @FindBy(xpath = "//div[@class='alert alert-error']")
    public WebElement errorAlert;

    public void login(String userNameStr, String passwordStr) {
        signInButton.click();
        username.sendKeys(userNameStr);
        password.sendKeys(passwordStr);
        submit.click();
        // verification that we logged
    }


}
