package capwallet;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Assert;
import org.junit.jupiter.api.*;
import pages.AccountsPage;
import pages.LoginPage;
import tags.tabs.Account;
import tags.userstory.US6351;
public class AccountsTest {
    public static AccountsPage page = new AccountsPage();

    @BeforeAll
    public static void LoginUser() {
        LoginPage.loginUser();
    }
    @BeforeEach
    public void LoadAccountPage() {
        page.checkIfAccountPageLoaded();
    }
    @AfterAll
    public static void closePage() {
        page.closePage();
    }

    @Test
    @Account
    @US6351
    public void checkDataForNL12ABNA9999876523Account(){
        String applicationHolderName = page.getHolderNameFromApplication(AccountsPage.SELECTOR_IBAN_523_HOLDERNAME);
        String applicationBalance = page.getBalanceFromApplication(AccountsPage.SELECTOR_IBAN_523_BALANCE);
        String applicationCurrency = page.getCurrencyFromApplication(AccountsPage.SELECTOR_IBAN_523_CURRENCY);
        String applicationIBAN = page.getNumberFromApplication(AccountsPage.SELECTOR_IBAN_523_NUMBER);
        String JSON = page.getJSONWithAccountInformation(AccountsPage.DETAILS_NL12ABNA9999876523);
        String APIHolderName = page.getHolderNameJSON(JSON);
        String APIBalance = page.getBalanceFromJSON(JSON).toString();
        String APICurrency = page.getCurrencyJSON(JSON);
        String APIIBAN = page.getIBAN(JSON);
        assertAll(
                () -> {
                    assertThat(applicationHolderName).isEqualTo(APIHolderName);
                    assertThat(applicationBalance).isEqualTo(APIBalance);
                    assertThat(applicationCurrency).contains(APICurrency);
                    assertThat(applicationIBAN).contains(APIIBAN);
                });
    }
    @Test
    @Account
    @US6351
    public void checkDataForNL58ABNA9999142181Account(){
        String applicationHolderName = page.getHolderNameFromApplication(AccountsPage.SELECTOR_IBAN_181_HOLDERNAME);
        String applicationBalance = page.getBalanceFromApplication(AccountsPage.SELECTOR_IBAN_181_BALANCE);
        String applicationCurrency = page.getCurrencyFromApplication(AccountsPage.SELECTOR_IBAN_181_CURRENCY);
        String applicationIBAN = page.getNumberFromApplication(AccountsPage.SELECTOR_IBAN_181_NUMBER);
        String JSON = page.getJSONWithAccountInformation(AccountsPage.DETAILS_NL58ABNA9999142181);
        String APIHolderName = page.getHolderNameJSON(JSON);
        String APIBalance = page.getBalanceFromJSON(JSON).toString();
        String APICurrency = page.getCurrencyJSON(JSON);
        String APIIBAN = page.getIBAN(JSON);
        assertAll(
                () -> {
                    assertThat(applicationHolderName).isEqualTo(APIHolderName);
                    assertThat(applicationBalance).isEqualTo(APIBalance);
                    assertThat(applicationCurrency).contains(APICurrency);
                    assertThat(applicationIBAN).contains(APIIBAN);
                });
    }
    @Test
    @Account
    @US6351
    public void checkDataForNL62ABNA9999841479Account(){
        String applicationHolderName = page.getHolderNameFromApplication(AccountsPage.SELECTOR_IBAN_479_HOLDERNAME);
        String applicationBalance = page.getBalanceFromApplication(AccountsPage.SELECTOR_IBAN_479_BALANCE);
        String applicationCurrency = page.getCurrencyFromApplication(AccountsPage.SELECTOR_IBAN_479_CURRENCY);
        String applicationIBAN = page.getNumberFromApplication(AccountsPage.SELECTOR_IBAN_479_NUMBER);
        String JSON = page.getJSONWithAccountInformation(AccountsPage.DETAILS_NL62ABNA9999841479);
        String APIHolderName = page.getHolderNameJSON(JSON);
        String APIBalance = page.getBalanceFromJSON(JSON).toString();
        String APICurrency = page.getCurrencyJSON(JSON);
        String APIIBAN = page.getIBAN(JSON);
        assertAll(
                () -> {
                    assertThat(applicationHolderName).isEqualTo(APIHolderName);
                    assertThat(applicationBalance).isEqualTo(APIBalance);
                    assertThat(applicationCurrency).contains(APICurrency);
                    assertThat(applicationIBAN).contains(APIIBAN);
                });
    }
    @Test
    @Account
    @US6351
    public void checkDataForNL91ABNA9999428707Account(){
        String applicationHolderName = page.getHolderNameFromApplication(AccountsPage.SELECTOR_IBAN_707_HOLDERNAME);
        String applicationBalance = page.getBalanceFromApplication(AccountsPage.SELECTOR_IBAN_707_BALANCE);
        String applicationCurrency = page.getCurrencyFromApplication(AccountsPage.SELECTOR_IBAN_707_CURRENCY);
        String applicationIBAN = page.getNumberFromApplication(AccountsPage.SELECTOR_IBAN_707_NUMBER);
        String JSON = page.getJSONWithAccountInformation(AccountsPage.DETAILS_NL91ABNA9999428707);
        String APIHolderName = page.getHolderNameJSON(JSON);
        String APIBalance = page.getBalanceFromJSON(JSON).toString();
        String APICurrency = page.getCurrencyJSON(JSON);
        String APIIBAN = page.getIBAN(JSON);
        assertAll(
                () -> {
                    assertThat(applicationHolderName).isEqualTo(APIHolderName);
                    assertThat(applicationBalance).isEqualTo(APIBalance);
                    assertThat(applicationCurrency).contains(APICurrency);
                    assertThat(applicationIBAN).contains(APIIBAN);
                });
    }
        @Test
        public void checkIfFiveLastTransactionsAreVisible() throws InterruptedException {
            page.clickTransactionHistoryButton();
            Thread.sleep(3000);
            page.isOperationDateDisplayed();
            page.clickOperationDate();
            page.isFiveLastTransactionVisible();
            String currentTransactions1 = page.getTransactions1();
            assertThat(currentTransactions1).isEqualTo(AccountsPage.EXPECTED_TRANSACTIONS_AMOUNT_1);
            String currentTransactions2 = page.getTransactions2();
            assertThat(currentTransactions2).isEqualTo(AccountsPage.EXPECTED_TRANSACTIONS_AMOUNT_2);
            String currentTransactions3 = page.getTransactions3();
            assertThat(currentTransactions3).isEqualTo(AccountsPage.EXPECTED_TRANSACTIONS_AMOUNT_3);
            String currentTransactions4 = page.getTransactions4();
            assertThat(currentTransactions4).isEqualTo(AccountsPage.EXPECTED_TRANSACTIONS_AMOUNT_4);
            String currentTransactions5 = page.getTransactions5();
            assertThat(currentTransactions5).isEqualTo(AccountsPage.EXPECTED_TRANSACTIONS_AMOUNT_5);
            page.clickTransactionHistoryButton();
        }

}

