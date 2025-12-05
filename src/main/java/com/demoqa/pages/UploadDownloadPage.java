package com.demoqa.pages;

import com.demoqa.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.assertj.core.api.Assertions.assertThat;

public class UploadDownloadPage extends BasePage {

    private static final String URL = "https://demoqa.com/upload-download";

    public UploadDownloadPage(WebDriver driver) {
        super(driver);
    }

    public UploadDownloadPage open() {
        driver.get(URL);
        return this;
    }

    @FindBy(id = "uploadFile")
    WebElement uploadInput;

    @FindBy(id = "uploadedFilePath")
    WebElement uploadedFilePath;

    public UploadDownloadPage uploadFile(String path) {
        uploadInput.sendKeys(path);
        return this;
    }

    public UploadDownloadPage verifyUploadedFileName(String fileName) {
        assertThat(shouldHaveText(uploadedFilePath, fileName, 5)).isTrue();
        return this;
    }
}
