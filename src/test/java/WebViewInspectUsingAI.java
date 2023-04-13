import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.remote.SupportsContextSwitching;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

import java.time.Duration;
import java.util.Set;

public class WebViewInspectUsingAI {

    public static void main(String[] args) throws Exception {
        AppiumDriver driver = CreateDriverSession2.initializeDriver("Android");
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.findElement(AppiumBy.accessibilityId("Views")).click();


        Dimension size = driver.manage().window().getSize();

        int startX = size.width / 2;
        int endX = startX;

        int startY = (int) (size.height * 0.8);
        int endY = (int) (size.height * 0.2);

        for (int i = 0; i < 4; i++) {
            TouchAction action = new TouchAction((PerformsTouchActions) driver);
            action.press(PointOption.point(startX, startY))
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000)))
                    .moveTo(PointOption.point(endX, endY))
                    .release()
                    .perform();
        }

        driver.findElement(AppiumBy.accessibilityId("WebView")).click();
        Thread.sleep(3000);
        //System.out.println(driver.findElement(AppiumBy.xpath("//android.webkit.WebView/android.widget.TextView[1]")).getText());
        //System.out.println(driver.findElement(AppiumBy.accessibilityId("This is HTML content inside a WKWebView .")).getAttribute("label"));

        Set<String> contextHandles = ((SupportsContextSwitching) driver).getContextHandles();
        for (String contextHandle : contextHandles){
            System.out.println(contextHandle);
        }

        //((SupportsContextSwitching) driver).context("WEBVIEW");

        ((SupportsContextSwitching) driver).context(contextHandles.toArray()[2].toString());
        System.out.println(driver.findElement(By.cssSelector("body > h1")).getText());
        System.out.println(driver.findElement(By.id("i_am_a_textbox")).getText());

        ((SupportsContextSwitching) driver).context("NATIVE_APP");


    }
}
