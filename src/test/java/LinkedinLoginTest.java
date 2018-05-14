import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;

public class LinkedinLoginTest {

    @Test
    public void succeccfullLoginTest() throws InterruptedException {

        WebDriver webDriver = new FirefoxDriver();
        webDriver.get("https://www.linkedin.com/");

//        *Assert.assertEquals("a", "b", "Probably 'a' is not equals to 'b'");

//        Assert.assertEquals(webDriver.getTitle(), "LinkedIn: Войти или зарегистрироваться","Login page is wrong");
//
////        WebElement searchMail = webDriver.findElement(By.xpath("//input[@class='login-email']"));
////        searchMail.sendKeys("m.korshikov@everad.com");
////        WebElement searchPass = webDriver.findElement(By.xpath("//input[@name='session_password']"));
////        searchPass.sendKeys("q124578fg");
//
//
//        WebElement buttonSubmit = webDriver.findElement(By.xpath("//input[@id='login-submit']"));
//        Assert.assertTrue(buttonSubmit.isDisplayed(), "Singin buton is not displayed");
//
//        buttonSubmit.sendKeys(Keys.ENTER);
//
//        Assert.assertEquals(webDriver.getTitle(),
//                "LinkedIn: Войти или зарегистрироваться",
//                "Login page Title is wrong");
//        Assert.assertEquals(webDriver.getCurrentUrl(), "https://www.linkedin.com/", "home page URL is wrong");
//
//        Assert.assertTrue(webDriver.getTitle().contains("LinkedIn"), "Login page is wrong");

        WebElement searchMail = webDriver.findElement(By.xpath("//input[@class='login-email']"));
        searchMail.sendKeys("123");
        WebElement searchPass = webDriver.findElement(By.xpath("//input[@name='session_password']"));
        searchPass.sendKeys("123");
        WebElement buttonSubmit = webDriver.findElement(By.xpath("//input[@id='login-submit']"));
        buttonSubmit.sendKeys(Keys.ENTER);
        Assert.assertEquals(webDriver.getCurrentUrl(), "https://www.linkedin.com/", "in correct adress");
        sleep(5000);
        webDriver.navigate().back();


    }

    @Test
    public void notsucceccfullLoginTest() {
        WebDriver webDriver = new FirefoxDriver();
        webDriver.get("https://www.linkedin.com/");

        WebElement searchMail2 = webDriver.findElement(By.xpath("//input[@class='login-email']"));
        searchMail2.sendKeys("");
        WebElement searchPass2 = webDriver.findElement(By.xpath("//input[@name='session_password']"));
        searchPass2.sendKeys("");
        WebElement buttonSubmit2 = webDriver.findElement(By.xpath("//input[@id='login-submit']"));
        buttonSubmit2.click();

        Assert.assertEquals(webDriver.getCurrentUrl(), "https://www.linkedin.com/", "in correct adress");


    }

    @Test
    public void notsucceccfullLoginTest2() {
        WebDriver webDriver = new FirefoxDriver();
        webDriver.get("https://www.linkedin.com/");

        WebElement searchMail2 = webDriver.findElement(By.xpath("//input[@class='login-email']"));
        searchMail2.sendKeys("");
        WebElement searchPass2 = webDriver.findElement(By.xpath("//input[@name='session_password']"));
        searchPass2.sendKeys("123");
        WebElement buttonSubmit2 = webDriver.findElement(By.xpath("//input[@id='login-submit']"));
        buttonSubmit2.click();

        Assert.assertEquals(webDriver.getCurrentUrl(), "https://www.linkedin.com/", "in correct adress");
    }


    @Test
    public void notsucceccfullLoginTest4() {
        WebDriver webDriver = new FirefoxDriver();
        webDriver.get("https://www.linkedin.com/");

        WebElement searchMail2 = webDriver.findElement(By.xpath("//input[@class='login-email']"));
        searchMail2.sendKeys("123123");
        WebElement searchPass2 = webDriver.findElement(By.xpath("//input[@name='session_password']"));
        searchPass2.sendKeys("");
        WebElement buttonSubmit2 = webDriver.findElement(By.xpath("//input[@id='login-submit']"));
        buttonSubmit2.click();

        Assert.assertEquals(webDriver.getCurrentUrl(), "https://www.linkedin.com/", "in correct adress");
    }
}