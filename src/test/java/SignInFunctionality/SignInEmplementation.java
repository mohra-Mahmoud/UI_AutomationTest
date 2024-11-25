package SignInFunctionality;

import MainMethods.MainMethods;
import SignUpFunctionality.SignUpImplementation;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class SignInEmplementation extends MainMethods {

    String SavedEmail= SignUpImplementation.getSavedEmail();
    String SavedPassword= SignUpImplementation.getSavedPassword();
   private WebElement emailField;
   private WebElement PasswordField;
   private WebElement LoginButton;
   private WebElement LogoutButton;
    private WebElement USerName;
    private WebElement LoginLink;


public void print(){
    System.out.println(SavedEmail);
    System.out.println(SavedPassword);


}




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




    }







}
