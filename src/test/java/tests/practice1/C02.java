package tests.practice1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBase;

import java.util.Set;

public class C02 extends TestBase {



        @Test
        public void test01(){
            //      go to url :http://demo.guru99.com/popup.php
            driver.get("http://demo.guru99.com/popup.php");
            //      get the first window
            WebElement securty=driver.findElement(By.className("faktor-iframe-wrapper"));
            driver.switchTo().frame(securty);
            driver.findElement(By.xpath("(//span[text()='Tümünü Kabul Et'])")).click();
            driver.switchTo().defaultContent();
            //      clicking on click here button
            String ilkSayfaHandle=driver.getWindowHandle();
           WebElement clickButton= driver.findElement(By.xpath("//a[text()='Click Here']"));
           clickButton.click();
            //      get all the window in the set
            Set<String> tumHandles=driver.getWindowHandles();
            String ikinciHandle="";
            for (String e: tumHandles
            ) {
                if (!e.equals(ilkSayfaHandle)){
                    ikinciHandle=e;
                }
            }
            //      switch to window
            driver.switchTo().window(ikinciHandle);
            //      input email id (somepne@gmail.com) and type something in that input
            driver.findElement(By.xpath("//input[@name='emailid']")).sendKeys("somepne@gmail.com");
            //      Clicking on the submit button
            driver.findElement(By.xpath("//input[@type='submit']")).click();
            //      verify title as expected
            String actualTitle=driver.getTitle();
            String expectedTitle="Guru99 Bank Home Page";
            SoftAssert softAssert=new SoftAssert();
            softAssert.assertEquals(actualTitle,expectedTitle,"title Test Failed");
            softAssert.assertAll();
            //      switch to first window
            driver.switchTo().window(ilkSayfaHandle);


        }

}





