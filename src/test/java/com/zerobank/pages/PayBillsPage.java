package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PayBillsPage {
    public PayBillsPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(id = "pay_bills_tab")
    public WebElement payBills;
    
    @FindBy(id = "sp_amount")
    public WebElement amount;

    @FindBy(id = "sp_date")
    public WebElement dateField;

    @FindBy(xpath = "(//a[@class='ui-state-default'])[1]")
    public WebElement chooseDate;

    @FindBy(id = "pay_saved_payees")
    public WebElement pay;

    @FindBy(xpath = "//div[@id='alert_content']/span")
    public WebElement paySuccessAlert;

    @FindBy(xpath = "//a[.='Add New Payee']")
    public WebElement AddNewPayee;

    @FindBy(xpath = "//div[@id='alert_content']")
    public WebElement newPayeeAlert;


}
