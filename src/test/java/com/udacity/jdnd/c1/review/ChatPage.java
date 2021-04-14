package com.udacity.jdnd.c1.review;

import com.udacity.jdnd.c1.review.model.ChatMessage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChatPage {

    @FindBy(id="messageText")
    private WebElement msgTextBox;

    @FindBy(xpath="//input[@type='submit']")
    private WebElement submitBtn;

    @FindBy(xpath="//div/span[1]")
    private WebElement getUsername;

    @FindBy(xpath="//div/span[2]")
    private WebElement getUserMessage;

    public ChatPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void enterMessage(String message){
        msgTextBox.sendKeys(message);
        submitBtn.click();
    }

    public ChatMessage getFirstMessage() {
        ChatMessage result = new ChatMessage();
        result.setMessage(getUserMessage.getText());
        result.setUsername(getUsername.getText());
        return result;
    }
}
