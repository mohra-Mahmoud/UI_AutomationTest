package SearchTest;

import MainMethods.MainMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class searchFunctionality extends MainMethods {
    public static void searchForProductByName() {
        //Search For A product
        WebElement search_Item = driver.findElement(By.xpath("//*[@id=\"search_product\"]"));
        search_Item.sendKeys("Men Tshirt");
        //Click on search button
        driver.findElement(By.xpath("//*[@id=\"submit_search\"]")).click();
        // Assert That The searched Product Is Exist
        WebElement searchresult=driver.findElement(By.xpath("/html/body/section[2]/div[1]/div/div[2]/div"));
        String SEARCH_Result=(searchresult.findElement(By.xpath("/html/body/section[2]/div[1]/div/div[2]/div/div[2]/div/div[1]/div[1]/p")).getText());
        System.out.println(SEARCH_Result);
        Assert.assertTrue(SEARCH_Result.contains("Men  Tshirt"));

}}
