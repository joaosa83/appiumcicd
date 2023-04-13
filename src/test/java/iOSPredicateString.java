import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class iOSPredicateString {

    public static void main(String[] args) throws Exception {
        AppiumDriver driver = CreateDriverSession2.initializeDriver("iOS");

        WebElement myElement = driver.findElements(AppiumBy.iOSNsPredicateString("name == \"Activity Indicators\" OR name == \"Alert Views\"")).get(1);
        System.out.println(myElement.getText());


        myElement = driver.findElement(AppiumBy.iOSNsPredicateString("type == \"XCUIElementTypeStaticText\" AND name == \"Activity Indicators\""));
        System.out.println(myElement.getText());










    }
}
