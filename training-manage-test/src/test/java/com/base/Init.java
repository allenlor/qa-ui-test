package com.base;

import com.base.business.LoginBusiness;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.playwright.utils.LaunchBrowser;
import org.testng.annotations.BeforeClass;

public class Init {
    Playwright playwright = Playwright.create();
    LaunchBrowser launchBrowser;
    Page page;
    LoginBusiness loginBusiness;
    @BeforeClass
    public void BeforeClass() {
        launchBrowser = new LaunchBrowser(playwright);
        page = launchBrowser.openBrowser("chrome");
        loginBusiness = new LoginBusiness(page);
        page.navigate("https://pro.coolcollege.cn/#/index-auth-login-new?source=ding");
        loginBusiness.login("18220783868","Aa111111");
    }

}
