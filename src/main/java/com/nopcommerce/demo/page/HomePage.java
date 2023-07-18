package com.nopcommerce.demo.page;

import com.nopcommerce.demo.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends Utility
{
    @CacheLookup
    @FindBy(xpath="//div[@class='header-menu']")
    List<WebElement> allTopListMenu;
    @CacheLookup
    @FindBy(xpath="//ul[@class='top-menu notmobile']//a[normalize-space()='Computers']")
    WebElement computerMenu;
    @CacheLookup
    @FindBy(xpath="//ul[@class='top-menu notmobile']//a[normalize-space()='Desktops']")
    WebElement desktopTab;
    @CacheLookup
    @FindBy(xpath="//h2[contains(text(),'Welcome to our store')]")
    WebElement actualWelcomeStoretext;
    @CacheLookup
    @FindBy(xpath="//ul[@class='top-menu notmobile']//a[normalize-space()='Electronics']")
    WebElement electronicMouseHover;
    @CacheLookup
    @FindBy(xpath="//ul[@class='top-menu notmobile']//a[normalize-space()='Cell phones']")
    WebElement cellPhoneMouseHover;

    // 1.1 create method with name "selectMenu" it has one parameter name "menu" of type string
    public void selectMenu(String menu)
    {
        //1.2 This method should click on the menu whatever name is passed as parameter.
        List<WebElement> topMenuList = getListOfElements(allTopListMenu);
        try {
            for (WebElement element : topMenuList) {
                if (element.getText().equalsIgnoreCase(menu)) {
                    element.click();
                }
            }
        } catch (StaleElementReferenceException e) {
            topMenuList = getListOfElements(allTopListMenu);
        }
        clickOnElement(By.linkText(menu));
    }

    public void clickOnDesktop()
    {
        mouseHoverAction(computerMenu,desktopTab);
    }
    public String verifyWelcomeText()
    {
        //2.37 Verify the text “Welcome to our store”
        return getTextFromElement(actualWelcomeStoretext);
    }
    public void clickOnElectronics()
    {
        mouseHoverAction(electronicMouseHover,cellPhoneMouseHover);
    }
}
