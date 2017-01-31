package functional.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import page.object.factory.HomePage;
import utils.DriverSetup;

/**
 * Created by natalia on 30.01.17.
 */
public class HomePageTest {

    protected DriverSetup driverSetup = new DriverSetup();
    protected WebDriver driver;

    HomePage homePage;

    private static final String expectedTitle = "Welcome";

    @BeforeClass
    @Parameters({"browser", "url"})
    public void setUpClass(String browser, String url) {
        driver = driverSetup.setUpDriver(browser, url);
        homePage = new HomePage(driver);
    }

    @Test
    public void verifyPageTitle() {
        Assert.assertEquals(homePage.getPageTitle(), expectedTitle);
    }

    @AfterClass
    public void tearDown() {
        driver.close();
    }
}
