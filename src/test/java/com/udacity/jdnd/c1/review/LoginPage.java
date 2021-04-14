package com.udacity.jdnd.c1.review;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    @FindBy(id="inputUsername")
    private WebElement username;

    @FindBy(id="inputPassword")
    private WebElement password;

    @FindBy(id="submit-button")
    private WebElement loginBtn;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void login(String userName, String pwd){
        username.sendKeys(userName);
        password.sendKeys(pwd);
        loginBtn.click();
    }

}
