package org.automation.pages;

import org.automation.architecture.TestProperties;
import org.automation.architecture.annotations.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@PageObject
public class AddRemoveElementsPage {
    @Autowired
    WebDriver webDriver;

    @Autowired
    TestProperties testProperties;

    @FindBy(xpath = "//div[contains(@class, 'example')]/button")
    public WebElement addElementButton;

    @FindAll(@FindBy(xpath = "//div[contains(@id, 'elements')]/button"))
    public List<WebElement> deleteButtons;

    public void visit() {
        webDriver.get(testProperties.getAppBaseUrl() + "add_remove_elements/");
    }

    public void clickAddElement() {
        addElementButton.click();
    }

    public void clickDeleteElement(int deleteButtonIndex) {
        deleteButtons.get(deleteButtonIndex).click();
    }
}