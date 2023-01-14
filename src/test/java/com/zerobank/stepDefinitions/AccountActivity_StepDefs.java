package com.zerobank.stepDefinitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.utilities.BrowserUtils;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class AccountActivity_StepDefs {

    AccountActivityPage accountActivityPage=new AccountActivityPage();

    @When("User should navigate to {string}")
    public void user_should_navigate_to(String accountTypes) {
        accountActivityPage.navigateToAccountMtd(accountTypes);

    }
    @When("User should see the {string} as default type")
    public void user_should_see_the_as_default_type(String expectedOption) {
        Select select=new Select(accountActivityPage.dropDownElement_loc);
        String actualOptions=select.getFirstSelectedOption().getText();
        Assert.assertEquals(expectedOption, actualOptions);
        System.out.println("expectedOption = " + expectedOption);
        System.out.println("actualOptions = " + actualOptions);
    }
    @When("User should be see the following Accounts")
    public void user_should_be_see_the_following_accounts(List<String>expectedAccountTypes) {
        Select select=new Select(accountActivityPage.dropDownElement_loc);
        List<WebElement> options=select.getOptions();
        boolean match=false;
        for (WebElement option: options){
            System.out.println("option.getText() = " + option.getText());
            for (int i=0; i<expectedAccountTypes.size(); i++){
                if(option.getText().equals(expectedAccountTypes.get(i))){
                    match=true;
                }
            }
            Assert.assertTrue(match);
        }

    }
    @When("User should be see the following options")
    public void user_should_be_see_the_following_options(List<String>expectedOptions) {
        List<String>actualOptins = BrowserUtils.getElementsText(accountActivityPage.rowHeader_loc);
        Assert.assertEquals(expectedOptions, actualOptins);
    }

}
