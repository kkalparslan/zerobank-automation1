package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddNewPayeee extends BasePage{

    @FindBy(xpath = "//input[@id='np_new_payee_name']")
    public WebElement payeeName_loc;

    @FindBy(css = "#np_new_payee_address")
    public WebElement address_loc;

    @FindBy(css = "#np_new_payee_account")
    public WebElement account_loc;

    @FindBy(css = "#np_new_payee_details")
    public WebElement paydetails_loc;

    @FindBy(id ="add_new_payee")
    public WebElement newPayBtn_loc;

    public void payeeInputMethod(String payeeName, String payeeAdress, String account, String payeeDetails){
        //BrowserUtils.waitFor(3);
        payeeName_loc.sendKeys(payeeName);
        address_loc.sendKeys(payeeAdress);
        account_loc.sendKeys(account);
        paydetails_loc.sendKeys(payeeDetails);
        newPayBtn_loc.click();

    }

}
