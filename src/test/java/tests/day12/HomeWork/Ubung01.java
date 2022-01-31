package tests.day12.HomeWork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.TestBase;

public class Ubung01 extends TestBase {




    @Test
    public  void  test01() throws InterruptedException {


        /// 1- "http://webdriveruniversity.com/Actions" sayfasina gidin
        driver.get("http://webdriveruniversity.com/Actions");
        //    //2- Hover over Me First" kutusunun ustune gelin
        Actions actions=new Actions(driver);
        WebElement element= driver.findElement(By.xpath("//button[text()='Hover Over Me First!']"));
        actions.moveToElement(element).perform();



        //    //3- Link 1" e tiklayin
       WebElement link1= driver.findElement(By.xpath("//a[.='Link 1']"));
         actions.click(link1).perform();

        //    //4- Popup mesajini yazdirin
        System.out.println(driver.switchTo().alert().getText());
        //    //5- Popup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();
        //    //6- “Click and hold" kutusuna basili tutun
        WebElement clickandHold= driver.findElement(By.xpath("//div[@id='click-box']"));

        actions.moveToElement(clickandHold).perform();

        //    //7-“Click and hold" kutusunda cikan yaziyi yazdirin

        System.out.println(driver.findElement(By.xpath("//div[@id='click-box']")).getText());
        //Thread.sleep(5000);
        //    //8- “Double click me" butonunu cift tiklayin
           WebElement ClcikMe=driver.findElement(By.tagName("h2"));
          actions.doubleClick(ClcikMe).perform();
           driver.close();

    }


}
