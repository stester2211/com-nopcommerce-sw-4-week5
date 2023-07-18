package com.nopcommerce.demo.page;

import com.nopcommerce.demo.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class CheckOutPage extends Utility
{
    @CacheLookup
    @FindBy(xpath="//input[@id='BillingNewAddress_FirstName']")
    WebElement firstName;
    @CacheLookup
    @FindBy(xpath="//input[@id='BillingNewAddress_LastName']")
    WebElement lastName;
    @CacheLookup
    @FindBy(xpath="//input[@id='BillingNewAddress_Email']")
    WebElement email;
    @CacheLookup
    @FindBy(xpath="//select[@id='BillingNewAddress_CountryId']")
    WebElement countryName;
    @CacheLookup
    @FindBy(xpath="//select[@id='BillingNewAddress_StateProvinceId']")
    WebElement provinceName;
    @CacheLookup
    @FindBy(xpath="//input[@id='BillingNewAddress_City']")
    WebElement cityName;
    @CacheLookup
    @FindBy(xpath="//input[@id='BillingNewAddress_Address1']")
    WebElement address;
    @CacheLookup
    @FindBy(xpath="//input[@id='BillingNewAddress_ZipPostalCode']")
    WebElement zipCode;
    @CacheLookup
    @FindBy(xpath="//input[@id='BillingNewAddress_PhoneNumber']")
    WebElement phoneNumber;
    @CacheLookup
    @FindBy(xpath="//div[@id='billing-buttons-container']//button[text()='Continue']")
    WebElement continueButton;
    @CacheLookup
    @FindBy(xpath="//input[@id='shippingoption_1']")
    WebElement radioButtonAir;
    @CacheLookup
    @FindBy(xpath="//div[@id='shipping-method-buttons-container']//button[text()='Continue']")
    WebElement continueTwoButton;
    @CacheLookup
    @FindBy(xpath="//input[@id='paymentmethod_1']")
    WebElement radioCreditCard;
    @CacheLookup
    @FindBy(xpath="//div[@id='payment-method-buttons-container']//button[text()='Continue']")
    WebElement continueThreeButton;
    @CacheLookup
    @FindBy(xpath="//select[@id='CreditCardType']")
    WebElement selectMasterCardDropDown;
    @CacheLookup
    @FindBy(xpath="//input[@id='CardholderName']")
    WebElement cardHolder;
    @CacheLookup
    @FindBy(xpath="//input[@id='CardNumber']")
    WebElement cardNumber;
    @CacheLookup
    @FindBy(xpath="//select[@id='ExpireMonth']")
    WebElement expireMonth;
    @CacheLookup
    @FindBy(xpath="//select[@id='ExpireYear']")
    WebElement expireYear;
    @CacheLookup
    @FindBy(xpath="//input[@id='CardCode']")
    WebElement cardCode;
    @CacheLookup
    @FindBy(xpath="//div[@id='payment-info-buttons-container']//button[text()='Continue']")
    WebElement continueFourButton;
    @CacheLookup
    @FindBy(xpath="//span[contains(text(),'Credit Card')]")
    WebElement actualTextPaymentMethod;
    @CacheLookup
    @FindBy(xpath="//li[@class='shipping-method']//span[@class='value']")
    WebElement actualTextShippingMethod;
    @CacheLookup
    @FindBy(xpath="//span[@class='product-subtotal']")
    WebElement actualTextTotal;
    @CacheLookup
    @FindBy(xpath="//button[contains(text(),'Confirm')]")
    WebElement clickOnConfirm;
    @CacheLookup
    @FindBy(xpath="//h1[contains(text(),'Thank you')]")
    WebElement actualTextThankYou;
    @CacheLookup
    @FindBy(xpath="//strong[contains(text(),'Your order has been successfully processed!')]")
    WebElement actualTextSuccessfulOrder;
    @CacheLookup
    @FindBy(xpath="//button[contains(text(),'Continue')]")
    WebElement clickContinueFive;
    public void checkOutInfo(String fName, String lName, String enterEmail, String enterCountry, String enterProvince, String enterCity, String enterAddress, String enterZipCode, String enterPhone)
    {
        //2.22 Fill the all mandatory field
        sendTextToElement(firstName,fName);
        sendTextToElement(lastName,lName);
        sendTextToElement(email,enterEmail);
        selectByValueFromDropDown(countryName,enterCountry);
        selectByValueFromDropDown(provinceName,enterProvince);
        sendTextToElement(cityName,enterCity);
        sendTextToElement(address,enterAddress);
        sendTextToElement(zipCode,enterZipCode);
        sendTextToElement(phoneNumber,enterPhone);
    }
    public void clickContinue()
    {
        //2.23 Click on “CONTINUE”
        clickOnElement(continueButton);
    }
    public void clickRadioButtonNextDay()
    {
        //2.24 Click on Radio Button “Next Day Air($0.00)”
        clickOnElement(radioButtonAir);
    }
    public void clickContinueTwo()
    {
        //2.25 Click on “CONTINUE”
        clickOnElement(continueTwoButton);
    }
    public void selectRadioCreditCard()
    {
        //2.26 Select Radio Button “Credit Card”
        clickOnElement(radioCreditCard);
        clickOnElement(continueThreeButton);
    }
    public void selectMasterCard()
    {
        //2.27 Select “Master card” From Select credit card dropdown
        selectByVisibleTextFromDropDown(selectMasterCardDropDown,"Master card");
    }
    public void fillAllDetailMasterCard(String cardHolderName, String enterCardNumber, String enterCode)
    {
        //2.28 Fill all the details
        sendTextToElement(cardHolder,cardHolderName);

        sendTextToElement(cardNumber,enterCardNumber);

        selectByIndexFromDropDown(expireMonth,1);

        selectByIndexFromDropDown(expireYear,1);

        sendTextToElement(cardCode,enterCode);
    }
    public void clickContinueFourButton()
    {
        //2.29 Click on “CONTINUE”
        clickOnElement(continueFourButton);
    }
    public String verifyPaymentCreditCard()
    {
        //2.30 Verify “Payment Method” is “Credit Card”
        return getTextFromElement(actualTextPaymentMethod);
    }
    public String verifyShippingMethod()
    {
        //2.32 Verify “Shipping Method” is “Next Day Air”
        return getTextFromElement(actualTextShippingMethod);
    }
    public String verifyTotalText()
    {
        //2.33 Verify Total is “$2,950.00”
        return getTextFromElement(actualTextTotal);
    }
    public void clickOnConfirmButton()
    {
        //2.34 Click on “CONFIRM”
        clickOnElement(clickOnConfirm);
    }
    public String verifyTextThankYou()
    {
        //2.35 Verify the Text “Thank You”
        return getTextFromElement(actualTextThankYou);
    }
    public String verifyTextOrderSuccessfully()
    {
        ///2.36 Verify the message “Your order has been successfully processed!”
        return getTextFromElement(actualTextSuccessfulOrder);
    }
    public void clickContinueFive()
    {
        //2.37 Click on “CONTINUE”
        clickOnElement(clickContinueFive);
    }

}
