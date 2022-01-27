package tests.tekrarlar;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class C01 {


    static WebDriver driver;
    @BeforeClass
    public static  void  setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }


    @Test
    public  void test01(){
        //● https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

        //● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        String actualBaslik=driver.findElement(By.tagName("h3")).getText();
        String exceptedBaslik="Opening a new window";
        Assert.assertEquals(exceptedBaslik,actualBaslik);

        //● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String actualTitel=driver.getTitle();
        String exceptedTitel="The Internet";
        Assert.assertEquals(actualTitel,exceptedTitel);

        //● Click Here butonuna basın.
        driver.findElement(By.xpath("//a[text()='Click Here']")).click();

        //● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        String actualTitl=driver.findElement(By.xpath("//div[@class='example']")).getText();
        String exceptedTitl="New Window";

        // Assert.assertEquals(actualTitl,exceptedTitl);


        //● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.







    }



    @AfterClass
    public static  void  teardown(){
        // driver.close();

    }



















}
