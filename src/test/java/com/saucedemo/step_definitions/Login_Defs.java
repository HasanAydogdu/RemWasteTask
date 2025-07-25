package com.saucedemo.step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.saucedemo.pages.LoginPage;
import com.saucedemo.utilities.BrowserUtils;
import com.saucedemo.utilities.ConfigurationReader;
import com.saucedemo.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;

public class Login_Defs {
    LoginPage loginPage = new LoginPage();

    @When("Scenario Started {string}")
    public void scenario_Started(String message) {
        System.out.println("----------------------------------------------------------------------");
        System.out.println("Scenario Name: "+message);
//        System.out.println("------------------------------------------------------------------------");
    }


    @Given("User logs in to {string}")
    public void userLogsInTo(String environment) {
        System.out.println("environment = " + environment);

        String url = ConfigurationReader.get(environment);
        Driver.get().get(url);

        String username =null;
        String password =null;

        if(environment.equals("sauceLabs")){
            username = ConfigurationReader.get("sauceLabsStandartUser");
            password = ConfigurationReader.get("sauceLabsPass");

        }

        LoginPage loginPage = new LoginPage();
        BrowserUtils.waitFor(0.2);
//        System.out.println("username = " + username);
//        System.out.println("password = " + password);
        loginPage.login(username,password);

        BrowserUtils.waitFor(5);

    }

    @Given("User logs in to {string} as {string} with {string} password")
    public void userLogsInToAsWithPassword(String environment, String username, String password) {
        System.out.println("environment = " + environment);

        String url = ConfigurationReader.get(environment);
        Driver.get().get(url);

        if(username.equals("sauceLabsStandartUser")){
            username = ConfigurationReader.get("sauceLabsStandartUser");
            password = ConfigurationReader.get("sauceLabsPass");

        }else if(username.equals("sauceLabsWrongUser")) {
            username = ConfigurationReader.get("sauceLabsWrongUser");
            password = ConfigurationReader.get("sauceLabsPass");

        }

        LoginPage loginPage = new LoginPage();
        BrowserUtils.waitFor(0.2);
//        System.out.println("username = " + username);
//        System.out.println("password = " + password);
        loginPage.login(username,password);

        BrowserUtils.waitFor(5);
    }

    @Then("Verify Used Logged")
    public void verify_used_logged() {
        BrowserUtils.waitFor(2);

        String products = loginPage.mainPageProduct.getText();

        Assert.assertEquals("Products",products);
    }

    @Then("Verify User Unable To Login")
    public void verify_user_unable_to_login() {
        String userWarning = loginPage.loginError.getText();

        BrowserUtils.waitFor(2);

        Assert.assertEquals("Epic sadface: Username and password do not match any user in this service",userWarning);

    }

    @Then("User Logs OUT")
    public void user_logs_out() {
        loginPage.menuButton.click();
        BrowserUtils.waitFor(1.5);

        loginPage.sideLogOut.click();
        BrowserUtils.waitFor(1);
    }


}
