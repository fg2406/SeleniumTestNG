package tests.tekrarlar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.util.Set;

public class Day12TekrarMause extends TestBase {


    //1- Yeni bir class olusturalim: MouseActions1

   @Test
   public  void  test01() throws InterruptedException {
       //2- https://the-internet.herokuapp.com/context_menu sitesine gidelim
       driver.get("https://the-internet.herokuapp.com/context_menu");

       //3- Cizili alan uzerinde sag click yapalim

       Actions actions = new Actions(driver);
       WebElement element = driver.findElement(By.id("hot-spot"));
       actions.contextClick(element).perform();
       //4- Alert’te cikan yazinin “You selected a context menu” oldugunu
       //    test edelim.

       String actualText =driver.switchTo().alert().getText();
       String expectedText = "You selected a context menu";
       Assert.assertEquals(expectedText, actualText);

       //5- Tamam diyerek alert’I kapatalim
       Thread.sleep(3000);
       driver.switchTo().alert().accept();

       //6- Elemental Selenium linkine tiklayalim
       String ilkSayfaninHnadleDegeri = driver.getWindowHandle();
       System.out.println(ilkSayfaninHnadleDegeri);
       driver.findElement(By.xpath("//a[text()='Elemental Selenium']")).click();

       //7- Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
       String ikinciSayfaDegeri = "";
       Set<String> handleSeti = driver.getWindowHandles();
       for (String each : handleSeti
       ) {
           if (!each.equals(ilkSayfaninHnadleDegeri)) {
               ikinciSayfaDegeri=each;

           }
       }

       Thread.sleep(5000);
       System.out.println(ikinciSayfaDegeri);
       driver.switchTo().window(ikinciSayfaDegeri);

       WebElement h1TagElementi= driver.findElement(By.tagName("h1"));
       String actualtitle=h1TagElementi.getText();
       String expectedtitle="Elemental Selenium";
       Assert.assertEquals(actualtitle,expectedtitle);
       driver.quit();


   }}
