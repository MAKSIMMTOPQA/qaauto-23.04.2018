package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LinkedinSuccesfulPasswordResetPage extends LinkedinBasePage{

   @FindBy(id = "reset-password-submit-button")
   private WebElement goHomeButton;

    /**
     *Constructor
     *  @param webDriver
     */
    public LinkedinSuccesfulPasswordResetPage(WebDriver webDriver) {
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
     *Method click on button which take us on Home Page
     *  @return
     */
    public LinkedinHomePage clickOnGoToHomeButton() {

        goHomeButton.click();
        return new LinkedinHomePage(webDriver);
    }
}
