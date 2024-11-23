package SignUpFunctionality;

import MainMethods.MainMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Objects;

import static MainMethods.fakedata.*;

public class SignUpImpelementation extends MainMethods {
    @Test()
    public void NavigateToSinUpScreen() {
        openBrowser();
        driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a")).click();

    }

    @Test(dependsOnMethods = "NavigateToSinUpScreen")
    public void setdataforsignupscreenone() {
        WebElement name = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/input[2]"));
        name.sendKeys(fakeName().toString());
        WebElement email = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/input[3]"));
        email.sendKeys(fakeemail());
        driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/button")).click();


    }

    @Test(dependsOnMethods = "setdataforsignupscreenone")
    public void Enter_Account_Information() {
        System.out.println(driver.getCurrentUrl());

        driver.findElement(By.xpath("//*[@id=\"id_gender2\"]")).click();
        // set the password
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(fakepassword());
        //Select  dayes
        WebElement dayes = driver.findElement(By.xpath("//*[@id=\"days\"]"));
        Select select = new Select(dayes);
        select.selectByValue("19");
        // select month
        WebElement Month = driver.findElement(By.xpath("//*[@id=\"months\"]"));
        Select select1 = new Select(Month);
        select1.selectByValue("6");
        // select years
        WebElement Years = driver.findElement(By.xpath("//*[@id=\"years\"]"));
        Select select2 = new Select(Years);
        select2.selectByValue("1996");
        //Enter FirstName
        driver.findElement(By.xpath("//*[@id=\"first_name\"]")).sendKeys(fakeName().toString());
        driver.findElement(By.xpath("//*[@id=\"last_name\"]")).sendKeys(fakeName().toString());
        // select address
        driver.findElement(By.xpath("//*[@id=\"address1\"]")).sendKeys("Alex");
        // select Country
        WebElement Country = driver.findElement(By.xpath("//*[@id=\"country\"]"));
        Select select3 = new Select(Country);
        select3.selectByValue("United States");
        //Enter state
        driver.findElement(By.xpath("//*[@id=\"state\"]")).sendKeys("Arizona");
        // select city
        driver.findElement(By.xpath("//*[@id=\"city\"]")).sendKeys("America");
        // Enter zipcode
        driver.findElement(By.xpath("//*[@id=\"zipcode\"]")).sendKeys("123");
        //Enter mobile
        driver.findElement(By.xpath("//*[@id=\"mobile_number\"]")).sendKeys(fakemobile());
        //Click on create account
        driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/div[1]/form/button")).click();

        Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/account_created", "test fails");


    }

}
