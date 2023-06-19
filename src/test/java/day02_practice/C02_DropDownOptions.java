package day02_practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C02_DropDownOptions {

    WebDriver driver;
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @Test
    public void tesr01() {

        // https://www.amazon.com/ sayfasina gidin
        driver.get("https://www.amazon.com");

        // dropdown'dan "Baby" secenegini secin
        WebElement ddm = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select select = new Select(ddm);
        select.selectByVisibleText("Baby");

        // sectiginiz option'i yazdirin
        System.out.println(select.getFirstSelectedOption().getText());

        // dropdown'daki optionlarin toplam sayısının 28'e esit oldugunu test edin
        List<WebElement> options = select.getOptions();
        int expected = 28;
        int actual = options.size();
        Assert.assertEquals(expected, actual);

        select.getOptions().equals(28);

        // dropdown'daki optionların tamamını yazdırın
        int sayac = 1;
        for (WebElement f : options) {
            System.out.println(sayac + "." + f.getText());
            sayac++;
        }
        options.forEach(m-> System.out.println(m.getText()));
    }
}