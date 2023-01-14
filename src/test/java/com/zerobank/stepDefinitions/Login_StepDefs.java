package com.zerobank.stepDefinitions;

import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Login_StepDefs {

    LoginPage loginPage=new LoginPage();

    @Given("User should be on the login page")
    public void user_should_be_on_the_login_page() {

        Driver.get().get(ConfigurationReader.get("url"));

    }
    @When("User should input username {string} and password {string}")
    public void user_should_input_username_and_password(String username, String password) {
        loginPage.signinButton_loc.click();
        loginPage.username_loc.sendKeys(username);
        loginPage.password_loc.sendKeys(password);
        loginPage.loginButton_loc.click();
        Driver.get().get("http://zero.webappsecurity.com/bank/account-summary.html");

    }
    @Then("{string} page should be displayed")
    public void page_should_be_displayed(String expectedTitle) {
        String actualTitle=Driver.get().getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle));

    }

    @When("User should input usernameInfo {string} and passwordInfo {string}")
    public void user_should_input_username_info_and_password_info(String userInfo, String passwordInfo) {
        loginPage.signinButton_loc.click();
        loginPage.username_loc.sendKeys(userInfo);
        loginPage.password_loc.sendKeys(passwordInfo);
        loginPage.loginButton_loc.click();

    }
    @Then("Error message {string} should be displayed")
    public void error_message_should_be_displayed(String expectedMsg) {
        String actualMsg=loginPage.errorMsj_loc.getText();
        Assert.assertEquals(expectedMsg, actualMsg);

    }

}
