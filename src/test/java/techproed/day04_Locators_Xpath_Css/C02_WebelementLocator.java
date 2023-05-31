package techproed.day04_Locators_Xpath_Css;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C02_WebelementLocator {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // https://www.amazon.com sayfasına gidiniz
        driver.get("https://www.amazon.com");

        // arama kutusuna "city bike" yazıp aratın
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("city bike", Keys.ENTER);

        // sonuc yazısını yazdırın
        //(bunlada alabiliriz) driver.findElements(By.id("a-section a-spacing-small a-spacing-top-small"))
        List<WebElement> sonucYazisi = driver.findElements(By.className("sg-col-inner"));
        String sonucMetni = sonucYazisi.get(0).getText();
        System.out.println(sonucMetni);

        //Xpath ile list kullanmadan tek seferde locate aldik
        WebElement sonucYazisiXpath = driver.findElement(By.xpath("(//div[@class='sg-col-inner'])[1]"));

        // sonuc sayısını yazdırın
        String sonucSayisi = sonucMetni.split(" ")[2];
        System.out.println("sonucSayisi = " + sonucSayisi);

        //Sayfadaki 12. elementi list kullanmadan xpath'in index ozelligini kullanarak locate aldik.
        WebElement onikinciElement = driver.findElement(By.xpath("(//*[@class='sg-col-inner'])[12]"));
        System.out.println(onikinciElement.getText());

        // ilk ürünün locatini alın
        List<WebElement> urunler = driver.findElements(By.className("s-image"));
        WebElement ilkUrun = urunler.get(0);

        // ilk ürünün, görünür olup olmadıgını true, false seklinde yazdırın
        System.out.println(ilkUrun.isDisplayed());

        // ilk ürünün, erisilebilir olup olmadıgını true, false seklinde yazdırın
        System.out.println(ilkUrun.isEnabled());

        // ilk ürünün, secilebilir olup olmadıgını true, false seklinde yazdırın
        System.out.println(ilkUrun.isSelected());
        //false cunku secilme ozelligine sahip degil

        // ilk urune tıklayın
        ilkUrun.click();

        // sayfayı kapatın
        driver.close();

        //Arama kutusunun HTML kodlari
        /*
        <input type="text" value="" name="field-keywords" autocomplete="off" placeholder="Ara Amazon.com.tr"
        class="nav-input nav-progressive-attribute" dir="auto" tabindex="0" aria-label="Ara Amazon.com.tr"
         spellcheck="false">
         */
        //Relative Xpath Syntax -->  //tagName[@attributeName='attributeValue']
                                     //input[@type='text']
                             //      (//input[@type='text'])[1]
   // * farketmez anlamina gelir     //*[@type='text']
        /*
        Aldigimiz xpath unique olmadigi zaman xpathimizi parantez icine alarak index belirtebiliriz.
        Böylelikle webelementleri Liste atip istedigimiz elementi almakla ugrasmayiz
        Xpath'in degisik kullanma yollari vardir.Ustteki yol en garanti yoldur.
         */

    }
}
