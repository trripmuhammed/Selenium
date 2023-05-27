package techproed.day02_DriverMethods;

import com.beust.ah.A;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_ManageMethods_ImplicitlyWait {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        /*
        ImplicitlyWait(Duration.ofSeconds(20) Sayfadaki WebElementleri gorunur olana kadar(sayfada olana kadar)
        maximum 20 saniye bekler.Eger webelementler 2 saniyede olusursa 2 saniye bekler ve alt satira gecer.
        Fakat belirttigimiz max sure boyunca internetten veya sayfadan kaynaklı olarak webelementler olusmassa
        testimiz FAIL verir.
            Thread.sleep() java kodlarini bizim belirttigimiz sure kadar bekletir.30 saniye beklemesini belirtirsek
            30 saniye bekler ve alt satira gecer.
         */

        //techproed sayfasina gidelim
        String techproUrl = "https://www.techproeducation.com";
        driver.get(techproUrl);

        //amazona gidelim
        String amazonUrl = "https://www.amazon";
        driver.get(amazonUrl);

        //techproed sayfasina geri don
        driver.navigate().back();

        //sayfa basliginin 'techpro' icerdigini test edelim
        String actualTechTitle = driver.getTitle();
        String arananTechKelime = "techpro";
        if(actualTechTitle.contains(arananTechKelime)){
            System.out.println("Test PASSED");
        }else System.out.println("Test FAIL" + actualTechTitle);

        //tekrar amazona gidelim
        driver.navigate().forward();

        //sayfa basliginin 'Amazon' icerdigini test edelim.
        String actualAmazonTitle = driver.getTitle();
        if(actualAmazonTitle.contains("Amazon")){
            System.out.println("Test PASSED");
        }else System.out.println("Test FAIL" + actualAmazonTitle);

        //Sayfayi kapat
        driver.close();

    }
}
