package org.automation;

import org.automation.pages.ABTestingPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ABTest extends BaseTest {
    @Autowired
    ABTestingPage abTestingPage;

    @Test
    public void Example() {
        abTestingPage.visit();

        assertThat(abTestingPage.testControlHeader.getText()).contains("A/B Test");

        String testControlContentExpected = "Also known as split testing. This is a way in which businesses are able " +
                "to simultaneously test and learn different versions of a page to see which text and/or functionality " +
                "works best towards a desired outcome (e.g. a user action such as a click-through).";
        assertThat(abTestingPage.testControlContent.getText()).contains(testControlContentExpected);
    }

}
