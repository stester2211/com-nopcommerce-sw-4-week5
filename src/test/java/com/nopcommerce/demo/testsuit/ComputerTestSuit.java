package com.nopcommerce.demo.testsuit;

import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.page.*;
import com.nopcommerce.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListeners.class)

public class ComputerTestSuit extends BaseTest
{
    HomePage homePage;
    ComputerDesktopPage computerDesktopPage;
    BuildComputerPage buildComputerPage;
    ShoppingCartPage shoppingCartPage;
    SignInPage signInPage;
    CheckOutPage checkOutPage;

    @BeforeMethod(alwaysRun = true)
    public void inIT()
    {
        homePage= new HomePage();
        computerDesktopPage = new ComputerDesktopPage();
        buildComputerPage = new BuildComputerPage();
        shoppingCartPage= new ShoppingCartPage();
        signInPage=new SignInPage();
        checkOutPage= new CheckOutPage();
    }

    @Test(groups = {"sanity","regression"})
    //1.Test name verifyProductArrangeInAlphaBaticalOrder()
    public void verifyProductArrangeInAlphaBaticalOrder() throws InterruptedException
    {
        //1.1 Click on Computer Menu.
        //1.2 Click on Desktop
        homePage.clickOnDesktop();
        Thread.sleep(2000);

        //1.3 Select Sort By position "Name: Z to A"
        computerDesktopPage.productByPosition("Name: Z to A");
        Thread.sleep(2000);

        //1.4 Verify the Product will arrange in Descending order.
        computerDesktopPage.productInDecending();
        Thread.sleep(2000);
    }

