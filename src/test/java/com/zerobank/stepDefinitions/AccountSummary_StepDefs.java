package com.zerobank.stepDefinitions;

import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.List;

public class AccountSummary_StepDefs {
    AccountSummaryPage accountSummaryPage=new AccountSummaryPage();

    @Then("User should be see the following Accounts Types")
    public void user_should_be_see_the_following_accounts_types(List<String> expectedAccounts) {
        List<String> actualAccounts= BrowserUtils.getElementsText(accountSummaryPage.accountTypes_loc);
        Assert.assertEquals(expectedAccounts, actualAccounts);
        System.out.println("actualAccounts = " + actualAccounts);
        System.out.println("actualAccounts.size() = " + actualAccounts.size());

    }
    @Then("Credit Account table should have following columns")
    public void credit_account_table_should_have_following_columns(List<String> expectedColumns) {
        List<String>actualColumns=BrowserUtils.getElementsText(accountSummaryPage.creditAccountColumns_loc);
        System.out.println("actualColumns = " + actualColumns);
        System.out.println("actualColumns.size() = " + actualColumns.size());
        Assert.assertEquals(expectedColumns, actualColumns);

    }

}
