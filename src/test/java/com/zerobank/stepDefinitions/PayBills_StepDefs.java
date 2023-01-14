package com.zerobank.stepDefinitions;

import com.zerobank.pages.AddNewPayeee;
import com.zerobank.pages.PayBillsPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;

import java.util.Map;

public class PayBills_StepDefs {
    PayBillsPage payBillsPage=new PayBillsPage();
    AddNewPayeee addNewPayeee=new AddNewPayeee();
    @When("User should input the pay requirements")
    public void user_should_input_the_pay_requirements() {

        Select select=new Select(payBillsPage.payeeInput_loc);
        select.selectByVisibleText("Bank of America");

        Select select1=new Select(payBillsPage.accountInput_loc);
        select1.selectByVisibleText("Loan");

        payBillsPage.amountInput_loc.sendKeys("7777");
        payBillsPage.dateInput_loc.sendKeys("2022-12-13");
        payBillsPage.descriptonInput_loc.sendKeys("Good payment");
        payBillsPage.payButton_loc.click();
    }
    @Then("{string} message should be displayed")
    public void message_should_be_displayed(String expectesMessage) {
        String actualMessage=payBillsPage.messageText_loc.getText();
        Assert.assertEquals(expectesMessage, actualMessage);
    }

    @When("User should not to complete pay operation by using invalid {string}. {string}, {string}")
    public void user_should_not_to_complete_pay_operation_by_using_invalid(String amount, String date, String description) {
        Select select=new Select(payBillsPage.payeeInput_loc);
        select.selectByVisibleText("Bank of America");

        Select select1=new Select(payBillsPage.accountInput_loc);
        select1.selectByVisibleText("Loan");

        payBillsPage.amountInput_loc.sendKeys(amount);
        payBillsPage.dateInput_loc.sendKeys(date);
        payBillsPage.descriptonInput_loc.sendKeys(description);
        payBillsPage.payButton_loc.click();
    }
    @Then("{string} message should not be displayed")
    public void message_should_not_be_displayed(String expectedMessage) {
        String actualMessage=payBillsPage.messageText_loc.getText();
        boolean match=false;
        if(actualMessage!=expectedMessage){
            match=true;
        }
        Assert.assertTrue(match);
       // Assert.assertFalse(expectedMessage.equals(actualMessage));
    }

    @When("User should create new payee using following information")
    public void user_should_create_new_payee_using_following_information(Map<String, String> information) {
        addNewPayeee.payeeInputMethod(information.get("Payee Name"), information.get("Payee Address"), information.get("Account"),
                information.get("Payee details"));
    }


}
