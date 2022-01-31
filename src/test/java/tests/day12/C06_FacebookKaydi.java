package tests.day12;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C06_FacebookKaydi extends TestBase {

  //Yeni bir class olusturalim: D15_MouseActions4


    @Test
    public void test01() throws InterruptedException {
        //1- https://www.facebook.com adresine gidelim
        driver.get("https://www.facebook.com");

        driver.findElement(By.xpath("//button[text()='Tüm Çerezlere İzin Ver']")).click();

        //2- Yeni hesap olustur butonuna basalim
        WebElement yeniButton=driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']"));
        yeniButton.click();
        //3- Ad, soyad, mail ve sifre kutularina deger yazalim ve kaydol tusuna basalim

        Actions actions=new Actions(driver);
       WebElement nameBox= driver.findElement(By.xpath("//input[@name='firstname']"));
       actions.click(nameBox).
               keyDown(Keys.SHIFT).sendKeys("s").
               keyUp(Keys.SHIFT).sendKeys("iliz").sendKeys(Keys.TAB).
               keyDown(Keys.SHIFT).sendKeys("g").keyUp(Keys.SHIFT).
               sendKeys("ul").sendKeys(Keys.TAB).
               sendKeys("glt@gmail.com").sendKeys(Keys.TAB).
               sendKeys("glt@gmail.com").sendKeys(Keys.TAB).
               sendKeys("12345").sendKeys(Keys.TAB).
               sendKeys("30").sendKeys(Keys.TAB).
               sendKeys("Nisan").sendKeys(Keys.TAB).
               sendKeys("1983").sendKeys(Keys.TAB).sendKeys("kadin").
               sendKeys(Keys.TAB).sendKeys(Keys.ARROW_LEFT).sendKeys(Keys.TAB).sendKeys(Keys.TAB).
               sendKeys(Keys.ENTER).perform();


        //4- Kaydol tusuna basalim

        //driver.findElement(By.xpath("//button[text()='Kaydol']")).click();

       /* Actions action=new Actions(driver);
        WebElement user=driver.findElement(By.xpath("(//input[@type='text'])[2]"));
        action.click(user).
                keyDown(Keys.SHIFT).
                sendKeys("s").
                keyUp(Keys.SHIFT).sendKeys("eyfullah").
                sendKeys(Keys.TAB).keyDown(Keys.SHIFT).sendKeys("m").keyUp(Keys.SHIFT).sendKeys("erdanli").
                sendKeys(Keys.TAB).sendKeys("merdanseyfullah33@hotmail.com").
                sendKeys(Keys.TAB).sendKeys("merdanseyfullah33@hotmail.com").
                sendKeys(Keys.TAB).sendKeys("123456asdF.").sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).sendKeys("19").
                sendKeys(Keys.TAB).sendKeys("Nis").
                sendKeys(Keys.TAB).sendKeys("1989").
                sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.ARROW_RIGHT).
                sendKeys(Keys.TAB).sendKeys(Keys.ARROW_RIGHT).
                sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).
                sendKeys(Keys.ENTER).perform();*/


    }}
