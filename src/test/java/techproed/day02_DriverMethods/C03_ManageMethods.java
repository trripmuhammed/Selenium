package techproed.day02_DriverMethods;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C03_ManageMethods {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //Browser'in konumunu yazdiralim
        System.out.println("Sayfanin konumu : " + driver.manage().window().getPosition());

        //Browser'in boyutlarini yazdiralim.
        System.out.println("Sayfanin boyutlari: " +driver.manage().window().getSize());

        //Browser'i maximize yapalim
        driver.manage().window().maximize();
        /*
        Bir web sitesine gittigimizde browser default olarak bir boyutta gelir.
        Ve acilan browser'daki webElementlere browser maximize olmadigi icin ulasamayabiliriz.
        Dolayisiyla browser'i  actiktan sonra maximize yaparsak driver butun webElementleri
        gorur ve rahatlikla mudahale eder.Bu yuzden browser'i actiktan sonra ilk olarak
        driver.manage().window().maximize(); yapmamiz bizim webElementlere ulasmada isimizi kolaylastirir.
        Boylece FAIL almamis oluruz.
         */

        //Techproeducation sayfasina gidelim.
        driver.get("https://www.techproeducation.com");

        //Browser'in konumunu yazdiralim
        System.out.println("Sayfanin konumu : " + driver.manage().window().getPosition());


        //Browser'in boyutlarini yazdiralim.
        System.out.println("Sayfanin boyutlari: " +driver.manage().window().getSize());
        Thread.sleep(3000);

        //Sayfayi sayfayi minimize yapalim
        driver.manage().window().minimize();
        Thread.sleep(3000);

        //Sayfayi fullscreen yapalim
        driver.manage().window().fullscreen();


        Point point = new Point(50,50);//x ve y ekseninde konum belirleriz
        driver.manage().window().setPosition(point);//istedigimiz konuma getirir
        Thread.sleep(3000);

        Dimension dimension = new Dimension(600,600);//Bir boyut belirlememizi saglar
        driver.manage().window().setSize(dimension);//istedigimiz boyutu browser'a uygular.
        Thread.sleep(3000);

        //Sayfayi kapatiniz
        driver.close();
    }
}
