package com.zerobank.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PayBillsPage extends BasePage{

    @FindBy(css = "#sp_payee")
    public WebElement payeeInput_loc;

    @FindBy(css = "#sp_account")
    public WebElement accountInput_loc;

    @FindBy(css = "#sp_amount")
    public WebElement amountInput_loc;

    @FindBy(id = "sp_date")
    public WebElement dateInput_loc;

    @FindBy(id = "sp_description")
    public WebElement descriptonInput_loc;

    @FindBy(id = "pay_saved_payees")
    public WebElement payButton_loc;

    @FindBy(id = "alert_content")
    public WebElement messageText_loc;




}
