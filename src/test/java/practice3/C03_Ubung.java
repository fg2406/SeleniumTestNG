package practice3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.sql.Driver;

public class C03_Ubung extends TestBase {

  //TESTNG POM
    //    Go to https://demoqa.com/ write an automated test
    @Test
    public  void  test01() throws InterruptedException {
        driver.get("https://demoqa.com/");
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div[3]/div/div[2]")).click();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[1]/div/div/div[3]/span/div/div[2]/div[2]")).click();

        driver.findElement(By.xpath("//span[text()='Alerts']")).click();

        // Alerts ( handle all alerts)
        WebElement allertsHndle= driver.findElement(By.xpath("//div[text()='Click me']"));
        driver.switchTo().alert().accept();
        Thread.sleep(5000);
        driver.switchTo().alert().accept();
        Thread.sleep(5000);
        driver.switchTo().alert().accept();
        Thread.sleep(5000);
        driver.switchTo().alert().sendKeys("1234");
        driver.switchTo().alert().accept();


        // Interactions (Click droppable button and under the simple module drag the “drag me” box to the   “drop me” box  and verify that dropped.)

        // Widgets ( click tool Tips button, hover over the
        // “Hover me to see” button and verify the “You Hovered Over the button” message then hover over the
        // “Hover me to see” text field and verify “You hovered the text field” message.



    }




}
