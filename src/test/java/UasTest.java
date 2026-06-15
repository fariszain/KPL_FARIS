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
        
        // Konfigurasi khusus untuk HP fisik Samsung kamu
        options.setDeviceName("Samsung S25 FE"); 
        options.setUdid("RRGL102J8VE"); 
        
        // Path ke file APK yang sudah di-download
        options.setApp("/home/zeyn/Documents/KPL/app.apk"); 
        options.setAutomationName("UiAutomator2");

        // Menghubungkan ke server Appium lokal
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void testLoginInvalid() {
        // 1. Buka Hamburger Menu
        driver.findElement(AppiumBy.accessibilityId("open menu")).click();
        
        // 2. Pilih menu Log In
        driver.findElement(AppiumBy.accessibilityId("menu item log in")).click();
        
        // 3. Masukkan Username yang salah
        driver.findElement(AppiumBy.accessibilityId("Username input field")).sendKeys("user_salah@mail.com");
        
        // 4. Masukkan Password asal
        driver.findElement(AppiumBy.accessibilityId("Password input field")).sendKeys("123456");
        
        // 5. Klik tombol Login
        driver.findElement(AppiumBy.accessibilityId("Login button")).click();
        
        // 6. Validasi bahwa pesan error muncul (Asersi)
        WebElement errorMsg = driver.findElement(AppiumBy.xpath("//android.widget.TextView[contains(@text, 'Provided credentials do not match')]"));
        Assert.assertTrue(errorMsg.isDisplayed(), "Pesan error tidak muncul, test gagal!");
        System.out.println("Test Berhasil: Pesan error muncul sesuai harapan.");
    }

    @AfterClass
    public void tearDown() {
        // Menutup aplikasi dan sesi setelah test selesai
        if (driver != null) {
            driver.quit();
        }
    }
}