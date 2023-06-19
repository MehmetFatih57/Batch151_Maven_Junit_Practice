package day03_practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Odev {

    WebDriver driver;
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void test01() {

        // https://www.google.com/ adresine gidin
        driver.get("https://www.google.com/");

        // sayfa baslıgının "Google" kelimesini icerdigini test edin
        Assert.assertTrue(driver.getTitle().contains("Google"));

        // arama cubuguna "Nutella" yazıp aratın
        driver.findElement(By.xpath("//textarea[@class='gLFyf']")).sendKeys("Nutella" , Keys.ENTER);

        // bulunan sonuc sayısını yazdırın
        String sonucYazisi = driver.findElement(By.xpath("//div[@id='result-stats']")).getText();
        String [] sonucSayisi = sonucYazisi.split(" ");
        String result = sonucSayisi[1].replace(".","");
        System.out.println("Nutella Sonuc Sayisi : " + result);
        int intSonuc=Integer.valueOf(result);
        System.out.println(intSonuc);

        // sonuc sayısının 100000000  fazla oldugunu test edin
        Assert.assertTrue(intSonuc>100000000);
    }

    @After
    public void afterClass() throws Exception {
        driver.close();
    }
}
