package pages;

import org.json.JSONObject;
import org.openqa.selenium.By;
import static org.assertj.core.api.Assertions.assertThat;

public class AccountsPage extends BasePage{
    public void checkUrlAccountsPage()
    {
        assertThat(driver.getCurrentUrl()).isEqualTo(URL_ACCOUNTS);
    }
        public static final String DETAILS_NL12ABNA9999876523 = "https://localhost/accounts/NL12ABNA9999876523/details-with-balance";
        public static final String DETAILS_NL58ABNA9999142181 = "https://localhost/accounts/NL58ABNA9999142181/details-with-balance";
        public static final String DETAILS_NL62ABNA9999841479 = "https://localhost/accounts/NL62ABNA9999841479/details-with-balance";
        public static final String DETAILS_NL91ABNA9999428707 = "https://localhost/accounts/NL91ABNA9999428707/details-with-balance";
        public static final By SELECTOR_IBAN_523_BALANCE = By.xpath("//*[@id='currency-info-NL12ABNA9999876523']/div/span");
        public static final By SELECTOR_IBAN_523_CURRENCY = By.xpath("//*[@id='currency-info-NL12ABNA9999876523']/div");
        public static final By SELECTOR_IBAN_523_HOLDERNAME = By.xpath("//*[@id='holder-name-info-NL12ABNA9999876523']");
        public static final By SELECTOR_IBAN_523_NUMBER = By.xpath("//*[@id='number-info-NL12ABNA9999876523']");
        public static final By SELECTOR_IBAN_181_BALANCE = By.xpath("//*[@id='currency-info-NL58ABNA9999142181']/div/span");
        public static final By SELECTOR_IBAN_181_CURRENCY = By.xpath("//*[@id='currency-info-NL58ABNA9999142181']/div");
        public static final By SELECTOR_IBAN_181_HOLDERNAME = By.xpath("//*[@id='holder-name-info-NL58ABNA9999142181']");
        public static final By SELECTOR_IBAN_181_NUMBER = By.xpath("//*[@id='number-info-NL58ABNA9999142181']");
        public static final By SELECTOR_IBAN_479_BALANCE = By.xpath("//*[@id='currency-info-NL62ABNA9999841479']/div/span");
        public static final By SELECTOR_IBAN_479_CURRENCY = By.xpath("//*[@id='currency-info-NL62ABNA9999841479']/div");
        public static final By SELECTOR_IBAN_479_HOLDERNAME = By.xpath("//*[@id='holder-name-info-NL62ABNA9999841479']");
        public static final By SELECTOR_IBAN_479_NUMBER = By.xpath("//*[@id='number-info-NL62ABNA9999841479']");
        public static final By SELECTOR_IBAN_707_BALANCE = By.xpath("//*[@id='currency-info-NL91ABNA9999428707']/div/span");
        public static final By SELECTOR_IBAN_707_CURRENCY = By.xpath("//*[@id='currency-info-NL91ABNA9999428707']/div");
        public static final By SELECTOR_IBAN_707_HOLDERNAME = By.xpath("//*[@id='holder-name-info-NL91ABNA9999428707']");
        public static final By SELECTOR_IBAN_707_NUMBER = By.xpath("//*[@id='number-info-NL91ABNA9999428707']");
        public static final By OPERATION_DATE = By.id("table-sort-btn-bookDate");

        public static final By TRANSACTIONS = By.id("table-cell-book-date-NL12ABNA9999876523");

        public static final By TRANSACTION_HISTORY = By.id("transaction-history-btn-NL12ABNA9999876523");

        public static final By TRANSACTIONS_AMOUNT_1 = By.xpath("/html/body/div[1]/div/div[1]/div[2]/div/div/div/div/div/table/tbody/tr[1]/td[5]");

        public static final By TRANSACTIONS_AMOUNT_2 = By.xpath("/html/body/div[1]/div/div[1]/div[2]/div/div/div/div/div/table/tbody/tr[2]/td[5]");

