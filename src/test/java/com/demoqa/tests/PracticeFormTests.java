package com.demoqa.tests;

import com.demoqa.core.TestBase;
import com.demoqa.pages.HomePage;
import com.demoqa.pages.PracticeFormPage;
import com.demoqa.pages.SidePanel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PracticeFormTests extends TestBase {


    PracticeFormPage practiceForm;

    @BeforeEach
    public void precondition(){
        practiceForm = new PracticeFormPage(driver);
        new HomePage(driver).selectForms();
        new SidePanel(driver).selectPracticeForm();
    }
@Test
    public void createStudentAccountPositiveTest(){

        practiceForm.enterPersonalData("Robert","Wide","Test@gmail.com","1234567890")
               .enterGender("Male")
                .enterOfData("14 Oct 1987")
                .enterSubjects(new String[]{"English","Maths","Economics"})
                .selectHobby(new String[]{"Sports","Reading"})
                .uploadFile("/Users/kristinatomas/Tools/1.jpg")
                .inputState("NCR")
               .inputCity("Delhi")
                .submitForm()
               .verifySuccess("Thanks for submitting the form")
                ;
}
@Test
    public void createStudentAccountWithSelectDatePositiveTest(){

        practiceForm.enterPersonalData("Robert","Wide","Test@gmail.com","1234567890")
               .enterGender("Male")
                .selectDate("August","1987","16")
                .submitForm()
               .verifySuccess("Thanks for submitting the form")
                ;
}

}
