package page.object.factory;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by natalia on 30.01.17.
 */
public class OwnerInfoPage {

    protected WebDriver driver;

    OwnerInfoPage ownerInfoPage;

    @FindBy(css = "b")
    private WebElement NAME;

    public OwnerInfoPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public String getOwnerName() {
        /**
         * There is a need to catch exception, because it might happen that we will find more than one owner (it is
         * possible to save the same owner multiple times).
         * In my opinion it is lack of functionality. See more information in attached document.
         */
        try {
            return NAME.getText();
        } catch (NoSuchElementException e) {
            ownerInfoPage = new OwnersPage(driver).selectFirstOwner();
            return ownerInfoPage.getOwnerName();
        }
    }
}
