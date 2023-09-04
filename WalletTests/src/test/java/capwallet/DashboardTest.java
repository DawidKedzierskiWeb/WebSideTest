package capwallet;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

import framework.logging.StepLogger;
import io.qameta.allure.Description;
import org.junit.jupiter.api.*;
import pages.BasePage;
import pages.DashboardPage;
import pages.LoginPage;
import tags.status.InDevelopment;
import tags.tabs.Dashboard;
import tags.userstory.US6705;
import tags.userstory.US7520;

public class DashboardTest {
  public static DashboardPage page = new DashboardPage();

  // assertThat("ACTUAL").isEqualTo("EXPECTED");
  @BeforeAll
  public static void LoginUser() {
      StepLogger.logStep("Login User");
      LoginPage.loginUser();
  }

  @BeforeEach
  public void LoadDashboardPage() {
    page.checkIfDashboardLoaded();
  }

/*  @AfterAll
  public static void closePage() {
    page.closePage();
  }*/

  @Test
  @Dashboard
  @Description("Dashboard")
  @DisplayName("Checking if URL is correct")
  public void checkIfURLIsCorrect() {
    String currentURL = page.getUrl();
    StepLogger.logStep("Checking website URL");
    assertThat(currentURL).isEqualTo(DashboardPage.URL_DASHBOARD);
  }

  @Test
  @Dashboard
  @Description("Dashboard")
  @DisplayName("Checking if website title is correct")
  public void checkIfTitleIsCorrect() {
      StepLogger.logStep("Checking website title");
    assertThat(page.getTitle()).isEqualTo(DashboardPage.EXPECTED_DASHBOARD_PAGE_TITLE);
  }

  @Test
  @Dashboard
  @Description("Dashboard")
  @DisplayName("Checking Dashboard button")
  public void checkIfDashboardButtonMovesToDashboardTab() {
    page.clickDashboardButton();
    page.wait(2, 2, BasePage.URL_DASHBOARD);
    String currentURL = page.getUrl();
    String currentTitle = page.getTitle();
      StepLogger.logStep("Checking if dashboard button moves to DASHBOARD TAB");
    assertAll(
        () -> {
          assertThat(currentURL).isEqualTo(DashboardPage.URL_DASHBOARD);
          assertThat(currentTitle).isEqualTo(DashboardPage.EXPECTED_DASHBOARD_PAGE_TITLE);
        });
  }

  @Test
  @Dashboard
  @Description("Dashboard")
  @DisplayName("Checking Accounts button")
  public void checkIfAccountButtonMovesToAccountsTab() {
    page.clickAccountButton();
    page.wait(10, 1, BasePage.URL_ACCOUNTS);
    String currentURL = page.getUrl();
    String currentTitle = page.getTitle();
      StepLogger.logStep("Checking if accounts button moves to ACCOUNT TAB");
    assertAll(
        () -> {
          assertThat(currentURL).isEqualTo(DashboardPage.URL_ACCOUNTS);
          assertThat(currentTitle).isEqualTo(DashboardPage.EXPECTED_ACCOUNTS_PAGE_TITLE);
        });
  }

  @Test
  @Dashboard
  @Description("Dashboard")
  @DisplayName("Checking Cards button")
  public void checkIfCardButtonMovesToCardsTab() {
    page.clickCardButton();
    page.wait(10, 1, BasePage.URL_CARDS);
    String currentURL = page.getUrl();
    String currentTitle = page.getTitle();
      StepLogger.logStep("Checking if Cards button moves to CARDS TAB");
    assertAll(
        () -> {
          assertThat(currentURL).isEqualTo(DashboardPage.URL_CARDS);
          assertThat(currentTitle).isEqualTo(DashboardPage.EXPECTED_CARDS_PAGE_TITLE);
        });
  }

  @Test
  @Dashboard
  @US7520
  @Description("Dashboard")
  @DisplayName("Checking cumulated bank balance")
  public void checkIfAccountBalanceForMultipleBanks() {
    page.driverWaits(5);
    String amountEUR = page.getEURBalance();
    String amountUSD = page.getUSDBalance();
    assertAll(
        () -> {
          assertThat(amountEUR).isEqualTo(page.sumEuro());
          assertThat(amountUSD).isEqualTo(page.sumUSD());
          StepLogger.logStep("Checking if cumulated balance is correct");
        });
  }

  @Test
  @Dashboard
  @US7520
  @Description("Dashboard")
  @DisplayName("Checking displayed currencies")
  public void checkIfCurrenciesAreDisplaying() {
    page.driverWaits(5);
    assertAll(
        () -> {
          assertThat(page.getEURSignature()).isEqualTo("EUR");
          assertThat(page.getUSDSignature()).isEqualTo("USD");
          assertTrue(page.getEURFlag());
          assertTrue(page.getUSDFlag());
        });
  }

  @Test
  @Dashboard
  @US7520
  @Description("Dashboard")
  @DisplayName("Checking if bank logo is displayed")
  public void checkIfBankLogoIsDisplaying() {
    page.driverWaits(5);
    assertAll(
        () -> {
          assertTrue(page.getAMROLogo());
        });
  }

  @Test
  @InDevelopment
  @Dashboard
  @US6705
  @Description("Dashboard")
  @DisplayName("Adding IBAN for user")
  public void AddIBANForUser() {
    page.clickPlusButton();
    page.clickBankRadioButton();
    page.clickBankDropList();
    page.clickFirstDropListElement();
    page.clickCancelButton();
  }
}

