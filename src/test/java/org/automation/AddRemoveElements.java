package org.automation;

import org.automation.pages.AddRemoveElementsPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class AddRemoveElements  extends BaseTest{
    private static int TOTAL_OF_DELETE_BUTTONS = 5;
    @Autowired
    AddRemoveElementsPage addRemoveElementsPage;

    @Test
    public void AddAndRemoveElements() {
        addRemoveElementsPage.visit();

        for (int i = 0; i < TOTAL_OF_DELETE_BUTTONS; i++) {
            addRemoveElementsPage.clickAddElement();
        }

        assertThat(addRemoveElementsPage.deleteButtons.size()).isEqualTo(TOTAL_OF_DELETE_BUTTONS);

        // When calling .click(), deleteButtons is updated and the size decreases, that's why we need to start backward
        for (int buttonIndex = TOTAL_OF_DELETE_BUTTONS - 1; buttonIndex >= 0; buttonIndex--) {
            addRemoveElementsPage.clickDeleteElement(buttonIndex);
        }

// Another solution
//        Iterator<WebElement> deleteButtonsIterator = addRemoveElementsPage.deleteButtons.iterator();
//        while(deleteButtonsIterator.hasNext()) {
//            WebElement deleteButton = deleteButtonsIterator.next();
//            deleteButton.click();
//        }

        assertThat(addRemoveElementsPage.deleteButtons.isEmpty()).isTrue();
    }
}
