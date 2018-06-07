package page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LinkedinHomePage extends LinkedinBasePage {

    @FindBy (xpath = "//li[@id='profile-nav-item']")
    private WebElement profileNavItem;

    @FindBy (xpath = "//input[@placeholder='Поиск']")
    private WebElement searchField;

    /**
     *Constructor
     *  @param webDriver
     */
    public LinkedinHomePage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    /**
     *Method which test is page loaded or not
     *  @return
     */
    public boolean isPageLoaded() {
        waitUntilElementIsClickable(profileNavItem, 5);
        return profileNavItem.isDisplayed();
    }

    /**
     *Method whuch enter some data to search field
     *  @param searchTerm
     * @return
     */
    public LinkedinSearchResults search(String searchTerm){
        searchField.sendKeys(searchTerm);
        searchField.sendKeys(Keys.ENTER);
        return new LinkedinSearchResults(webDriver);
    }
}