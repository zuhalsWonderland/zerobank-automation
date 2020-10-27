package com.zerobank.stepdefinitions;

import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStepDefs {

    LoginPage loginPage = new LoginPage();

    @When("the user logs in with valid credentials")
    public void the_user_logs_in_with_valid_credentials() {
        String username = ConfigurationReader.get("username");
        String password = ConfigurationReader.get("password");

        loginPage.login(username, password);
}

    @Then("the {string} page should be displayed")
    public void the_page_should_be_displayed(String expectedTitle) {
        System.out.println(Driver.get().getTitle());
        Assert.assertTrue(Driver.get().getTitle().contains(expectedTitle));
    }

    @When("the user logs in using {string} and {string}")
    public void the_user_logs_in_using_and(String username, String password) {

        loginPage.login(username, password);
    }

    @Then("{string} should be displayed")
    public void should_be_displayed(String alert) {

        Assert.assertTrue(loginPage.errorAlert.getText().contains(alert));
    }

    @When("the user tries to log in with no credentials")
    public void the_user_tries_to_log_in_with_no_credentials() {

        loginPage.login("","");

    }



}
