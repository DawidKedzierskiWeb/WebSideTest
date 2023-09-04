package pages;

import java.time.Duration;

import framework.logging.StepLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class BasePage {

  public static final String URL_DASHBOARD = "http://localhost:3000/dashboard";
  public static final String URL_ACCOUNTS = "http://localhost:3000/accounts";
  public static final String URL_CARDS = "http://localhost:3000/cards";
  public static final By MENU_DASHBOARD = By.id("dashboard-link-btn");
  public static final By MENU_ACCOUNTS = By.id("accounts-link-btn");
  public static final By MENU_CARDS = By.id("cards-link-btn");
  public static final By LOGO = By.xpath("");
  public static final String EXPECTED_DASHBOARD_PAGE_TITLE = "Dashboard - CapWallet";
  public static final String EXPECTED_ACCOUNTS_PAGE_TITLE = "Accounts - CapWallet";
  public static final String EXPECTED_CARDS_PAGE_TITLE = "Cards - CapWallet";

  public BasePage() {
    System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--remote-allow-origins=*");
    options.addArguments("--disable notifications");
    options.addArguments(
        "--remote-allow-origins=*", "ignore-certificate-errors", "disable-popup-blocking");
    this.driver = new ChromeDriver(options);
    // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  }

  public static WebDriver driver;

  public void loadPage() {
    driver.get(URL_DASHBOARD);
  }

  public void closePage() {
    driver.quit();
    StepLogger.logStep("Closing browser");
  }

  public String getTitle() {
    String title = driver.getTitle();
    return title;
  }

  public String getUrl() {
    String url = driver.getCurrentUrl();
    return url;
  }

  public void clickDashboardButton() {
    driver.findElement(MENU_DASHBOARD).click();
  }

  public void clickAccountButton() {
    driver.findElement(MENU_ACCOUNTS).click();
  }

  public void clickCardButton() {
    driver.findElement(MENU_CARDS).click();
  }

  // Waiting x(waitingTime) seconds for an element to be present on the page, checking
  // for its presence once every y(refreshTime) seconds.
  public static void wait(int waitingTime, int refreshTime, String url) {
    Wait wait =
        new FluentWait(driver)
            .withTimeout(Duration.ofSeconds(waitingTime))
            .pollingEvery(Duration.ofSeconds(refreshTime));
    Object foo = wait.until(ExpectedConditions.urlToBe(url));
  }

  public void driverWaits(int seconds) {
    try {
      Thread.sleep(seconds * 1000);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }
}
