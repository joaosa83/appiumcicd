import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;

import java.io.File;
import java.time.Duration;

public class iOSInteractWithApps {

    public static void main(String[] args) throws Exception {
        AppiumDriver driver = CreateDriverSession2.initializeDriver("iOS");
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        By views = AppiumBy.accessibilityId("Activity Indicators");
        driver.findElement(views).click();


        Thread.sleep(5000);
        System.out.println(((IOSDriver) driver).queryAppState("com.example.apple-samplecode.UICatalog"));
        Thread.sleep(5000);
        ((IOSDriver) driver).terminateApp("com.example.apple-samplecode.UICatalog");
        Thread.sleep(5000);
        System.out.println(((IOSDriver) driver).queryAppState("com.example.apple-samplecode.UICatalog"));
        String iOSAppUrl = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + "resources"
                + File.separator + "UIKitCatalog-iphonesimulator.app";

        //((IOSDriver) driver).installApp(iOSAppUrl);
        //((IOSDriver) driver).runAppInBackground(Duration.ofMillis(5000));
      //  ((IOSDriver) driver).activateApp("com.apple.Preferences");
       // Thread.sleep(5000);
       // ((IOSDriver) driver).activateApp("com.example.apple-samplecode.UICatalog");
    }
}
