package tests.tekrarlar;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class C04 {

    WebDriver driver;
    @BeforeClass
    public  void  setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("http://demo.guru99.com/test/guru99home/");

    }
    @Test
    public  void  test01() {


        //1) http://demo.guru99.com/test/guru99home/ sitesine gidiniz

        //2) sayfadaki iframe sayısını bulunuz.
        //3)
        //ilk iframe'deki (Youtube) play butonuna tıklayınız.
        //4)
        //ilk iframe'den çıkıp ana sayfaya dönünüz
        //5)
        //ikinci iframe'deki (Jmeter Made Easy) linke (https://www.guru99.com/live selenium project.html)
        //tıklayınız
    }

    @AfterClass
    public  void  tearDown(){

    }


}
