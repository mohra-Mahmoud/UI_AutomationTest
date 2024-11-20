package MainMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MainMethods {
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






}


