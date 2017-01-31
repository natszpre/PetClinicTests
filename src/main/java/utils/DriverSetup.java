package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by natalia on 18.01.17.
 */
public class DriverSetup {

    private WebDriver driver;

    public WebDriver setUpDriver(String browser, String url) {
        switch (browser) {
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "C:\\myprograms\\chromedriver.exe");
                driver = new ChromeDriver();
                break;
            case "ie":
                System.setProperty("webdriver.ie.driver", "C:\\myprograms\\IEDriverServer.exe");
                driver = new InternetExplorerDriver();
                break;
        }
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get(url);
        return driver;
    }
}
