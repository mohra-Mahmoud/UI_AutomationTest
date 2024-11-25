package SignInFunctionality;

import MainMethods.MainMethods;
import SignUpFunctionality.SignUpImplementation;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SignInEmplementation extends MainMethods {

   private String SavedEmail;
   private   String SavedPassword ;
   private WebElement emailField;
   private WebElement PasswordField;
   private WebElement LoginButton;
   private WebElement LogoutButton;
   private WebElement USerName;
   private WebElement LoginLink;


    @BeforeTest
    public void executeSignUp() {
        // Execute the sign-up process
        SignUpImplementation signUp = new SignUpImplementation();
        signUp.setUp(); // Initialize the browser
        signUp.NavigateToSignUpScreen(); // Navigate to sign-up page
        signUp.FillSignUpForm(); // Fill the first sign-up form
        signUp.EnterAccountInformation(); // Fill account information

        // Retrieve the saved credentials
        this.SavedEmail = SignUpImplementation.getSavedEmail();
        this.SavedPassword = SignUpImplementation.getSavedPassword();
        System.out.println(SavedEmail);
        System.out.println(SavedPassword);
    }
        // Optionally close the browser after signup to start fresh


    private void IntialLoginElements(){
        this.emailField=driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/input[2]"));
        this.PasswordField=driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/input[3]"));
        this.LoginButton=driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/button"));

    }
    @Test
    public void loginWithValidCredintials(){

        driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a")).click();
        IntialLoginElements();
        emailField.sendKeys(SavedEmail);
        PasswordField.sendKeys(SavedPassword);
        LoginButton.click();
        System.out.println(SavedEmail);
        System.out.println(SavedPassword);




    }







}
