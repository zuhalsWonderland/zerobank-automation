package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.List;

public class AccountSummmaryPageStepDefs {

    @Then("the {string} title should be displayed")
    public void the_title_should_be_displayed(String expectedTitle) {

        Assert.assertTrue(Driver.get().getTitle().contains(expectedTitle));
    }

    @Then("the user should see following options")
    public void the_user_should_see_following_options(List<String> expectedOptions) {
        List<String> actualOptions = BrowserUtils.getElementsText(new AccountSummaryPage().summaryOptions);
        System.out.println(actualOptions);
        System.out.println(expectedOptions);
        Assert.assertEquals(expectedOptions,actualOptions);
    }

    @Then("the Credit Accounts table must have following columns")
    public void the_Credit_Accounts_table_must_have_following_columns(List<String>  expectedOptions) {
        List<String> actualOptions = BrowserUtils.getElementsText(new AccountSummaryPage().creditAccountsColumns);
        System.out.println(actualOptions);
        System.out.println(expectedOptions);
        Assert.assertEquals(expectedOptions,actualOptions);

    }


}
