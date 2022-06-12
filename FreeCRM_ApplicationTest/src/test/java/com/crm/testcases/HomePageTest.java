package com.crm.testcases;

import com.crm.base.TestBase;
import com.crm.pages.ContactsPage;
import com.crm.pages.HomePage;
import com.crm.pages.LoginPage;
import com.crm.util.TestUtil;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest extends TestBase {

    LoginPage loginPage;
    HomePage homePage;
    TestUtil testUtil;
    ContactsPage contactsPage;

    public HomePageTest() {
        super();
    }
    @BeforeMethod
    public void setUp(){
        initialization();
        testUtil = new TestUtil();
        loginPage = new LoginPage();
        contactsPage = new ContactsPage();
        homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));  //login method is returning home page
    }

    @Test(priority = 1)
    public void verifyHomePageTitleTest() {
        String homePageTitle = homePage.verifyHomePageTitle();
        Assert.assertEquals(homePageTitle,"CRMPRO","Home page title not matched");  // message printed only if TC failed
    }

    @Test(priority = 2)
    public void verifyUsernameTest(){
        testUtil.switchToFrame();
        Assert.assertTrue(homePage.verifyCorrectUsername());
    }

    @Test(priority = 3)
    public void verifyContactsLinkTest() {
        testUtil.switchToFrame();
        contactsPage = homePage.clickOnContactsLink();
    }

    @AfterMethod
    public void closeDriver() {
        driver.quit();
    }
}
