package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class LoginPage extends BasePage {
  public static final String URL_LOGIN = "http://localhost:3000/login";
  public static final By SELECTOR_ACCOUNT_TYPE_FIELD = By.id("account-type-select");
  public static final By SELECTOR_ACCOUNT_TYPE_DOPLIST_PERSONAL =
      By.id("account-type-select-Personal");
  public static final By SELECTOR_EMAIL_FIELD = By.id("text-field-email");
  public static final By SELECTOR_PASSWORD_FIELD = By.id("text-field-password");
  public static final By SELECTOR_LOGIN_BUTTON = By.id("login-button");
  public static final String EMAIL = "user1@op.pl";
  public static final String PASSWORD = "123456aA!";

  public static final String WRONG_EMAIL = "user1@op.pl";

  public static final String WRONG_PASSWORD = "1234573r";

  public static final By WRONG_EMAIL_OR_PASSWORD_MESSAGE = By.id("password-infromation");

  public static void loadLoginPage() {
    driver.get(URL_LOGIN);
  }

  public static void clickAccountTypeList() {
    driver.findElement(SELECTOR_ACCOUNT_TYPE_FIELD).click();
  }

  public static void clickAccountEmailField() {
    driver.findElement(SELECTOR_EMAIL_FIELD).click();
  }

  public static void clickAccountPasswordField() {
    driver.findElement(SELECTOR_PASSWORD_FIELD).click();
  }

  public static void clickPersonal() {
    driver.findElement(SELECTOR_ACCOUNT_TYPE_DOPLIST_PERSONAL).click();
  }

  public static void clickLoginButton() {
    driver.findElement(SELECTOR_LOGIN_BUTTON).click();
  }

  public static void fillEmailField() {
    driver.findElement(SELECTOR_EMAIL_FIELD).sendKeys(EMAIL);
  }

  public static void fillPasswordField() {
    driver.findElement(SELECTOR_PASSWORD_FIELD).sendKeys(PASSWORD);
  }

  public void sendEnter() {
    driver.findElement(SELECTOR_ACCOUNT_TYPE_FIELD).sendKeys(Keys.ENTER);
  }

  public static void fillWrongEmailField()
  { driver.findElement(SELECTOR_EMAIL_FIELD).sendKeys(WRONG_EMAIL);}

  public static void fillWrongPasswordField()
  { driver.findElement(SELECTOR_PASSWORD_FIELD).sendKeys(WRONG_PASSWORD);}
  public static void checkIfWrongEmailOrPasswordMessageDisplayed()
  { driver.findElement(WRONG_EMAIL_OR_PASSWORD_MESSAGE).isDisplayed();}

  public static void loginUser() {
    loadLoginPage();
    clickAccountTypeList();
    clickPersonal();
    clickAccountEmailField();
    fillEmailField();
    clickAccountPasswordField();
    fillPasswordField();
    clickLoginButton();
    wait(20, 1, BasePage.URL_DASHBOARD);
  }
  public static void loginWrongEmailOrAddress() throws InterruptedException {
    loadLoginPage();
    clickAccountTypeList();
    clickPersonal();
    clickAccountEmailField();
    fillWrongEmailField();
    clickAccountPasswordField();
    fillWrongPasswordField();
    clickLoginButton();
    Thread.sleep(5000);
    checkIfWrongEmailOrPasswordMessageDisplayed();
    Thread.sleep(5000);
  }

}
