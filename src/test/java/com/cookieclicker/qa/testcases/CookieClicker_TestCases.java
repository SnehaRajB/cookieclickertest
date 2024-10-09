package com.cookieclicker.qa.testcases;

import com.cookieclicker.qa.base.TestBase;
import com.cookieclicker.qa.pages.CookiesCounter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class CookieClicker_TestCases extends TestBase{

    CookiesCounter cookiesCounter;

    public CookieClicker_TestCases() {
        super();
    }

    @BeforeSuite(alwaysRun = true)
    public void setUp() {
        initializaton();
        cookiesCounter = new CookiesCounter();

    }

    @Test(groups = { "Login Functionality" })
        public void TC001_EnterUsernameToLogin() {

            cookiesCounter.Userlogin();

    }

    @Test(groups = { "Adding cookies Functionality" })
    public void TC002_AddingFirstCookie() throws InterruptedException {

        cookiesCounter.AddingCookies();

    }

    @Test(groups = { "Selling cookies Functionality" })
    public void TC003_SellingCookies() throws InterruptedException {

        cookiesCounter.sellingCookies();

    }



    @AfterSuite(alwaysRun = true)
    public void tearDown() {
        tearDownMain();
    }

}
