package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.HomePage;
import page.ResultsPage;
import service.TestDataReader;

public class AvTest extends BaseTest{

    @Test
    public void findCarsWithoutData(){
        homePage.openPage()
                .clickFindButton();
        resultsPage.waitForOpenPage(ResultsPage.HEADER);
        Assert.assertTrue(resultsPage.GetResultsAmount() > 0);
    }

    @Test
    public void findCarForBrand() {
        homePage.openPage()
                .fillCarBrandInput(TestDataReader.getCarBrand())
                .clickFindButton();
        resultsPage.waitForOpenPage(ResultsPage.HEADER);
        Assert.assertTrue(resultsPage.GetResultCarName().contains(TestDataReader.getCarBrand()));
    }
//
    @Test
    public void findCarsForMinPrice(){
        homePage.openPage()
                .fillMinPriceInput(TestDataReader.getCarMinPrice())
                .clickFindButton();
        resultsPage.waitForOpenPage(ResultsPage.HEADER);
        Assert.assertTrue(resultsPage.GetResultCarPrice() >= TestDataReader.getCarMinPrice());
    }

    @Test
    public void findCarsForMinYear() {
        homePage.openPage()
                .fillMinYearInput(TestDataReader.getCarMinYear())
                .clickFindButton();
        resultsPage.waitForOpenPage(ResultsPage.HEADER);
        Assert.assertTrue(resultsPage.GetResultsYear() >= TestDataReader.getCarMinYear());
    }

    @Test
    public void findCarsForLittlePrice(){
        boolean isSearchButtonAvailable = homePage.openPage()
                .fillMaxPriceInput(TestDataReader.getCarMaxPrice())
                .isSearchButtonAvailable();
        Assert.assertFalse(isSearchButtonAvailable);
    }
}
