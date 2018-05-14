import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LinkedinLoginPage {

         private WebDriver webDriver;

    private WebElement searchMail = webDriver.findElement(By.xpath("//input[@class='login-email']"));
    private WebElement searchPass = webDriver.findElement(By.xpath("//input[@name='session_password']"));
    private WebElement buttonSubmit = webDriver.findElement(By.xpath("//input[@id='login-submit']"));

    public void login(String email, String password){

        searchMail.sendKeys(email);
        searchPass.sendKeys(password);
        buttonSubmit.click();
    }

}
