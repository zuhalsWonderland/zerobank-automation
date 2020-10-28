package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public abstract class BasePage {
    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath = "//ul[@class='nav nav-tabs']/li")
    public List<WebElement> menuOptions;

    @FindBy(xpath = "//h2[@class='board-header']")
    public List<WebElement> summaryOptions;

    @FindBy(xpath = "//div[@class='board'][3]/div/table/thead/tr/th")
    public List<WebElement> creditAccountsColumns;


}
