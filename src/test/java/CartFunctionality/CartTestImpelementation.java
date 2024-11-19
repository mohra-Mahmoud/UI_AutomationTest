package CartFunctionality;

import SearchTest.VerifySearchFunctionality;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class CartTestImpelementation extends VerifySearchFunctionality {
    public void ADDSearchedProductToCart(){
        openBrowser();
        MainPage();
        searchForProductByName();
        driver.findElement(By.xpath("/html/body/section[2]/div[1]/div/div[2]/div/div[2]/div/div[1]/div[1]/a")).click();



    }
    public void VerifyThatProductAddedToCart(){
        driver.findElement(By.xpath("/html/body/section[2]/div[1]/div/div[2]/div/div[2]/div/div[1]/div[1]/a")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"cartModal\"]/div/div/div[2]/p[2]/a/u")));
        WebElement viewCartLink = driver.findElement(By.xpath("//*[@id=\"cartModal\"]/div/div/div[2]/p[2]/a/u")); // You can use the text "View Cart" to locate the link
        viewCartLink.click();
        List<WebElement> rows = driver.findElements(By.xpath("//table[@id='cart_info_table']/tbody/tr"));
        int expectedRowCount = 1; // Example: change based on your test setup
        Assert.assertEquals(rows.size(), expectedRowCount, "The number of items in the cart does not match the expected count.");





    }


}
