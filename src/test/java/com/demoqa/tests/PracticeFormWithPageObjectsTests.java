package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import com.demoqa.pages.PracticeFormPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class PracticeFormWithPageObjectsTests {
    PracticeFormPage practiceFormPage = new PracticeFormPage();

    @BeforeAll
    static void configure() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void fillFormTest() {
        practiceFormPage.openPage()
                .setFirstName("Petr")
                .setLastName("Kukushkin")
                .setEmail("kuku@gmail.com")
                .setGender("Male")
                .setNumber("8999333224")
                .setBirthDate("31", "July", "1992")
                .setSubjects("Chemistry")
                .setHobbies("Reading")
                .setPicture("kot.jpg")
                .setAddress("Neva 40")
                .setState("Haryana")
                .setCity("Karnal")
                .clickSubmit();

       practiceFormPage.checkResultsTableVisible()
               .checkResult("Student Name","Petr Kukushkin")
               .checkResult("Student Email","kuku@gmail.com")
               .checkResult("Gender","Male")
               .checkResult("Mobile","8999333224")
               .checkResult("Date of Birth","31 July,1992")
               .checkResult("Subjects","Chemistry")
               .checkResult("Hobbies","Reading")
               .checkResult("Address","Neva 40")
               .checkResult("State and City","Haryana Karnal");

    }
        }
