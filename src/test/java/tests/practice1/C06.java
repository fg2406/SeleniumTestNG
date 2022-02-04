package tests.practice1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.time.Duration;
import java.util.List;

public class C06 {

   static WebDriver driver;
    @BeforeClass
    public static void  setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }


        @Test
        public void test() {
            //-->Task1 Find Dropdown on Multi Selection
            driver.findElement(By.xpath("//input[@id ='justAnInputBox']")).click();
            //-->Task2 Find Dropdown Elements
            List<WebElement> dropList = driver.findElements(By.xpath("//span[@class ='comboTreeItemTitle']"));
            //-->Task3 printout DropDown Elements' number
            System.out.println("dropListteki elementlerin sayisi :" + dropList.size()); //dropListteki elementlerin sayisi :45
            //-->Task4 choose all dropdown elements and printout dropdown elements' name

            for (int i = 0; i < dropList.size(); i++) {
                String text = dropList.get(i).getText();
                System.out.println("text = " + text);
                if (!text.isEmpty()) {
                    dropList.get(i).click();
                }
                //-->Task5 check until choise 6'
                if (text.equals("choice 6")) {
                    dropList.get(i).click();
                    break;
                }
            }
        }}









