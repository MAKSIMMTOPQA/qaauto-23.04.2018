import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LinkedinLoginTest {

    @Test
    public void succeccfullLoginTest() {

        WebDriver webDriver = new FirefoxDriver();
        webDriver.get("https://www.linkedin.com/");

//        *Assert.assertEquals("a", "b", "Probably 'a' is not equals to 'b'");

        Assert.assertEquals(webDriver.getTitle(), "LinkedIn: Войти или зарегистрироваться","Login page is wrong");

        WebElement searchMail = webDriver.findElement(By.xpath("//input[@class='login-email']"));
        searchMail.sendKeys("m.korshikov@everad.com");
        WebElement searchPass = webDriver.findElement(By.xpath("//input[@name='session_password']"));
        searchPass.sendKeys("q124578fg");


        WebElement buttonSubmit = webDriver.findElement(By.xpath("//input[@id='login-submit']"));
        Assert.assertTrue(buttonSubmit.isDisplayed(), "Singin buton is not displayed");

        buttonSubmit.sendKeys(Keys.ENTER);

        Assert.assertEquals(webDriver.getTitle(),
                "LinkedIn: Войти или зарегистрироваться",
                "Login page Title is wrong");
        Assert.assertEquals(webDriver.getCurrentUrl(), "https://www.linkedin.com/", "home page URL is wrong");

        Assert.assertTrue(webDriver.getTitle().contains("LinkedIn"), "Login page is wrong");






    }




}