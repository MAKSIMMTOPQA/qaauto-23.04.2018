package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.GMailService;

public abstract class LinkedinBasePage {
    protected WebDriver webDriver;
    protected static GMailService gMailService = new GMailService();

    /**
     *Constructor
     *  @param webDriver
     */
    public LinkedinBasePage (WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    /**
     * Method which return current URL
     * @return
     */
    public String getCurrentUrl (){
        return webDriver.getCurrentUrl();
    }

    /**
     *Method which return current title
     *  @return
     */
    public String getCurrentTittle (){
        return webDriver.getTitle();
    }

    /**
     *Method which test is page loaded or not
     *  @return
     */
    abstract boolean isPageLoaded();

    /**
     *Method stops test until some element won`t be clickable
     *  @param webElement
     * @param timeOutInSeconds
     * @return
     */
    public WebElement waitUntilElementIsClickable (WebElement webElement, int timeOutInSeconds){
        WebDriverWait wait = new WebDriverWait(webDriver, timeOutInSeconds);
        //wait.until(ExpectedConditions.elementToBeClickable(webElement));
        return webElement;
    }

    /**
     *Method stops test until some element won`t be visible
     *  @param webElement
     * @param timeOutInSeconds
     * @return
     */
    public WebElement waitUntilElementIsVisible (WebElement webElement, int timeOutInSeconds){
        WebDriverWait wait = new WebDriverWait(webDriver, timeOutInSeconds);
       // wait.until(ExpectedConditions.visibilityOf(webElement));
        return webElement;
    }
}