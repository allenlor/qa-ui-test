package com.playwright.utils;

import com.microsoft.playwright.*;
import java.util.Collections;


public class LaunchBrowser {
    public LaunchBrowser(Playwright playWright) {
        this.playWright = playWright;
    }

    Playwright playWright;


    public BrowserContext createContext(Browser browser) {
        BrowserContext context = browser.newContext(new Browser.NewContextOptions()
                .setIgnoreHTTPSErrors(true)
                .setJavaScriptEnabled(true)
                //此处可以理解为设定指定窗口启动
                .setViewportSize(1980, 1080));
        return context;
    }

    public Page openBrowser(String name) {
        Browser browser = null;
        Page page = null;
        try {
            switch (name) {
                case "firefox":
                    browser = playWright.firefox().launch(launchOptions());
                    page = new LaunchBrowser(playWright).createContext(browser).newPage();
                    break;
                case "chrome":
                    browser = playWright.chromium().launch(launchOptions());
                    page = new LaunchBrowser(playWright).createContext(browser).newPage();
                    break;
                case "edge":
                    browser = playWright.chromium().launch(new BrowserType.LaunchOptions()
                            .setArgs(Collections.singletonList("--able-auto-maximize-for-tests"))
                            .setChannel("msedge")
                            .setHeadless(false)
                            .setSlowMo(200)
                            .setTimeout(3000));
                    page = new LaunchBrowser(playWright).createContext(browser).newPage();
                    break;
                case "h5":
                    browser = playWright.chromium().launch(launchOptions());
                    page = browser.newContext(new Browser.NewContextOptions()
                            .setUserAgent("Mozilla/5.0 (Linux; Android 8.0; Pixel 2 Build/OPD3.170816.012) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/75.0.3765.0 Mobile Safari/537.36")
                            .setViewportSize(411, 731)
                            .setDeviceScaleFactor(2.625)
                            .setIsMobile(true)
                            .setHasTouch(true)
                            .setLocale("en-US")).newPage();

            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return page;
    }
    public static BrowserType.LaunchOptions launchOptions(){
        return new BrowserType.LaunchOptions()
                .setArgs(Collections.singletonList("--able-auto-maximize-for-tests"))
                .setHeadless(false)
                .setSlowMo(200)
                .setTimeout(3000);
    }

}
