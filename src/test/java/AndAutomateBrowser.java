import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class AndAutomateBrowser {

    public static void main(String[] args) throws Exception {
        AppiumDriver driver = CreateBrowserSession.initializeDriver("Android");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://tesla.com");

        driver.findElement(By.xpath("//*[@id=\"tds-site-header\"]/ol/li/button/span")).click();
        driver.findElement(By.xpath("//*[@id=\"tds-global-menu\"]/dialog/section/ol/li[3]/a/span")).click();
        driver.findElement(By.xpath("//*[@id=\"tesla-hero-2846\"]/div[2]/div/section/div/a")).click();
        //Thread.sleep(10000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("tds-modal-close"))).click();
        //driver.findElement(By.className("tds-modal-close")).click();
        //Thread.sleep(10000);




        WebElement paymentButton = driver.findElement(By.xpath("//*[@id=\"main-content\"]/section/div/div/div[8]/div/div/div[2]/button/span"));
        //((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true)", paymentButton);

        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"main-content\"]/section/div/div/div[8]/div/div/div[2]/button"))).click();
        Thread.sleep(10000);
        WebElement paymentButton2 = driver.findElement(By.xpath("//*[@id=\"main-content\"]/section/div/div/div[8]/div/div/div[2]/button/span"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true)", paymentButton2);

        Thread.sleep(10000);
        paymentButton.click();

        Thread.sleep(10000);

        WebElement orderWithCardButton = driver.findElement(By.xpath("//*[@class=\"tds-btn_group--stacked payment-options\"]/button"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true)", orderWithCardButton);
        Thread.sleep(10000);
        orderWithCardButton.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("privateVatId"))).sendKeys("122845897");
        //driver.findElement(By.id("privateVatId")).sendKeys("122845897");

    }
}
