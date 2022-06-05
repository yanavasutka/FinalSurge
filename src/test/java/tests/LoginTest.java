package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest {

    @Test(description = "Log in using valid data")
    public void loginShouldBeSuccessful() {
        loginPage.open();
        assertTrue(loginPage.isPageOpened(), "Login page hasn't been opened");
        loginPage.login(USER, PASSWORD);
        assertTrue(homePage.isPageOpened(), "Calendar page hasn't been opened");
    }

    @DataProvider(name = "Invalid data input for negative login tests")
    public Object[][] loginWithInvalidData() {
        return new Object[][]{
                {INVALID_EMAIL, PASSWORD, "Invalid login credentials. Please try again."},
                {USER, INVALID_PASSWORD, "Invalid login credentials. Please try again."},
                {INVALID_EMAIL, INVALID_PASSWORD, "Invalid login credentials. Please try again."}
        };
    }

    @Test(dataProvider = "Invalid data input for negative login tests")
    public void loginWithInvalidData (String user, String password, String error) {
        loginSteps.login(user, password);
        assertEquals(loginPage.getErrorMessage(), error, "The error message is not correct");
    }

    @Test(description = "Log in without entering an email")
    public void loginWithEmptyEmailField() {
        loginSteps.login(" ", PASSWORD);
        String errorEmail = loginPage.getEmptyEmailMessage();
        assertEquals(errorEmail, "Please enter your e-mail address.");
    }

    @Test(description = "Log in without entering a password")
    public void loginWithEmptyPasswordField() {
        loginSteps.login(USER, " ");
        String errorPassword = loginPage.getEmptyPasswordMessage();
        assertEquals(errorPassword, "Please enter a password.");
    }

    @Test(description = "Log in without entering an email and a password")
    public void loginWithEmptyFields() {
        loginSteps.login(" ", " ");
        String errorEmail = loginPage.getEmptyEmailMessage();
        assertEquals(errorEmail, "Please enter your e-mail address.");
        String errorPassword = loginPage.getEmptyPasswordMessage();
        assertEquals(errorPassword, "Please enter a password.");
    }

    @Test(description = "Log out on the LOGOUT button on the HOMEPAGE")
    public void logoutShouldBePerformed() {
        loginSteps.login(USER, PASSWORD);
        assertTrue(homePage.isPageOpened(), "Home page hasn't been opened");
        homePage.clickOnTheLogoutButton();
        String message = homePage.getLogoutMessage();
        assertEquals(message, "You have been successfully logged out of the system.");


    }
}

