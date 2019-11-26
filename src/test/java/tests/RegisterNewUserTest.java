package tests;

import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.InitialPage;
import utils.WebNavigator;
import static org.junit.Assert.assertEquals;

//@RunWith(DataDrivenTestRunner.class)
//@DataLoader(filePaths = "registerNewUserSucessData.csv")

public class RegisterNewUserTest {
    WebDriver navigator;
    @Before
    public void setUp(){
        navigator = WebNavigator.createChrome();

    }

    @Test
    public void registerNewUserSucess(){
        new InitialPage(navigator)
                .clickSignIn()
                .typeEmailAndClickSubmit()
                .fillAndSubmitForm();
        assertEquals("Sign out", navigator.findElement(By.linkText("Sign out")).getText());
    }

    @After
    public void tearDown(){

    }
}
