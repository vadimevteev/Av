package page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import utils.Waits;

public class HomePage extends BasePage{

    private static final Logger logger = LogManager.getRootLogger();
    private static final String PAGE_URL = "https://av.by/";
    private static final By CAR_BRAND_BUTTON = By.xpath("//button[contains(@name,\"brand\")]");
    private static final String CAR_BRAND_ITEM = "//ul[@class=\"dropdown-list dropdown-list--opened\"]//button[@data-item-label=\"REPLACE\"]";
    private static final By ACTIVE_MODEL_CHOICE = By.xpath("//*[@id=\"p-1440-0-1437-model\"]//button[contains(@class,\"dropdown__control\")][not(@disabled)]");
    private static final By SEARCH_BUTTON = By.xpath("//*[@id=\"__next\"]//a[contains(@class,\"button--secondary button--block\")]");
    private static final By MIN_PRICE_INPUT = By.xpath("//div[@class=\"richinput-control\"]//input");
    private static final By MAX_PRICE_INPUT = By.xpath("//div[@class=\"richinput__controls\"]//div[2]//input");
    private static final By MIN_YEAR_CHOICE = By.xpath("//*[@id=\"p-1441-year\"]//button[@class=\"dropdown__control dropdown-floatlabel\"]");
    private static final String COMMON_YEAR = "//*[@id=\"p-1441-year\"]//button[@data-item-label=REPLACE]";
    private static final By DISABLED_SEARCH_BUTTON = By.xpath("//a[contains(@class,\"button--secondary\")][@aria-disabled]");

    public HomePage(WebDriver driver){
        super(driver);
    }

    public HomePage openPage(){
        driver.get(PAGE_URL);
        logger.info("Home page opened");
        return this;
    }

    public HomePage fillCarBrandInput(String brand) {
        buttonClick(CAR_BRAND_BUTTON);
        buttonClick(By.xpath(CAR_BRAND_ITEM.replace("REPLACE",brand)));
        Waits.getWebElementUntilWait(driver, ACTIVE_MODEL_CHOICE);
        return this;
    }

    public HomePage fillMinPriceInput(int price){
        fillInput(MIN_PRICE_INPUT, String.valueOf(price));
        return this;
    }

    public HomePage fillMinYearInput(int year){
        buttonClick(MIN_YEAR_CHOICE);
        buttonClick(By.xpath(COMMON_YEAR.replace("REPLACE",String.valueOf(year))));
        return this;
    }

    public HomePage fillMaxPriceInput(int price){
        fillInput(MAX_PRICE_INPUT, String.valueOf(price));
        return this;
    }

    public boolean isSearchButtonAvailable(){
        try {
            Waits.getWebElementUntilWait(driver, MAX_PRICE_INPUT);
            return false;
        }
        catch (TimeoutException ex) {
            return true;
        }
    }

    public HomePage clickFindButton(){
        buttonClick(SEARCH_BUTTON);
        return this;
    }

}
