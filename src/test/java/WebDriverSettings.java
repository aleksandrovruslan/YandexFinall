import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class WebDriverSettings {

    protected WebDriver driver;

    static {
        System.setProperty("webdriver.chrome.driver", getDriverPath());
    }

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().fullscreen();
        driver.get("https://yandex.ru/");
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    private static String getDriverPath() {
        String driverPath = "src/test/resources/";
        String osName = System.getProperty("os.name");

        if (osName.contains("Linux")) {
            driverPath += "chromedriver_linux64/chromedriver";
        } else if (osName.contains("Windows")) {
            driverPath += "chromedriver_win32/chromedriver.exe";
        } else if (osName.contains("Mac")) {
            driverPath += "chromedriver_mac64/chromedriver";
        }
        return driverPath;
    }

}
