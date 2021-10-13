package org.automation.pages;

import org.automation.architecture.TestProperties;
import org.automation.architecture.annotations.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;
@PageObject
public class ABTestingPage {
    @Autowired
    WebDriver webDriver;

    @Autowired
    TestProperties testProperties;

    @FindBy(xpath = "//div[contains(@class, 'example')]/h3")
    public WebElement testControlHeader;

    @FindBy(xpath = "//div[contains(@class, 'example')]/p")
    public WebElement testControlContent;

    public void visit() {
        webDriver.get(testProperties.getAppBaseUrl() + "abtest");
    }

}
