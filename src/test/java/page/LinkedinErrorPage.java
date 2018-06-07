package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LinkedinErrorPage extends LinkedinBasePage {

    @FindBy (xpath ="//div [@role='alert']")
    private WebElement errorMessage;

    @FindBy (xpath ="//div [@class='forgot-password-container'] //a" )
    private WebElement forgotYorPassword;

    /**
     *Constructor
     *  @param webDriver
     */
    public LinkedinErrorPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    /**
     *Method which test is page loaded or not
     *  @return
     */
    boolean isPageLoaded() {
        return false;
    }

    /**
     *Method which return us text of error message
     *  @return
     */
    public String getTextErrorMessage() {
        return errorMessage.getText();
    }


    /**
     *Method which return us message which shows when we forget our password
     *  @return
     */
    public String getforgotYorPassword () {
        return forgotYorPassword.getText();
    }


}