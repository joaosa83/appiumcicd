import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DifferentWayOfDefiningElements {

    @AndroidFindBy (xpath = "//*[@text=\"Accessibility\"]")
    @iOSXCUITFindBy (accessibility = "Accessibility")
    private static WebElement webElement3;

    public DifferentWayOfDefiningElements(AppiumDriver driver){
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public static void main(String[] args) throws Exception {
        AppiumDriver driver = CreateDriverSession2.initializeDriver("Android");
        DifferentWayOfDefiningElements differentWayOfDefiningElements = new DifferentWayOfDefiningElements(driver);
        webElement3.getText();
        System.out.println(webElement3.getText());



        By myElement2 = By.xpath("//*[@text=\"Accessibility\"]");
        System.out.println(driver.findElement(myElement2).getText());

        By myElement3 = AppiumBy.accessibilityId("Accessibility");
        System.out.println(driver.findElement(myElement3).getText());

        WebElement myElement = driver.findElement(AppiumBy.accessibilityId("Accessibility"));
        System.out.println(myElement.getText());

        driver.findElement(myElement2).click();

    }
}
