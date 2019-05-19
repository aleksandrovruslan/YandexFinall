import org.junit.Before;
import org.junit.Test;
import pages.HomePage;
import pages.ComputersPage;
import pages.MarketPage;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class NotebooksTest extends WebDriverSettings {

    private ComputersPage computersPage;
    private List<String> productsList;

    @Override
    @Before
    public void setUp() {
        super.setUp();
        HomePage homePage = new HomePage(driver);
        MarketPage marketPage = homePage.clickMarketLink();
        computersPage = marketPage.clickComputersLink();
        computersPage.clickNotebooksLink().setMaxPrice("30000")
                .selectBrandName("HP").selectBrandName("Lenovo").applySearch();
        productsList = computersPage.getProductsList();
    }

    @Test
    public void testNotebooksHPAndLenovoUp3000() {
        assertEquals(productsList.size(), 12);
    }

    @Test
    public void secondTest() {
        String firstProduct = productsList.get(0);
        assertEquals(computersPage.findProduct(firstProduct), firstProduct);
    }

}
