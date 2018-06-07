package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static java.lang.Thread.sleep;

public class LinkedinLoginPage extends LinkedinBasePage {

    @FindBy(id = "login-email")
    private WebElement emailField;

    @FindBy(id = "login-password")
    private WebElement passwordField;

    @FindBy(id = "login-submit")
    private WebElement signInButton;

    @FindBy(xpath = "//input [@class='registration submit-button']")
    private WebElement buttonWillJoin;

    @FindBy(xpath = "//span [@class='alert-content']")
    private WebElement allertContentMassage;

    @FindBy(id = "reg-firstname")
    private WebElement loginRegistration;

    @FindBy(id = "reg-firstname")
    private WebElement lastNameRegistration;

    @FindBy(id = "reg-email")
    private WebElement emailRegistration;

    @FindBy(id = "reg-password")
    private WebElement passwordRegistration;

    @FindBy (className = "link-forgot-password")
    private WebElement forgotPassword;


    /**
     *Constructor
     *  @param webDriver
     */
    public LinkedinLoginPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    /**
     *Method which test is page loaded or not
     *  @return
     */
    @Override
    public boolean isPageLoaded(){
        waitUntilElementIsClickable(signInButton, 10);
        return signInButton.isDisplayed();
    }

    /**
     * Method which enter to input fields our email and password and click on submit button
     *  @param email
     * @param password
     * @return
     */
    public LinkedinErrorPage loginSubmitPage(String email, String password) {
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        signInButton.click();
//        return PageFactory.initElements(webDriver, page.LinkedinErrorPage.class);
        return new LinkedinErrorPage(webDriver);
    }

    /**
     *Method which login us into Linkedin
     * @param email
     * @param password
     * @param <T>
     * @return
     */
    public <T> T login(String email, String password) {
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        signInButton.click();
        if (getCurrentUrl().contains("/feed")) {
            return (T) new LinkedinHomePage(webDriver);
        }
        if (getCurrentUrl().contains("/login-submit")) {
            return (T) new LinkedinErrorPage(webDriver);
        } else {
            return (T) this;
        }
    }


    /**
     * Method whiich click join-button
     */
    public void joinButton (){
        buttonWillJoin.click();
    }

    /**
     *Method which get alert message
     *  @return
     */
    public String getAllertContentMassage (){
        return allertContentMassage.getText();
    }


    /**
     * Method which enter data for registration
     * @param name
     * @param lastName
     * @param email
     * @param password
     */
    public void formRegistration (String name, String lastName, String email, String password){
        loginRegistration.sendKeys(name);
        lastNameRegistration.sendKeys(lastName);
        emailRegistration.sendKeys(email);
        passwordRegistration.sendKeys(password);
        buttonWillJoin.click();
    }

    /**
     *Method which click on button "Forgot password"
     *  @return
     */
    public LinkedinRequestPasswordResetPage clickOnForgotPasswordLink(){

        forgotPassword.click();
        return new LinkedinRequestPasswordResetPage(webDriver);
    }
}