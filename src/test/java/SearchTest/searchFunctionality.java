package SearchTest;

import MainMethods.MainMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class searchFunctionality extends MainMethods {
   private WebElement ProductButton;
   private WebElement search_Item;
    private WebElement search_icon;
   private WebElement searchresult;
   public void IntialopenProductScreenElements(){
       this.ProductButton= driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[2]/a"));


   }
    public void IntialSearchScreenElements(){
        this.search_Item= driver.findElement(By.xpath("//*[@id=\"search_product\"]"));
        this.search_icon= driver.findElement(By.xpath("//*[@id=\"submit_search\"]"));

    }
    @Test()
    public  void verify_search_For_ProductByName() {
       openBrowser();
        IntialopenProductScreenElements();
        ProductButton.click();
        IntialSearchScreenElements();
        search_Item.sendKeys("Men Tshirt");
        search_icon.click();}

       // searchresult=driver.findElement(By.xpath("/html/body/section[2]/div[1]/div/div[2]/div/div[2]/div/div[1]/div[1]/p"));
//        String Actual=searchresult.getText();
//        System.out.println(searchresult.getText());
//        Assert.assertEquals(Actual,"Men Tshirt");
//        //Click on search button

    @AfterClass
    public void tearDown() {
       driver.quit();

        }

}

