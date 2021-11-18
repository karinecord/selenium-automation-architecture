package org.automation.pages;

import org.automation.architecture.TestProperties;
import org.automation.architecture.annotations.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@PageObject
public class DropdrownListPage {

    @Autowired
    WebDriver webDriver;

    @Autowired
    TestProperties testProperties;

    @FindAll(@FindBy(id = "dropdown"))
    public List<WebElement> dropdown;

    public void visit() {
        webDriver.get(testProperties.getAppBaseUrl() + "dropdown");
    }

    public void selectDropdownListOption1() {
        Select option = new Select(webDriver.findElement(By.id("dropdown")));
        option.selectByVisibleText("Option 1");
        option.selectByIndex(1);
    }

    public void selectDropdownListOption2() {
        Select option = new Select(webDriver.findElement(By.id("dropdown")));
        option.selectByVisibleText("Option 2");
        option.selectByIndex(2);
    }

    public String getDropdownName(int index){
        return dropdown.get(index).getText();
    }

}
