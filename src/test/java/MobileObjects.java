import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class MobileObjects {

    private AppiumDriver driver;

    @AndroidFindBy(id = "userInput")
    @iOSXCUITFindBy(xpath = "//XCUIElement...")
    public MobileElement userInput;

    @AndroidFindBy(id = "buttonChange")
    @iOSXCUITFindBy(xpath = "//XCUIElement...")
    public MobileElement btnChange;

    @AndroidFindBy(id = "textToBeChanged")
    @iOSXCUITFindBy(xpath = "//XCUIElement...")
    public MobileElement textToBeChanged;

    @AndroidFindBy(id = "buttonActivity")
    @iOSXCUITFindBy(xpath = "//XCUIElement...")
    public MobileElement btnActivity;

    @AndroidFindBy(id = "text")
    @iOSXCUITFindBy(xpath = "//XCUIElement...")
    public MobileElement stText;

    public MobileObjects(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
    }

}
