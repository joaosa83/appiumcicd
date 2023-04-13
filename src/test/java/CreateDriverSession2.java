import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.zip.Deflater;

public class CreateDriverSession2 {


    public static AppiumDriver initializeDriver(String platformName) throws Exception {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, platformName);
        caps.setCapability("newCommandTimeout", 300);

        URL url = new URL("http://0.0.0.0:4723/wd/hub");

        switch (platformName) {
            case "Android":
                caps.setCapability("avd", "Pixel5");
                //caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixell3");
                //caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12");
                caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
                caps.setCapability(MobileCapabilityType.UDID, "emulator-5554");
                String appUrl = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + "ApiDemos-debug.apk";
                //caps.setCapability(MobileCapabilityType.APP, appUrl);
                caps.setCapability("appPackage", "io.appium.android.apis");
                caps.setCapability("appActivity", "io.appium.android.apis.ApiDemos");
                caps.setCapability("unlockType", "pattern");
                caps.setCapability("unlockKey", "125478963");
                //caps.setCapability("chromedriverExecutable", "/Users/joaomirandasa/Downloads/chromedriver_mac64/chromedriver");
                return new AndroidDriver(url, caps);
            case "iOS":
                caps.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 11");
                caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
                caps.setCapability(MobileCapabilityType.UDID, "C0091E7D-F1D7-4358-B7DA-072F45498CBC");
                caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "16");
                caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
                String iOSAppUrl = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + "resources"
                        + File.separator + "UIKitCatalog-iphonesimulator.app";
                //caps.setCapability(MobileCapabilityType.APP, appUrl);
                caps.setCapability("simulatorStartupTimeout", 180000);
                caps.setCapability("bundleId", "com.example.apple-samplecode.UICatalog");
                caps.setCapability("includeSafariInWebviews", true);
                caps.setCapability("webviewConnectTimeout", "9000");
                return new IOSDriver(url, caps);
            default:
                throw new Exception("invalid platform");
        }
    }
}


