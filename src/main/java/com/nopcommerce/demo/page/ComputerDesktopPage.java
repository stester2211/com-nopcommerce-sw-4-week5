package com.nopcommerce.demo.page;

import com.nopcommerce.demo.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ComputerDesktopPage extends Utility
{
    @CacheLookup
    @FindBy(xpath="//select[@id='products-orderby']")
    WebElement position;
    @CacheLookup
    @FindBy(xpath="//select[@id='products-orderby']")
    WebElement filterName;
    @CacheLookup
    @FindBy(xpath="//h2[@class='product-title']")
    List<WebElement> verifyProductInOrder;
    @CacheLookup
    @FindBy(xpath="//div[@class='buttons']//button[text()='Add to cart']")
    WebElement clickOnAddCart;

    public void productByPosition(String positionName)
    {
        //1.3 Select Sort By position "Name: Z to A"
        selectByVisibleTextFromDropDown(position, positionName);
    }
    public void productInDecending()
    {
        //1.4 Verify the Product will arrange in Descending order.
        listOfElementVerifyInReverse(verifyProductInOrder, filterName,"Name: Z to A",verifyProductInOrder,"Product is not in descending order");
    }
    public void productByPositionAtoZ()
    {
        // 2.3 Select Sort By position "Name: A to Z"
        selectByVisibleTextFromDropDown(position,"Name: A to Z");
    }
    public void clickOnAddToCart()
    {
        //2.4 Click on "Add To Cart"
        clickOnElement(clickOnAddCart);
    }
}
