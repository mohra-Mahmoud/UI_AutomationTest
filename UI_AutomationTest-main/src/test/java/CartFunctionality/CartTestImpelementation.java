package CartFunctionality;

import MainMethods.MainMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import static SearchTest.searchFunctionality.searchForProductByName;

public class CartTestImpelementation extends MainMethods {
    public void ADDSearchedProductToCart() throws InterruptedException {

        openBrowser();
        MainPage();
        searchForProductByName() ;
        WebElement product=driver.findElement(By.xpath("/html/body/section[2]/div[1]/div/div[2]/div/div[2]/div/div[1]/div[1]/img"));
        Actions hover=new Actions(driver);
        hover.moveToElement(product).perform();
        Thread.sleep(2000);
        WebElement add_cart_button=driver.findElement(By.xpath("/html/body/section[2]/div[1]/div/div[2]/div/div[2]/div/div[1]/div[2]/div/a"));
        add_cart_button.click();
        Thread.sleep(2000);
        WebElement PopUpMessage=driver.findElement(By.xpath("//*[@id=\"cartModal\"]/div/div/div[2]/p[1]"));
        String ActualResult=PopUpMessage.getText();
        System.out.println(ActualResult);
       Assert.assertEquals(ActualResult,"Your product has been added to cart.");



    }
    public void VerifyThatProductAddedToCart() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"cartModal\"]/div/div/div[3]/button")).click();

        //go to cart
        driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[3]/a")).click();
        WebElement productincart=driver.findElement(By.xpath("//*[@id=\"product-2\"]/td[3]"));
        String actualproduct =productincart.getText();
        String expectedproduct="Rs. 400";
        Assert.assertEquals(actualproduct,expectedproduct);











}}
