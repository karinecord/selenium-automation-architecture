package org.automation;

import org.automation.pages.ChallengingDOMPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Random;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ChallengingDOM extends BaseTest {

    @Autowired
    ChallengingDOMPage challengingDOMPage;

    @Test
    public void VerifyURLEdit() {
        challengingDOMPage.visit();
        challengingDOMPage.clickEdit(1);

        assertThat(challengingDOMPage.getCurrentUrl()).contains("#edit");
    }

    @Test
    public void VerifyURLRemove() {
        challengingDOMPage.visit();
        challengingDOMPage.clickDelete(1);

        assertThat(challengingDOMPage.getCurrentUrl()).contains("#delete");
    }

    //Verify simple button - Click --> answer
    @Test
    public void answerChangesOnRefresh() {
        challengingDOMPage.visit();
        // get value of answer
        String startingValue = challengingDOMPage.getAnswer();
        // button click
        challengingDOMPage.clickButton();
        // get new value after clicking
        String afterButtonClickedValue = challengingDOMPage.getAnswer();
        // compare starting value to new answer
        assertThat(afterButtonClickedValue).isNotEqualTo(startingValue);
    }


    //Verify alert button - click --> answer
    @Test
    public void testAnswerChangesOnAlertButtonClick() {
        challengingDOMPage.visit();
        // get value of answer
        String startingValue = challengingDOMPage.getAnswer();
        // button click
        challengingDOMPage.clickButtonAlert();
        // get new value after clicking
        String afterButtonClickedValue = challengingDOMPage.getAnswer();
        // compare starting value to new answer
        assertThat(afterButtonClickedValue).isNotEqualTo(startingValue);
    }

    //Verify success button - click -> answer
    @Test
    public void testAnswerChangesOnSuccessButtonClick() {
        challengingDOMPage.visit();
        // get value of answer
        String startingValue = challengingDOMPage.getAnswer();
        // button click
        challengingDOMPage.clickButtonSuccess();
        // get new value after clicking
        String afterButtonClickedValue = challengingDOMPage.getAnswer();
        // compare starting value to new answer
        assertThat(afterButtonClickedValue).isNotEqualTo(startingValue);
    }

    //Verify shuffle after button clicks
    @Test
    public void testButtonsShuffleOnAnyButtonClick() {
        challengingDOMPage.visit();

        List<String> startingButtonsText = challengingDOMPage.getButtonsText();

        int buttonsTotal = challengingDOMPage.buttonsList.size();
        // Generates a number between 0 and buttonsTotal-1. Ex. size=3 -> min: 0, max: 2
        // If buttonsTotal is not specified, nextInt can generate a number bigger than the number of items in the buttonsList
        int buttonIndex = new Random().nextInt();

        challengingDOMPage.clickOnAButtonInTheList(buttonIndex);

        List<String> buttonsTextAfterClick = challengingDOMPage.getButtonsText();

        assertThat(buttonsTextAfterClick).isNotEqualTo(startingButtonsText);
    }
}
