package com.saucedemo.step_definitions;

import com.saucedemo.pages.ProductsPage;
import com.saucedemo.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class Products_Defs {
    ProductsPage productsPage = new ProductsPage();

    @Then("Add Product to Chart")
    public void add_product_to_chart() {
        productsPage.addBackPack.click();
        BrowserUtils.waitFor(1);
        productsPage.addBoltTshirt.click();
        BrowserUtils.waitFor(1);
        productsPage.addBikeLight.click();
        BrowserUtils.waitFor(1);

    }

    @Then("Open Chart Page")
    public void open_chart_page() {
        productsPage.openChart.click();
        BrowserUtils.waitFor(1);

        Assert.assertTrue(productsPage.cartTitle.isDisplayed());
    }

    @Then("Verify Items Added")
    public void verify_items_added() {

        Assert.assertTrue(productsPage.chartItemsList.size()>0);
    }

    @Then("Open Payments")
    public void open_payments() {
        productsPage.buttonCheckout.click();
        BrowserUtils.waitFor(1);

        String title = productsPage.pageTitle.getText();

        Assert.assertEquals("Checkout: Your Information", title);
    }

    @Then("Fill {string} as Name {string} as Lastname {string} as ZipCode")
    public void fill_as_name_as_lastname_as_zip_code(String name, String lastName, String zipCode) {
        productsPage.fName.sendKeys(name);
        productsPage.lastName.sendKeys(lastName);
        productsPage.zipCode.sendKeys(zipCode);
        BrowserUtils.waitFor(1);

        productsPage.buttonContinuie.click();
        BrowserUtils.waitFor(1);
    }

    @Then("Buy Products")
    public void buy_products() {
        String title = productsPage.pageTitle.getText();

        Assert.assertEquals("Checkout: Overview", title);

        productsPage.buttonFinish.click();
        BrowserUtils.waitFor(1);

        title = productsPage.pageTitle.getText();

        Assert.assertEquals("Checkout: Complete!", title);
        Assert.assertEquals(productsPage.thankYouTitle.getText(),"Thank you for your order!");
    }


    @Then("Remove All Items")
    public void remove_all_items() {
        while (productsPage.removeButtonList.size()>0) {
            productsPage.removeButtonList.get(0).click();
            BrowserUtils.waitFor(1);

        }

        Assert.assertEquals(0, productsPage.chartItemsList.size());
    }

    @Then("Open Products Page")
    public void open_products_page() {
        productsPage.buttonContinueShopping.click();
        BrowserUtils.waitFor(1.5);

        Assert.assertEquals("Products",productsPage.pageTitle.getText());
    }




}
