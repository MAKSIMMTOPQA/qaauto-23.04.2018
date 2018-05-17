import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;

    public class LinkedinLoginTest {
    WebDriver webDriver;

    @BeforeMethod
    public void before(){
        webDriver = new FirefoxDriver();
        webDriver.get("https://www.linkedin.com/");

    }


    @Test
    public void succeccfullLoginTest() throws InterruptedException {

        LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage(webDriver);
        String actualLoginPageTitle  = linkedinLoginPage.getCurrentTitle();

        Assert.assertEquals(linkedinLoginPage.getCurrentTitle(),
                "LinkedIn: Войти или зарегистрироваться",
                "Login page is wrong");
        Assert.assertTrue(linkedinLoginPage.isSearchButtonDisplayed(),
                "Singin buton is not displayed");

        linkedinLoginPage.login("m.korshikov@everad.com","q124578fg");



        LinkedinHomePage linkedinHomePage = new LinkedinHomePage (webDriver);

        Assert.assertEquals(linkedinHomePage.getCurrentUrl(),
                "https://www.linkedin.com/",
                "ERROR IN AUTORIZATION FORM");
        Assert.assertTrue(linkedinHomePage.getCurrentTitle().contains("LinkedIn"),
                "Home page title is wrong");

        sleep(5000);
        webDriver.navigate().back();

    }

    @Test
    public void notsucceccfullLoginTest() throws InterruptedException {

        String actualLoginPageTitle  = webDriver.getTitle();

        LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage(webDriver);
        Assert.assertTrue(linkedinLoginPage.isSearchButtonDisplayed(), "Singin buton is not displayed");
        linkedinLoginPage.login("m.korshikov@everad.com","1");


        sleep(2000);
        Assert.assertEquals(webDriver.getCurrentUrl(), "https://www.linkedin.com/", "ERROR IN AUTORIZATION FORM");

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