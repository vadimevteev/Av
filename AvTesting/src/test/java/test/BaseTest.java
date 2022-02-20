package test;

import driver.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import page.HomePage;
import page.ResultsPage;

public abstract class BaseTest {
    protected WebDriver driver;
    protected HomePage homePage;
    protected ResultsPage resultsPage;

    @BeforeMethod(alwaysRun = true)
    public void init(){
        driver = DriverSingleton.getDriver();
        homePage = new HomePage(driver);
        resultsPage = new ResultsPage(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void close(){
        DriverSingleton.closeBrowser();
    }
}
