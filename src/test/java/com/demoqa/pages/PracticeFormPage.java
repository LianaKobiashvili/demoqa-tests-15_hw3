package com.demoqa.pages;

import com.codeborne.selenide.SelenideElement;
import com.demoqa.pages.components.CalendarComponent;
import com.demoqa.pages.components.ResultsTableComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormPage {

    private CalendarComponent calendarComponent = new CalendarComponent();
    private ResultsTableComponent resultsTableComponent = new ResultsTableComponent();
    private SelenideElement firstNameInput = $("#firstName");
    private SelenideElement lastNameInput = $("#lastName");
    private SelenideElement emailInput =  $("#userEmail");
    private SelenideElement genderInput =  $("#genterWrapper");
    private SelenideElement numberInput =  $("#userNumber");
    private SelenideElement hobbiesInput =  $("#hobbiesWrapper");
    private SelenideElement subjectsInput =  $("#subjectsInput");
    private SelenideElement addressInput =  $("#currentAddress");


    private final static String TITLE_TEXT = "Student Registration Form";

    public PracticeFormPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text(TITLE_TEXT));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixdban').remove()");
        return this;
    }

    public PracticeFormPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public PracticeFormPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public PracticeFormPage setEmail(String value) {
        emailInput.setValue(value);

        return this;
    }

    public PracticeFormPage setGender(String value) {
        genderInput.$(byText(value)).click();

        return this;
    }

    public PracticeFormPage setNumber(String value) {
        numberInput.setValue(value);

        return this;
    }

    public PracticeFormPage setBirthDate(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        calendarComponent.setDate(day, month, year);

        return this;
    }
    public PracticeFormPage setAddress (String value) {
        addressInput.setValue(value).click();


        return this;
    }

    public PracticeFormPage setSubjects (String value) {
        subjectsInput.setValue(value).pressEnter();

        return this;
    }

    public PracticeFormPage setHobbies (String value) {
        hobbiesInput.$(byText(value)).click();


        return this;
    }
    public PracticeFormPage setPicture (String value) {
        $("#uploadPicture").uploadFromClasspath(value);

        return this;
    }

    public PracticeFormPage setState (String value) {
        $("#state").click();
        $("#stateCity-wrapper").$(byText(value)).click();

        return this;
    }
    public PracticeFormPage setCity (String value) {
        $("#city").click();
        $("#stateCity-wrapper").$(byText(value)).click();

        return this;

    }

    public PracticeFormPage clickSubmit () {
        $("#submit").click();

        return this;
    }

    public PracticeFormPage checkResultsTableVisible() {
        resultsTableComponent.checkVisible ();

        return this;
    }
    public PracticeFormPage checkResult(String key, String value) {
        resultsTableComponent.checkResult(key, value);

        return this;
    }
}