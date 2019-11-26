package tests;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.InitialPage;
import utils.WebNavigator;
import static org.junit.Assert.assertEquals;

public class LoginSucessTest {
    WebDriver navigator;
    @Before
    public void setUp(){
        navigator = WebNavigator.createChrome();
    }
    @Test
    public void login(){
        new InitialPage(navigator)
            .clickSignIn()
            .doLogin();
        assertEquals("Sign out", navigator.findElement(By.linkText("Sign out")).getText());
    }
    @After
    public void tearDown(){
        navigator.close();
    }
}
