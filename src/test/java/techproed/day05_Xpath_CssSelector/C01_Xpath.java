package techproed.day05_Xpath_CssSelector;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class C01_Xpath {
    public static void main(String[] args) {

        System.setProperty("webdriver.edge.driver","src/resources/drivers/msedgedriver.exe");
        WebDriver driver = new EdgeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // https://www.amazon.com sayfasına gidiniz
        driver.get("https://www.amazon.com");

        // arama kutusuna "city bike" yazıp aratın
        /*Arama kutusu HTML kodlari
            <input type="text" id="twotabsearchtextbox" value="" name="field-keywords"
            autocomplete="off" placeholder="Search Amazon" class="nav-input nav-progressive-attribute"
            dir="auto" tabindex="0" aria-label="Search Amazon" spellcheck="false">
         */
        WebElement searchBox = driver.findElement(By.xpath("//*[@name='field-keywords']"));
        searchBox.sendKeys("city bike",Keys.ENTER);

        //Hybrid Bikes bolumune tikla
        driver.findElement(By.xpath("//*[text()='Hybrid Bikes']")).click();
        //  //*[.='Hybrid Bikes'] nokta text icin kullanilir

        // sonuc yazısını yazdırın
        WebElement sonucYazisi = driver.findElement(By.xpath("//*[@class='sg-col-inner'][1]"));
        System.out.println(sonucYazisi.getText());

        // sonuc sayısını yazdırın
        String sonucSayisi = sonucYazisi.getText().split(" ")[2];
        if(!sonucYazisi.getText().split(" ")[0].contains("-"))
            sonucSayisi = sonucYazisi.getText().split(" ")[0];

        System.out.println(sonucSayisi);

        // ilk ürünün locatini alın
        WebElement ilkUrun = driver.findElement(By.xpath("//h2)[1]"));
        // //*[@class='a-size-medium a-color-base a-text-normal'][1]

        // ilk ürünün, görünür olup olmadıgını true, false seklinde yazdırın
        if(ilkUrun.isDisplayed()){
            System.out.println("Test PASSED");
        }else System.out.println("Test FAILED");

        // ilk ürünün, erisilebilir olup olmadıgını true, false seklinde yazdırın
        if(ilkUrun.isEnabled()){
            System.out.println("Test PASSED");
        }else System.out.println("Test FAILED");

        // ilk ürünün, secilebilir olup olmadıgını true, false seklinde yazdırın
        if(ilkUrun.isSelected()){
            System.out.println("Test PASSED");
        }else System.out.println("Test FAILED");

        // ilk urune tıklayın
        ilkUrun.click();

        // sayfayı kapatın
        driver.close();
    }
}
