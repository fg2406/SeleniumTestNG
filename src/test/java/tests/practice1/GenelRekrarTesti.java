package tests.practice1;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
    public class GenelRekrarTesti {
        // https://www.amazon.com.tr sitesine gidelim
        // Ana sayfanın açıldıgı kontrol edin
        // String expectedTitle="Amazon";
        // çerez tercihlerinden Çerezleri kabul et seçilir
        // siteye login olun
        // login işlemi kontrol edin
        //arama butonunun yanındaki kategörüler tabından bilgisayar secilir
        // bilgisayar kategorisi seçildigi kontrol edilir
        // arama aranına msi yaz ve arama yapın
        // aramanın yapıldıgını kontrol et
        // arama sonucları sayfasından 2. sayfa açılır
        // 2. sayfanın açıldıgı kontrol edilir
        //sayfadaki 2. ürün favorilere eklenir
        // 2. ürünün favorilere eklendigi kontrol edilir
        // hesabım->  favori listem sayfasına gidilir
        // favori Listem sayfası açıldıgı kontrol edilir
        // eklenen ürün favorilerden silinir
        // silme işleminin gerçekleştigi kontrol edilir.
        // üye çıkış işlemi yapılır
        //çıkış işleminin yapıldıgı kontrol edilir.
        static WebDriver driver;
        @BeforeClass
        public static void setup(){
            WebDriverManager.chromedriver().setup();
            driver =new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
            driver.manage().window().maximize();
        }
        @Test
        public void test01(){
            // https://www.amazon.com.tr sitesine gidelim
            driver.get("https://www.amazon.com");
            // Ana sayfanın açıldıgı kontrol edin
            boolean sayfaTesti=driver.getTitle().contains("Amazon.com");
            Assert.assertTrue(sayfaTesti);
            // String expectedTitle="Amazon";
            // çerez tercihlerinden Çerezleri kabul et seçilir
            // siteye login olun
            Actions actions=new Actions(driver);
            driver.findElement(By.xpath("//a[@data-csa-c-content-id='nav_ya_signin']")).click();

            driver.findElement(By.id("//input[@id='ap_email']")).click();
            WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("//input[@id='ap_email']")));
            // login işlemi kontrol edin

            //arama butonunun yanındaki kategörüler tabından bilgisayar secilir

            // bilgisayar kategorisi seçildigi kontrol edilir
            // arama aranına msi yaz ve arama yapın
            // aramanın yapıldıgını kontrol et
            // arama sonucları sayfasından 2. sayfa açılır
            // 2. sayfanın açıldıgı kontrol edilir
            //sayfadaki 2. ürün favorilere eklenir
            // 2. ürünün favorilere eklendigi kontrol edilir
            // hesabım->  favori listem sayfasına gidilir
            // favori Listem sayfası açıldıgı kontrol edilir
            // eklenen ürün favorilerden silinir
            // silme işleminin gerçekleştigi kontrol edilir.
            // üye çıkış işlemi yapılır
            //çıkış işleminin yapıldıgı kontrol edilir.
        }






   }


