package com.base.business;

import com.alibaba.fastjson.JSONObject;
import com.config.ResourceFileUtil;
import com.microsoft.playwright.Page;

public class LoginPage {
    Page page;
    JSONObject loginPage = new ResourceFileUtil().parseJsonFile("PageElement", "LoginPage.json");

    public LoginPage(Page page) {
        this.page = page;
    }

    public void selectEnterprise() {
        page.click(loginPage.getString("enterpriseName"));
    }
    public void switchLoginStyle() {
        page.click(loginPage.getString("switchLoginStyle"));
    }

    public void setUsername(String username) {
        page.fill(loginPage.getString("userName"), username);
    }

    public void setPassword(String password) {
        page.fill(loginPage.getString("passWord"), password);
    }

    public void clickSubmitButton() {
        page.click(loginPage.getString("loginButton"));
    }
}
