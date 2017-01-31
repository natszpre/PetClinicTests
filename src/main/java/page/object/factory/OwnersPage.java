package page.object.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * Created by natalia on 30.01.17.
 */
public class OwnersPage {

    protected WebDriver driver;

    @FindBy(className = "sorting_1")
    private List<WebElement> NAMES;


    public OwnersPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public OwnerInfoPage selectFirstOwner() {
        NAMES.get(0).click();
        return new OwnerInfoPage(driver);
    }
}
