import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class iOSFindElements {

    public static void main(String[] args) throws Exception {
        AppiumDriver driver = CreateDriverSession2.initializeDriver("iOS");

        WebElement myElement = driver.findElement(AppiumBy.accessibilityId("Activity Indicators"));
        System.out.println(myElement.getText());

        myElement = driver.findElements(AppiumBy.className("XCUIElementTypeStaticText")).get(1);
        System.out.println(myElement.getText());

        myElement = driver.findElement(AppiumBy.name("Activity Indicators"));
        System.out.println(myElement.getText());

        myElement = driver.findElement(AppiumBy.id("Activity Indicators"));
        System.out.println(myElement.getText());

        myElement = driver.findElement(AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"Activity Indicators\"]"));
        System.out.println(myElement.getText());

       // myElement = driver.findElement(AppiumBy.tagName("Activity Indicators"));
        //System.out.println(myElement.getText());

        myElement = driver.findElement(By.id("Activity Indicators"));
        System.out.println(myElement.getText());




    }
}
