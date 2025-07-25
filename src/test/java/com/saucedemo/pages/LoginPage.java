package com.saucedemo.pages;

import com.saucedemo.utilities.BrowserUtils;
import com.saucedemo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage extends BasePage{

    public LoginPage(){PageFactory.initElements(Driver.get(), this);}

    @FindBy(id="user-name")
    public  WebElement usernameSaucelab;

    @FindBy(id="password")
    public  WebElement passwordSaucelab;

    @FindBy(id="login-button")
    public  WebElement loginBtn;

    @FindBy(xpath = "//span[@class='title']")
    public WebElement mainPageProduct;

    @FindBy(xpath = "//h3")
    public WebElement loginError;

    @FindBy(id="react-burger-menu-btn")
    public WebElement menuButton;

    @FindBy(id="logout_sidebar_link")
    public WebElement sideLogOut;




    public void login(String userNameStr, String passwordStr) {

        usernameSaucelab.clear();
        usernameSaucelab.sendKeys(userNameStr);
        BrowserUtils.waitFor(0.5);
        passwordSaucelab.clear();
        passwordSaucelab.sendKeys(passwordStr);
        BrowserUtils.waitFor(0.5);
        loginBtn.click();

    }


}
