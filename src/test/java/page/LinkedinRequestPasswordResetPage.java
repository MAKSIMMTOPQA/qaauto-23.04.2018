package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.GMailService;

public class LinkedinRequestPasswordResetPage extends LinkedinBasePage{

    @FindBy (id = "username")
    private WebElement emailField;

    @FindBy (className = "form__submit")
    private WebElement emailSubmitButton;


    /**
     *Constructor
     *  @param webDriver
     */
    public LinkedinRequestPasswordResetPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    /**
     *Method which enter and submit our email
     *  @param userEmail
     * @return
     */
    public LinkedinRequestPasswordResetSubmitPage submitUserEmail(String userEmail){

        gMailService.connect();
        emailField.sendKeys(userEmail);
        emailSubmitButton.click();
        return new LinkedinRequestPasswordResetSubmitPage(webDriver);
    }

    /**
     *Method check is page loaded or not
     *  @return
     */
   public boolean isPageLoaded() {

        return emailField.isDisplayed();
    }

}
