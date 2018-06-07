package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LinkedinSetNewPasswordPage extends LinkedinBasePage{

    @FindBy(id = "newPassword")
    private WebElement newPassword;

    @FindBy(id = "confirmPassword")
    private WebElement confirmPassword;

    @FindBy(id = "reset-password-submit-button")
    private WebElement resetPassword;

    /**
     *Constructor
     *  @param webDriver
     */
    public LinkedinSetNewPasswordPage(WebDriver webDriver) {
        super(webDriver);
    }

    /**
     *Method check is page loaded or not
     *  @return
     */
    public boolean isPageLoaded() {
        return true;
    }

    /**
     *Method which write twice new password
     *  @param newUserPassword
     * @return
     */
    public LinkedinSuccesfulPasswordResetPage submitNewPassword(String newUserPassword) {

        waitUntilElementIsClickable(newPassword, 5);
        newPassword.sendKeys(newUserPassword);
        confirmPassword.sendKeys(newUserPassword);
        resetPassword.click();

        return new LinkedinSuccesfulPasswordResetPage(webDriver);
    }
}
