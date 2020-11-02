package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.util.List;

public class FindTransactionsStepDefs {
    AccountActivityPage findTransactionsPart = new AccountActivityPage();

    @Given("the user accesses the Find Transactions tab")
    public void the_user_accesses_the_Find_Transactions_tab() {
        new AccountActivityPage().accountActivity.click();
        findTransactionsPart.findTransactions.click();
    }

    @When("the user enters date range from {string} to {string}")
    public void the_user_enters_date_range_from_to(String from, String to) throws InterruptedException {
       Thread.sleep(3000);
        findTransactionsPart.fromDate.sendKeys(from);
        findTransactionsPart.toDate.sendKeys(to);

}

    @When("clicks search")
    public void clicks_search() throws InterruptedException {
        Thread.sleep(2000);
        findTransactionsPart.findButton.click();
    }

    @Then("results table should only show the dates {string} to {string}")
    public void results_table_should_only_show_the_dates_to(String from, String to) throws InterruptedException {
        Thread.sleep(3000);
        List<String> td = BrowserUtils.getElementsText(findTransactionsPart.resultsTable);
        int fromDate = Integer.parseInt(from.substring(0,4)) + Integer.parseInt(from.substring(5,7)) + Integer.parseInt(from.substring(8))*30;
        int toDate = Integer.parseInt(to.substring(0,4)) + Integer.parseInt(to.substring(5,7)) + Integer.parseInt(to.substring(8))*30;
        boolean bool=true;
        for (int i = 0; i < td.size(); i++) {
            int date = Integer.parseInt(td.get(i).substring(0,4)) + Integer.parseInt(td.get(i).substring(5,7)) + Integer.parseInt(td.get(i).substring(8))*30;
            if(date < fromDate || date > toDate){
                bool = false;
                break;
            }
        }
        findTransactionsPart.fromDate.clear();
        findTransactionsPart.toDate.clear();
        Assert.assertTrue(bool);
    }

    @Then("the	results	should be sorted by	most recent	date {string}")
    public void the_results_should_be_sorted_by_most_recent_date(String to) throws InterruptedException {
        Thread.sleep(3000);
        List<String> td = BrowserUtils.getElementsText(findTransactionsPart.resultsTable);
        int mostRecentDate = Integer.parseInt(td.get(0).substring(0,4)) + Integer.parseInt(td.get(0).substring(5,7))*30 + Integer.parseInt(td.get(0).substring(8));
        int toDate = Integer.parseInt(to.substring(0,4)) + Integer.parseInt(to.substring(5,7))*30 + Integer.parseInt(to.substring(8));
        Assert.assertTrue(mostRecentDate == toDate);
    }

    @Then("the	results	table should only not contain transactions dated {string}")
    public void the_results_table_should_only_not_contain_transactions_dated(String date) {
        Assert.assertFalse(Driver.get().findElement(By.xpath("//td[.='" + date + "']")).isDisplayed());
    }

    @When("the user enters description {string} and clicks search")
    public void theUserEntersDescriptionAndClicksSearch(String searchWord) throws InterruptedException {
       Thread.sleep(3000);
        findTransactionsPart.description.sendKeys(searchWord);
        findTransactionsPart.findButton.click();
    }

    @Then("results table should only show	descriptions containing	{string}")
    public void resultsTableShouldOnlyShowDescriptionsContaining(String searchWord) throws InterruptedException {
        Thread.sleep(2000);
        System.out.println(findTransactionsPart.description.getText());
        List<String>  descData = BrowserUtils.getElementsText(findTransactionsPart.descriptionTd);
        Assert.assertTrue(descData.size() != 0);
        for (int i = 0; i < descData.size(); i++) {
            System.out.println(descData.get(i));
            Assert.assertTrue(descData.get(i).contains(searchWord));
        }
        findTransactionsPart.description.clear();
        //Description input is not case insensitive. We have a bug here.
    }

    @When("user selects type {string}")
    public void userSelectsType(String type) throws InterruptedException {
       Driver.get().findElement(By.id("aa_type")).click();
       Driver.get().findElement(By.xpath("//option[@value='" + type + "']")).click();
       Thread.sleep(2000);
       findTransactionsPart.findButton.click();
    }


    @Then("results table should show at least one result under {string}")
    public void resultsTableShouldShowAtLeastOneResultUnder(String type) throws InterruptedException {
        Thread.sleep(2000);
        int counter=0;
        if(type.equals("Deposit")){

         for (int i = 0; i < findTransactionsPart.depositTd.size(); i++) {
           if (!(findTransactionsPart.depositTd.get(i).getText().equals(""))){
               counter++;
           }
         }
         Assert.assertTrue(counter > 0);
        }else if(type.equals("Withdrawal")){

           for (int i = 0; i < findTransactionsPart.withdrawalTd.size(); i++) {
             if (!(findTransactionsPart.withdrawalTd.get(i).getText().equals(""))){
                counter++;
             }
           }
        Assert.assertTrue(counter > 0);
        }
    }

    @And("results table should show no result under {string}")
    public void resultsTableShouldShowNoResultUnder(String type) throws InterruptedException {
        Thread.sleep(2000);
        int counter=0;
        if(type.equals("Withdrawal")) {
            for (int i = 0; i < findTransactionsPart.withdrawalTd.size(); i++) {
                if (findTransactionsPart.withdrawalTd.get(i).getText().equals("")) {
                    counter++;
                }
            }
            System.out.println(counter + "Withdrawal");
            Assert.assertTrue(counter == findTransactionsPart.withdrawalTd.size());
        }else if(type.equals("Deposit")){
            for (int i = 0; i < findTransactionsPart.depositTd.size(); i++) {
               if (findTransactionsPart.depositTd.get(i).getText().equals("")){
                counter++;
               }
            }
            System.out.println(counter + "deposit");
          Assert.assertTrue(counter == findTransactionsPart.depositTd.size());
        }
      }
    }

