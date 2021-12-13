package page_objects;

import command_providers.ActOn;
import command_providers.AssertThat;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Home extends NavigationBar{
    private static final Logger LOGGER = LogManager.getLogger(Home.class);


    private  final By HomeValueInputField = By.id("homeval");
    private  final By DownPaymentInputField = By.id("downpayment");
    private final By DollarSign = By.xpath("//input[@name='param[downpayment_type]' and @value='money']");
    private final By LoanAmount = By.id("loanamt");
    private final By InterestRate = By.id("intrstsrate");
    private final By LoanTermInputField = By.id("loanterm");
    private final By LoanStartMonth = By.xpath("//select[@name='param[start_month]']");
    private final By LoanYear = By.id("start_year");
    private final By PropertyTaxField = By.id("pptytax");
    private final By PMIInputField = By.id("pmi");
    private final By HoiInputField = By.id("hoi");
    private final By HoaInputField =By.id("hoa") ;
    private final By LoanTypeField =By.xpath("//select[@name='param[milserve]']") ;
    private final By BuyOrRefinance = By.name("param[refiorbuy]");
    private final By CalculateButton = By.xpath("//input[@name='cal']");


    public Home(WebDriver driver){
        super(driver);
    }

    public Home TypeHomeValue(String value){
        LOGGER.debug("Home value is: " + value);
        ActOn.element(driver, HomeValueInputField).setValue("30000");
        return this;
    }
    public Home TypeDownPayment(String value){
        LOGGER.debug("Down Payment is: " + value);
        ActOn.element(driver, DownPaymentInputField).setValue("60000");
        return this;
    }

    public Home ClickOnDollar(){
        LOGGER.debug("Clicking on Dollar ");
        ActOn.element(driver,DollarSign).click();
        return this;
    }

    public Home TypeLoanAmount(String value){
        LOGGER.debug("Loan Amount is: " + value);
        ActOn.element(driver, LoanAmount).setValue("240000");
        return this;
    }

    public Home TypeInterestRate(String value){
        LOGGER.debug("Interest Rate is: " + value);
        ActOn.element(driver, InterestRate).setValue("3");
        return this;
    }

    public Home TypeLoanTerm(String value){
        LOGGER.debug("Loan Term  is: " + value);
        ActOn.element(driver, LoanTermInputField).setValue("30");
        return this;
    }
    public Home SelectMonth(String month){
        LOGGER.debug("Select the month is: " + month);
        ActOn.element(driver, LoanStartMonth).selectValue(month);
        return this;
    }

    public Home TypeYear(String year){
        LOGGER.debug("Select the Year is: " + year);
        ActOn.element(driver, LoanYear).setValue(year);
        return this;
    }
    public Home TypePropertyTax(String value){
        LOGGER.debug("Property tax is: " + value);
        ActOn.element(driver, PropertyTaxField).setValue("5000");
        return this;
    }

    public Home TypePMI(String value){
        LOGGER.debug("The PMI is: " + value);
        ActOn.element(driver, PMIInputField).setValue("0.5");
        return this;
    }

    public Home TypeHOI(String value){
        LOGGER.debug("The HOI is: " + value);
        ActOn.element(driver, HoiInputField).setValue("1000");
        return this;
    }

    public Home TypeHOAInsurance(String value){
        LOGGER.debug("The HOA Insurance is: " + value);
        ActOn.element(driver, HoaInputField).setValue("100");
        return this;
    }

    public Home SelectLoanType(String value){
        LOGGER.debug("Selecting Loan Type is: " + value);
        ActOn.element(driver, LoanTypeField).selectValue("FHA");
        return this;
    }
    public Home SelectBuyOrRefinance(String value){
        LOGGER.debug("Selecting Buy/Refinance is: " + value);
        ActOn.element(driver, BuyOrRefinance).selectValue("Buy");
        return this;
    }
    public Home ClickOnCalculateButton(){
        LOGGER.debug("Clicking on the Calculate Button");
        ActOn.element(driver, CalculateButton).click();
        return this;
    }

    public Home ValidatingMonthlyPayment(String expectedMonthlyPayment){
        String formattedXpath = String.format("//*[@id='calc']//h3[text()='%s']", expectedMonthlyPayment);
        By monthlyPayment = By.xpath(formattedXpath);
        LOGGER.debug("Validating Monthly Payment is: " + expectedMonthlyPayment);
        AssertThat.elementAssertions(driver,monthlyPayment).elementIsDisplayed();
        return this;
    }
}
