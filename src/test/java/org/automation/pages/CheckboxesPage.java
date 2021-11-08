package org.automation.pages;

import org.automation.architecture.TestProperties;
import org.automation.architecture.annotations.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@PageObject
public class CheckboxesPage {

    @Autowired
    WebDriver webDriver;

    @Autowired
    TestProperties testProperties;

    @FindAll(@FindBy(css = "#checkboxes input"))
    public List<WebElement> checkboxes;

    public void visit() {
        webDriver.get(testProperties.getAppBaseUrl() + "checkboxes");
    }

    public Boolean isCheckboxSelected(int checkboxIndex) {
        return checkboxes.get(checkboxIndex).isSelected();
    }

    public void check(int checkboxIndex) {
         checkboxes.get(checkboxIndex).click();
    }

}
