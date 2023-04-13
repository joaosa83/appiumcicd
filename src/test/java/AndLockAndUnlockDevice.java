import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class AndLockAndUnlockDevice {

    public static void main(String[] args) throws Exception {
        AppiumDriver driver = CreateDriverSession2.initializeDriver("Android");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        ((AndroidDriver) driver).lockDevice();
        System.out.println(((AndroidDriver) driver).isDeviceLocked());
        ((AndroidDriver) driver).unlockDevice();
    }
}
