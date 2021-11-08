package org.automation;

import org.automation.pages.AddRemoveElementsPage;
import org.automation.pages.CheckboxesPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CheckboxeTest extends BaseTest{

    private final static int CHECKBOX_1 = 0;
    private final static int CHECKBOX_2 = 1;

    @Autowired
    CheckboxesPage inputPage;

    public void verifyCheckboxes(){
        inputPage.visit();

        assertThat(inputPage.isCheckboxSelected(CHECKBOX_1 )).isFalse();
        assertThat(inputPage.isCheckboxSelected(CHECKBOX_2)).isTrue();

        inputPage.check(CHECKBOX_1);

        assertThat(inputPage.isCheckboxSelected(CHECKBOX_1 )).isTrue();

        inputPage.check(CHECKBOX_2);
        assertThat(inputPage.isCheckboxSelected(CHECKBOX_2 )).isFalse();
    }
}
