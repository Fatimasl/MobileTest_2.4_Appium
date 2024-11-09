import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class NetologyTest {

    enum Platform {Android, IOS};
    Platform platform = Platform.Android;
    private AppiumDriver driver;
    private MobileObjects mobileObjects;
    private String myText = "Netology";
    private String myEmptyText = "   ";

    private URL getUrl() {
        try {
            return new URL("http://127.0.0.1:4723");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @BeforeEach
    public void setUp() {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("appium:ensureWebviewsHavePages", true);
        desiredCapabilities.setCapability("appium:nativeWebScreenshot", true);
        desiredCapabilities.setCapability("appium:newCommandTimeout", 3600);
        desiredCapabilities.setCapability("appium:connectHardwareKeyboard", true);

        if (platform == Platform.Android) {
            desiredCapabilities.setCapability("platformName", "Android");
            desiredCapabilities.setCapability("appium:deviceName", "myPhone");
            desiredCapabilities.setCapability("appium:appPackage", "ru.netology.testing.uiautomator");
            desiredCapabilities.setCapability("appium:appActivity", "ru.netology.testing.uiautomator.MainActivity");
            desiredCapabilities.setCapability("appium:automationName", "uiautomator2");
            driver = new AndroidDriver(getUrl(),desiredCapabilities);
        }

        mobileObjects = new MobileObjects(driver);
    }

    @Test
    public void netologyTest_1() {
        mobileObjects.userInput.isDisplayed();
        mobileObjects.userInput.sendKeys(myEmptyText);

        mobileObjects.textToBeChanged.isDisplayed();
        String expected = mobileObjects.textToBeChanged.getText();

        mobileObjects.btnChange.isDisplayed();
        mobileObjects.btnChange.click();

        Assertions.assertEquals(expected, mobileObjects.textToBeChanged.getText());
    }

    @Test
    public void netologyTest_2() {
        mobileObjects.userInput.isDisplayed();
        mobileObjects.userInput.sendKeys(myText);

        mobileObjects.btnActivity.isDisplayed();
        mobileObjects.btnActivity.click();

        mobileObjects.stText.isDisplayed();
        Assertions.assertEquals(myText, mobileObjects.stText.getText());
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
