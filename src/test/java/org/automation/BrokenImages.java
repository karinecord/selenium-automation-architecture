package org.automation;

import org.automation.pages.ABTestingPage;
import org.automation.pages.BrokenImagesPage;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BrokenImages extends BaseTest{
    private static int TOTAL_EXPECT_OF_IMAGES = 3;
    @Autowired
    BrokenImagesPage brokenImagesPage;

    @Test
    public void testImages() throws IOException {
        brokenImagesPage.visit();

        assertThat(brokenImagesPage.images.size()).isEqualTo(TOTAL_EXPECT_OF_IMAGES);
        for (WebElement image : brokenImagesPage.images) {
            if(!brokenImagesPage.isVisible(image)){
                System.out.println(image.getAttribute("outerHTML") + " is broken.");
            }
        }


    }
}