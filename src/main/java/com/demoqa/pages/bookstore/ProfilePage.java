package com.demoqa.pages.bookstore;

import com.demoqa.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.assertj.core.api.Assertions.assertThat;

public class ProfilePage extends BasePage {

    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "userName-value")
    WebElement userNameValue;

    public ProfilePage verifyUserName(String name) {
        assertThat(isContains(name, userNameValue)).isTrue();
        return this;
    }
}
