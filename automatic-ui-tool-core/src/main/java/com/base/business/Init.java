package com.base.business;

import com.base.business.LoginBusiness;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.playwright.utils.LaunchBrowser;
import org.testng.annotations.BeforeSuite;

public class Init {
    public Playwright playwright = Playwright.create();
    public LaunchBrowser launchBrowser;
    public  Page page;
    LoginBusiness loginBusiness;
    @BeforeSuite
    public void BeforeClass() {
        launchBrowser = new LaunchBrowser(playwright);
        page = launchBrowser.openBrowser("chrome");
        loginBusiness = new LoginBusiness(page);
        page.navigate(LoginBusiness.getHost());
        loginBusiness.login();
    }


}
