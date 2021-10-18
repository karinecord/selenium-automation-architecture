package org.automation.pages;

import org.automation.architecture.TestProperties;
import org.automation.architecture.annotations.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;


@PageObject
public class BasicAuthPage {
    @Autowired
    WebDriver webDriver;

    @Autowired
    TestProperties testProperties;

    @FindBy(css = "p")
    public WebElement text;

    public void visit(String login, String password) {
        int endOfHttps = 8;
        StringBuilder baseUrl = new StringBuilder(testProperties.getAppBaseUrl());

        String authentication = login + ":" + password + "@";
        String authUrl = baseUrl.insert(endOfHttps, authentication).toString();

        webDriver.get(authUrl + "basic_auth");
    }

    public String getTextAuth() {
        return text.getText();
    }
}
