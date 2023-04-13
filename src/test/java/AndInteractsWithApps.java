import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.appmanagement.AndroidInstallApplicationOptions;
import io.appium.java_client.android.appmanagement.AndroidTerminateApplicationOptions;
import org.openqa.selenium.By;

import java.io.File;
import java.time.Duration;

public class AndInteractsWithApps {

    public static void main(String[] args) throws Exception {
        AppiumDriver driver = CreateDriverSession2.initializeDriver("Android");
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        By views = AppiumBy.accessibilityId("Views");
        driver.findElement(views).click();

        Thread.sleep(5000);
        System.out.println(((AndroidDriver) driver).queryAppState("io.appium.android.apis"));
        Thread.sleep(5000);
        ((AndroidDriver) driver).terminateApp("io.appium.android.apis");
        Thread.sleep(5000);
        System.out.println(((AndroidDriver) driver).queryAppState("io.appium.android.apis"));

        //((AndroidDriver) driver).runAppInBackground(Duration.ofMillis(5000));

       /* ((AndroidDriver) driver).terminateApp("io.appium.android.apis");
        Thread.sleep(5000);
        ((AndroidDriver) driver).activateApp("com.android.settings");
        Thread.sleep(5000);
        ((AndroidDriver) driver).activateApp("io.appium.android.apis");*/

        //System.out.println(((AndroidDriver) driver).isAppInstalled("io.appium.android.apis"));

        //((AndroidDriver) driver).terminateApp("io.appium.android.apis");


        String appUrl = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main"
                + File.separator + "resources" + File.separator + "ApiDemos-debug.apk";

       // ((AndroidDriver) driver).installApp(appUrl, new AndroidInstallApplicationOptions().withReplaceEnabled());

    }
}
