package com.demoqa.pages.alertsFrameWindows;

import com.demoqa.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class FramesPage extends BasePage {

    public FramesPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(css = "iframe")
    private List<WebElement> iframes;

    @FindBy(id = "sampleHeading")
    private WebElement sampleHeading;

    @FindBy(id = "frame1")
    private WebElement frame1;

    @FindBy(css = ".text-center")
    private WebElement title;

    @FindBy(css = "body")
    private WebElement body;


    public FramesPage returnListOfIframes() {
        System.out.println("The total number of iframes is " + iframes.size());
        return this;
    }

    public FramesPage switchToIframeByIndex(int index) {
        driver.switchTo().frame(index);
        return this;
    }

    public FramesPage switchToIframeById() {
        driver.switchTo().frame(frame1);
        return this;
    }

    public FramesPage switchToMainPage() {
        driver.switchTo().defaultContent();
        return this;
    }

    public FramesPage switchToParentIframe() {
        driver.switchTo().frame(frame1);
        return this;
    }

    public FramesPage switchToChildIframeByIndex(int index) {
        driver.switchTo().frame(index);
        return this;
    }


    public boolean isIframeTitleContains(String expectedText) {
        return isContains(expectedText, sampleHeading);
    }

    public boolean isMainPageTitleContains(String expectedText) {
        return isContains(expectedText, title);
    }

    public boolean isBodyContains(String expectedText) {
        return isContains(expectedText, body);
    }

    public int getIframesCount() {
        return iframes.size();
    }
}
