package com.base.business;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPath;
import com.config.ResourceFileUtil;
import com.microsoft.playwright.Page;

public class LoginBusiness {

    LoginPage loginPage;
    Page page;
    static JSONObject accountObject = new ResourceFileUtil().parseJsonFile("env", "account.json");

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

    public void login() {
        if (System.getProperty("loginMobile") == null || System.getProperty("loginMobile").isEmpty()
                || System.getProperty("password") == null || System.getProperty("password").isEmpty()) {
            String loginAccount = (accountObject.getString("loginMobile"));
            String password = (accountObject.getString("password"));
            login(loginAccount, password);
        } else {
            login(System.getProperty("loginMobile"), // 从-D参数取
                    System.getProperty("password"));
        }
    }

    public static String  getHost(){
        String host = "";
        String env = System.getProperty("env");
        if (env == null || env.isEmpty()) {
            env = new ResourceFileUtil().parseJsonFile("env", "account.json").get("env").toString();
        }

        switch (env) {
            case "GREEN":
                host = "https://green.coolcollege.cn";
                break;
            case "PRO":
                host = "https://pro.coolcollege.cn";
                break;
            case "T":
                host = "https://test.coolcollege.cn";
                break;
            default:
                host = env;
                break;
        }
        return host;
    }
}
