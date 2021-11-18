package org.automation;

import org.automation.pages.DropdrownListPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class DropdownList extends BaseTest {

    private final static int DROPDOWN_1 = 0;
    private final static int DROPDOWN_2 = 0;

    @Autowired
    DropdrownListPage dropdownListPage;

    @Test
    public void verifyDropdownListOption1() {
        dropdownListPage.visit();

        dropdownListPage.selectDropdownListOption1();
        assertThat(dropdownListPage.getDropdownName(DROPDOWN_1).contains("Option 1"));
    }

    @Test
    public void verifyDropdownListOption2() {
        dropdownListPage.visit();

        dropdownListPage.selectDropdownListOption2();
        assertThat(dropdownListPage.getDropdownName(DROPDOWN_2).contains("Option 2"));
    }
}
