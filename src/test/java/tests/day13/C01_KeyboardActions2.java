package tests.day13;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C01_KeyboardActions2 extends TestBase {


 @Test
    public  void test01() throws InterruptedException {

    // 1- Bir Class olusturalim

     //     2- https://html.com/tags/iframe/ sayfasina gidelim
     driver.get("https://html.com/tags/iframe/");
     //     3- video’yu gorecek kadar asagi inin

     Actions actions=new Actions(driver);
     actions.sendKeys(Keys.PAGE_DOWN)
             .sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.ARROW_UP)
                     .perform();
     //     4- videoyu izlemek icin Play tusuna basin
     //videoya tiklamadan once ifrema oldugundan ona gecis yapmaliyiz etmeliyiz
     WebElement iframeElement= driver.findElement(By.xpath("//iframe[@class='lazy-loaded']"));
     driver.switchTo().frame(iframeElement);
     driver.findElement(By.xpath("//button[@class='ytp-large-play-button ytp-button']")).click();
     Thread.sleep(3000);

     //     5- videoyu calistirdiginizi test edin

     WebElement pauseButton=driver.findElement(By.xpath("//button[@class='ytp-play-button ytp-button']"));
     Assert.assertTrue(pauseButton.isEnabled());
     driver.close();





 }

}
