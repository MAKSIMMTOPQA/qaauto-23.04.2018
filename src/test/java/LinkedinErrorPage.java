import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LinkedinErrorPage extends LinkedInBasePage {


    private WebElement errorMessage;
    private WebElement emailField;
    public LinkedinErrorPage(WebDriver webDriver) {
        super(WebDriver);
        initElements();
    }




    public void initElements()
    {

        errorMessage = webDriver.findElement(By.xpath("//div[@role='alert']"));
        emailField = webDriver.findElement(By.id("session_key-login"));
    }

    public boolean isPageLoaded(){
        return emailField.isDisplayed();


    }



    public String getErrorText(){

        return errorMessage.getText();
    }





}




