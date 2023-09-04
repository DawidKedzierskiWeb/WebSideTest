package pages;

import org.openqa.selenium.By;

import java.util.Random;

public class RegisterPage extends BasePage{

    static Random random = new Random();
    static int randomNumber = random.nextInt(9999) + 1;
    public static final String URL_REGISTER = "http://localhost:3000/register";
    public static final By SELECTOR_ACCOUNT_TYPE_FIELD = By.id("account-type-select");
    public static final By SELECTOR_ACCOUNT_TYPE_PERSONAL = By.id("account-type-select-Personal");
    public static final By SELECTOR_NAME_FIELD = By.id("text-field-name");
    public static final By SELECTOR_EMAIL_FIELD = By.id("text-field-email");
    public static final By SELECTOR_PASSWORD_FIELD = By.id("text-field-password");
    public static final By SELECTOR_PHONENUMBER_FIELD = By.id("text-field-phoneNumber");
    public static final By SELECTOR_PASSWORDCONFIRMATION_FIELD = By.id("text-field-passwordConfirmation");
    public static final By SELECTOR_SUBMIT_BUTTON = By.id("submit-button");
    public static final By PHONE_INFORMATION = By.xpath("//*[@id=\"register-form\"]/div[4]/p");
    public static final By PASSWORD_INFORMATION = By.xpath("//*[@id=\"register-form\"]/div[6]/p");
    public static final String NAME = "User" + randomNumber;
    public static final String EMAIL = "email" + randomNumber + "@op.pl";
    public static final String PASSWORD = "123456aA!";


