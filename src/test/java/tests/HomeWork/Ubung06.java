package tests.HomeWork;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Ubung06 {


     WebDriver driver;

    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // //● https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");
    }
    @Test
    public void test01(){
        //  //● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        WebElement newWindow= driver.findElement(By.xpath("//h3[normalize-space()='Opening a new window']"));
        Assert.assertTrue(newWindow.isDisplayed());
        //  //● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String actualTitle= driver.getTitle();
        String expectedTitle="The Internet";
        Assert.assertEquals(actualTitle,expectedTitle);
        //  //● Click Here butonuna basın.
        driver.findElement(By.xpath("//a[normalize-space()='Click Here']")).click();
        //  //● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        String actualTitle1=driver.getTitle();
        String expectedTitle1="New Window";
        Assert.assertEquals(actualTitle1,expectedTitle1);
        // //● Sayfadaki textin “New Window” olduğunu doğrulayın.
        String actualText=driver.findElement(By.xpath("//h3[normalize-space()='New Window']")).getText();
        String expectedText="New Window";
        Assert.assertEquals(actualText,expectedText);

        // //● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.
        driver.navigate().back(); //Does not return to previous window.Stays where it is.
        String actualTitleNewWindow=driver.getTitle();
        String expectedTitleNewWindow="The Internet";
        Assert.assertEquals(actualTitleNewWindow,expectedTitleNewWindow);
    }
    @AfterMethod
    public void tearDown(){
        driver.close();
    }


}
