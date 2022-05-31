package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest {

    @Test(description = "Login using valid data")
    public void loginShouldBeSuccessful() {
        loginPage.open();
        assertTrue(loginPage.isPageOpened(), "Login page hasn't been opened");
        loginPage.login(user, password);
        assertTrue(homePage.isPageOpened(), "Calendar page hasn't been opened");
    }

    //TODO DataProvider там где это можно

    @Test(description = "Login using invalid email")
    public void loginShouldNotBeSuccessful() {
        loginPage.open();
        assertTrue(loginPage.isPageOpened(), "Login page hasn't been opened");
        loginPage.login(INVALID_EMAIL, password);
        String error = loginPage.getErrorMessage();
        assertEquals(error, "Invalid login credentials. Please try again.");
    }

    @Test(description = "Login using invalid password")
    public void loginWithInvalidPasswordTest() {
        loginPage.open();
        assertTrue(loginPage.isPageOpened(), "Login page hasn't been opened");
        loginPage.login(user, INVALID_PASSWORD);
        String error = loginPage.getErrorMessage();
        assertEquals(error, "Invalid login credentials. Please try again.");
    }

    @Test(description = "Login using invalid data")
    public void loginWithInvalidDataTest() {
        loginPage.open();
        assertTrue(loginPage.isPageOpened(), "Login page hasn't been opened");
        loginPage.login(INVALID_EMAIL, INVALID_PASSWORD);
        String error = loginPage.getErrorMessage();
        assertEquals(error, "Invalid login credentials. Please try again.");
    }

    @Test(description = "Login without entering an email")
    public void loginWithEmptyEmailTest() {
        loginPage.open();
        assertTrue(loginPage.isPageOpened(), "Login page hasn't been opened");
        loginPage.login(" ", password);
        String errorEmail = loginPage.getEmptyEmailMessage();
        assertEquals(errorEmail, "Please enter your e-mail address.");
    }

    @Test(description = "Login without entering a password")
    public void loginWithEmptyPasswordTest() {
        loginPage.open();
        assertTrue(loginPage.isPageOpened(), "Login page hasn't been opened");
        loginPage.login(user, " ");
        String errorPassword = loginPage.getEmptyPasswordMessage();
        assertEquals(errorPassword, "Please enter a password.");
    }

    @Test(description = "Login without entering an email and a password")
    public void loginWithEmptyDataTest() {
        loginPage.open();
        assertTrue(loginPage.isPageOpened(), "Login page hasn't been opened");
        loginPage.login(" ", " ");
        String errorEmail = loginPage.getEmptyEmailMessage();
        assertEquals(errorEmail, "Please enter your e-mail address.");
        String errorPassword = loginPage.getEmptyPasswordMessage();
        assertEquals(errorPassword, "Please enter a password.");
    }
}

