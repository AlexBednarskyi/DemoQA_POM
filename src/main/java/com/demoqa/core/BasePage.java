package com.demoqa.core;

import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class BasePage {

    protected WebDriver driver;
    public static JavascriptExecutor js;
    public static SoftAssertions softly;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        js = (JavascriptExecutor) driver;
        softly = new SoftAssertions();
    }

    public void scrollWithJS(int x,int y){
        js.executeScript("window.scrollBy("+ x + "," + y +")");
    }
    public void clickWithJS(WebElement element,int x,int y){
        scrollWithJS(x,y);
        click(element);
    }

    public void typeWithJS(WebElement element,String text, int x, int y){
        scrollWithJS(x,y);
        type(element,text);
    }



    public void click(WebElement element){
        element.click();
    }
    public void type(WebElement element,String text){
        if(text !=null){
            click(element);
            element.clear();
            element.sendKeys(text);
        }
    }
    public boolean isAlertPresent(int seconds) {
        Alert alert = getWait(seconds)
                .until(ExpectedConditions.alertIsPresent());
        if (alert == null) {
            return false;
        } else {
            driver.switchTo().alert().accept();
            return true;
        }
    }
    public WebDriverWait getWait(int seconds) {
        return new WebDriverWait(driver, Duration.ofSeconds(seconds));
    }

    public boolean isContains(String text, WebElement element) {
        return element.getText().contains(text);
    }

    public boolean shouldHaveText(WebElement element, String text, int time) {
        return getWait(time)
                .until(ExpectedConditions.textToBePresentInElement(element,text));
    }
    public void switchToNewTabWindow(int index) {
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(index));
    }
}

