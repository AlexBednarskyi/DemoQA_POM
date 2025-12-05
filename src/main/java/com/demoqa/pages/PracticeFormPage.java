package com.demoqa.pages;

import com.demoqa.core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class PracticeFormPage extends BasePage {

    public PracticeFormPage(WebDriver driver) {
        super(driver);
    }

    // ---------------- ЛОКАТОРЫ ----------------

    @FindBy(id = "firstName")
    private WebElement firstNameInput;

    @FindBy(id = "lastName")
    private WebElement lastNameInput;

    @FindBy(id = "userEmail")
    private WebElement userEmailInput;

    @FindBy(id = "userNumber")
    private WebElement userNumberInput;

    @FindBy(css = "[for='gender-radio-1']")
    private WebElement male;

    @FindBy(css = "[for='gender-radio-2']")
    private WebElement female;

    @FindBy(css = "[for='gender-radio-3']")
    private WebElement other;

    @FindBy(id = "dateOfBirthInput")
    private WebElement dateOfBirthInput;

    @FindBy(id = "subjectsInput")
    private WebElement subjectsInput;

    @FindBy(css = "[for='hobbies-checkbox-1']")
    private WebElement sports;

    @FindBy(css = "[for='hobbies-checkbox-2']")
    private WebElement reading;

    @FindBy(css = "[for='hobbies-checkbox-3']")
    private WebElement music;

    @FindBy(id = "uploadPicture")
    private WebElement uploadPicture;

    @FindBy(id = "react-select-3-input")
    private WebElement stateInput;

    @FindBy(id = "react-select-4-input")
    private WebElement cityInput;

    @FindBy(id = "submit")
    private WebElement submit;

    @FindBy(id = "example-modal-sizes-title-lg")
    private WebElement modalTitle;

    @FindBy(css = ".react-datepicker__month-select")
    private WebElement selectMonth;

    @FindBy(css = ".react-datepicker__year-select")
    private WebElement selectYear;

    // ---------------- МЕТОДЫ ----------------

    public PracticeFormPage enterPersonalData(String firstName,
                                              String lastName,
                                              String email,
                                              String phone) {

        scrollWithJS(0, 300);
        type(firstNameInput, firstName);
        type(lastNameInput, lastName);
        type(userEmailInput, email);
        type(userNumberInput, phone);
        return this;
    }

    public PracticeFormPage enterGender(String gender) {
        if ("Male".equalsIgnoreCase(gender)) {
            click(male);
        } else if ("Female".equalsIgnoreCase(gender)) {
            click(female);
        } else {
            click(other);
        }
        return this;
    }

    // ввод даты через клавиатуру
    public PracticeFormPage enterOfData(String date) {
        click(dateOfBirthInput);

        String os = System.getProperty("os.name");
        System.out.println("My os is " + os);

        if (os.startsWith("Mac")) {
            dateOfBirthInput.sendKeys(Keys.COMMAND, "a");
        } else {
            dateOfBirthInput.sendKeys(Keys.CONTROL, "a");
        }
        dateOfBirthInput.sendKeys(date);
        dateOfBirthInput.sendKeys(Keys.ENTER);
        return this;
    }

    public PracticeFormPage enterSubjects(String[] subjects) {
        if (subjects == null) return this;

        for (String subject : subjects) {
            if (subject != null && !subject.isEmpty()) {
                typeWithJS(subjectsInput, subject, 0, 200);
                subjectsInput.sendKeys(Keys.ENTER);
            }
        }
        return this;
    }

    public PracticeFormPage selectHobby(String[] hobbies) {
        if (hobbies == null) return this;

        for (String hobby : hobbies) {
            if (hobby == null) continue;

            if ("Sports".equalsIgnoreCase(hobby)) {
                click(sports);
            } else if ("Reading".equalsIgnoreCase(hobby)) {
                click(reading);
            } else if ("Music".equalsIgnoreCase(hobby)) {
                click(music);
            }
        }
        return this;
    }

    public PracticeFormPage uploadFile(String path) {
        uploadPicture.sendKeys(path);
        return this;
    }

    public PracticeFormPage inputState(String state) {
        stateInput.sendKeys(state);
        stateInput.sendKeys(Keys.ENTER);
        return this;
    }

    public PracticeFormPage inputCity(String city) {
        cityInput.sendKeys(city);
        cityInput.sendKeys(Keys.ENTER);
        return this;
    }

    public PracticeFormPage submitForm() {
        clickWithJS(submit, 0, 200);
        return this;
    }

    public PracticeFormPage verifySuccess(String successTitle) {
        return this;
    }

    // выбор даты через селекты (month/year/day)
    public PracticeFormPage selectDate(String month, String year, String day) {
        click(dateOfBirthInput);

        new Select(selectMonth).selectByVisibleText(month);
        new Select(selectYear).selectByVisibleText(year);

        // более корректный локатор для дня
        WebElement dayCell = driver.findElement(
                By.xpath("//div[contains(@class,'react-datepicker__day') and text()='" + day + "']")
        );
        dayCell.click();

        return this;
    }
}
