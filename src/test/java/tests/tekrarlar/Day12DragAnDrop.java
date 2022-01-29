package tests.tekrarlar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class Day12DragAnDrop extends TestBase {




   @Test
    public  void  test01(){

       //Yeni bir class olusturalim: MouseActions2
       //1- https://demoqa.com/droppable adresine gidelim
       driver.get("https://demoqa.com/droppable");

       //2- “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim

       Actions actions=new Actions(driver);
       WebElement dragMeButton= driver.findElement(By.xpath("//div[text()='Drag me']"));
       WebElement dropHereButton=driver.findElement(By.xpath("//p[text()='Drop here']"));
       actions.dragAndDrop(dragMeButton,dropHereButton).perform();

       //3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin
       String droppedYazisi= dropHereButton.getText();
       String expectedYazi="Dropped";
       Assert.assertTrue(droppedYazisi.contains(expectedYazi));
        driver.close();
   }



}
