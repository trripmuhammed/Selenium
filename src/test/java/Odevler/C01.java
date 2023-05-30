package Odevler;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //Amazon sayfasina gidiniz
        driver.get("https://www.amazon.com");

        //iphone aratiniz
        driver.findElement(By.id(""));

        //cikan sonuc yazisini konsola yazdiriniz
        //cikan urunlerden ilk 5 tanesine tiklayip sayfa basliklarini yazdiriniz.
    }
}
