package com.demoqa.tests;

import com.demoqa.core.TestBase;
import com.demoqa.pages.UploadDownloadPage;
import org.junit.jupiter.api.Test;          // JUnit 5
import java.nio.file.Paths;

public class FileUploadTests extends TestBase {

    @Test
    public void fileUpload_displaysFileName() {

        String filePath = Paths.get("src", "test", "resources", "test-file.txt")
                .toAbsolutePath()
                .toString();

        new UploadDownloadPage(driver)
                .open()
                .uploadFile(filePath)
                .verifyUploadedFileName("test-file.txt");
    }
}
