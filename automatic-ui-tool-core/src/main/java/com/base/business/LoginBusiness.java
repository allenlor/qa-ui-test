package com.base.business;

import com.microsoft.playwright.Page;

public class LoginBusiness {

    LoginPage loginPage;
    Page page;

    public LoginBusiness(Page page) {
        this.loginPage = new LoginPage(page);
        this.page = page;
    }

    public void login(String username, String password) {
        loginPage.switchLoginStyle();
        loginPage.setUsername(username);
        loginPage.setPassword(password);
        loginPage.clickSubmitButton();
        loginPage.selectEnterprise();
    }


}
