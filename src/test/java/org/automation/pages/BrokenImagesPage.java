package org.automation.pages;

import org.automation.architecture.TestProperties;
import org.automation.architecture.annotations.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.List;

@PageObject
public class BrokenImagesPage {

    @Autowired
    WebDriver webDriver;

    @Autowired
    TestProperties testProperties;

    @FindAll(@FindBy(xpath = "//div[contains(@class, 'example')]/img"))
    public List<WebElement> images;

    public void visit() {
        webDriver.get(testProperties.getAppBaseUrl() + "broken_images");
    }


    public boolean isVisible(WebElement image) {
        if (image != null) {
            if (image.getAttribute("naturalWidth").equals("0")) {
                //If natural width is equal to 0 probably it is broken
                return false;
            }

            return true;
        }
        return false;
    }
}
