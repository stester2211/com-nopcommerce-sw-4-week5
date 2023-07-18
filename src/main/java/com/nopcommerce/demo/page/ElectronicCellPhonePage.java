package com.nopcommerce.demo.page;

import com.nopcommerce.demo.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class ElectronicCellPhonePage extends Utility
{
    @CacheLookup
    @FindBy(xpath="//h1[contains(text(),'Cell phones')]")
    WebElement actualTextCellPhone;
    @CacheLookup
    @FindBy(xpath="//a[contains(text(),'List')]")
    WebElement listView;
    @CacheLookup
    @FindBy(xpath="//a[contains(text(),'Nokia Lumia 1020')]")
    WebElement clickProduct;
    @CacheLookup
    @FindBy(xpath="//h1[contains(text(),'Nokia Lumia 1020')]")
    WebElement actualTextNokia;
    @CacheLookup
    @FindBy(xpath="//span[@id='price-value-20']")
    WebElement actualPrice;
    @CacheLookup
    @FindBy(xpath="//input[@id='product_enteredQuantity_20']")
    WebElement changeQty;
    @CacheLookup
    @FindBy(xpath="//button[@id='add-to-cart-button-20']")
    WebElement clickAddToCart;
    @CacheLookup
    @FindBy(xpath="//p[@class='content']")
    WebElement actualTextProductAdded;
    @CacheLookup
    @FindBy(xpath="//span[@title='Close']")
    WebElement clickCloseButton;
    @CacheLookup
    @FindBy(xpath="//span[contains(text(),'Shopping cart')]")
    WebElement mouseHoverShoppingCart;
    @CacheLookup
    @FindBy(xpath="//button[contains(text(),'Go to cart')]")
    WebElement clickOnGoToCart;

    public String verifyTextCellPhone()
    {
        // 1.3 Verify the text “Cell phones”
        return getTextFromElement(actualTextCellPhone);
    }

    public void clickOnlistviewTab()
    {
        //2.4 Click on List View Tab
        clickOnElement(listView);
    }
    public void clickOnNokiaProduct()
    {
        //2.5 Click on product name “Nokia Lumia 1020” link
        clickOnElement(clickProduct);
    }
    public void verifyTextNokia()
    {
        //2.6 Verify the text “Nokia Lumia 1020”
        clickOnElement(actualTextNokia);
    }
    public void verifyTextPrice()
    {
        //2.7 Verify the price “$349.00”
        clickOnElement(actualPrice);
    }
    public void changeQTYToTwo(String changeQuantity)
    {
        //2.8 Change quantity to 2
        changeQty.clear();
        sendTextToElement(changeQty,changeQuantity);
    }
    public void clickAddToShoppingCart()
    {
        //2.9 Click on “ADD TO CART” tab
        clickOnElement(clickAddToCart);
    }
    public String verifyTextProductAdded()
    {
        //2.10 Verify the Message "The product has been added to your shopping cart" on Top green Bar After that close the bar clicking on the cross button.
        return getTextFromElement(actualTextProductAdded);
    }
    public void clickOnCloseButton()
    {
        clickOnElement(clickCloseButton);
    }
    public void mouseHoverToCartAndClick()
    {
        //2.11 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
         mouseHoverAction(mouseHoverShoppingCart,clickOnGoToCart);
    }

}
