import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Waits {

    public static void main(String[] args) throws Exception {
        AppiumDriver driver = CreateDriverSession2.initializeDriver("iOS");
      //  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        By alertViews = AppiumBy.accessibilityId("Alert Views");
        By okeyCancel = AppiumBy.accessibilityId("Okay / Cancel");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(alertViews)).click();


        //driver.findElement(alertViews).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(okeyCancel)).click();
        //driver.findElement(okeyCancel).click();
    }
}
