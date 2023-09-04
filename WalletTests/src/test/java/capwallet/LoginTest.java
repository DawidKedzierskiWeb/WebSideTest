package capwallet;

import org.junit.jupiter.api.Test;
import pages.BasePage;
import pages.LoginPage;
import tags.status.InDevelopment;

public class LoginTest {
  public static BasePage base = new BasePage();
  public static LoginPage page = new LoginPage();

  @Test
  @InDevelopment
  // happy path created to use for other test which requires logged user
  public void login() {
    page.loginUser();
    page.closePage();
  }
  @Test
  public void loginWrongEmailOrAddress() throws InterruptedException {
    page.loginWrongEmailOrAddress();
    page.closePage();

  }
}
