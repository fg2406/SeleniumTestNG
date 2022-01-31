package tests.tekrarlar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.TestBase;

public class day13_04 extends TestBase {



    @Test
    public  void test01() {


   //ests packagenin altina bir class oluşturun : C05_UploadFile
   //https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");

        //chooseFile butonuna basalim
   WebElement fileButton=driver.findElement(By.id("file-upload"));

   //Yuklemek istediginiz dosyayi secelim. //\\DESKTOP-F0BARKV\Users\Redi\OneDrive\Masaüstü\denemeler
        String dosyaYolu=System.getProperty("user.home")+"\\OneDriver\\Masaüstü\\denemeler";

   //Upload butonuna basalim.
        fileButton.sendKeys(dosyaYolu);
   //“File Uploaded!” textinin goruntulendigini test edelim


    }
}
