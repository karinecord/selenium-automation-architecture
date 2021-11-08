package org.automation;

import org.automation.pages.CheckboxesPage;
import org.automation.pages.ContextMenuPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ContextMenu extends BaseTest {
    @Autowired
    ContextMenuPage contextMenuPage;

    @Test
    public void verifyAlertDisplay(){
        contextMenuPage.visit();
        contextMenuPage.openContentMenu();

        assertThat(contextMenuPage.openContextMenu.isDisplayed()).isTrue();

    }
}
