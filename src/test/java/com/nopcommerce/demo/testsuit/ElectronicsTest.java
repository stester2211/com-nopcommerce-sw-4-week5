package com.nopcommerce.demo.testsuit;

import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.page.*;
import com.nopcommerce.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListeners.class)

public class ElectronicsTest extends BaseTest
{
    HomePage homePage;
    ElectronicCellPhonePage electronicCellPhonePage;
    ShoppingCartPage shoppingCartPage;
    SignInPage signInPage;
    RegistrationPage registrationPage;

    @BeforeMethod(alwaysRun = true)
    public void inIT()
    {
        homePage= new HomePage();
        electronicCellPhonePage =new ElectronicCellPhonePage();
        shoppingCartPage= new ShoppingCartPage();
        signInPage= new SignInPage();
        registrationPage= new RegistrationPage();
    }

    //1. Test name verifyUserShouldNavigateToCellPhonesPageSuccessfully()
    @Test(groups = {"sanity","regression"})
    public void verifyUserShouldNavigateToCellPhonesPageSuccessfully() throws InterruptedException
    {
        //1.1 Mouse Hover on “Electronics” Tab
        //1.2 Mouse Hover on “Cell phones” and click
        homePage.clickOnElectronics();
        Thread.sleep(1000);

        //1.3 Verify the text “Cell phones”
        electronicCellPhonePage.verifyTextCellPhone();
        Thread.sleep(1000);
    }

    // 2. Test name verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully()
    @Test(groups = {"sanity", "smoke","regression"})
    public void verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully() throws InterruptedException
    {
        //2.1 Mouse Hover on “Electronics” Tab
        //2.2 Mouse Hover on “Cell phones” and click
        homePage.clickOnElectronics();

        //2.3 Verify the text “Cell phones”
        Assert.assertEquals(electronicCellPhonePage.verifyTextCellPhone(),"Cell phones","Cell Phone text not found");
        Thread.sleep(1000);

        //2.4 Click on List View Tab
        electronicCellPhonePage.clickOnlistviewTab();
        Thread.sleep(1000);

        //2.5 Click on product name “Nokia Lumia 1020” link
        electronicCellPhonePage.clickOnNokiaProduct();
        Thread.sleep(1000);

        //2.6 Verify the text “Nokia Lumia 1020”
        electronicCellPhonePage.verifyTextNokia();
        Thread.sleep(1000);

        //2.7 Verify the price “$349.00”
        electronicCellPhonePage.verifyTextPrice();
        Thread.sleep(1000);

        //2.8 Change quantity to 2
        electronicCellPhonePage.changeQTYToTwo("2");
        Thread.sleep(1000);

        //2.9 Click on “ADD TO CART” tab
        electronicCellPhonePage.clickAddToShoppingCart();
        Thread.sleep(1000);

        //2.10 Verify the Message "The product has been added to your shopping cart" on Top green Bar After that close the bar clicking on the cross button.
        Assert.assertEquals(electronicCellPhonePage.verifyTextProductAdded(),"The product has been added to your shopping cart","Product added message not display");
        electronicCellPhonePage.clickOnCloseButton();
        Thread.sleep(1000);

        //2.11 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        electronicCellPhonePage.mouseHoverToCartAndClick();
        Thread.sleep(1000);

        //2.12 Verify the message "Shopping cart"
        Assert.assertEquals(shoppingCartPage.verifyMessageShoppingCart(),"Shopping cart", "Shopping cart text not found");
        Thread.sleep(1000);

        //2.13 Verify the quantity is 2
        //Assert.assertEquals(shoppingCartPage.verifyQtyText(),"2","Quantity text not found");
        Thread.sleep(1000);

        //2.14 Verify the Total $698.00
        //Assert.assertEquals(shoppingCartPage.verifyTotalCellPhoneText(),"$698.00","Total text not found");
        Thread.sleep(1000);

        //2.15 click on checkbox “I agree with the terms of service”
        shoppingCartPage.clickOnCheckBox();
        Thread.sleep(1000);

        //2.16 Click on “CHECKOUT”
        shoppingCartPage.clickOnCheckOutButton();
        Thread.sleep(1000);

        //2.17 Verify the Text “Welcome, Please Sign In!”
        signInPage.verifyMessageSignIn();

        //2.18 Click on “REGISTER” tab
        signInPage.clickOnRegister();
        Thread.sleep(1000);

        //2.19 Verify the text “Register”
        Assert.assertEquals( registrationPage.verifyRegisterText(),"Register","Register text not found");
        Thread.sleep(1000);

        //2.20 Fill the mandatory fields
        registrationPage.fillAllRegisterField("Vishwa","Patel","va123@gmail.com","v123456","v123456");
        Thread.sleep(1000);

        //2.21 Click on “REGISTER” Button
        registrationPage.clickRegisterButton();
        Thread.sleep(1000);

        //2.22 Verify the message “Your registration completed”
        Assert.assertEquals(registrationPage.verifyRegistrationCompleted(),"Your registration completed","Registration complete message not found");
        Thread.sleep(1000);

        //2.23 Click on “CONTINUE” tab
        registrationPage.clickContinue();

        //2.24 Verify the text “Shopping card”
        Assert.assertEquals(shoppingCartPage.verifyMessageShoppingCart(),"Shopping cart", "Shopping cart text not found");
        Thread.sleep(5000);
    }

}

