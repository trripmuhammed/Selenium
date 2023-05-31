package techproed.day04_Locators_Xpath_Css;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Objects;

public class C01_getTagName_getAttributeName {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // 1- amazon.com'a gidip arama kutusunu locate edin
        driver.get("https://www.amazon.com");
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));

        // 2- arama kutusunun tagName'inin input oldugunu test edin
        String actualTagName = searchBox.getTagName();
        String expectedTagName = "input";

        if(actualTagName.equals(expectedTagName)){
            System.out.println("Test PASSED");
        }else System.out.println("Test FAILED");

        // 3- arama kutusunun name attribute'nun degerinin field-keywords oldugunu test edin
        /*
        <input type="text" id="twotabsearchtextbox" value="" name="field-keywords" autocomplete="off" placeholder="Ara Amazon.com.tr"
        class="nav-input nav-progressive-attribute" dir="auto" tabindex="0" aria-label="Ara Amazon.com.tr"
         spellcheck="false">
         */

        String actualAttribute = searchBox.getAttribute("name");
        String expectedAttribute = "field-keywords";

        if(actualAttribute.equals(expectedAttribute)){
            System.out.println("Test PASSED");
        }else System.out.println("Test FAILED");

        // 4- sayfayı kapatınız
        driver.close();


    }
}
