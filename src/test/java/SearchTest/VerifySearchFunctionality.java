package SearchTest;

import org.checkerframework.checker.units.qual.K;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.time.Duration;
import java.util.List;
import java.util.Objects;

public class VerifySearchFunctionality {
    public static WebDriver driver = new ChromeDriver();
    static WebElement Search_Item;


    public void openBrowser() {
        driver.get("https://automationexercise.com/");
        driver.manage().window().maximize();

    }

    public void MainPage() {
        driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[2]/a")).click();
        driver.getCurrentUrl();


    }

    public void searchForProductByName() {
        //Search For A product
        Search_Item = driver.findElement(By.xpath("//*[@id=\"search_product\"]"));
        Search_Item.sendKeys("Men");
        //Click on search button
        driver.findElement(By.xpath("//*[@id=\"submit_search\"]")).click();
        // Assert That The searched Product Is Exist
       String Productname=driver.getPageSource();
        assert Productname != null;
        Assert.assertTrue(Productname.contains("Men"),"no results");





    }
}


