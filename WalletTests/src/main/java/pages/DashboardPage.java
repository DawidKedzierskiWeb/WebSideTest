package pages;

import framework.logging.StepLogger;
import org.apache.velocity.util.introspection.VelPropertySet;
import org.json.JSONObject;
import org.openqa.selenium.By;

public class DashboardPage extends BasePage {

  public static final String DETAILS_NL12ABNA9999876523 = "https://localhost/accounts/NL12ABNA9999876523/details-with-balance";
  public static final String DETAILS_NL58ABNA9999142181 = "https://localhost/accounts/NL58ABNA9999142181/details-with-balance";
  public static final String DETAILS_NL62ABNA9999841479 = "https://localhost/accounts/NL62ABNA9999841479/details-with-balance";
  public static final String DETAILS_NL91ABNA9999428707 = "https://localhost/accounts/NL91ABNA9999428707/details-with-balance";
  public static final By SELECTOR_EUR_BALANCE = By.xpath("//*[@id='account-balance-info-ABN-EUR']/span/span");
  public static final By SELECTOR_USD_BALANCE = By.xpath("//*[@id='account-balance-info-ABN-USD']/span/span");
  public static final By SELECTOR_CURRENCY_EUR = By.xpath("/html/body/div[1]/div/div[1]/div[2]/div[1]/div/div/div[1]/div/div");
  public static final By SELECTOR_CURRENCY_USD = By.xpath("/html/body/div[1]/div/div[1]/div[2]/div[1]/div/div/div[2]/div/div/p");
  public static final By SELECTOR_CURRENCY_FLAG_EUR = By.xpath("/html/body/div[1]/div/div[1]/div[2]/div[1]/div/div/div[1]/div/div/img");
  public static final By SELECTOR_CURRENCY_FLAG_USD = By.xpath("/html/body/div[1]/div/div[1]/div[2]/div[1]/div/div/div[2]/div/div/img");
  public static final By SELECTOR_BANK_LOGO_AMRO = By.xpath("//*[@id=\"__next\"]/div/div[1]/div[1]/img");
  //--------------------------------------------------Adding new iban selectors------------------------------------------------------------------------
  public static final By SELECTOR_PLUS_BUTTON = By.xpath("//*[@id=\"add-new-account\"]");
  public static final By SELECTOR_BANK_RADIOBUTTON = By.xpath("/html/body/div[3]/div[3]/div/div[1]/div/div/label[1]/span[1]");
  public static final By SELECTOR_IBAN_DROP_LIST = By.xpath("//*[@id=\"demo-simple-select\"]");
  public static final By SELECTOR_IBAN_DROP_LIST_FIRST_ELEMENT = By.xpath("//*[@id=\"menu-\"]/div[3]/ul/li[1]");
  public static final By SELECTOR_IBAN_DROP_LIST_SECOND_ELEMENT = By.xpath("//*[@id=\"menu-\"]/div[3]/ul/li[2]");
  public static final By SELECTOR_IBAN_DROP_LIST_THIRD_ELEMENT = By.xpath("//*[@id=\"menu-\"]/div[3]/ul/li[3]");
  public static final By SELECTOR_IBAN_DROP_LIST_FOURTH_ELEMENT = By.xpath("//*[@id=\"menu-\"]/div[3]/ul/li[4]");
  public static final By SELECTOR_APPROVE_BUTTON = By.xpath("/html/body/div[3]/div[3]/div/div[2]/button[1]");
  public static final By SELECTOR_CANCEL_BUTTON = By.xpath("/html/body/div[3]/div[3]/div/div[2]/button[2]");






  public void checkIfDashboardLoaded() {
    String url = driver.getCurrentUrl();
    if (!url.equals(URL_DASHBOARD)) {
      driver.get(URL_DASHBOARD);
      StepLogger.logStep("Loading Dashboard Tab");
      wait(20, 2, URL_DASHBOARD);
      driverWaits(3);
    }
    }


  public String getJSONWithAccountInformation(String urlAccountDetails) {
    StepLogger.logStep("Getting balance information from API");
    driver.get(urlAccountDetails);
    wait(10, 1, urlAccountDetails);
    return driver.findElement(By.xpath("/html/body/pre")).getText();
  }

  public Double getBalanceFromJSON(String getJSON) {
    JSONObject obj = new JSONObject(getJSON);
    return obj.getDouble("amount");
  }

  public String sumEuro() {
    Double amount1 =
        getBalanceFromJSON(getJSONWithAccountInformation(DETAILS_NL12ABNA9999876523));
    Double amount2 =
        getBalanceFromJSON(getJSONWithAccountInformation(DETAILS_NL58ABNA9999142181));
    Double amount3 =
        getBalanceFromJSON(getJSONWithAccountInformation(DETAILS_NL62ABNA9999841479));
    Double sum = amount1 + amount2 + amount3;
    return sum.toString();
  }

  public String sumUSD() {
    Double amount1 =
        getBalanceFromJSON(getJSONWithAccountInformation(DETAILS_NL91ABNA9999428707));
    return amount1.toString();
  }

  public String getEURBalance() {
    StepLogger.logStep("Getting displayed balance in EUR currency");
    String balance = driver.findElement(SELECTOR_EUR_BALANCE).getText();
    return balance.replace(",", ".");
  }

  public String getUSDBalance() {
    StepLogger.logStep("Getting displayed balance in USD currency");
    String balance = driver.findElement(SELECTOR_USD_BALANCE).getText();
    return balance.replace(",", ".");
  }

  public String getEURSignature() {
    StepLogger.logStep("Checking EUR signature");
    return driver.findElement(SELECTOR_CURRENCY_EUR).getText();
  }

  public String getUSDSignature() {
    StepLogger.logStep("Checking USD signature");
    return driver.findElement(SELECTOR_CURRENCY_USD).getText();
  }

  public boolean getEURFlag() {
    StepLogger.logStep("Checking EUR icon is displaying");
    return driver.findElement(SELECTOR_CURRENCY_FLAG_EUR).isDisplayed();
  }

  public boolean getUSDFlag() {
    StepLogger.logStep("Checking USD icon is displaying");
    return driver.findElement(SELECTOR_CURRENCY_FLAG_USD).isDisplayed();
  }

  public boolean getAMROLogo() {
    StepLogger.logStep("Checking if bank logo is displaying");
    return driver.findElement(SELECTOR_BANK_LOGO_AMRO).isDisplayed();
  }
  public void clickPlusButton(){
    driverWaits(5);
    driver.findElement(SELECTOR_PLUS_BUTTON).click();
    StepLogger.logStep("Clicking Plus button");
    driverWaits(2);
  }
  public void clickBankRadioButton(){
    driver.findElement(SELECTOR_BANK_RADIOBUTTON).click();
    StepLogger.logStep("Clicking Bank Radio-Button");
  }
  public void clickBankDropList(){
    driver.findElement(SELECTOR_IBAN_DROP_LIST).click();
    StepLogger.logStep("Clicking IBAN DropList");
  }
  public void clickFirstDropListElement(){
    driverWaits(2);
    driver.findElement(SELECTOR_IBAN_DROP_LIST_FIRST_ELEMENT).click();
    StepLogger.logStep("Choosing first IBAN");
  }
  public void clickApproveButton(){
    driverWaits(1);
    driver.findElement(SELECTOR_APPROVE_BUTTON).click();
    StepLogger.logStep("Click Approve button");
  }
  public void clickCancelButton(){
    driverWaits(1);
    driver.findElement(SELECTOR_CANCEL_BUTTON).click();
    StepLogger.logStep("Click Cancel button");
  }
}
