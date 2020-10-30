package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class AccountActivityPageStepDefs {
    AccountActivityPage accountActivityPage = new AccountActivityPage();
    @When("the user navigates to Account Activity page")
    public void the_user_navigates_to_Account_Activity_page() throws InterruptedException {
     accountActivityPage.accountActivity.click();
     Thread.sleep(3000);
    }

    @Then("the title should be {string}")
    public void the_title_should_be(String expected) {
        Assert.assertTrue(Driver.get().getTitle().contains(expected));
    }


    @Then("the dropdown default option should be {string}")
    public void the_dropdown_default_option_should_be(String expected) {
        System.out.println(accountActivityPage.defaultOption.getText());
        Assert.assertEquals(expected,accountActivityPage.defaultOption.getText());
    }

    @Then("Account Dropdown should have following options")
    public void account_Dropdown_should_have_following_options(List<String> expectedOptions) {
        Select dropdownElement = new Select(accountActivityPage.accountDropdown);
        List<String> actualOptions = BrowserUtils.getElementsText(dropdownElement.getOptions());
        System.out.println(actualOptions);
        System.out.println(expectedOptions);
        Assert.assertEquals(expectedOptions,actualOptions);
        //We have a bug here
    }

    @Then("Transactions table should haave the following column names")
    public void transactions_table_should_haave_the_following_column_names(List<String> expected) {
        List<String> actual = BrowserUtils.getElementsText(accountActivityPage.transactionColumns);
        System.out.println(actual);
        System.out.println(expected);
        Assert.assertEquals(expected,actual);
    }



}
