import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LinkedinLoginPage extends LinkedInBasePage {

    @FindBy (xpath = "//input[@class='login-email']")
    private WebElement searchMail;
    @FindBy (xpath ="//input[@name='session_password']" )
    private WebElement searchPass;
    @FindBy (xpath = "//input[@id='login-submit']")
    private WebElement buttonSubmit;
    @FindBy (xpath = "//a[@class='link-forgot-password']")
    private WebElement passrecovery;

    public LinkedinLoginPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);

    }


    public <T> T login(String email, String password) {
        searchMail.sendKeys(email);
        searchPass.sendKeys(password);
        buttonSubmit.click();
        if (getCurrentUrl().contains("/feed")) {
            return (T) new LinkedInHomePage(webDriver);
        }
        if (getCurrentUrl().contains("/login-submit")) {
            return (T) new LinkedinErrorPage(webDriver);
        }
        else {
            return (T) this;
        }
    }
    public boolean isSearchButtonDisplayed(){
        return buttonSubmit.isDisplayed();
    }

    public LinkeInPassRecovery passRecoveryClick(){
        passrecovery.click();
        return new LinkeInPassRecovery(webDriver);

    }

}
