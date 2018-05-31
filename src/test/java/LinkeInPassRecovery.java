
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LinkeInPassRecovery extends LinkedInBasePage {

    @FindBy (xpath = "//button[@class='form__submit']")
    private WebElement submitEmail;
    @FindBy (xpath = "//input[@name='userName']")
    private WebElement emailField;

    public LinkeInPassRecovery(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    public void sendEmail(){
        emailField.sendKeys("m.korshikov@everad.com");
        submitEmail.click();
    }



}