        public static final By TRANSACTIONS_AMOUNT_3 = By.xpath("/html/body/div[1]/div/div[1]/div[2]/div/div/div/div/div/table/tbody/tr[3]/td[5]");;

        public static final By TRANSACTIONS_AMOUNT_4 = By.xpath("/html/body/div[1]/div/div[1]/div[2]/div/div/div/div/div/table/tbody/tr[4]/td[5]");;

        public static final By TRANSACTIONS_AMOUNT_5 = By.xpath("/html/body/div[1]/div/div[1]/div[2]/div/div/div/div/div/table/tbody/tr[5]/td[5]");;

        public static final String EXPECTED_TRANSACTIONS_AMOUNT_1 = "16.03";

        public static final String EXPECTED_TRANSACTIONS_AMOUNT_2 = "2468.04";

        public static final String EXPECTED_TRANSACTIONS_AMOUNT_3 = "181.5";

        public static final String EXPECTED_TRANSACTIONS_AMOUNT_4 = "229.6";

        public static final String EXPECTED_TRANSACTIONS_AMOUNT_5 = "223.85";

        public void checkIfAccountPageLoaded() {
            String url = driver.getCurrentUrl();
            if (!url.equals(URL_ACCOUNTS)) {
                driver.get(URL_ACCOUNTS);
                wait(20, 2, URL_ACCOUNTS);
                driverWaits(5);
            }
        }

        public String getJSONWithAccountInformation(String urlAccountDetails) {
            driver.get(urlAccountDetails);
            wait(10, 1, urlAccountDetails);
            return driver.findElement(By.xpath("/html/body/pre")).getText();
        }

        public Double getBalanceFromJSON(String getJSON) {
            JSONObject obj = new JSONObject(getJSON);
            return obj.getDouble("amount");
        }
        public String getCurrencyJSON(String getJSON) {
            JSONObject obj = new JSONObject(getJSON);
            return obj.getString("currency");
        }
        public String getHolderNameJSON(String getJSON) {
            JSONObject obj = new JSONObject(getJSON);
            return obj.getString("holderName");
        }
        public String getIBAN(String getJSON) {
            JSONObject obj = new JSONObject(getJSON);
            return obj.getString("number");
        }
        public String getBalanceFromApplication(By selector){
            return driver.findElement(selector).getText().replace(",",".");
        }
        public String getCurrencyFromApplication(By selector){
            return driver.findElement(selector).getText();
        }
        public String getHolderNameFromApplication(By selector){
            return driver.findElement(selector).getText();
        }
        public String getNumberFromApplication(By selector){
            return driver.findElement(selector).getText();
        }
        public void isTransactionHistoryButtonDisplayed() {
            driver.findElement(TRANSACTION_HISTORY).isDisplayed();
        }
        public void clickTransactionHistoryButton() {
            driver.findElement(TRANSACTION_HISTORY).click();
        }
        public void isOperationDateDisplayed() {
            driver.findElement(OPERATION_DATE).isDisplayed();
        }
        public void clickOperationDate() {
            driver.findElement(OPERATION_DATE).click();
        }
        public String getTransactions1(){
            String amount = String.valueOf(driver.findElement(TRANSACTIONS_AMOUNT_1).getText());
            return amount;
        }
        public String getTransactions2(){
        String amount = String.valueOf(driver.findElement(TRANSACTIONS_AMOUNT_2).getText());
        return amount;
        }
        public String getTransactions3(){
        String amount = String.valueOf(driver.findElement(TRANSACTIONS_AMOUNT_3).getText());
        return amount;
         }
        public String getTransactions4(){
        String amount = String.valueOf(driver.findElement(TRANSACTIONS_AMOUNT_4).getText());
        return amount;
        }
        public String getTransactions5(){
        String amount = String.valueOf(driver.findElement(TRANSACTIONS_AMOUNT_5).getText());
        return amount;
        }
        public void isFiveLastTransactionVisible() {
            driver.findElement(TRANSACTIONS).isDisplayed();
        }
    }

