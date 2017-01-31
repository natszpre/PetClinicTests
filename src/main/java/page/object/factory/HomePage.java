package page.object.factory;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by natalia on 30.01.17.
 */
public class HomePage {

    protected WebDriver driver;

    @FindBy(css = "h2")
    private WebElement PAGE_TITLE;
    @FindBy(css = "a[href*=\"/owners/find.html\"]")
    private WebElement FIND_OWNER_BUTTON;

    final static Logger logger = Logger.getLogger(HomePage.class);

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public String getPageTitle() {
        String title = PAGE_TITLE.getText();
        logger.info("Page title is: " + title);
        return title;
    }

    public FindOwnersPage openFindOwnerPage() {
        FIND_OWNER_BUTTON.click();
        return new FindOwnersPage(driver);
    }
}
