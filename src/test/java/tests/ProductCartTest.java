package tests;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class ProductCartTest {
    static WebDriver navigatorChrome;

    @Before
    public void setUp(){
        //Setting chrome parameters
        System.setProperty("webdriver.chrome.driver","C:/Users/Zeus/Documents/Drivers navegadores/chromedriver_win32/chromedriver.exe");
        //instacy of the chrome
        navigatorChrome = new ChromeDriver();
        //Setting a timeout to avoid erros
        navigatorChrome.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //Getting the page
        navigatorChrome.get("http://automationpractice.com/index.php");
        //Set the window size
        navigatorChrome.manage().window().maximize();
    }

    @Test
    public void addProductCartWithoutPreviousLogin(){
        //Search and click in a button using the xpath
      //  navigatorChrome.findElement(By.xpath("//div/a[@data-id-product = '1']")).isSelected();

        Actions builder = new Actions(navigatorChrome);
        WebElement element = navigatorChrome.findElement(By.xpath("//div/a[@data-id-product = '1']"));
        builder.moveToElement(element).build();
        builder.click();
    }
}

