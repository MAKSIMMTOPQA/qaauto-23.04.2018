import org.openqa.selenium.WebDriver;

public class LinkedInBasePage {

    protected WebDriver webDriver;

    public LinkedInBasePage(WebDriver webDriver){

        this.webDriver = webDriver;
    }


    public String getCurrentUrl() {
        return webDriver.getCurrentUrl();

    }


    public String getCurrentTitle() {

        return webDriver.getTitle();
    }

}