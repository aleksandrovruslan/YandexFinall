package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ComputersPage {

    private WebDriver driver;

    private By notebooksLink = By.xpath(
            "//div[@data-zone-name='link']/a[text()='Ноутбуки']");
    private By tabletsLink = By.xpath(
            "//div[@data-zone-name='link']/a[text()='Планшеты']");
    private By minPriceBy = By.id("glpricefrom");
    private By maxPriceBy = By.id("glpriceto");
    private By viewAllBy = By.xpath("//footer[@class='_2XviVqx9xN']/a[text()='Показать всё']");
    private By cardProductBy = By.xpath("//div[@class='n-snippet-card2__title']/a");
    private By productPageTitleBy = By.xpath("//div[@class='n-title__text']/h1");
    private By searchFieldBy = By.id("header-search");
    private By searchButtonBy = By.className("search2__button");

    public ComputersPage(WebDriver driver) {
        this.driver = driver;
    }

    public ComputersPage clickNotebooksLink() {
        driver.findElement(notebooksLink).click();
        return this;
    }

    public ComputersPage clickTabletsLink() {
        driver.findElement(tabletsLink).click();
        return this;
    }

    public ComputersPage setMinPrice(String minPrice) {
        driver.findElement(minPriceBy).sendKeys(minPrice);
        return this;
    }

    public ComputersPage setMaxPrice(String maxPrice) {
        driver.findElement(maxPriceBy).sendKeys(maxPrice);
        return this;
    }

    public ComputersPage selectBrandName(String brandName) {
        WebElement viewAll = driver.findElement(viewAllBy);
        if (viewAll != null) {
            viewAll.click();
        }
        By elementBy = By.xpath("//span[@class='NVoaOvqe58 _17C4Le-0TB' and contains(text(), '" + brandName + "')]");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(elementBy));
        driver.findElement(elementBy).click();
        return this;
    }

    public ComputersPage applySearch() {
        driver.navigate().refresh();
        return this;
    }

    public List<String> getProductsList() {
        List<String> products;
        WebElement product = null;
        try {
            product = driver.findElement(productPageTitleBy);
            products = new ArrayList<>();
            products.add(product.getText());
        } catch (NoSuchElementException e) {
            products = driver.findElements(cardProductBy).stream()
                    .map(element -> element.getText()).collect(Collectors.toList());
        }
        return products;
    }

    public String findProduct(String productName) {
        driver.findElement(searchFieldBy).sendKeys(productName);
        driver.findElement(searchButtonBy).click();
        return getProductsList().get(0);
    }

}
