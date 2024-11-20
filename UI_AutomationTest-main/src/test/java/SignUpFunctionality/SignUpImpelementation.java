package SignUpFunctionality;

import MainMethods.MainMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static MainMethods.fakedata.fakeName;
import static MainMethods.fakedata.fakeemail;

public class SignUpImpelementation extends MainMethods {

    @Test
    public void NavigateToSinUpScreen() {
        openBrowser();
        driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a")).click();

    }
    @Test

    public void setdataforsignupscreenone(){
        WebElement name= driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/input[2]"));
        name.sendKeys(fakeName().toString());
        WebElement email= driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/input[3]"));
        email.sendKeys(fakeemail());
        driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/button")).click();


    }
}
