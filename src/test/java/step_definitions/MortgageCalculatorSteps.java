package step_definitions;

import command_providers.ActOn;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import page_objects.Home;
import page_objects.RealApr;
import utilities.ReadConfigFiles;

import java.util.List;
import java.util.Map;

public class MortgageCalculatorSteps {
    private static final Logger LOGGER = LogManager.getLogger(MortgageCalculatorSteps.class);
    WebDriver driver = Hooks.driver;

    @Given("^user is on Mortgage Calculator Home page$")
    public void navigateToMortgageCalculatorHomePage() {
        ActOn.browser(driver).openBrowser(ReadConfigFiles.getPropertyValues("MortgageAppURL"));
        LOGGER.info("Mortgage Calculator Home Page opens");
    }

    @And("^user is navigate to Real Apr Page$")
    public void navigateToRealAprPage() {
        new Home(driver)
                .mouseHoverToRates()
                .navigateToRealApr();
        LOGGER.info("Navigate to real apr page");
    }

    @When("^user clicks on Login Button upon entering the data$")
    public void clickOnCalculateButtonUponEnteringData(DataTable table) {
        List<Map<String,String>> dataTable = table.asMaps(String.class,String.class);
        for (Map<String,String> cells: dataTable) {
            new RealApr(driver)
                    .HomeValue(cells.get("HomePrice"))
                    .ClickOnDollarButton()
                    .DownPayment(cells.get("DownPayment"))
                    .InterestRate(cells.get("InterestRate"))
                    .ClickOnCalculateButton();
        }
        LOGGER.info("click on calculate button upon entering the data");
    }

    @Then("^the Real Apr rate is \"(.+?)\"$")
    public void validatingTheRealAprRate(String realApr) {
        new RealApr(driver)
                .validatingAprRate(realApr);
        LOGGER.info("validate the actual real apr rate");
    }

}
