package techproed.day01_ilkTest_DriverMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C02_DriverMethods {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.amazon.com");
        System.out.println("Amazon Actual Title: "+driver.getTitle());
        String amazonWindowHandle = driver.getWindowHandle();
        System.out.println("amazonWindowHandle = " + amazonWindowHandle);

        driver.get("https://www.techproeducation.com");

        String title = driver.getTitle();//sayfa basligini verir.
        System.out.println("Techproeducation Actual Title: " + title);

        String url = driver.getCurrentUrl();
        System.out.println(url);
        //getCurrentUrl() gidilen sayfanin url'sini verir.
        System.out.println("Techproed Actual Url: " +driver.getCurrentUrl());

        //getPageSource() acilan sayfanin kaynak kodlarini verir.
        //System.out.println(driver.getPageSource()); uzun oldugundan yoruma aldik.

        //getWindowHandle() gidilen sayfanin handle degerini(hashcode) verir.Bu handle degerini sayfalar arasi gecis icin kullaniriz.
        System.out.println("Techproed Window Handle Degeri: " +driver.getWindowHandle());


    }
}
