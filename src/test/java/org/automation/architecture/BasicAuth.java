package org.automation.architecture;

import org.automation.BaseTest;
import org.automation.pages.ABTestingPage;
import org.automation.pages.BasicAuthPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BasicAuth extends BaseTest {
    @Autowired
    BasicAuthPage basicAuthPage;

    @Test
    public void AuthPage() {
        basicAuthPage.visit("admin", "admin");

        String successMsg = "Congratulations! You must have the proper credentials";

        assertThat(basicAuthPage.getTextAuth().contains(successMsg));


    }
}
