package com.nopcommerce.demo.page;

import com.nopcommerce.demo.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends Utility
{
    @CacheLookup
    @FindBy(xpath="//h1[contains(text(),'Register')]")
    WebElement actualRegisterText;
    @CacheLookup
    @FindBy(xpath="//input[@id='FirstName']")
    WebElement firstName;
    @CacheLookup
    @FindBy(xpath="//input[@id='LastName']")
    WebElement lastName;
    @CacheLookup
    @FindBy(xpath="//input[@id='Email']")
    WebElement email;
    @CacheLookup
    @FindBy(xpath="//input[@id='Password']")
    WebElement password;
    @CacheLookup
    @FindBy(xpath="//input[@id='ConfirmPassword']")
    WebElement confirmPassword;
    @CacheLookup
    @FindBy(xpath="//button[@id='register-button']")
    WebElement clickRegisterButton;
    @CacheLookup
    @FindBy(xpath="//div[contains(text(),'Your registration completed')]")
    WebElement actualRegisterCompleteMessage;
    @CacheLookup
    @FindBy(xpath="//a[contains(text(),'Continue')]")
    WebElement continueButton;
    public String verifyRegisterText()
    {
        //2.19 Verify the text “Register”
        return getTextFromElement(actualRegisterText);
    }
    public void fillAllRegisterField(String fName, String lName, String enterEmail, String enterPassword, String enterConfirmPassword)
    {
        //2.20 Fill the mandatory fields
        sendTextToElement(firstName,fName);

        sendTextToElement(lastName,lName);

        sendTextToElement(email,enterEmail);

        sendTextToElement(password,enterPassword);

        sendTextToElement(confirmPassword,enterConfirmPassword);
    }
    public void clickRegisterButton()
    {
        //2.21 Click on “REGISTER” Button
        clickOnElement(clickRegisterButton);
    }
    public String verifyRegistrationCompleted()
    {
        //2.22 Verify the message “Your registration completed”
        return getTextFromElement(actualRegisterCompleteMessage);
    }
    public void clickContinue()
    {
        //2.23 Click on “CONTINUE” tab
        clickOnElement(continueButton);
    }
}
