import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class MobileObjects {

    private AppiumDriver driver;

    @AndroidFindBy(id = "userInput")
    public MobileElement userInput;

    @AndroidFindBy(id = "buttonChange")
    public MobileElement btnChange;

    @AndroidFindBy(id = "textToBeChanged")
    public MobileElement textToBeChanged;

    @AndroidFindBy(id = "buttonActivity")
    public MobileElement btnActivity;

    @AndroidFindBy(id = "text")
    public MobileElement stText;

    public MobileObjects(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
    }

}
