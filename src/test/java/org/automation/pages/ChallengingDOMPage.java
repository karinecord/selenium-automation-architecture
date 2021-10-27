package org.automation.pages;

import org.automation.architecture.TestProperties;
import org.automation.architecture.annotations.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@PageObject
public class ChallengingDOMPage {
    @Autowired
    WebDriver webDriver;

    @FindBy(xpath = "//*[@id=\"content\"]/div/div/div/div[2]/table/tbody/tr")
    public List<WebElement> rows;

    @FindBy(xpath = "//a[@class='button']")
    public WebElement button;

    @FindAll(@FindBy(xpath = "//*[@class='large-2 columns']/a[contains(@class, 'button')]"))
    public List<WebElement> buttonsList;

    @FindBy(xpath = "//a[@class='button alert']")
    public WebElement buttonAlert;

    @FindBy(xpath = "//a[@class='button success']")
    public WebElement buttonSuccess;

    @FindAll(@FindBy(xpath = "//div[@id=\"content\"]/script"))
    public List<WebElement> answerChanges;


    @Autowired
    TestProperties testProperties;

    public void visit() {
        webDriver.get(testProperties.getAppBaseUrl() + "challenging_dom");
    }

    public String getCurrentUrl() {

        return webDriver.getCurrentUrl();
    }

    public void clickEdit(int rowIndex) {
        WebElement row = rows.get(rowIndex);
        WebElement editButton = row.findElement(By.xpath("//a[text()='edit']"));
        editButton.click();
    }

    public void clickDelete(int rowIndex) {

        WebElement row = rows.get(rowIndex);
        WebElement deleteButton = row.findElement(By.xpath("//a[text()='delete']"));
        deleteButton.click();
    }

    public void clickButton() {
        button.click();
    }

    public String getAnswer() {
        String newAnswer = "";

        for (WebElement answerChange : answerChanges) {
            String oldAnswer = answerChange.getAttribute("innerHTML");
            newAnswer = oldAnswer.substring(oldAnswer.indexOf("Answer"), oldAnswer.indexOf("',"));
        }

        return newAnswer;
    }

    public void clickButtonAlert() {
        buttonAlert.click();
    }

    public String getAlertButtonText() {
        return buttonAlert.getText();
    }

    public void clickButtonSuccess() {
        buttonSuccess.click();
    }

    public String getSuccessButtonText() {
        return buttonSuccess.getText();
    }

    public List<String> getButtonsText() {
        List<String> buttonsText = new ArrayList<>();

        for (WebElement button : buttonsList) {
            buttonsText.add(button.getText());
        }

        return buttonsText;
    }

    public void clickOnAButtonInTheList(int buttonIndex) {
        buttonsList.get(buttonIndex).click();
    }

}


