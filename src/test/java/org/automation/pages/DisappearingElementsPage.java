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
public class DisappearingElementsPage {
    @Autowired
    WebDriver webDriver;

    @Autowired
    TestProperties testProperties;

    @FindAll(@FindBy(css = "ul li"))
    public List<WebElement> lists;

    public void visit() {
        webDriver.get(testProperties.getAppBaseUrl() + "disappearing_elements");
    }

    public void elementDisappearReappearLoadPage(int index) {
        webDriver.navigate().refresh();
    }

    public List<String> getElementsText() {
        List<String> elementsText = new ArrayList<>();

        for (WebElement element : lists) {
            elementsText.add(element.getText());
        }

        return elementsText;
    }
}
