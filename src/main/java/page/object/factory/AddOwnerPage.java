package page.object.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by natalia on 30.01.17.
 */
public class AddOwnerPage {

    protected WebDriver driver;

    @FindBy(id = "firstName")
    private WebElement FIRST_NAME;
    @FindBy(id = "lastName")
    private WebElement LAST_NAME;
    @FindBy(id = "address")
    private WebElement ADDRESS;
    @FindBy(id = "city")
    private WebElement CITY;
    @FindBy(id = "telephone")
    private WebElement TELEPHONE;
    @FindBy(css = "button")
    private WebElement ADD_OWNER_BUTTON;

    public AddOwnerPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void fillForm(String fName, String lName, String addr, String city, String tel) {
        FIRST_NAME.sendKeys(fName);
        LAST_NAME.sendKeys(lName);
        ADDRESS.sendKeys(addr);
        CITY.sendKeys(city);
        TELEPHONE.sendKeys(tel);
    }

    public OwnerInfoPage submitForm() {
        ADD_OWNER_BUTTON.click();
        return new OwnerInfoPage(driver);
    }
}
