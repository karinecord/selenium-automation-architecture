package org.automation.pages;

import org.automation.architecture.TestProperties;
import org.automation.architecture.annotations.PageObject;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@PageObject
public class ContextMenuPage {
    @Autowired
    WebDriver webDriver;

    @Autowired
    TestProperties testProperties;

    @FindBy(id = "hot-spot")
    public WebElement openContextMenu;

    public void visit() {
        webDriver.get(testProperties.getAppBaseUrl() + "context_menu");
    }

    public void openContentMenu(){
        Actions a = new Actions(webDriver);
        a.moveToElement(openContextMenu).contextClick().build().perform();

        Alert alert = webDriver.switchTo().alert();
        alert.dismiss();


    }
}
