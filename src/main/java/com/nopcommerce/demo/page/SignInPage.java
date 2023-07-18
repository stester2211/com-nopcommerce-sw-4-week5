package com.nopcommerce.demo.page;

import com.nopcommerce.demo.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends Utility
{
    @CacheLookup
    @FindBy(xpath="//h1[contains(text(),'Welcome, Please Sign In!')]")
    WebElement actualSignInMessage;
    @CacheLookup
    @FindBy(xpath="//button[contains(text(),'Checkout as Guest')]")
    WebElement clickOnCheckout;
    @CacheLookup
    @FindBy(xpath="//button[contains(text(),'Register')]")
    WebElement clickOnRegister;

    public String verifyMessageSignIn()
    {
        //2.20 Verify the Text “Welcome, Please Sign In!”
        return getTextFromElement(actualSignInMessage);
    }
    public void clickOnCheckOutAsGuestButton()
    {
        //2.21Click on “CHECKOUT AS GUEST” Tab
        clickOnElement(clickOnCheckout);
    }
    public void clickOnRegister()
    {
        //2.18 Click on “REGISTER” tab
        clickOnElement(clickOnRegister);
    }
}
