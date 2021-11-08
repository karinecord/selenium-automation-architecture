package org.automation;

import org.automation.pages.AuthenticationPage;
import org.automation.pages.BrokenImagesPage;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class AuthenticationText extends BaseTest{

    @Autowired
    AuthenticationPage authenticationPage;

    @Test
    public void test() {
        authenticationPage.visit();

        authenticationPage.GetAuthentication("admin", "admin");

        assertThat(authenticationPage.getTextAuth().contains("Congratulations! You must have the proper credentials."));



    }
}
