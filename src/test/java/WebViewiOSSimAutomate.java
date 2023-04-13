import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.remote.SupportsContextSwitching;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.naming.Context;
import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class WebViewiOSSimAutomate {

    public static void main(String[] args) throws Exception {
        AppiumDriver driver = CreateDriverSession2.initializeDriver("iOS");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

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

        driver.findElement(AppiumBy.accessibilityId("Web View")).click();
        Thread.sleep(10000);

        Set<String> contextHandles = ((SupportsContextSwitching) driver).getContextHandles();
        for(String contextHandle : contextHandles){
            System.out.println(contextHandle);
        }

        ((SupportsContextSwitching) driver).context(contextHandles.toArray()[1].toString());
        System.out.println(driver.findElement(By.cssSelector("body > h1")).getText());
        System.out.println(driver.findElement(By.xpath("//h1")).getText());
        System.out.println(driver.findElement(By.tagName("h1")).getText());

        ((SupportsContextSwitching) driver).context("NATIVE_APP");
        driver.findElement(AppiumBy.xpath("//XCUIElementTypeButton[@name=\"UIKitCatalog\"]")).click();
        driver.quit();

        }


}
