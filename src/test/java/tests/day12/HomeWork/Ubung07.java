package tests.day12.HomeWork;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Ubung07 {

     //// 4 TEST METODU OLUSTURUN,oncelik vererek sirasiyla
    //    // https://www.n11.com/ SAYFASINA GiDİN.
    //    // https://www.gittigidiyor.com/ SAYFASINA GiDiN
    //    // https://getir.com/ SAYFASINA GiDiN
    //    // https://www.sahibinden.com/ SAYFASINA GiDiN
    WebDriver driver;

    @BeforeClass
    public void  setUp(){
      WebDriverManager.chromedriver().setup();
      driver=new ChromeDriver();
      driver.manage().window().maximize();
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

  }

  @Test (priority = 1)
    public  void  n11(){
      driver.get("https://www.n11.com/");
  }

    @Test (priority = 2)
    public  void  ggidiyor(){
    driver.get("https://www.gittigidiyor.com/");


    }


    @Test (priority = 3)
    public  void  getir(){
    driver.get("https://getir.com/");


    }


    @Test (priority = 4)
    public  void  sahibinden(){
    driver.get("https://www.sahibinden.com/");


    }


  @AfterClass
  public  void  teardown(){
        driver.quit();
  }

}
