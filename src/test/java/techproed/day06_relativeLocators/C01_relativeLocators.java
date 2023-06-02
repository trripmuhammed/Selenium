package techproed.day06_relativeLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class C01_relativeLocators {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //Amazona gidelim
        driver.get("https://www.amazon.com");

        //city bike aratalim
        WebElement searchBox = driver.findElement(By.cssSelector("input[id='twotabsearchtextbox']"));
        searchBox.sendKeys("city bike", Keys.ENTER);

        //relative locator kullanarak hybrid bikes altindaki elemente tiklayalim
        //Webelementlerin yazisini konsola yazdiriniz.
        WebElement hybridBikes = driver.findElement(By.xpath("//*[text()='Hybrid Bikes']"));
        System.out.println(hybridBikes.getText());
        WebElement electricBike = driver.findElement(with(By.tagName("a")).below(hybridBikes));
        System.out.println(electricBike.getText());
        WebElement completeBike = driver.findElement(with(By.tagName("a")).below(electricBike));
        System.out.println(completeBike.getText());
        //Bikes altindaki tum linkleri(webelementleri) konsola yazdiralim.
        List<WebElement> list = driver.findElements(By.xpath("(//*[@class='a-list-item'])[position()>=10 and position()<16]"));
        /*
        XPATH kullaniminda bir sayfadaki webelementlere mudahale etmek istedigimizde xpath ile locate aldigimizda birden fazla sonuc
        verebilir.[position()>=10 and position()<16] bu kullanimla aralik belirterek istedigimiz WE leri secip mudahale edebiliriz.
         */
        System.out.println("*************************");
        list.forEach(t-> System.out.println(t.getText()));

        //bu linklerin hepsine tiklayalim ve sayfa basliklarini alalim
        for (int i = 0; i<list.size(); i++){
            list = driver.findElements(By.xpath("(//*[@class='a-list-item'])[position()>=10 and position()<16]"));
            //bunu tekrar yapmamizin sebebi for icinde bayatliyor burda tazeliyoruz.
            System.out.println(list.get(i).getText());
            list.get(i).click();
            Thread.sleep(3000);
            driver.navigate().back();
            Thread.sleep(3000);
        }

        completeBike.click();

        driver.close();
    }
}
