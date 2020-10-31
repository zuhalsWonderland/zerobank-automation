package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AccountActivityPage {
    public AccountActivityPage() {
        PageFactory.initElements(Driver.get(), this);
    }
    @FindBy(xpath = "//ul[@class='nav nav-tabs']/li[2]")
    public WebElement accountActivity;

    @FindBy(xpath = "//option[@value='1']")
    public WebElement defaultOption;

    @FindBy(id = "aa_accountId")
    public WebElement accountDropdown;

    @FindBy(xpath = "//table[@class='table table-condensed table-hover']/thead/tr/th")
    public List<WebElement> transactionColumns;

    //Find Transactions locators
    @FindBy(xpath = "//a[.='Find Transactions']")
    public WebElement findTransactions;

    @FindBy(id = "aa_description")
    public WebElement description;

    @FindBy(id = "aa_fromDate")
    public WebElement fromDate;

    @FindBy(id = "aa_toDate")
    public WebElement toDate;

    @FindBy(xpath = "//button[.='Find']")
    public WebElement findButton;

    @FindBy(xpath = "(//tbody)[2]/tr/td[1]")
    public List<WebElement> resultsTable;






}
