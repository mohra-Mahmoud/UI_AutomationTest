package SignUpFunctionality;

import MainMethods.MainMethods;
import Utilites.ReportManger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static MainMethods.fakedata.*;


public class SignUpImplementation extends MainMethods {
    @BeforeClass
    public void setUp() {
        openBrowser(); // Initialize the browser
        ReportManger.initReport(); // Initialize ExtentReports
    }

    // Elements specific to each page
    private WebElement SignUpLink;
    private WebElement name;
    private WebElement email;
    private WebElement SignUpButton;
    private WebElement Gender;
    private WebElement Password;
    private WebElement Dayes;
    private WebElement Month;
    private WebElement Years;
    private WebElement FirstName;
    private WebElement LastName;
    private WebElement Address;
    private WebElement Country;
    private WebElement State;
    private WebElement City;
    private WebElement ZipCode;
    private WebElement Mobile;

    public static String savedEmail;
    public static String savedPassword;




    /**
     * Step 1: Initialize elements for the home page.
     */
    private void initializeHomePageElements() {
        this.SignUpLink = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a"));

    }

    /**
     * Step 2: Initialize elements for the sign-up form (first page).
     */
    private void initializeSignUpFormElements() {
        this.name = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/input[2]"));
        this.email = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/input[3]"));

        this.SignUpButton = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/button"));
    }

    /**
     * Step 3: Initialize elements for the account information form (second page).
     */
    private void initializeAccountInfoFormElements() {
        this.Gender = driver.findElement(By.xpath("//*[@id=\"id_gender2\"]"));
        this.Password = driver.findElement(By.xpath("//*[@id=\"password\"]"));
        this.Dayes = driver.findElement(By.xpath("//*[@id=\"days\"]"));
        this.Month = driver.findElement(By.xpath("//*[@id=\"months\"]"));
        this.Years = driver.findElement(By.xpath("//*[@id=\"years\"]"));
        this.FirstName = driver.findElement(By.xpath("//*[@id=\"first_name\"]"));
        this.LastName = driver.findElement(By.xpath("//*[@id=\"last_name\"]"));
        this.Address = driver.findElement(By.xpath("//*[@id=\"address1\"]"));
        this.Country = driver.findElement(By.xpath("//*[@id=\"country\"]"));
        this.State = driver.findElement(By.xpath("//*[@id=\"state\"]"));
        this.City = driver.findElement(By.xpath("//*[@id=\"city\"]"));
        this.ZipCode =driver.findElement(By.xpath("//*[@id=\"zipcode\"]"));
        this.Mobile = driver.findElement(By.xpath("//*[@id=\"mobile_number\"]"));
    }





    /**
     * Test: Navigate to the sign-up screen.
     */
    @Test(priority = 1)
    public void NavigateToSignUpScreen() {
        openBrowser();
        initializeHomePageElements();
        SignUpLink.click(); // Navigate to the sign-up page
    }

    /**
     * Test: Fill out the first sign-up form.
     */
    @Test(priority = 2, dependsOnMethods = "NavigateToSignUpScreen")
    public void FillSignUpForm() {
        initializeSignUpFormElements(); // Initialize elements for the first sign-up form
        name.sendKeys(fakeName().toString());
        savedEmail = fakeemail();
        email.sendKeys(savedEmail);
        SignUpButton.click(); // Navigate to the next form
    }

    /**
     * Test: Enter account information on the second form.
     */
    @Test(priority = 3, dependsOnMethods = "FillSignUpForm")
    public void EnterAccountInformation() {
        initializeAccountInfoFormElements(); // Initialize elements for the account information form
        Gender.click();
        savedPassword = fakepassword();
        Password.sendKeys(savedPassword);
        new Select(Dayes).selectByValue("19");
        new Select(Month).selectByValue("6");
        new Select(Years).selectByValue("1996");
        FirstName.sendKeys(fakeName().toString());
        LastName.sendKeys(fakeName().toString());
        Address.sendKeys("Alex");
        new Select(Country).selectByValue("United States");
        State.sendKeys("Arizona");
        City.sendKeys("America");
        ZipCode.sendKeys("123");
        Mobile.sendKeys(fakemobile());
        driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/div[1]/form/button")).submit();


        // Verify successful account creation
        Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/account_created", "Account creation failed");
    }
    @Test(priority = 4, dependsOnMethods = "EnterAccountInformation")
   public void ClickonLogoutButton(){
        // Click on Contiue button
        driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/div/a")).click();
        //click on logout button

       driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]")).click();
   }




    @AfterClass
    public void tearDown() {

        driver.quit();
   }
    public static String getSavedEmail() {

        return  savedEmail;
    }

    public  static String getSavedPassword() {

        return savedPassword;
    }


}

