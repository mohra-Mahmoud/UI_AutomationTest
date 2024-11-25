package MainMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class MainMethods {
    public static WebDriver driver = new ChromeDriver();
    static WebElement Search_Item;

@Test
    public void openBrowser() {
        driver.get("https://automationexercise.com/");
        driver.manage().window().maximize();

    }







}


