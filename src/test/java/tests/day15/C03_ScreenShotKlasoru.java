package tests.day15;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.TestBase;
import java.io.IOException;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C03_ScreenShotKlasoru extends TestBase {

    //amazona gidin
   //3 farkli test methodu ile java, nutella ve elma aratip
   //sonuc sayfasini screenshot'i kaydedin

        WebElement aramaKutusu;
        @Test
        public void test01() throws IOException {
            driver.get("https://www.amazon.com");
            aramaKutusu=driver.findElement(By.id("twotabsearchtextbox")); //mutlaka deger atamasi yapalim
            aramaKutusu.sendKeys("Java" + Keys.ENTER);
            tumSayfaScreenshot();
        }
        @Test
        public void test02() throws IOException {
            aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
            aramaKutusu.clear();
            aramaKutusu.sendKeys("Nutella" + Keys.ENTER);
            tumSayfaScreenshot();
        }
        @Test
        public void test03() throws IOException {
            aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
            aramaKutusu.clear();
            aramaKutusu.sendKeys("elma" + Keys.ENTER);
            tumSayfaScreenshot();
            driver.close();
        }
    }







