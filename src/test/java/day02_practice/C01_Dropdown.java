package day02_practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C01_Dropdown {

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
            // https://www.amazon.com/ sayfasina gidin
            driver.get("https://www.amazon.com");

            // dropdown'dan "Books" secenegini secin
            WebElement ddm = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
            Select select = new Select(ddm);
            select.selectByVisibleText("Books");

            // arama cubuguna "Java" aratın
            driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Java" , Keys.ENTER);

            // arama sonuclarinin Java icerdigini test edin
            WebElement java = driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
            Assert.assertTrue(java.getText().contains("Java"));
        }
    }
