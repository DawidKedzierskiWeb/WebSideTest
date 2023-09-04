package capwallet;

import org.junit.Assert;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import pages.BasePage;
import pages.LoginPage;
import pages.RegisterPage;
import tags.status.InDevelopment;
import tags.tabs.Account;

import static pages.BasePage.driver;
import static pages.RegisterPage.PASSWORD_INFORMATION;
import static pages.RegisterPage.PHONE_INFORMATION;

public class CreateAccountTest {
     public static RegisterPage page = new RegisterPage();


//    @BeforeEach
//    public void LoadDashboardPage(){
//        page.checkIfRegisterLoaded();
//    }
    @AfterAll
    public static void closePage(){
        page.closePage();
    }
    @Test
    @Account
    //happy path created to use for other test which requires logged user
    public void createAccountSC1(){       // Scenario 1: Create a new account- all details correct
    page.openRegisterUserPage();
    page.registerUser();
    Assert.assertEquals("http://localhost:3000/register",page.getUrl());

    }
    @Test
    @Account
    public void createAccountSC2(){//Scenario 2Create a new account- wrong email address
    page.openRegisterUserPage();
    page.registerUserWrongEmailAddress();
    String pageSource =driver.getPageSource();
    Assert.assertTrue(pageSource.contains("Invalid email address"));


    }
    @Test
    @Account
    public void createAccountSC3(){//Scenario 3: Create a new account- wrong password provided
        page.openRegisterUserPage();
        page.registerUserWrongPassword();
        String pageSource =driver.getPageSource();
        Assert.assertTrue(pageSource.contains("Password must be at least 8 characters"));

    }
    @Test
    @Account
    public void createAccountSC4(){ // Scenario 4: Create a new account with to short number
        page.openRegisterUserPage();
        page.registerTooShortNumber();
        Assert.assertEquals("phone number is not valid",driver.findElement(PHONE_INFORMATION).getText());

    }
    @Test
    @Account
    public void createAccountSC5(){ // Scenario 5: Create a new account with characters instead of numbers
        page.openRegisterUserPage();
        page.registerCharacterInsteadOfNumbers();
        Assert.assertEquals("phone number is not valid",driver.findElement(PHONE_INFORMATION).getText());

    }
    @Test
    @Account
    public void createAccountSC6(){ // Scenario 6: Create a new account with mix character and numbers
        page.openRegisterUserPage();
        page.registerMixCharacterAndNumbers();
        Assert.assertEquals("phone number is not valid",driver.findElement(PHONE_INFORMATION).getText());

    }
    @Test
    @Account
    public void createAccountSC7(){ // Scenario 7: Create a new account with different passwords
        page.openRegisterUserPage();
        page.registerDifferentPassword();
        Assert.assertEquals("passwords must match",driver.findElement(PASSWORD_INFORMATION).getText());

    }
    @Test
    @Account
    public void createAccountSC8(){ // Scenario 8: Create a new account with real data
        page.openRegisterUserPage();
        page.registerDifferentPassword();
        Assert.assertEquals("passwords must match",driver.findElement(PASSWORD_INFORMATION).getText());

    }
}
