package tests.tekrarlar;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.TestBase;

public class Day12_Keysboard extends TestBase {
//1- Bir Class olusturalim KeyboardActions2


    @Test
    public  void  test01(){
        //2- https://html.com/tags/iframe/ sayfasina gidelim
         driver.get("https://html.com/tags/iframe/");

        //3- video’yu gorecek kadar asagi

        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).
                sendKeys(Keys.PAGE_DOWN).
                sendKeys(Keys.ARROW_UP).click().perform();





        WebElement videoGor= driver.findElement(By.xpath("//iframe[@class='lazy-loaded']"));
        driver.switchTo().frame(videoGor);

        //4- videoyu izlemek icin Play tusuna basin
        driver.findElement(By.xpath("//button[@class='ytp-large-play-button ytp-button']")).click();
        //5- videoyu calistirdiginizi test edin
    }




}
