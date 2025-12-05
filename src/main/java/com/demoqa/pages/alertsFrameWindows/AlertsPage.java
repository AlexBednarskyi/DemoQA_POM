package com.demoqa.pages.alertsFrameWindows;

import com.demoqa.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AlertsPage extends BasePage {

    public AlertsPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(id = "timerAlertButton")
    WebElement timerAlertButton;

    public AlertsPage clickOnTimerAlertButton() {
        clickWithJS(timerAlertButton, 0, 300);
        return this;
    }

    public boolean isTimerAlertOpened(int seconds) {
        return isAlertPresent(seconds);
    }


    @FindBy(id = "confirmButton")
    WebElement confirmButton;

    public AlertsPage clickOnConfirmButton() {
        clickWithJS(confirmButton, 0, 300);
        return this;
    }

    public AlertsPage selectResult(String result) {
        if ("Ok".equals(result)) {
            driver.switchTo().alert().accept();
        } else if ("Cancel".equals(result)) {
            driver.switchTo().alert().dismiss();
        }
        return this;
    }

    @FindBy(id = "confirmResult")
    WebElement confirmResult;

    public boolean isConfirmResultContains(String expectedText) {
        return isContains(expectedText, confirmResult);
    }


    @FindBy(id = "promtButton")
    WebElement promtButton;

    public AlertsPage clickOnPromtButton() {
        clickWithJS(promtButton, 0, 300);
        return this;
    }

    public AlertsPage sendMessageToAlert(String text) {
        if (text != null) {
            driver.switchTo().alert().sendKeys(text);
            driver.switchTo().alert().accept();
        }
        return this;
    }

    @FindBy(id = "promptResult")
    WebElement promptResult;

    public boolean isPromptResultContains(String expectedText) {
        return isContains(expectedText, promptResult);
    }
}
