package com.crm.pages;

import com.crm.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase {

    @FindBy(name = "username")
    WebElement userName;
    @FindBy(name = "password")
    WebElement password;
    @FindBy(xpath = "//input[@type='submit']")
    WebElement loginButton;
    @FindBy(xpath = "//a[contains(text(),'Sign Up')]")
    WebElement signUpButton;

    @FindBy(xpath = "//a[@class='navbar-brand']//img[@class='img-responsive']")
    WebElement crmLogo;

    public LoginPage(){
        PageFactory.initElements(driver,this);
    }
    public String validateLoginPageTitle() {
        return driver.getTitle();
    }
    public boolean validateCRMImage() {
        return crmLogo.isDisplayed();
    }
    public HomePage login(String un, String pwd) {
        userName.sendKeys(un);
        password.sendKeys(pwd);
        loginButton.click();

        return new HomePage();
    }
}
