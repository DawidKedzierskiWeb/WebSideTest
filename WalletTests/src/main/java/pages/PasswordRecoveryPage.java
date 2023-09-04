package pages;

import org.openqa.selenium.By;

import static pages.BasePage.driver;
import static pages.LoginPage.URL_LOGIN;
import static pages.LoginPage.clickAccountEmailField;

public class PasswordRecoveryPage extends BasePage{
    public static void loadLoginPage() {
        driver.get(URL_LOGIN);
    }
    public static final String URL_PASSWORD_RECOVERY = "http://localhost:3000/password-recovery";
    public static final String URL_PASSWORD_RECOVERY_TOKEN = "http://localhost:3000/password-recovery/Hove0hX6a2TXDFldGb-vvwi2WuQfO-6Uz9vViw268Lc";
    public static final String URL_MAIl_PAGE ="https://poczta.o2.pl/login/login.html";
    public static final By FORGOTPASSWORDBUTTON= By.xpath("//*[@id=\"__next\"]/div[3]/p/a");

    public void clickResetPasswordPageButton() {
        driver.findElement(FORGOTPASSWORDBUTTON).click();
    }
    public static final By TEXTFIELDEMAIL= By.id("text-field-email");
    public static final By O2LOGINBUTTON = By.linkText("Zaloguj się");
    public static final By O2ACCEPTPAGE = By.xpath("/html/body/div[3]/div/div[2]/div[3]/div/button[2]");
    public static final By O2LOGINFIELD = By.id("login");
    public static final By O2PASSWORDFIELD = By.id("password");
    public static final By TEXTPASSWORDFIELD= By.id("text-field-password");
    public static final By TEXTPASSWORDCONFIRMATIONFIELD= By.id("text-field-passwordConfirmation");
    public static final By RESETPASSWORDMAIL = By.name("Reset password");
    public static void fillEmailField(String mail){ driver.findElement(TEXTFIELDEMAIL).sendKeys(mail);}
    public static void fillPasswordField(String mail){ driver.findElement(TEXTPASSWORDFIELD).sendKeys(mail);}
    public static void fillPasswordConfirmationField(String mail){ driver.findElement(TEXTPASSWORDCONFIRMATIONFIELD).sendKeys(mail);}
    public static void fillO2EmailField(){driver.findElement(O2LOGINFIELD).sendKeys("captest@o2.pl");}
    public static void fillO2PasswordField(){driver.findElement(O2PASSWORDFIELD).sendKeys("Capgemini123!");}

    public static void clickMail(){driver.findElement(RESETPASSWORDMAIL).click();}
    public static final By SUBMITBUTTON= By.id("submit-button");
    public static final By RESETPASSWORDBUTTON= By.id("reset-password-btn");
    public static void resetPasswordButton(){driver.findElement(RESETPASSWORDBUTTON).click();}
    public static final By EMAIL_INFORMATION = By.xpath("//*[@id=\"password-recovery-form\"]/div[1]/p");

    public static void clickSubmitButton(){driver.findElement(SUBMITBUTTON).click();}
    public static void clickO2LoginButton(){driver.findElement(O2LOGINBUTTON).click();}
    public static void clickO2AcceptPage(){driver.findElement(O2ACCEPTPAGE).click();}

    public void openLoginPage()
    {
        loadLoginPage();
        wait(20, 1, URL_LOGIN);
    }
    public void openPasswordRecoveryPage()
    {
        clickResetPasswordPageButton();
        wait(20, 1, URL_PASSWORD_RECOVERY);
    }
    public void sendAccouranceEmailToResetPassword()
    {
        fillEmailField("mai@mail.pl");
        clickSubmitButton();
    }
    public void sendwithoutatEmailToResetPassword()
    {
        fillEmailField("maimail.pl");
        clickSubmitButton();
    }
    public void sendonlyatEmailToResetPassword()
    {
        fillEmailField("@");
        clickSubmitButton();

    }
    public void sendwithdoubleatEmailToResetPassword()
    {
        fillEmailField("mai@@mail.pl");
        clickSubmitButton();
    }
    public void openRecoveryPageToken()
    {
        driver.get(URL_PASSWORD_RECOVERY_TOKEN);
        wait(20, 1, URL_PASSWORD_RECOVERY_TOKEN);
    }
public void clickResetPasswordButton()
{
    resetPasswordButton();
    wait(20, 1, URL_PASSWORD_RECOVERY_TOKEN);
}
public void setNewPassword()
{
    fillEmailField("mai@mail.pl");
    fillPasswordField("111111111B!");
    fillPasswordConfirmationField("111111111B!");

}
public void clickSubmitbutton()
{
clickSubmitButton();
}
public void O2loginToMail()
{
    driver.get(URL_MAIl_PAGE);
    wait(10,1,URL_MAIl_PAGE);
    clickO2AcceptPage();
    fillO2EmailField();
    fillO2PasswordField();
    clickO2LoginButton();
    clickMail();

}

}

