package com.zerobank.stepdefinitions;

import com.zerobank.pages.PayBillsPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.util.HashSet;
import java.util.List;

public class PurchaseForeignCurrencyStepDefs {

    PayBillsPage payBillsPage = new PayBillsPage();

    @When("the user accesses the Purchase foreign currency cash tab")
    public void the_user_accesses_the_Purchase_foreign_currency_cash_tab() {
        payBillsPage.purchaseForeignCurrency.click();
    }

    @Then("following currencies should be	available")
    public void following_currencies_should_be_available(List<String> currencies) {
        payBillsPage.currencyInput.click();
        int counter=0;
       List<String> currencyList = BrowserUtils.getElementsText(payBillsPage.currencyList);
       for (int i = 0; i < currencies.size(); i++) {
           System.out.println("expected" + currencies.get(i));
           for (int j = 1; j < currencyList.size(); j++) {
               System.out.println("actual" + currencyList.get(j));
                if (currencies.get(i).equals(currencyList.get(j))) {
                    counter++;
                }
            }
        }
        Assert.assertEquals(currencies.size(),counter);

    }


}
