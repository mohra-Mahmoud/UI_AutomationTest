package CartFunctionality;

import MainMethods.MainMethods;
import SearchTest.searchFunctionality;
import Utilites.ReportManger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.util.List;


public class CartTestImpelementation extends MainMethods {

private WebElement product;
   private WebElement add_cart_button;
   private WebElement PopUpMessage;
   private   WebElement productincart;
   private WebElement  Cartbutton;
   private WebElement viewCartlink;
    private WebElement tableBody;
public void IntialAddToCartElements(){

    this.product=driver.findElement(By.xpath("/html/body/section[2]/div[1]/div/div[2]/div/div[2]/div/div[1]/div[1]/img"));
    this.add_cart_button=driver.findElement(By.xpath("/html/body/section[2]/div[1]/div/div[2]/div/div[2]/div/div[1]/div[2]/div/a"));
    this.PopUpMessage=driver.findElement(By.xpath("//*[@id=\"cartModal\"]/div/div/div[2]/p[1]"));
    this.viewCartlink = driver.findElement(By.xpath("//*[@id=\"cartModal\"]/div/div/div[2]/p[2]/a/u"));
}


    public void IntialCartElements(){

       this.productincart=driver.findElement(By.xpath("//*[@id=\"product-2\"]/td[3]/p"));



    }

   @Test
    public void ADDSearchedProductToCart() throws InterruptedException {

        openBrowser();
        searchFunctionality search=new searchFunctionality();
        search.verify_search_For_ProductByName();
        IntialAddToCartElements();
        Actions hover=new Actions(driver);
        hover.moveToElement(product).perform();
        add_cart_button.click();
        Thread.sleep(2000);
        String ActualResult=PopUpMessage.getText();
        System.out.println(ActualResult);
       Assert.assertEquals(ActualResult,"Your product has been added to cart.");
       viewCartlink.click();
       System.out.println( driver.getCurrentUrl());



    }
    @Test
    public void VerifyThatProductAddedToCart() throws InterruptedException {
        IntialCartElements();
        System.out.println( driver.getCurrentUrl());
       String actualproduct =productincart.getText().trim();
        System.out.println(actualproduct);
        String expectedproduct="Rs. 400";
       Assert.assertEquals(actualproduct,expectedproduct);





}
    @AfterClass
    public void tearDown() {
        driver.quit();
    }}
