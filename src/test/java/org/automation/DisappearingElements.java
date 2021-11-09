package org.automation;

import org.automation.pages.DisappearingElementsPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class DisappearingElements extends BaseTest {

    @Autowired
    DisappearingElementsPage disappearingElementsPage;

    @Test
    public void getElementLoadPage() {
        disappearingElementsPage.visit();

        List<String> startingElementsText = disappearingElementsPage.getElementsText();

        int elements = disappearingElementsPage.lists.size();

        disappearingElementsPage.elementDisappearReappearLoadPage(elements);

        List<String> elementsTextAfterLoad = disappearingElementsPage.getElementsText();

        if (elementsTextAfterLoad.equals(startingElementsText)) {
            assertThat(elementsTextAfterLoad).isEqualTo(startingElementsText);
        } else {
            assertThat(elementsTextAfterLoad).isNotEqualTo(startingElementsText);
        }
    }
}
