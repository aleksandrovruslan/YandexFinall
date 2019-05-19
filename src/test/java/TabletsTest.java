import org.junit.Before;
import org.junit.Test;
import pages.ComputersPage;
import pages.HomePage;
import pages.MarketPage;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class TabletsTest extends WebDriverSettings {

    private ComputersPage computersPage;
    private List<String> productsList;

    @Override
    @Before
    public void setUp() {
        super.setUp();
        HomePage homePage = new HomePage(driver);
        MarketPage marketPage = homePage.clickMarketLink();
        computersPage = marketPage.clickComputersLink();
        computersPage.clickTabletsLink().setMinPrice("20000").setMaxPrice("25000")
                .selectBrandName("Acer").selectBrandName("DELL").applySearch();
        productsList = computersPage.getProductsList();
    }

    @Test
    public void testTabletsAcerAndDELLFrom20000To25000() {
        assertEquals(productsList.size(), 12);
    }

    @Test
    public void secondTest() {
        String firstProduct = productsList.get(0);
        assertEquals(computersPage.findProduct(firstProduct), firstProduct);
    }

}
