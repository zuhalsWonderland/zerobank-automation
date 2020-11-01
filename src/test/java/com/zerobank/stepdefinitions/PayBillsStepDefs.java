package com.zerobank.stepdefinitions;

import com.zerobank.pages.PayBillsPage;
import com.zerobank.utilities.Driver;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import java.util.Map;

public class PayBillsStepDefs {
    PayBillsPage payBillsPage = new PayBillsPage();
    @When("the user navigates to Pay Bills page")
    public void the_user_navigates_to_Pay_Bills_page() {
       payBillsPage.payBills.click();
    }

    @Then("the title should be like {string}")
    public void the_title_should_be(String expected) {
        Assert.assertTrue(Driver.get().getTitle().contains(expected));
    }

    @Then("the user enter {string} and {string} to input fields")
    public void the_user_enter_and_to_input_fields(String amount, String date) {
        payBillsPage.amount.sendKeys(amount);
        payBillsPage.dateField.sendKeys(date);
    }

    @Then("the user should see the success warning after clicking Pay")
    public void the_user_should_see_the_success_warning_after_clicking_Pay(String warning) {
       payBillsPage.pay.click();
       Assert.assertEquals(warning,payBillsPage.paySuccessAlert.getText());
    }

    @Then("the user should see the following alert after clicking Pay")
    public void the_user_should_see_the_following_alert_after_clicking_Pay(String warning) throws InterruptedException {
        payBillsPage.pay.click();
        Thread.sleep(1000);
        String message = payBillsPage.amount.getAttribute("validationMessage");
        Assert.assertEquals(warning,message);
    }

    @Then("the user should not be able to make a payment using {string}")
    public void the_user_should_not_be_able_to_make_a_payment_using(String amount) {
        payBillsPage.amount.sendKeys(amount);
        payBillsPage.dateField.sendKeys("2020-10-01");
        payBillsPage.pay.click();
        Assert.assertFalse(payBillsPage.paySuccessAlert.isDisplayed());
        //Here we have a bug
    }
    @Then("the user should not be able to make a payment with {string}")
    public void the_user_should_not_be_able_to_make_a_payment_with(String amount) {
       payBillsPage.amount.sendKeys(amount);
       payBillsPage.dateField.sendKeys("2020-10-01");
       payBillsPage.pay.click();
       Assert.assertFalse(payBillsPage.paySuccessAlert.isDisplayed());
       //Here we have a bug
    }

    @Then("date field should not accept {string}")
    public void date_field_should_not_accept(String specialCharacters) {
      payBillsPage.amount.sendKeys("30");
      payBillsPage.dateField.sendKeys(specialCharacters);
      Assert.assertFalse(payBillsPage.dateField.getText().equalsIgnoreCase(specialCharacters));

    }

    @Given("creates	new	payee using following information")
    public void creates_new_payee_using_following_information(Map<String,String> newPayeeData) throws InterruptedException {
        Thread.sleep(2000);
        payBillsPage.AddNewPayee.click();
        Thread.sleep(2000);
        Driver.get().findElement(By.id("np_new_payee_name")).sendKeys(newPayeeData.get("PayeeName"));
        Driver.get().findElement(By.tagName("textarea")).sendKeys(newPayeeData.get("PayeeAddress"));
        Driver.get().findElement(By.id("np_new_payee_account")).sendKeys(newPayeeData.get("Account"));
        Driver.get().findElement(By.id("np_new_payee_details")).sendKeys(newPayeeData.get("PayeeDetails"));

        Driver.get().findElement(By.cssSelector("input#add_new_payee")).click();

    }


    @Then("message {string} should be displayed")
    public void messageShouldBeDisplayed(String successAlert) throws InterruptedException {
        Thread.sleep(2000);
        Assert.assertEquals(successAlert,payBillsPage.newPayeeAlert.getText());
    }
}
