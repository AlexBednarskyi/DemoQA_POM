package com.demoqa.pages;

import com.demoqa.core.BasePage;
import com.demoqa.pages.alertsFrameWindows.AlertsPage;
import com.demoqa.pages.alertsFrameWindows.FramesPage;
import com.demoqa.pages.alertsFrameWindows.WindowsPage;
import com.demoqa.pages.bookstore.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SidePanel extends BasePage {
    public SidePanel(WebDriver driver) {
        super(driver);
    }

@FindBy(xpath = "//span[.='Login']")
    WebElement login;

    public LoginPage selectLogin() {
        //clickWithJS(login,0,400);
        clickWithJS(login,0,600);
        return new LoginPage(driver);
    }
    @FindBy(xpath = "//span[.='Text Box']")
    WebElement textBox;

    public JSExecutor selectTextBox() {
        clickWithJS(textBox,0,600);
        return new JSExecutor(driver);
    }
    @FindBy(xpath = "//span[.='Alerts']")
    WebElement alerts;

    public AlertsPage selectAlerts() {
        clickWithJS(alerts,0,200);
        return new AlertsPage(driver);
    }
    @FindBy(xpath = "//span[.='Browser Windows']")
    WebElement browserWindows;

    public WindowsPage selectWindows() {
        clickWithJS(browserWindows,0,200);
        return new WindowsPage(driver);
    }

    @FindBy(xpath = "//span[.='Frames']")
    WebElement frames;

    public FramesPage selectFrame() {
        clickWithJS(frames,0,300);
        return new FramesPage(driver);
    }
    @FindBy(xpath = "//span[.='Nested Frames']")
    WebElement nestedFrames;
    public FramesPage selectNestedFrames() {
        clickWithJS(nestedFrames,0,500);

        return new FramesPage(driver);
    }
}
