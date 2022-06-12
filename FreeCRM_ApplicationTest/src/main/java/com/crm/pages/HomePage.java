package com.crm.pages;

import com.crm.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends TestBase {

    @FindBy(xpath = "//td[contains(text(),'User: Dattatri Bhure')]")
    @CacheLookup
    WebElement userNameLabel;
    @FindBy(xpath = "//a[contains(text(),'Contacts')]")
    WebElement contactsLink;
    @FindBy(xpath = "//a[contains(text(),'Deals')]")
    WebElement dealsLink;
    @FindBy(xpath = "//a[contains(text(),'Tasks')]")
    WebElement tasksLink;
    @FindBy(xpath = "//a[contains(text(),'Companies')]")
    WebElement companiesLink;
    @FindBy(xpath = "//a[contains(text(),'Calendar')]")
    WebElement calendarLink;
    @FindBy(xpath = "//a[contains(text(),'Reports')]")
    WebElement reportsLink;

    @FindBy(xpath = "//a[contains(text(),'New Contact')]")
    WebElement newContactLink;


    public HomePage() {
        PageFactory.initElements(driver, this);
    }
    public String verifyHomePageTitle() {
        return driver.getTitle();
    }
    public boolean verifyCorrectUsername() {
        return userNameLabel.isDisplayed();
    }

    public ContactsPage clickOnContactsLink() {
        contactsLink.click();
        return new ContactsPage();
    }

    public void clickOnNewContactLink()  {
        Actions actions = new Actions(driver);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        actions.moveToElement(contactsLink).build().perform();
        newContactLink.click();
    }
}
