import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

import java.time.Duration;

public class iOSInteractWithKeyboard {

    public static void main(String[] args) throws Exception {
        AppiumDriver driver = CreateDriverSession2.initializeDriver("iOS");
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        By steppers = AppiumBy.accessibilityId("Steppers");
        By activityIndicators = AppiumBy.accessibilityId("Activity Indicators");

        Dimension size = driver.manage().window().getSize();

        int startX = size.width / 2;
        int endX = startX;

        int startY = (int) (size.height * 0.8);
        int endY = (int) (size.height * 0.2);

        for (int i = 0; i < 3; i++) {
            TouchAction action = new TouchAction((PerformsTouchActions) driver);
            action.press(PointOption.point(startX, startY))
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000)))
                    .moveTo(PointOption.point(endX, endY))
                    .release()
                    .perform();
        }

        driver.findElement(AppiumBy.accessibilityId("Text Fields")).click();
        driver.findElement(AppiumBy.xpath("//XCUIElementTypeCell[1]/XCUIElementTypeTextField")).click();
        Thread.sleep(3000);

        driver.findElement(AppiumBy.accessibilityId("q")).click();
        driver.findElement(AppiumBy.accessibilityId("w")).click();
        driver.findElement(AppiumBy.accessibilityId("x")).click();

        Thread.sleep(3000);
        driver.findElement(AppiumBy.accessibilityId("Done")).click();
    }
}
