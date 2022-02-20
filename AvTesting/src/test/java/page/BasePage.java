package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.Waits;

public abstract class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForOpenPage(By uniqueElement){
        Waits.getWebElementUntilWait(driver, uniqueElement);
    }

    protected void buttonClick(By buttonPath){
        Waits.getWebElementUntilWait(driver, buttonPath).click();
    }

    protected String getTextFromElement(By elementPath){
        return Waits.getWebElementUntilWait(driver, elementPath).getText();
    }

    protected void fillInput(By elementPath, String data){
        Waits.getWebElementUntilWait(driver, elementPath).sendKeys(data);
    }

}
