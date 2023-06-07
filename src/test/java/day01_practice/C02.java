package day01_practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02 {

    // https://www.sahibinden.com/ sayfasina gidin
    // Title ve Url'ini alın ve yazdırın
    // Title'in "Online" kelimesini içerip içermedigini test edin
    // Url'in "sahibinden" kelimesini içerip içermedigini test edin
    // https://www.amazon.com/ sayfasına gidin
    // Title'ini alın ve yazdırın
    // Title'in "more" kelimesini içerip içermedigini test edin
    // sahibinden.com'a geri dönün
    // sayfayı yenileyin
    // amazon.com'a tekrar gelin

    WebDriver driver;
    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @Test
    public void sahibinden() throws InterruptedException {
        // https://www.sahibinden.com/ sayfasina gidin
        driver.get("https://www.sahibinden.com");
        // Title ve Url'ini alın ve yazdırın
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        // Title'in "Online" kelimesini içerip içermedigini test edin
        Assert.assertTrue(driver.getTitle().contains("Online"));
        // Url'in "sahibinden" kelimesini içerip içermedigini test edin
        Assert.assertTrue(driver.getCurrentUrl().contains("sahibinden"));
        // https://www.amazon.com/ sayfasına gidin
        driver.get("https://www.amazon.com/");
        // Title'ini alın ve yazdırın
        System.out.println(driver.getTitle());
        // Title'in "more" kelimesini içerip içermedigini test edin
        Assert.assertTrue(driver.getTitle().contains("more"));
        System.out.println(driver.getCurrentUrl());
        Thread.sleep(2000);
        // sahibinden.com'a geri dönün
        driver.navigate().back();
        Thread.sleep(2000);
        // sayfayı yenileyin
        driver.navigate().refresh();
        Thread.sleep(2000);
        // amazon.com'a tekrar gelin
        driver.navigate().forward();
    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }
}
