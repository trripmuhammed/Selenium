package techproed.day03_Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_Submit {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //Amazon sayfasina gidelim
        driver.get("https://www.amazon.com");

        //Arama kutusunu locate edip iphone aratalim
        WebElement searchBox = driver.findElement(By.name("field-keywords"));
        searchBox.sendKeys("Iphone");
        Thread.sleep(2000);
        searchBox.submit();//Keys.ENTER

        //Sayfayi kapatalim
        driver.close();
    }
}
