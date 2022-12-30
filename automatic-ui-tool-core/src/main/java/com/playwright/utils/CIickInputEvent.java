package com.playwright.utils;

import com.microsoft.playwright.Page;
import org.apache.log4j.Logger;

public class CIickInputEvent {
    Page page;
    public CIickInputEvent(Page page) {
        this.page = page;
    }

    /**
     * 定位输入框并输入字段内容
     * @param selector   元素名称
     * @param value    输入值
     */
    public void Input(String selector, String value){
        page.fill(selector,value);
        page.locator("").fill("");
    }
}
