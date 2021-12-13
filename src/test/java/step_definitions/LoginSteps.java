package step_definitions;

import command_providers.ActOn;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.ReadConfigFiles;

import java.util.List;
import java.util.Map;

public class LoginSteps {
    private static final By FullName = By.id("name");
    private static final By Password = By.id("password");
    private static final By LoginButton = By.xpath("//*[@id='login']");
    private static final By LogOutButton = By.xpath("//*[@id='logout']");
    private static final By InvalidPasswordText = By.xpath("//div[text()='Password is invalid']");
    WebDriver driver = Hooks.driver;


    private static final Logger LOGGER = LogManager.getLogger(LoginSteps.class);

    @Given("^user is on login page$")
    public void NavigateToLoginPage() {
        ActOn.browser(driver).openBrowser(ReadConfigFiles.getPropertyValues("TestAppURL"));
        LOGGER.info("user is on login page");

    }

    @When("^user enters username \"(.+?)\" and password \"(.+?)\"$")
    public void entersUserCredentials(String username, String password) {
        ActOn.element(driver, FullName).setValue(username);
        ActOn.element(driver, Password).setValue(password);
        LOGGER.info("user enters username and password");

    }

    @And("^click on login button$")
    public void clickOnLoginButton() {
        ActOn.element(driver, LoginButton).click();
        LOGGER.info("user click on login button");
    }

    @When("^user click on Login Button upon entering credentials$")
    public void userClickOnLoginButtonEnteringCredentials(DataTable table) {
        List<Map<String,String>> data = table.asMaps(String.class, String.class);
        for (Map<String, String> cells: data) {
            ActOn.element(driver,FullName).setValue(cells.get("username"));
            ActOn.element(driver, Password).setValue(cells.get("password"));
            LOGGER.info("user enters username and password");

            ActOn.element(driver, LoginButton).click();
            LOGGER.info("user click on login button");
        }
    }

    @Then("^user is navigate on Homepage$")
    public void validateLoginIsSuccessful() {
        boolean logOutDisplayed = driver.findElement(LogOutButton).isDisplayed();
        Assert.assertTrue("Logout button id displayed",logOutDisplayed);
        //AssertThat.elementAssertions(driver,LogOutButton).elementIsDisplayed();
        LOGGER.info("user successfully login the home page");
    }

    @Then("^user is fail to Login$")
    public void logInfailvalidation() {
        boolean invalidPassword = driver.findElement(InvalidPasswordText).isDisplayed();
        Assert.assertTrue("Invalid password is not displayed",invalidPassword);
        //AssertThat.elementAssertions(driver,InvalidPasswordText).elementIsDisplayed();
        LOGGER.info("user cannot login with invalid credentials");
    }



}
