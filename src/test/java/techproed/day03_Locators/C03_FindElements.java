package techproed.day03_Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C03_FindElements {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //Amazon sayfasina gidelim
        driver.get("https://www.amazon.com");

        //Sayfadaki linklerin sayisini ve linkeri yazdiralim
        /*
        findelement ile bir webelemente ulasirken, birden fazla webelement icin
        findelements() methodunu kullaniriz.Bu webelementlerin sayisina ulasmak icin yada
        bu webelementlerin yazisini konsola yazdirabilmek icin
        List<Webelement> linklerListesi = driver.findElements(By.locator("locator degeri")) olarak kullaniriz.
        olusturmus oldugumuz list'i loop ile konsola yazdiririz.
         */
        List<WebElement> linklerListesi = driver.findElements(By.tagName("a"));
        System.out.println("Linlerin Sayisi = " + linklerListesi.size());
/*
        for(WebElement w : linklerListesi) {
            if (!w.getText().isEmpty()) {
                System.out.println(w.getText());
            }
        }
  */
  //Lambda ile yazdiralim
        //linklerListesi.stream().filter(t -> !t.getText().isEmpty()).forEach(t -> System.out.println(t.getText()));
        linklerListesi.forEach(link -> {if(!link.getText().isEmpty()){System.out.println(link.getText());}});

        //Shop deals in Electronics webElementinin yazisini yazdiralim
        System.out.println("**************************");
        System.out.println(driver.findElement(By.id("nav-link-accountList-nav-line-1")).getText());
        WebElement link = driver.findElement(By.id("nav-link-accountList-nav-line-1"));
        String linkYazisi = link.getText();
        System.out.println(linkYazisi);

        //Siteyi kapatalim
        driver.close();

    }
}
