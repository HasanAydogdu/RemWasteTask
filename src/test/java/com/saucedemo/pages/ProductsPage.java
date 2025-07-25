package com.saucedemo.pages;

import com.saucedemo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductsPage extends BasePage {
    public ProductsPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath = "//span[@class='title']")
    public WebElement pageTitle;

    @FindBy(id="add-to-cart-sauce-labs-backpack")
    public WebElement addBackPack;

    @FindBy(id="add-to-cart-sauce-labs-bolt-t-shirt")
    public WebElement addBoltTshirt;

    @FindBy(id="add-to-cart-sauce-labs-bike-light")
    public WebElement addBikeLight;

    @FindBy(xpath = "//div[@class='shopping_cart_container']")
    public WebElement openChart;

    @FindBy(xpath = "//div[@class='cart_item']")
    public List<WebElement> chartItemsList;

    @FindBy(xpath = "//button[@id='checkout']")
    public WebElement buttonCheckout;

    @FindBy(xpath = "//span[@class='title'][.='Your Cart']")
    public WebElement cartTitle;

    @FindBy(id="first-name")
    public WebElement fName;

    @FindBy(id="last-name")
    public WebElement lastName;

    @FindBy(id="postal-code")
    public WebElement zipCode;

    @FindBy(id="continue")
    public WebElement buttonContinuie;

    @FindBy(id="finish")
    public WebElement buttonFinish;

    @FindBy(xpath = "//h2")
    public WebElement thankYouTitle;

    @FindBy(xpath = "//button[contains(@id,'remove')]")
    public List<WebElement> removeButtonList;

    @FindBy(id="continue-shopping")
    public WebElement buttonContinueShopping;







}
