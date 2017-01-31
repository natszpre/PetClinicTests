package functional.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import page.object.factory.FindOwnersPage;
import page.object.factory.HomePage;
import page.object.factory.OwnerInfoPage;
import utils.DriverSetup;

/**
 * Created by natalia on 30.01.17.
 * <p>
 * Preconditions:
 * Owner must be added in the system.
 */
public class FindOwnersTest {

    protected DriverSetup driverSetup = new DriverSetup();
    protected WebDriver driver;

    HomePage homePage;
    FindOwnersPage findOwnersPage;
    OwnerInfoPage ownerInfoPage;

    private static final String expectedName = "testName testName2";
    private static final String expectedTitle = "Find Owner";

    @BeforeClass
    @Parameters({"browser", "url"})
    public void setUpClass(String browser, String url) {
        driver = driverSetup.setUpDriver(browser, url);
        homePage = new HomePage(driver);
    }

    @Test
    public void findOwnerTest() {
        findOwnersPage = homePage.openFindOwnerPage();
        ownerInfoPage = findOwnersPage.searchOwner("testName");
        Assert.assertEquals(ownerInfoPage.getOwnerName(), expectedName);
    }

    @Test
    public void getButtonTitleTest() {
        findOwnersPage = homePage.openFindOwnerPage();
        Assert.assertEquals(findOwnersPage.getButtonTitle(), expectedTitle);
    }

    @AfterClass
    public void tearDown() {
        driver.close();
    }
}
