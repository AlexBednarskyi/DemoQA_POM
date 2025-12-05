package com.demoqa.pages.alertsFrameWindows;

import com.demoqa.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WindowsPage extends BasePage {

    public WindowsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "tabButton")
    WebElement tabButton;

    @FindBy(id = "sampleHeading")
    WebElement sampleHeading;

    public WindowsPage clickOnNewTabButton() {
        clickWithJS(tabButton, 0, 200);
        return this;
    }

    public WindowsPage switchToNewTab(int index) {
        switchToNewTabWindow(index);
        return this;
    }

    public String getNewTabTitleText() {
        return sampleHeading.getText();
    }
}
