import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

import java.time.Duration;

public class GesturesSwipeIOS {

    public static void main(String[] args) throws Exception {
        AppiumDriver driver = CreateDriverSession2.initializeDriver("iOS");
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        By steppers = AppiumBy.accessibilityId("Steppers");
        By activityIndicators = AppiumBy.accessibilityId("Activity Indicators");

        /*Dimension size = driver.manage().window().getSize();

        int startX = size.width / 2;
        int endX = startX;

        int startY = (int) (size.height * 0.8);
        int endY = (int) (size.height * 0.2);

        for(int i = 0; i<3; i++) {
            TouchAction action = new TouchAction((PerformsTouchActions) driver);
            action.press(PointOption.point(startX, startY))
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000)))
                    .moveTo(PointOption.point(endX, endY))
                    .release()
                    .perform();
        }*/


            TouchAction action = new TouchAction((PerformsTouchActions) driver);
            action.press(ElementOption.element(driver.findElement(steppers)))
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000)))
                    .moveTo(ElementOption.element(driver.findElement(activityIndicators)))
                    .release()
                    .perform();



        //332,1908
        //518,312
    }
}