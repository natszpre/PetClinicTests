package page.object.factory;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by natalia on 30.01.17.
 */
public class FindOwnersPage {

    protected WebDriver driver;

    @FindBy(css = "input#lastName")
    private WebElement LAST_NAME_INPUT;
    @FindBy(css = "div[class=\"form-actions\"] button")
    private WebElement FIND_OWNER_BUTTON;
    @FindBy(css = "a[href*='/owners/new']")
    private WebElement ADD_OWNER_LINK;

    final static Logger logger = Logger.getLogger(FindOwnersPage.class);

    public FindOwnersPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public String getButtonTitle() {
        String title = FIND_OWNER_BUTTON.getText();
        logger.info("Button title is: " + title);
        return title;
    }

    public AddOwnerPage addOwner() {
        ADD_OWNER_LINK.click();
        return new AddOwnerPage(driver);
    }

    public OwnerInfoPage searchOwner(String owner) {
        LAST_NAME_INPUT.sendKeys(owner);
        FIND_OWNER_BUTTON.click();
        return new OwnerInfoPage(driver);
    }
}
