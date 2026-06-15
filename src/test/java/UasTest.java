import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class UasTest {
    public AndroidDriver driver;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        
        // Ganti dengan nama device dari perintah 'adb devices' jika pakai HP fisik
        options.setDeviceName("emulator-5554"); 
        
        // Path ke APK yang baru saja diunduh
        options.setApp("/home/zeyn/Documents/KPL/app.apk"); 
        options.setAutomationName("UiAutomator2");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void testLoginInvalid() {
        driver.findElement(AppiumBy.accessibilityId("open menu")).click();
        driver.findElement(AppiumBy.accessibilityId("menu item log in")).click();
        driver.findElement(AppiumBy.accessibilityId("Username input field")).sendKeys("user_salah@mail.com");
        driver.findElement(AppiumBy.accessibilityId("Password input field")).sendKeys("12345");
        driver.findElement(AppiumBy.accessibilityId("Login button")).click();
        
        WebElement errorMsg = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Provided credentials do not match.']"));
        Assert.assertTrue(errorMsg.isDisplayed(), "Pesan error tidak muncul!");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}