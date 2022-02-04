package practice2;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C04 extends TestBase {

    @Test
    public void test01(){
        //  https://www.chanel.com/us/
        //  1- Accessing the site --> OK if the site is displayed
        driver.get("https://www.chanel.com/us/");
        String title= driver.getTitle();
        Assert.assertTrue(title.contains("CHANEL Official Website"));
        //  2- Click on the search bar (on the top menu)
        WebElement searchEl= driver.findElement(By.xpath("//button[@class='button nav-item is-hidden-s-only js-search-button']"));
        Actions actions=new Actions(driver);
        actions.click(searchEl).perform();
        //  3- Search for "ROUGE ALLURE"
        driver.findElement(By.xpath("//input[@id='searchInput']")).sendKeys("ROUGE ALLURE"+ Keys.ENTER);
        //  3- Check if the items of the displayed list contain the searched word

        //  4- Select the second item of the list
        driver.findElement(By.xpath("(//a[@class='product-list-inline__link'])[2]")).click();
        //  5- Make sure that the displayed product name is the same as the previously selected name.
        String actualName=driver.getTitle();
        String expectedName="ROUGE ALLURE";
        Assert.assertTrue(actualName.contains(expectedName));
    }
    @Test
    public void test02(){
        //1- Access to the site
        driver.get("https://www.chanel.com/us/");
        driver.findElement(By.xpath("//button[text()='Accept All Cookies']")).click();
        //2- Access to Makeup => Lipstick category (on top menu)
        WebElement makeUp= driver.findElement(By.xpath("//a[@id='makeup']"));
        makeUp.click();
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        WebElement lipStick= driver.findElement(By.xpath("//a[@data-linkname='Lipstick']"));
        lipStick.click();
        //3- Click on ROUGE ALLURE product
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        WebElement rougeAllure= driver.findElement(By.xpath("//span[text()='ROUGE ALLURE VELVET LA COMÈTE']"));
        rougeAllure.click();
        //4- Add the product to the cart
        driver.findElement(By.xpath("//button[@id='pos-cnc-btn']")).click();
        // driver.findElement(By.xpath("(//button[@class='button is-icon sidepanel__close js-sidepanel-close'])[2]")).click();
        //5- View Cart --> OK, if there is a "ROUGE ALLURE" product in the cart,
        WebElement bag= driver.findElement(By.xpath("//span[@data-test='btnReviewBagAndContinue']"));
        bag.click();
        // the quantity=1 and the total cart is equal to the product price.
        boolean quantityTest=driver.findElement(By.xpath("//p[@data-test='lblProductQty_151138']")).getText().contains("1");
        Assert.assertTrue(quantityTest);
        String productPrice= driver.findElement(By.xpath("//p[@class='cart-product__price js-cart-price-item cart-default-sample']")).getText();
        String totalPrice= driver.findElement(By.xpath("//td[@class='is-bold js-cart-price-subtotal']")).getText();
        Assert.assertEquals(totalPrice,productPrice," prices are not the same");
    }


}
