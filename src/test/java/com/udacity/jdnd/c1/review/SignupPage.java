package com.udacity.jdnd.c1.review;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignupPage {

    @FindBy(id="inputFirstName")
    private WebElement firstName;

    @FindBy(id="inputLastName")
    private WebElement lastName;

    @FindBy(id="inputUsername")
    private WebElement username;

    @FindBy(id="inputPassword")
    private WebElement password;

    @FindBy(id="submit-button")
    private WebElement signupBtn;

    @FindBy(linkText="Back to Login")
    private WebElement loginBtn;

    public SignupPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void signUp(String fName, String lName, String userName, String pwd){
        firstName.sendKeys(fName);
        lastName.sendKeys(lName);
        username.sendKeys(userName);
        password.sendKeys(pwd);
        signupBtn.click();
        loginBtn.click();
    }


}
