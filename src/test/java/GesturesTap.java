import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.TouchAction;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class GesturesTap {

    public static void main(String[] args) throws Exception {
        AppiumDriver driver = CreateDriverSession2.initializeDriver("iOS");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        By accessibility = AppiumBy.accessibilityId("Activity Indicators");

        TouchAction action = new TouchAction((PerformsTouchActions) driver);
        //action.tap(ElementOption.element(driver.findElement(accessibility))).perform();
        //action.tap(PointOption.point(538, 416)).perform();
        //action.tap(TapOptions.tapOptions().withElement(ElementOption.element(driver.findElement(accessibility)))).perform();
        //action.press(ElementOption.element(driver.findElement(accessibility))).waitAction(WaitOptions.waitOptions(Duration.ofMillis(5000))).release().perform();
        action.longPress(ElementOption.element(driver.findElement(accessibility))).waitAction(WaitOptions.waitOptions(Duration.ofMillis(5000))).release().perform();



    }
}

//TAP, PRESS, LONGPRESS, WIATACTION, RELEASE, PERFORM, MOVETO

