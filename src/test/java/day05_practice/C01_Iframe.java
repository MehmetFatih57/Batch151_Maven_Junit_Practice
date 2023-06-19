package day05_practice;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C01_Iframe extends TestBase {
    @Test
    public void test01() {
        // https://www.jqueryscript.net/demo/jQuery-Plugin-For-Responsive-Flexible-Iframes-Flexy/ sayfasına gidiniz
        driver.get("https://www.jqueryscript.net/demo/jQuery-Plugin-For-Responsive-Flexible-Iframes-Flexy/");

        // Videoyu görecek kadar asagiya ininiz
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        // Videoyu izlemek icin Play tusuna basiniz
        driver.switchTo().frame(0);
        driver.findElement(By.xpath("//button[@class='ytp-large-play-button ytp-button ytp-large-play-button-red-bg']")).click();

        /*
        play'i dogru locate edip click yapmamiza ragmen videoyu calistirmadi.
        Bunun uzerine HTML kodlarini inceleyince Play'in aslinda bir iframe icerisinde oldugunu gorduk.
        Bu durumda once iframe'i locate edip sonra switchTo() ile iframe'e gecmeliyiz
         */

        durYolcu(3);

        // videoyu durdurunuz
        driver.findElement(By.xpath("//button[@class='ytp-play-button ytp-button']")).click();
        durYolcu(2);

        // videoyu tam ekran yapınız
        driver.findElement(By.xpath("//button[@class='ytp-fullscreen-button ytp-button']")).click();
        durYolcu(2);

        // videoyu calıstırınız
        driver.findElement(By.xpath("//button[@class='ytp-play-button ytp-button']")).click();
        durYolcu(2);

        // videoyu kucultunuz
        driver.findElement(By.xpath("//button[@class='ytp-fullscreen-button ytp-button']")).click();
        durYolcu(2);

        // videoyu durdurunuz
        driver.findElement(By.xpath("//button[@class='ytp-play-button ytp-button']")).click();
        durYolcu(2);

        // Videoyu calistirdiginizi test ediniz
        assert driver.findElement(By.xpath("//a[@class='ytp-youtube-button ytp-button yt-uix-sessionlink']")).isDisplayed();
        durYolcu(2);

        // 'jQuery Flexy Plugin Demos' yazısının gorunur oldugunu test ediniz
        driver.switchTo().parentFrame();
        assert driver.findElement(By.xpath("//h1[@style='margin-top:150px;']")).isDisplayed();
    }
}
