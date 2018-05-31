import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;

    public class LinkedinLoginTest {
    WebDriver webDriver;

    @BeforeMethod
    public void before(){
        webDriver = new FirefoxDriver();
        webDriver.get("https://www.linkedin.com/");

    }

        @DataProvider
        public Object[][] validDataProvider() {
            return new Object[][]{
                    {"m.korshikov@everad.com", "q124578fg"},
                    {"M.KORSHIKOV@EVERAD.COM", "q124578fg"},

            };

        }
    @Test(dataProvider = "validDataProvider")
    public void succeccfullLoginTest(String email, String password) throws InterruptedException {

        LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage(webDriver);
        Assert.assertEquals(linkedinLoginPage.getCurrentTitle(),
                "LinkedIn: Войти или зарегистрироваться",
                "Login page is wrong");
        Assert.assertTrue(linkedinLoginPage.isSearchButtonDisplayed(),
                "Singin buton is not displayed");

        LinkedInHomePage linkedInHomePage = linkedinLoginPage.login(email,password);
        Assert.assertEquals(linkedInHomePage.getCurrentUrl(),
                "https://www.linkedin.com/feed/",
                "ERROR IN AUTORIZATION FORM");
        Assert.assertTrue(linkedInHomePage.getCurrentTitle().contains("LinkedIn"),
                "Home page title is wrong");

        sleep(5000);
        webDriver.navigate().back();

    }



    @Test
    public void negativeReturnedToLogInSubmitTest() throws InterruptedException {


        LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage(webDriver);
        Assert.assertTrue(linkedinLoginPage.isSearchButtonDisplayed(), "Singin buton is not displayed");
        linkedinLoginPage.login("m.korshikov@everad.com","1");

        LinkedinErrorPage linkedinErrorPage = new LinkedinErrorPage(webDriver);


        sleep(2000);

        Assert.assertTrue(linkedinErrorPage.isPageLoaded(),"Login Error page is not loaded");
        Assert.assertEquals(linkedinErrorPage.getCurrentUrl(),
                "https://www.linkedin.com/uas/login-submit",
                "ERROR IN AUTORIZATION FORM");
        Assert.assertEquals(linkedinErrorPage.getCurrentTitle(),
                "Войти в LinkedIn",
                "login submit title is wrong");
        Assert.assertEquals(linkedinErrorPage.getErrorText(),
                "При заполнении формы были допущены ошибки. Проверьте и исправьте отмеченные поля.",
                "Wrong error massage text displayed");


    }

    @Test
    public void notsucceccfullLoginTest2() throws InterruptedException {


        LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage(webDriver);
        Assert.assertEquals(linkedinLoginPage.getCurrentTitle(),
                "LinkedIn: Войти или зарегистрироваться",
                "login submit title is wrong");
        Assert.assertTrue(linkedinLoginPage.isSearchButtonDisplayed(), "Singin buton is not displayed");
        linkedinLoginPage.login("","1123123123");
        Assert.assertEquals(linkedinLoginPage.getCurrentTitle(),
                "LinkedIn: Войти или зарегистрироваться",
                "login submit title is wrong");

        sleep(2000);
        Assert.assertEquals(linkedinLoginPage.getCurrentUrl(), "https://www.linkedin.com/", "ERROR IN AUTORIZATION FORM");

    }

    @Test
    public void notsucceccfullLoginTest4() throws InterruptedException {


        LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage(webDriver);
        Assert.assertTrue(linkedinLoginPage.isSearchButtonDisplayed(), "Singin buton is not displayed");
        linkedinLoginPage.login("m.korshikoveverad.com", "123123123");

        LinkedinErrorPage linkedinErrorPage = new LinkedinErrorPage(webDriver);


        sleep(2000);
        Assert.assertEquals(linkedinErrorPage.getCurrentUrl(),
                "https://www.linkedin.com/uas/login-submit",
                "ERROR IN AUTORIZATION FORM");
        Assert.assertEquals(linkedinErrorPage.getCurrentTitle(),
                "Войти в LinkedIn",
                "login submit title is wrong");
        Assert.assertEquals(linkedinErrorPage.getErrorText(),
                "При заполнении формы были допущены ошибки. Проверьте и исправьте отмеченные поля.",
                "Wrong error massage text displayed");
    }

    @Test
    public void notsucceccfullLoginTest5() throws InterruptedException {


        LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage(webDriver);
        Assert.assertEquals(linkedinLoginPage.getCurrentTitle(),
                "LinkedIn: Войти или зарегистрироваться",
                "login submit title is wrong");
        Assert.assertTrue(linkedinLoginPage.isSearchButtonDisplayed(), "Singin buton is not displayed");
        linkedinLoginPage.login("", "");
        Assert.assertEquals(linkedinLoginPage.getCurrentTitle(),
                "LinkedIn: Войти или зарегистрироваться",
                "login submit title is wrong");

        sleep(2000);
        Assert.assertEquals(linkedinLoginPage.getCurrentUrl(), "https://www.linkedin.com/", "ERROR IN AUTORIZATION FORM");

    }
        @Test
            public void successfulResetPasswordTest() throws InterruptedException {
            LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage(webDriver);

            LinkeInPassRecovery linkeInPassRecovery = linkedinLoginPage.passRecoveryClick();

            sleep(2000);

            linkeInPassRecovery.sendEmail();

        }





        @AfterMethod
        public void after() {
            webDriver.close();
        }
}