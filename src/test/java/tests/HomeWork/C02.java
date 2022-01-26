package tests.HomeWork;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.signature.qual.DotSeparatedIdentifiersOrPrimitiveType;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class C02 {



   static WebDriver driver;

   @BeforeClass
    public static void  setUp(){
       WebDriverManager.chromedriver().setup();
       driver=new ChromeDriver();
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

   }




   @Test
   public  void test01() throws InterruptedException {
      //// Navigate to website  https://testpages.herokuapp.com/styled/index.html
      driver.get("https://testpages.herokuapp.com/styled/index.html");

      //// Under the  ORIGINAL CONTENTS
        String actualTitel= driver.getTitle();
        String exceptedTitel="Selenium Test Pages";
      Assert.assertEquals(actualTitel,exceptedTitel);

      //// click on Alerts
       driver.findElement(By.xpath("//a[@id='alerttest']")).click();

       //// navigate back
       driver.navigate().back();

      //// print the URL
       System.out.println(driver.getCurrentUrl());

      //// Click on Basic Ajax
       driver.findElement(By.xpath("//a[@id='basicajax']")).click();

      // print the URL
       System.out.println(driver.getCurrentUrl());

      // enter value-> 20 and Enter
       Thread.sleep(5000);
     WebElement enterBox= driver.findElement(By.id("lteq30"));
    enterBox.sendKeys("20"+Keys.ENTER);


      // and then verify Submitted Values is displayed open page
       enterBox.isDisplayed();

      //// close driver

   }



   @AfterClass
    public static  void  teardown() throws InterruptedException {

    Thread.sleep(5000);
    driver.close();

   }

}
