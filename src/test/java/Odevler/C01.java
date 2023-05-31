package Odevler;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C01 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //Amazon sayfasina gidiniz
        driver.get("https://www.amazon.com");

        //iphone aratiniz
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Iphone", Keys.ENTER);

        //cikan sonuc yazisini konsola yazdiriniz
        driver.findElement(By.xpath("(//*[@class='sg-col-inner'])[1]")).getText();

        //cikan urunlerden ilk 5 tanesine tiklayip sayfa basliklarini yazdiriniz.
        for(int i=0;i<5;i++){
            driver.findElement(By.xpath("(//*[@class='a-section aok-relative s-image-fixed-height'])[" +(i+1)+"]")).click();
            System.out.println(driver.getTitle());
            driver.navigate().back();
        }

        driver.close();
    }
}
