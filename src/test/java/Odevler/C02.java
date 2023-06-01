package Odevler;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02 {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //Techproeducation sayfasına gidelim
        driver.get("https://techproeducation.com/");

        //Çıkan reklamı locate edip kapatalım
        driver.findElement(By.xpath("//*[@class='eicon-close']")).click();

        //Arama bölümünde qa aratalım
        WebElement searchBox = driver.findElement(By.id("elementor-search-form-9f26725"));
        searchBox.sendKeys("qa",Keys.ENTER);

        //Sayfa başlığının qa içerdiğini doğrulayalım
        String actualTitle = driver.getTitle();
        String expectedTitle = "qa";

        if(actualTitle.contains(expectedTitle)){
            System.out.println("Test PASSED");
        }else System.out.println("Test FAILED");

        //Carrer Opportunities In QA linkinin görünür ve erişilebilir olduğunu doğrulayalım
        WebElement e1 = driver.findElement(By.xpath("(//*[@href='https://techproeducation.com/software-career-opportunities-qa/'])[2]"));
        System.out.println(e1.isDisplayed());
        System.out.println(e1.isEnabled());

        //Carrer Opportunities In QA linkine tıklayalım
        e1.click();

        //Başlığın Opportunities içerdiğini test edelim
        String actualTitle2 = driver.getTitle();
        String expectedTitle2 = "Opportunities";

        if(actualTitle2.contains(expectedTitle2)){
            System.out.println("Test PASSED");
        }else System.out.println("Test FAILED");

        //Tekrar anasayfaya dönelim ve url'in https://techproeducation.com/ olduğunu doğrulayalım
        driver.navigate().back();
        driver.navigate().back();

        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://techproeducation.com/";
        if (actualUrl.equals(expectedUrl)){
            System.out.println("Test PASSED");
        }else System.out.println("Test FAILED");

        driver.close();
    }
}
