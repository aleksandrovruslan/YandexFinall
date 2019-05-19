package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MarketPage {

    private WebDriver driver;
    
    private By computersLink = By.xpath(
            "//span[@class='n-w-tab__control-caption' and text()='Компьютерная техника']");

    public MarketPage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateTo() {
        driver.navigate().to("https://market.yandex.ru/");
    }
    
    public ComputersPage clickComputersLink() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(computersLink)).click();
        return new ComputersPage(driver);
    }

}
