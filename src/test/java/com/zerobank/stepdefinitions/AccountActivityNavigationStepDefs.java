package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.utilities.Driver;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

public class AccountActivityNavigationStepDefs {

@When("the user clicks on	the <\"accountTypeLinkName\"> on the	Account	Summary	page and account dropdown should have {string} selected on the account activity page")
public void the_user_clicks_on_the_accountTypeLinkName_on_the_Account_Summary_page_and_account_dropdown_should_have_selected_on_the_account_activity_page(String expected) throws InterruptedException {
    AccountSummaryPage accountSummaryPage = new AccountSummaryPage();
        for (int i = 1; i < accountSummaryPage.accountTypeLinkName.size() ; i++) {
            Thread.sleep(2000);
            accountSummaryPage.accountTypeLinkName.get(i).click();
            Thread.sleep(2000);
            Assert.assertTrue(Driver.get().findElement(By.xpath("//option[.='" + expected + "']")).isDisplayed());
        }
}



}
