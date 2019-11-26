package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class WebNavigator {
    static WebDriver navigator;

    public static WebDriver createChrome(){
        //Starting chrome
        System.setProperty("webdriver.chrome.driver","C:/Users/Zeus/Documents/Drivers navegadores/chromedriver_win32/chromedriver.exe");
        navigator = new ChromeDriver();
        //Setting a timeout to avoid erros
        navigator.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //getting the page of tests
        navigator.get("http://automationpractice.com/index.php");
        //Setting the windows to max size
        navigator.manage().window().maximize();

        return navigator;
    }
}
