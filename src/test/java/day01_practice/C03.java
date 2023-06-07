package day01_practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03 {
    // https://www.bestbuy.com/ sayfasına gidin
    // sayfa Title'ini alın "Best" içerdigini test edin
    // BestBuy logosunun görüntülendigini test edin
    // Canada logosunun görüntülendigini test edin

    WebDriver driver;
    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void bestBuy() {
        // https://www.bestbuy.com/ sayfasına gidin
        driver.get("https://www.bestbuy.com");
        // sayfa Title'ini alın "Best" içerdigini test edin
        Assert.assertTrue(driver.getTitle().contains("Best"));
        // BestBuy logosunun görüntülendigini test edin
        WebElement baslik = driver.findElement(By.xpath("//img[@class='logo']"));
        Assert.assertTrue(baslik.isDisplayed());
        // Canada logosunun görüntülendigini test edin
        WebElement logo = driver.findElement(By.xpath("(//a[@class='canada-link'])[1]"));
        Assert.assertTrue(logo.isDisplayed());
    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }
}
