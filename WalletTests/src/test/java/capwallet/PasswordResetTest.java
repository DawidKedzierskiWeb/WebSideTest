package capwallet;

import org.junit.Assert;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import pages.PasswordRecoveryPage;
import pages.RegisterPage;
import tags.tabs.Account;
import tags.tabs.ResetPassword;

import static pages.BasePage.driver;
import static pages.PasswordRecoveryPage.EMAIL_INFORMATION;
import static pages.RegisterPage.PHONE_INFORMATION;

public class PasswordResetTest {
    public static PasswordRecoveryPage page = new PasswordRecoveryPage();

//    @AfterAll
//    public static void closePage() {
//        page.closePage();
//    }

    @Test
    @ResetPassword
    //happy path created to use for other test which requires logged user
    public void openResetPasswordPage() {       // Open Reset Password Page
        page.openLoginPage();
        page.openPasswordRecoveryPage();
        Assert.assertEquals("http://localhost:3000/password-recovery", page.getUrl());
    }
    @Test
    @ResetPassword
    //happy path created to use for other test which requires logged user
    public void openResetPasswordPageAndUseAccouranceEmail() {       // Open Reset Password Page and use accourance email
        page.openLoginPage();
        page.openPasswordRecoveryPage();
        Assert.assertEquals("http://localhost:3000/password-recovery", page.getUrl());
        page.sendAccouranceEmailToResetPassword();


    }
    @Test
    @ResetPassword
    public void openResetPasswordPageAndUseEmailWithoutat() {       // Open Reset Password Page and use email without @
        page.openLoginPage();
        page.openPasswordRecoveryPage();
        Assert.assertEquals("http://localhost:3000/password-recovery", page.getUrl());
        page.sendwithoutatEmailToResetPassword();
        Assert.assertEquals("email must be a valid email",driver.findElement(EMAIL_INFORMATION).getText());
    }
    @Test
    @ResetPassword
    public void openResetPasswordPageAndUseEmailWithdoubleat() {       // Open Reset Password Page and use email with double at
        page.openLoginPage();
        page.openPasswordRecoveryPage();
        Assert.assertEquals("http://localhost:3000/password-recovery", page.getUrl());
        page.sendwithdoubleatEmailToResetPassword();
        Assert.assertEquals("email must be a valid email",driver.findElement(EMAIL_INFORMATION).getText());
    }
    @Test
    @ResetPassword
    public void openResetPasswordPageAndUseEmailWithOnlyOneAt() {       // Open Reset Password Page and use email with one @
        page.openLoginPage();
        page.openPasswordRecoveryPage();
        Assert.assertEquals("http://localhost:3000/password-recovery", page.getUrl());
        page.sendonlyatEmailToResetPassword();
        Assert.assertEquals("email must be a valid email",driver.findElement(EMAIL_INFORMATION).getText());
    }
    @Test
    @ResetPassword
    public void resetPassword()
    {
        page.O2loginToMail();

    }
}
