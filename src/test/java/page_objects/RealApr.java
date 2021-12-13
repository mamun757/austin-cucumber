package page_objects;

import command_providers.ActOn;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RealApr extends NavigationBar{
    private static final Logger LOGGER = LogManager.getLogger(RealApr.class);


    private final By CalculatorTab = By.xpath("//label[text()='Calculator']");
    private final By HomePriceField = By.name("HomeValue");
    private final By DownPaymentField = By.name("DownPayment");
    private final By DownPaymentInDollar = By.name("DownPaymentSel");
    private final By InterestRate = By.name("Interest");
    private final By ClickCalculateButton = By.name("calculate");
    private final By ActualAprRate = By.xpath("//strong[text()='Actual APR:']/../../td[2]/strong");


    public RealApr(WebDriver driver) {
        super(driver);
    }

    public RealApr waitForPageToLoad(){
        LOGGER.debug("Wait for the Page to Load");
        ActOn.wait(driver,CalculatorTab).waitForElementToBeVisible();
        return this;
    }

    public RealApr HomeValue(String value) {
        LOGGER.debug("Home value is: " + value);
        ActOn.element(driver, HomePriceField).setValue("200000");
        return this;
    }

    public RealApr ClickOnDollarButton() {
        LOGGER.debug("Clicking on Dollar Button");
        ActOn.element(driver, DownPaymentInDollar).click();
        return this;
    }

    public RealApr DownPayment(String value) {
        LOGGER.debug("Down Payment is: " + value);
        ActOn.element(driver, DownPaymentField).setValue("15000");
        return this;
    }

    public RealApr InterestRate(String value) {
        LOGGER.debug("Interest Rate is: " + value);
        ActOn.element(driver, InterestRate).setValue("3");
        return this;
    }

    public RealApr ClickOnCalculateButton() {
        LOGGER.debug("Clicking on Calculate Button");
        ActOn.element(driver, ClickCalculateButton).click();
        return this;
    }
    public RealApr validatingAprRate(String expectedAprRate){
        LOGGER.debug("Validate the real apr is: " + expectedAprRate);
        String actualRealAprRate = ActOn.element(driver,ActualAprRate).getTextValue();
        Assert.assertEquals(expectedAprRate, actualRealAprRate);
        return this;
    }
}
