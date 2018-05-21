import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LinkedinLoginPage extends LinkedInBasePage {

    private WebElement searchMail;
    private WebElement searchPass;
    private WebElement buttonSubmit;

    public LinkedinLoginPage(WebDriver webDriver) {
        super(WebDriver);
         initElements();
    }

    public void initElements(){
        searchMail = webDriver.findElement(By.xpath("//input[@class='login-email']"));
        searchPass = webDriver.findElement(By.xpath("//input[@name='session_password']"));
        buttonSubmit = webDriver.findElement(By.xpath("//input[@id='login-submit']"));
    }



    public void login(String email, String password){

        searchMail.sendKeys(email);
        searchPass.sendKeys(password);
        buttonSubmit.click();
    }

    public boolean isSearchButtonDisplayed(){
        return buttonSubmit.isDisplayed();
    }

}
