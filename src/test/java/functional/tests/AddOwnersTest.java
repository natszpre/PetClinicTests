package functional.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import page.object.factory.AddOwnerPage;
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
public class AddOwnersTest {

    protected DriverSetup driverSetup = new DriverSetup();
    protected WebDriver driver;

    HomePage homePage;
    FindOwnersPage findOwnersPage;
    AddOwnerPage addOwnerPage;
    OwnerInfoPage ownerInfoPage;

    private static final String name1 = "testName";
    private static final String name2 = "testName2";
    private static final String testAddr = "testAddr";
    private static final String city = "London";
    private static final String telephone = "1234567890";

    @BeforeClass
    @Parameters({"browser", "url"})
    public void setUpClass(String browser, String url) {
        driver = driverSetup.setUpDriver(browser, url);
        homePage = new HomePage(driver);
    }

    @Test
    public void addOwnerTest() {
        findOwnersPage = homePage.openFindOwnerPage();
        addOwnerPage = findOwnersPage.addOwner();
        addOwnerPage.fillForm(name1, name2, testAddr, city, telephone);
        ownerInfoPage = addOwnerPage.submitForm();
        Assert.assertEquals(ownerInfoPage.getOwnerName(), name1 + " " + name2);
    }

    @AfterClass
    public void tearDown() {
        driver.close();
    }
}
