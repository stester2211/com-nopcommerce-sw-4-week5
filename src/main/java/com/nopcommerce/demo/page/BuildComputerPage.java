package com.nopcommerce.demo.page;

import com.nopcommerce.demo.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class BuildComputerPage extends Utility
{
    @CacheLookup
    @FindBy(xpath="//h1[contains(text(),'Build your own computer')]")
    WebElement actualTextBuild;
    @CacheLookup
    @FindBy(xpath="//select[@id='product_attribute_1']")
    WebElement selectCore;
    @CacheLookup
    @FindBy(xpath="//select[@id='product_attribute_2']")
    WebElement selectRam;
    @CacheLookup
    @FindBy(xpath="//input[@id='product_attribute_3_7']")
    WebElement selectHdd;
    @CacheLookup
    @FindBy(xpath="//input[@id='product_attribute_4_9']")
    WebElement selectOs;
    @CacheLookup
    @FindBy(id="product_attribute_5_12")
    WebElement checkBox;
    @CacheLookup
    @FindBy(xpath="//span[@id='price-value-1']")
    WebElement actualLastPrice;
    @CacheLookup
    @FindBy(xpath="//button[@id='add-to-cart-button-1']")
    WebElement clickOnAddToCart;
    @CacheLookup
    @FindBy(xpath="//p[@class='content']")
    WebElement actualProductAddedMessage;
    @CacheLookup
    @FindBy(xpath="//span[@class='close']")
    WebElement clickOnCloseButton;
    @CacheLookup
    @FindBy(xpath="//span[contains(text(),'Shopping cart')]")
    WebElement hoverMouseOnShoppingCart;
    @CacheLookup
    @FindBy(xpath="//button[contains(text(),'Go to cart')]")
    WebElement clickOnShoppingCartButton;
    public String verifyTextBuild()
    {
        //2.5 Verify the Text "Build your own computer"
        return getTextFromElement(actualTextBuild);
    }
    public void selectCoreDropdown()
    {
        //2.6 Select "2.2 GHz Intel Pentium Dual-Core E2200" using Select class
        selectByValueFromDropDown(selectCore,"1");
    }
    public void selectRamDropdown()
    {
        //2.7.Select "8GB [+$60.00]" using Select class.
        selectByIndexFromDropDown(selectRam,3);
    }
    public void selectHddList()
    {
        //2.8 Select HDD radio "400 GB [+$100.00]"
        clickOnElement(selectHdd);
    }

    public void clickOs()
    {
        //2.9 Select OS radio "Vista Premium [+$60.00]"
        clickOnElement(selectOs);
    }
    public void clickCheckBox()
    {
        //2.10 Check Two Check boxes "Microsoft Office [+$50.00]" and "Total Commander [+$5.00]"
        clickOnElement(checkBox);
    }
    public String actualPrice()
    {
        //2.11 Verify the price "$1,475.00"
        return getTextFromElement(actualLastPrice);
    }
    public void clickOnAddToCart()
    {
        //2.12 Click on "ADD TO CARD" Button.
        clickOnElement(clickOnAddToCart);
    }
    public String actualProductAdded()
    {
        //2.13 Verify the Message "The product has been added to your shopping cart" on Top green Bar After that close the bar clicking on the cross button.
        //driver.findElement(By.xpath("//p[@class='content']")).getText().replace("x"," ");
        actualProductAddedMessage.getText().replace("x"," ");
        return getTextFromElement(actualProductAddedMessage);
    }
    public void clickOnCloseButton()
    {
        clickOnElement(clickOnCloseButton);
    }
    public void mouseHoverToCartAndClick()
    {
        //2.14 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        mouseHoverAction(hoverMouseOnShoppingCart, clickOnShoppingCartButton);
    }
}
