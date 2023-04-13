import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import io.appium.java_client.TouchAction;

import java.time.Duration;

public class GesturesSwipeAndroid {

    public static void main(String[] args) throws Exception {
        AppiumDriver driver = CreateDriverSession2.initializeDriver("Android");
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        By views = AppiumBy.accessibilityId("Views");
        By grid = AppiumBy.accessibilityId("Grid");
        By animation = AppiumBy.accessibilityId("Animation");
        driver.findElement(views).click();

        Dimension size = driver.manage().window().getSize();

        int startX = size.width / 2;
        int endX = startX;

        int startY = (int) (size.height * 0.8);
        int endY = (int) (size.height * 0.2);

        /*for(int i = 0; i<3; i++) {
            TouchAction action = new TouchAction((PerformsTouchActions) driver);
            action.press(PointOption.point(startX, startY))
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000)))
                    .moveTo(PointOption.point(endX, endY))
                    .release()
                    .perform();
        }*/


            TouchAction action = new TouchAction((PerformsTouchActions) driver);
            action.press(ElementOption.element(driver.findElement(grid)))
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000)))
                    .moveTo(ElementOption.element(driver.findElement(animation)))
                    .release()
                    .perform();



        //332,1908
        //518,312
    }
}