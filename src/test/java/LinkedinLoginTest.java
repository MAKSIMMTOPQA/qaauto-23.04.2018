import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;

public class LinkedinLoginTest {

    @BeforeMethod
    public void before(){
        webDriver = new FirefoxDriver();
        webDriver.get("https://www.linkedin.com/");

    }

    WebDriver webDriver;
    @Test
    public void succeccfullLoginTest() throws InterruptedException {



        Assert.assertEquals("a", "b", "Probably 'a' is not equals to 'b'");

        Assert.assertEquals(webDriver.getTitle(), "LinkedIn: Войти или зарегистрироваться","Login page is wrong");

        LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage();
        linkedinLoginPage.login("m.korshikov@everad.com","q124578fg");



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


        Assert.assertEquals(webDriver.getCurrentUrl(), "https://www.linkedin.com/", "ERROR IN AUTORIZATION FORM");
        sleep(5000);
        webDriver.navigate().back();

    }

    @Test
    public void notsucceccfullLoginTest()  {


        WebElement searchMail = webDriver.findElement(By.xpath("//input[@class='login-email']"));
        searchMail.sendKeys("");
        WebElement searchPass = webDriver.findElement(By.xpath("//input[@name='session_password']"));
        searchPass.sendKeys("");
        WebElement buttonSubmit = webDriver.findElement(By.xpath("//input[@id='login-submit']"));
        buttonSubmit.click();

        Assert.assertEquals(webDriver.getCurrentUrl(), "https://www.linkedin.com/", "ERROR IN AUTORIZATION FORM");


    }

    @Test
    public void notsucceccfullLoginTest2() {


        WebElement searchMail = webDriver.findElement(By.xpath("//input[@class='login-email']"));
        searchMail.sendKeys("");
        WebElement searchPass = webDriver.findElement(By.xpath("//input[@name='session_password']"));
        searchPass.sendKeys("123");
        WebElement buttonSubmit = webDriver.findElement(By.xpath("//input[@id='login-submit']"));
        buttonSubmit.click();

        Assert.assertEquals(webDriver.getCurrentUrl(), "https://www.linkedin.com/", "ERROR IN AUTORIZATION FORM");
    }

    @Test
    public void notsucceccfullLoginTest4() {


        WebElement searchMail = webDriver.findElement(By.xpath("//input[@class='login-email']"));
        searchMail.sendKeys("123123");
        WebElement searchPass = webDriver.findElement(By.xpath("//input[@name='session_password']"));
        searchPass.sendKeys("");
        WebElement buttonSubmit = webDriver.findElement(By.xpath("//input[@id='login-submit']"));
        buttonSubmit.click();

        Assert.assertEquals(webDriver.getCurrentUrl(), "https://www.linkedin.com/", "ERROR IN AUTORIZATION FORM");
    }

    @Test
    public void notsucceccfullLoginTest5() throws InterruptedException {


        Assert.assertEquals(webDriver.getTitle(), "LinkedIn: Войти или зарегистрироваться","Login page is wrong");

        WebElement searchMail = webDriver.findElement(By.xpath("//input[@class='login-email']"));
        searchMail.sendKeys("m.korshikoveverad.com");
        WebElement searchPass = webDriver.findElement(By.xpath("//input[@name='session_password']"));
        searchPass.sendKeys("1");
        WebElement buttonSubmit = webDriver.findElement(By.xpath("//input[@id='login-submit']"));
        buttonSubmit.click();

        sleep(3000);

        String currentPageUrl = webDriver.getCurrentUrl();
        String currentPageTitle = webDriver.getTitle();


        Assert.assertEquals(currentPageUrl,
                "https://www.linkedin.com/uas/login-submit",
                "login submit url is wrong");
        Assert.assertEquals(currentPageTitle,
                "Войти в LinkedIn",
                "login submit title is wrong");

        WebElement errorMessage = webDriver.findElement(By.xpath("//div[@role='alert']"));

        Assert.assertEquals(errorMessage.getText(),
                "При заполнении формы были допущены ошибки. Проверьте и исправьте отмеченные поля.",
                "Wrong error massage text displayed");




        }
        @AfterMethod
        public void after() {
            webDriver.close();
        }
}