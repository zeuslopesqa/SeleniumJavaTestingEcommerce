package tests;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

public class testSignIn {
    static WebDriver navegador;
    @Before
    public void setUp(){
        //Starting chrome
        System.setProperty("webdriver.chrome.driver","C:/Users/Zeus/Documents/Drivers navegadores/chromedriver_win32/chromedriver.exe");
        navegador = new ChromeDriver();
        //Setting a timeout to avoid erros
        navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //getting the page of tests
        navegador.get("http://automationpractice.com/index.php");
        //Setting the windows to max size
        navegador.manage().window().maximize();
        //Search and click in a link SignIn
        navegador.findElement(By.linkText("Sign in")).click();
    }

    @Test
    public void testRegisterNewUserSucess(){
        //Sending email to start the registration to field id = email_create
        navegador.findElement(By.id("email_create")).sendKeys("teste@email234.com");
        //Search and click in a button with id = SubmitCreate
        navegador.findElement(By.id("SubmitCreate")).click();

        //Into the registration window
        //select gender with id = id_gender2
        navegador.findElement(By.id("id_gender2")).click();

        //set the field id = customer_firstname
        navegador.findElement(By.id("customer_firstname")).sendKeys("Antoni");
        //set the field id = customer_lastname
        navegador.findElement(By.id("customer_lastname")).sendKeys("Anu");
        //set the field id = passwd
        navegador.findElement(By.id("passwd")).sendKeys("123456");

        //set the select field id = days
        WebElement formDay = navegador.findElement(By.id("days"));
        new Select(formDay).selectByVisibleText("1  ");
        //set the select field id = months
        WebElement formMonth = navegador.findElement(By.id("months"));
        new Select(formMonth).selectByVisibleText("January ");
        //set the select field id = years
        WebElement formYear = navegador.findElement(By.id("years"));
        new Select(formYear).selectByVisibleText("2017  ");

        //set the check box
        navegador.findElement(By.id("uniform-newsletter")).click();
        navegador.findElement(By.id("uniform-optin")).click();

        //Adress
        //set the first name
        navegador.findElement(By.id("firstname")).sendKeys("A");
        //set the last name
        navegador.findElement(By.id("lastname")).sendKeys("D");
        //set fielf with id = company
        navegador.findElement(By.id("company")).sendKeys("company");
        //Set adress
        navegador.findElement(By.id("address1")).sendKeys("address1");
        //set field with id = address2
        navegador.findElement(By.id("address2")).sendKeys("address2");
        //set field with id = city
        navegador.findElement(By.id("city")).sendKeys("Cidade nova");
        //set select field with the state = Arizona
        WebElement formState = navegador.findElement(By.id("id_state"));
        new Select(formState).selectByVisibleText("Arizona");
        //set field id =postcode
        navegador.findElement(By.id("postcode")).sendKeys("00000");
        //set select field = id_country
        WebElement formCountry = navegador.findElement(By.id("id_country"));
        new Select(formCountry).selectByVisibleText("United States");
        //set field id = other
        navegador.findElement(By.id("other")).sendKeys("Yes thank you!");
        //set field id = phone with a valid phone
        navegador.findElement(By.id("phone")).sendKeys("+558899887745");
        //set field id = phone_mobile with a valid cell phone
        navegador.findElement(By.id("phone_mobile")).sendKeys("+5588756845555");
        //set field id = alias with an alias's adress
        navegador.findElement(By.id("alias")).sendKeys("aliasadress@email.com");

        //send the informations in a button with id = submitAccount
        navegador.findElement(By.id("submitAccount")).click();

        //To Verify the sucess in the testcase
        WebElement sucessRegister =  navegador.findElement(By.linkText("Sign out"));
        String validateSucess = sucessRegister.getText();
        assertEquals("Sign out", validateSucess);

    }

    @Before
    public void tearDown(){

    }
}
