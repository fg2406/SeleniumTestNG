package tests.tekrarlar;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;

public class C03_SoftAssertion {




    WebDriver driver;

    @BeforeClass
    public  void  setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @Test
    public  void  test01(){

        // 1. “http://zero.webappsecurity.com/” Adresine gidin
        driver.get("http://zero.webappsecurity.com/");

        // 2. Sign in butonuna basin
        driver.findElement(By.xpath("//button[@class='signin btn btn-info']")).click();

        // 3. Login kutusuna “username” yazin
        driver.findElement(By.xpath("//input[@id='user_login']")).sendKeys("username");

        // 4. Password kutusuna “password” yazin
        driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys("password");

        // 5. Sign in tusuna basin
        driver.findElement(By.xpath("//input[@value='Sign in']")).click();

    }



    @Test
    public  void  test02() {

        driver.findElement(By.xpath("//button[text()='Güvenliğe geri dön']")).click();
        driver.findElement(By.xpath("//span[@id='account_activity_link']")).click();
        // 6. Pay Bills sayfasina gidin
       driver.findElement(By.xpath("//a[text()='Pay Bills']")).click();

        // 7. “Purchase Foreign Currency” tusuna basin
     driver.findElement(By.xpath("//a[text()='Purchase Foreign Currency']")).click();

        // 8. “Currency” drop down menusunden Eurozone’u secin
        WebElement dropdownMenu= driver.findElement(By.xpath("//select[@id='pc_currency']"));
        Select options=new Select(dropdownMenu);
        options.selectByValue("EUR");

        // 9. soft assert kullanarak "Eurozone (Euro)" secildigini test edin

        SoftAssert softAssert=new SoftAssert();
        String actual=options.getFirstSelectedOption().getText();
        String excepted="Eurozone (Euro)";
        softAssert.assertEquals(excepted,actual,"tekrar islemi gozden gecirmelisin");


        // 10. soft assert kullanarak DropDown listesinin su secenekleri oldugunu test edin
        List<WebElement> dropdownList=options.getOptions();


        // "Select One", "Australia (dollar)",
        // "Canada (dollar)","Switzerland (franc)","China (yuan)","Denmark (krone)","Eurozone (euro)","Great Britain (pound)",
        // "Hong Kong (dollar)","Japan (yen)","Mexico (peso)","Norway (krone)","New Zealand (dollar)","Sweden (krona)",
        // "Singapore (dollar)","Thailand (baht)"




    }

    @AfterClass
    public void teardown(){


    }

}
