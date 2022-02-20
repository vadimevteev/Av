package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ResultsPage extends BasePage{

    public static final By HEADER = By.xpath("//div[@class=\"filter__params\"]");
    private static final By RESULTS_PAGE_TITLE = By.xpath("//h3[@class=\"listing__title\"]");
    private static final By RESULT_CAR_TITLE = By.xpath("//div[@class=\"listing__items\"]//span[@class=\"link-text\"]");
    private static final By RESULT_CAR_PRICE = By.xpath("//div[@class=\"listing__items\"]//div[@class=\"listing-item__priceusd\"]");
    private static final By RESULT_CAR_YEAR = By.xpath("//div[contains(@class,\"listing-item--top\")]//div[@class=\"listing-item__params\"]/div[1]");

    public ResultsPage(WebDriver driver) {
        super(driver);
    }

    public String GetResultCarName(){
        return getTextFromElement(RESULT_CAR_TITLE);
    }

    private int GetIntegerValue(By path){
        String[] strings = getTextFromElement(path).split("\\D+");
        return Integer.parseInt(String.join("", strings));
    }

    public int GetResultCarPrice(){
        return GetIntegerValue(RESULT_CAR_PRICE);
    }

    public int GetResultsAmount(){
        return GetIntegerValue(RESULTS_PAGE_TITLE);
    }

    public int GetResultsYear(){
        return GetIntegerValue(RESULT_CAR_YEAR);
    }
}
