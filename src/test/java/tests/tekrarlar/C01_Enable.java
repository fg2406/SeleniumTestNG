package tests.tekrarlar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBase;

import java.time.Duration;

public class C01_Enable extends TestBase {

//1. Bir class olusturun : EnableTest



    @Test
    public  void  isEnable() throws InterruptedException {
    //2. Bir metod olusturun : isEnabled()
        //3. https://the
        //internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        SoftAssert softAssert=new SoftAssert();
        //Textbox’in etkin olmadigini(enabled) dogrulayin
        WebElement textBox= driver.findElement(By.xpath("//input[@type='text']"));

        softAssert.assertFalse(textBox.isEnabled(),"test Faild tekrar kontrol ediniz");


        //5. Enable butonuna tıklayın ve textbox etkin oluncaya kadar bekleyin
         driver.findElement(By.xpath("//button[text()='Enable']")).click();

         WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(45));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Enable']")));

        //6. “It’s enabled!” mesajinin goruntulendigini dogrulayın.
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));
        WebElement mesajTest= driver.findElement(By.xpath("//p[@id='message']"));
        softAssert.assertTrue(mesajTest.isDisplayed(),"test faild tekrar kontrol ediniz");

        //. Textbox’in etkin ol dugunu (enabled)
        softAssert.assertTrue(textBox.isEnabled(),"test pass kontrole gerek yok");
        softAssert.assertAll();
        Thread.sleep(3000);
        driver.close();

    }
}