    public static String randomNumberGen() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 9; i++) {
            int digit = random.nextInt(10);
            sb.append(digit);
        }
        String phoneNumber = sb.toString();
        return phoneNumber;
    }


    public static void clickAccountTypeList(){driver.findElement(SELECTOR_ACCOUNT_TYPE_FIELD).click();}
    public static void clickPersonalAccountTypeList(){driver.findElement(SELECTOR_ACCOUNT_TYPE_PERSONAL).click();}
    public static void fillEmailField(){ driver.findElement(SELECTOR_EMAIL_FIELD).sendKeys(EMAIL);}

    public static void fillEmailField(String adres){ driver.findElement(SELECTOR_EMAIL_FIELD).sendKeys(adres);}
    public static void fillNameField(){ driver.findElement(SELECTOR_NAME_FIELD).sendKeys(NAME);}
    public static void fillNameField(String imie){ driver.findElement(SELECTOR_NAME_FIELD).sendKeys(imie);}
    public static void fillPasswordField(){ driver.findElement(SELECTOR_PASSWORD_FIELD).sendKeys(PASSWORD);}
    public static void fillPasswordConfirmationField(){ driver.findElement(SELECTOR_PASSWORDCONFIRMATION_FIELD).sendKeys(PASSWORD);}
    public static void fillPasswordField(String password){ driver.findElement(SELECTOR_PASSWORD_FIELD).sendKeys(password);}
    public static void fillPasswordConfirmationField(String password){ driver.findElement(SELECTOR_PASSWORDCONFIRMATION_FIELD).sendKeys(password);}
    public static void clickNameField(){
        driver.findElement(SELECTOR_NAME_FIELD).click();
    }
    public static void clickAccountEmailField(){
        driver.findElement(SELECTOR_EMAIL_FIELD).click();
    }
    public static void clickAccountPasswordField(){
        driver.findElement(SELECTOR_PASSWORD_FIELD).click();
    }
    public static void clickAccountPasswordConfirmationField(){driver.findElement(SELECTOR_PASSWORDCONFIRMATION_FIELD).click();}

    public static void clickNumberField(){driver.findElement(SELECTOR_PHONENUMBER_FIELD).click();}
    public static void fillNumberField(){ driver.findElement(SELECTOR_PHONENUMBER_FIELD).sendKeys(randomNumberGen());}
    public static void fillNumberField(String number){ driver.findElement(SELECTOR_PHONENUMBER_FIELD).sendKeys(number);}
    public static void clickSubmitButton(){
        driver.findElement(SELECTOR_SUBMIT_BUTTON).click();
    }
    public void openRegisterUserPage() {
        driver.get(URL_REGISTER);
        wait(20, 1, URL_REGISTER);
    }
    public void checkIfRegisterLoaded(){
        String url = driver.getCurrentUrl();
        if (!url.equals(URL_REGISTER))
        {
            driver.get(URL_REGISTER);
            wait(20,2,URL_REGISTER);
        }
    }
    public void registerUser() {
        clickAccountTypeList();
        clickPersonalAccountTypeList();
        clickNameField();
        fillNameField();
        clickAccountEmailField();
        fillEmailField();
        clickAccountPasswordField();
        fillPasswordField();
        clickAccountPasswordConfirmationField();
        fillPasswordConfirmationField();
        clickNumberField();
        fillNumberField();
        clickSubmitButton();
    }
    public void registerUserWrongEmailAddress() {
        clickAccountTypeList();
        clickPersonalAccountTypeList();
        clickNameField();
        fillNameField();
        clickAccountEmailField();
        fillEmailField("adresBezMalpy");
        clickAccountPasswordField();
        fillPasswordField();
        clickAccountPasswordConfirmationField();
        fillPasswordConfirmationField();
        clickNumberField();
        fillNumberField();
        clickSubmitButton();
    }
    public void registerUserWrongPassword() {
        clickAccountTypeList();
        clickPersonalAccountTypeList();
        clickNameField();
        fillNameField();
        clickAccountEmailField();
        fillEmailField();
        clickAccountPasswordField();
        fillPasswordField("123");
        clickAccountPasswordConfirmationField();
        fillPasswordConfirmationField("123");
        clickNumberField();
        fillNumberField();
        clickSubmitButton();
    }
    public void registerTooShortNumber() {
        clickAccountTypeList();
        clickPersonalAccountTypeList();
        clickNameField();
        fillNameField();
        clickAccountEmailField();
        fillEmailField();
        clickAccountPasswordField();
        fillPasswordField();
        clickAccountPasswordConfirmationField();
        fillPasswordConfirmationField();
        clickNumberField();
        fillNumberField("1234");
        clickSubmitButton();
    }
    public void registerCharacterInsteadOfNumbers() {
        clickAccountTypeList();
        clickPersonalAccountTypeList();
        clickNameField();
        fillNameField();
        clickAccountEmailField();
        fillEmailField();
        clickAccountPasswordField();
        fillPasswordField();
        clickAccountPasswordConfirmationField();
        fillPasswordConfirmationField();
        clickNumberField();
        fillNumberField("PhoneNumb");
        clickSubmitButton();
    }
    public void registerMixCharacterAndNumbers() {
        clickAccountTypeList();
        clickPersonalAccountTypeList();
        clickNameField();
        fillNameField();
        clickAccountEmailField();
        fillEmailField();
        clickAccountPasswordField();
        fillPasswordField();
        clickAccountPasswordConfirmationField();
        fillPasswordConfirmationField();
        clickNumberField();
        fillNumberField("ddd999999");
        clickSubmitButton();
    }
    public void registerDifferentPassword() {
        clickAccountTypeList();
        clickPersonalAccountTypeList();
        clickNameField();
        fillNameField();
        clickAccountEmailField();
        fillEmailField();
        clickAccountPasswordField();
        fillPasswordField("12345Dawid!");
        clickAccountPasswordConfirmationField();
        fillPasswordConfirmationField("Dawid!12345");
        clickNumberField();
        fillNumberField();
        clickSubmitButton();
    }
    public void registerRealUser() {
        clickAccountTypeList();
        clickPersonalAccountTypeList();
        clickNameField();
        fillNameField("CapTest");
        clickAccountEmailField();
        fillEmailField("Captest@o2.pl");
        clickAccountPasswordField();
        fillPasswordField("111111111Cap!");
        clickAccountPasswordConfirmationField();
        fillPasswordConfirmationField("111111111Cap!");
        clickNumberField();
        fillNumberField("+48123456789");
        clickSubmitButton();
    }
    }



