package com.cookieclicker.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cookieclicker.qa.base.TestBase;

import static org.junit.Assert.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class CookiesCounter extends TestBase {


    public CookiesCounter() {
        PageFactory.initElements(driver, this);
    }




    @FindBy(tagName = "input")
    WebElement username;

    @FindBy(tagName = "button")
    WebElement start;

    @FindBy(id = "cookies")
    WebElement cookies;


    @FindBy(id = "factories")
    WebElement factories;

    @FindBy(id = "money")
    WebElement money;

    @FindBy(id = "cookies-to-sell")
    WebElement cookies_to_sell_text;

    @FindBy(id = "sell-cookies")
    WebElement sell_cookies_button;


    @FindBy(id = "factories-to-buy")
    WebElement factories_to_buy_text;

    @FindBy(id = "factories-to-buy")
    WebElement factories_to_buy_button;

    @FindBy(id = "click")
    WebElement addcookies;


    public CookiesCounter Userlogin() {
        username.sendKeys("sneha");
        System.out.println(username);
        start.click();
        return new CookiesCounter();
    }


    public CookiesCounter AddingCookies() throws InterruptedException {
        int initialCookieCount = Integer.parseInt(cookies.getText());
        addcookies.click();
        Thread.sleep(5000);
        int updatedCookieCount = Integer.parseInt(cookies.getText());
        assertTrue("Cookie count should increase after clicking the button", updatedCookieCount == initialCookieCount + 1);
        return new CookiesCounter();
    }

    public CookiesCounter sellingCookies() throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            addcookies.click();
            Thread.sleep(50);
        }
        assertEquals("Initial money should be 0", "0", money.getText());

        cookies_to_sell_text.clear();
        cookies_to_sell_text.sendKeys("10");
        sell_cookies_button.click();
        Thread.sleep(2000);
        String updatedMoney = money.getText();
        assertEquals("Money should be 2.5 after selling 10 cookies", "2.5", updatedMoney);
        return new CookiesCounter();
    }
}




