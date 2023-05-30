package techproed.day03_Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.security.Key;
import java.time.Duration;

public class C01_WebelementsLocators {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //Amazon sayfasina gidelim
        driver.get("https://www.amazon.com/");

        //Arama kutusunu locate edelim
        //Arama kutusuna iphone yazdiralim ve aratalim
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Iphone", Keys.ENTER);
        /*
            Bir webelementin locate'ini birden fazla kullanacaksak
            bir WebElement'e degisken olarak atayabiliriz.

            WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox")); seklinde kullanabiliriz.
            1-Locate islemi bittikten sonra eger webelemente bir metin gondereceksek sendKeys() methodunu kullaniliriz.
            2-webelemente tiklayacaksak click() methodunu
            3-webelementin uzerindeki yaziyi almak istiyorsak getText() methodunu kullaniriz.
            4-SendKeys() methodundan sonra(yani webElemente metin gonderdikten sonra) Keys.Enter ile yada
            submit() methodu ile manuel olarak enter yaptıgımız gibi otomasyonda da yapabiliriz.
         */

        Thread.sleep(3000);

        //Sayfayi kapatalim
        driver.close();
    }
}
