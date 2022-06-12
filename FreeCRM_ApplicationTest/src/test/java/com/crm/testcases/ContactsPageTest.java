package com.crm.testcases;

import com.crm.base.TestBase;
import com.crm.pages.ContactsPage;
import com.crm.pages.HomePage;
import com.crm.pages.LoginPage;
import com.crm.util.TestUtil;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ContactsPageTest extends TestBase {

    LoginPage loginPage;
    HomePage homePage;
    TestUtil testUtil;
    ContactsPage contactsPage;
    String sheetName = "contacts";

    public ContactsPageTest() {
        super();
    }
    @BeforeMethod
    public void setUp(){
        initialization();
        testUtil = new TestUtil();
        contactsPage = new ContactsPage();
        loginPage = new LoginPage();
        homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
        testUtil.switchToFrame();
        contactsPage = homePage.clickOnContactsLink();      // remove this while creating new contact
    }

    @Test(priority = 1)
    public void verifyContactsPageLabel() {
        Assert.assertTrue(contactsPage.verifyContactsLabel(),"Contacts list is missing on the page"); // message displayed only if TC failed
    }

    @Test(priority = 2)
    public void selectContactsTest() {
        contactsPage.selectContactsByName("Demo Name");
    }

    @Test(priority = 3)
    public void selectMultipleContactsTest() {
        contactsPage.selectContactsByName("Datta Bhure");
        contactsPage.selectContactsByName("Demo Name");
    }

    @Test(priority = 4)
    public void validateCreateNewSingleContact() {
        homePage.clickOnNewContactLink();
        contactsPage.createNewContact("Mr.","krishna","prakash","Google");
    }

     @DataProvider
     public Object[][] getCRMTestData(){
         Object data[][] = TestUtil.getTestData(sheetName);
         return data;
     }

     @Test(priority = 5,dataProvider = "getCRMTestData")
     public void validateCreateNewMultipleContact(String title, String firstName, String lastName, String company) {
         homePage.clickOnNewContactLink();
         contactsPage.createNewContact(title,firstName,lastName,company);
     }

    @AfterMethod
    public void closeDriver() {
        driver.quit();
    }
}
