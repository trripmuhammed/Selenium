package techproed.day02_DriverMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C02_NavigateMethods {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //Techproeducation sayfasina gidelim.
        driver.navigate().to("https://www.techproeducation.com");
        Thread.sleep(3000);//Java kodlarini bekletmek icin kullanabiliriz.

        //Sonra Amazon sayfasina gidelim.
        driver.navigate().to("https://www.amazon.com");
        Thread.sleep(3000);

        //Amazon sayfasinin basligini yazdiralim.
        System.out.println("Amazon sayfa basligi: " + driver.getTitle());
        Thread.sleep(3000);

        //TechproEducation sayfasina geri donelim.
        driver.navigate().back();
        Thread.sleep(3000);

        //Sayfa basligini yazdilarim.
        System.out.println("Techpro sayfa basligi: " + driver.getTitle());
        Thread.sleep(3000);

        //Amazon sayfasina donup gidip url'i yazdiralim
        driver.navigate().forward();
        System.out.println("Amazon sayfasi Url'si: " + driver.getCurrentUrl());
        Thread.sleep(3000);

        //Amazon sayfasindayken sayfayi yenile
        driver.navigate().refresh();
        Thread.sleep(3000);

        //Sayfayi kapatalim.
        driver.close();
    }
}
