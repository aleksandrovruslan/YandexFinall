package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    private WebDriver driver;

    private By computersMarket = By.xpath("//a[@data-id='market']");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateTo() {
        driver.navigate().to("https://yandex.ru/");
    }

    public MarketPage clickMarketLink() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(computersMarket)).click();
        return new MarketPage(driver);
    }

}