    //2. Test name verifyProductAddedToShoppingCartSuccessFully()
    @Test(groups = {"sanity", "smoke","regression"})
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException
    {
        //2.1 Click on Computer Menu.
        //2.2 Click on Desktop
        homePage.clickOnDesktop();

        //2.3 Select Sort By position "Name: A to Z"
        computerDesktopPage.productByPositionAtoZ();
        Thread.sleep(1000);

        //2.4 Click on "Add To Cart"
        computerDesktopPage.clickOnAddToCart();
        Thread.sleep(1000);

        //2.5 Verify the Text "Build your own computer"
        Assert.assertEquals(buildComputerPage.verifyTextBuild(),"Build your own computer", "Build text not found");
        Thread.sleep(1000);

        //2.6 Select "2.2 GHz Intel Pentium Dual-Core E2200" using Select class
        buildComputerPage.selectCoreDropdown();
        Thread.sleep(1000);

        //2.7.Select "8GB [+$60.00]" using Select class.
        buildComputerPage.selectRamDropdown();
        Thread.sleep(1000);

        //2.8 Select HDD radio "400 GB [+$100.00]"
        buildComputerPage.selectHddList();
        Thread.sleep(1000);

        //2.9 Select OS radio "Vista Premium [+$60.00]"
        buildComputerPage.clickOs();
        Thread.sleep(1000);

        //2.10 Check Two Check boxes "Microsoft Office [+$50.00]" and "Total Commander [+$5.00]"
        buildComputerPage.clickCheckBox();
        Thread.sleep(2000);

        // 2.11 Verify the price "$1,475.00"
        Assert.assertEquals(buildComputerPage.actualPrice(),"$1,475.00", "Price is not verify");
        Thread.sleep(2000);

        // 2.12 Click on "ADD TO CARD" Button.
        buildComputerPage.clickOnAddToCart();
        Thread.sleep(3000);

        // 2.13 Verify the Message "The product has been added to your shopping cart" on Top green Bar After that close the bar clicking on the cross button.
        Assert.assertEquals(buildComputerPage.actualProductAdded(),"The product has been added to your shopping cart","Product not added");
        buildComputerPage.clickOnCloseButton();
        Thread.sleep(1000);

        //2.14 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        buildComputerPage.mouseHoverToCartAndClick();
        Thread.sleep(1000);

        //2.15 Verify the message "Shopping cart"
        Assert.assertEquals(shoppingCartPage.verifyMessageShoppingCart(),"Shopping cart", "Shopping cart text not found");
        Thread.sleep(1000);

        //2.16 Change the Qty to "2" and Click on "Update shopping cart"
        shoppingCartPage.changeQtyClickOnUpdateCart("2");
        Thread.sleep(1000);

        //2.17 Verify the Total"$2,950.00"
        Assert.assertEquals(shoppingCartPage.verifyTotalText(),"$2,950.00","Total text not found");

        //2.18 click on checkbox “I agree with the terms of service”
        shoppingCartPage.clickOnCheckBox();
        Thread.sleep(1000);

        //2.19 Click on “CHECKOUT”
        shoppingCartPage.clickOnCheckOutButton();
        Thread.sleep(1000);

        //2.20 Verify the Text “Welcome, Please Sign In!”
        Assert.assertEquals( signInPage.verifyMessageSignIn(),"Welcome, Please Sign In!","Welcome Text not found");
        Thread.sleep(1000);

        //2.21 Click on “CHECKOUT AS GUEST” Tab
        signInPage.clickOnCheckOutAsGuestButton();
        Thread.sleep(1000);

        //2.22 Fill the all mandatory field
        checkOutPage.checkOutInfo("Vishwa","patel","patelv@gmail.com","153","23","Windsor","Asking","123456","1234567895");
        Thread.sleep(1000);

        //2.23 Click on “CONTINUE”
        checkOutPage.clickContinue();
        Thread.sleep(1000);

        //2.24 Click on Radio Button “Next Day Air($0.00)”
        checkOutPage.clickRadioButtonNextDay();
        Thread.sleep(1000);

        //2.25 Click on “CONTINUE”
        checkOutPage.clickContinueTwo();
        Thread.sleep(1000);

        //2.26 Select Radio Button “Credit Card”
        checkOutPage.selectRadioCreditCard();
        Thread.sleep(1000);

        //2.27 Select “Master card” From Select credit card dropdown
        checkOutPage.selectMasterCard();
        Thread.sleep(1000);

        //2.28 Fill all the
        checkOutPage.fillAllDetailMasterCard("aavv","1111222233334444","123");
        Thread.sleep(1000);

        //2.29 Click on “CONTINUE”
        checkOutPage.clickContinueFourButton();
        Thread.sleep(1000);

        //2.30 Verify “Payment Method” is “Credit Card”
        Assert.assertEquals(checkOutPage.verifyPaymentCreditCard(),"Credit Card","Payment method not found");
        Thread.sleep(1000);

        //2.32 Verify “Shipping Method” is “Next Day Air”
        Assert.assertEquals(checkOutPage.verifyShippingMethod(),"Next Day Air","Shipping method not found");
        Thread.sleep(1000);

        //2.33 Verify Total is “$2,950.00”
        Assert.assertEquals(checkOutPage.verifyTotalText(),"$2,950.00","Total text not found");
        Thread.sleep(1000);

        //2.34 Click on “CONFIRM”
        checkOutPage.clickOnConfirmButton();
        Thread.sleep(2000);

        //2.35 Verify the Text “Thank You”
        Assert.assertEquals( checkOutPage.verifyTextThankYou(),"Thank you","Thank you text not found");
        Thread.sleep(1000);

        //2.36 Verify the message “Your order has been successfully processed!”
        Assert.assertEquals(checkOutPage.verifyTextOrderSuccessfully(),"Your order has been successfully processed!","Order sucessfully text not found");
        Thread.sleep(1000);

        //2.37 Click on “CONTINUE”
        checkOutPage.clickContinueFive();
        Thread.sleep(1000);

        //2.37 Verify the text “Welcome to our store”
        Assert.assertEquals(homePage.verifyWelcomeText(),"Welcome to our store","Welcome Text not found");
        Thread.sleep(1000);
    }

}
