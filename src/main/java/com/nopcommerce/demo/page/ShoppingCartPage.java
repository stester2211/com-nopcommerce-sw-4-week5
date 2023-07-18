package com.nopcommerce.demo.page;

import com.nopcommerce.demo.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends Utility
{
    @CacheLookup
    @FindBy(xpath="//h1[contains(text(),'Shopping cart')]")
    WebElement actualShoppingText;
    @CacheLookup
    @FindBy(xpath="//input[contains(@class, 'qty-input')]")
    WebElement changeQty;
    @CacheLookup
    @FindBy(xpath="//button[@id='updatecart']")
    WebElement updatedPrice;
    @CacheLookup
    @FindBy(xpath="//span[@class='product-subtotal']")
    WebElement actualTotalText;
    @CacheLookup
    @FindBy(xpath="//input[@id='termsofservice']")
    WebElement clickAgreeCheckBox;
    @CacheLookup
    @FindBy(xpath="//button[@id='checkout']")
    WebElement clickOnCheckOut;
    @CacheLookup
    @FindBy(xpath="//input[@id='itemquantity11229']")
    WebElement actualquantityTextTwo;
    @CacheLookup
    @FindBy(xpath="//span[@class='product-subtotal']")
    WebElement actualTotalTextOfCellPhone;

    public String verifyMessageShoppingCart()
    {
        //2.15 Verify the message "Shopping cart" ----------- Computer Desktop
        //2.12 Verify the message "Shopping cart"------------ Electronic
        //2.24 Verify the text “Shopping card” --------------- Electronic after Registration
        return getTextFromElement(actualShoppingText);
    }
    public void changeQtyClickOnUpdateCart(String changeQuantity)
    {
        //2.16 Change the Qty to "2" and Click on "Update shopping cart"
        changeQty.clear();
        sendTextToElement(changeQty,changeQuantity);
        clickOnElement(updatedPrice);
    }
    public String verifyTotalText()
    {
        //2.17 Verify the Total"$2,950.00"
        return getTextFromElement(actualTotalText);
    }
    public void clickOnCheckBox()
    {
        //2.18 click on checkbox “I agree with the terms of service”---------computer
        //2.15 click on checkbox “I agree with the terms of service”---------Electronic cell phone
        clickOnElement(clickAgreeCheckBox);
    }
    public void clickOnCheckOutButton()
    {
        //2.19 Click on “CHECKOUT”----------Computer DeskTop
        //2.16 Click on “CHECKOUT”---------Electronic cellphone
        clickOnElement(clickOnCheckOut);
    }
   public String verifyQtyText()
   {
       //2.13 Verify the quantity is 2
       return getTextFromElement(actualquantityTextTwo);
   }
   public String verifyTotalCellPhoneText()
   {
       //2.14 Verify the Total $698.00
       return getTextFromElement(actualquantityTextTwo);
   }
}
