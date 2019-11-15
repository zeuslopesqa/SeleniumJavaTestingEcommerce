package tests;

import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.RandomEmailGenerator;
import utils.ScreenshotGenerator;
import utils.TimeGenerator;
import static org.junit.Assert.*;
import java.util.concurrent.TimeUnit;

@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = "testloginSucessData.csv")

public class SignInTest {
    static WebDriver navigator;
    @Rule
    public TestName testName = new TestName();
    @Before
    public void setUp(){
        //Starting chrome
        System.setProperty("webdriver.chrome.driver","C:/Users/Zeus/Documents/Drivers navegadores/chromedriver_win32/chromedriver.exe");
        navigator = new ChromeDriver();
        //Setting a timeout to avoid erros
        navigator.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //getting the page of tests
        navigator.get("http://automationpractice.com/index.php");
        //Setting the windows to max size
        navigator.manage().window().maximize();
        //Search and click in a link SignIn
        navigator.findElement(By.linkText("Sign in")).click();
    }

    @Test
    public void testRegisterNewUserSucess(){
        //Sending email to start the registration to field id = email_create
        navigator.findElement(By.id("email_create")).sendKeys(RandomEmailGenerator.randomEmail() +"@email.com");
        //Search and click in a button with id = SubmitCreate
        navigator.findElement(By.id("SubmitCreate")).click();

        //Into the registration window
        //select gender with id = id_gender2
        navigator.findElement(By.id("id_gender2")).click();
        //set the field id = customer_firstname
        navigator.findElement(By.id("customer_firstname")).sendKeys("Antoni");
        //set the field id = customer_lastname
        navigator.findElement(By.id("customer_lastname")).sendKeys("Anu");
        //set the field id = passwd
        navigator.findElement(By.id("passwd")).sendKeys("123456");
        //set the select field id = days
        WebElement formDay = navigator.findElement(By.id("days"));
        new Select(formDay).selectByVisibleText("1  ");
        //set the select field id = months
        WebElement formMonth = navigator.findElement(By.id("months"));
        new Select(formMonth).selectByVisibleText("January ");
        //set the select field id = years
        WebElement formYear = navigator.findElement(By.id("years"));
        new Select(formYear).selectByVisibleText("2017  ");

        //set the check box
        navigator.findElement(By.id("uniform-newsletter")).click();
        navigator.findElement(By.id("uniform-optin")).click();

        //Adress
        //set the first name
        navigator.findElement(By.id("firstname")).sendKeys("A");
        //set the last name
        navigator.findElement(By.id("lastname")).sendKeys("D");
        //set fielf with id = company
        navigator.findElement(By.id("company")).sendKeys("company");
        //Set adress
        navigator.findElement(By.id("address1")).sendKeys("address1");
        //set field with id = address2
        navigator.findElement(By.id("address2")).sendKeys("address2");
        //set field with id = city
        navigator.findElement(By.id("city")).sendKeys("Cidade nova");
        //set select field with the state = Arizona
        WebElement formState = navigator.findElement(By.id("id_state"));
        new Select(formState).selectByVisibleText("Arizona");
        //set field id =postcode
        navigator.findElement(By.id("postcode")).sendKeys("00000");
        //set select field = id_country
        WebElement formCountry = navigator.findElement(By.id("id_country"));
        new Select(formCountry).selectByVisibleText("United States");
        //set field id = other
        navigator.findElement(By.id("other")).sendKeys("Yes thank you!");
        //set field id = phone with a valid phone
        navigator.findElement(By.id("phone")).sendKeys("+558899887745");
        //set field id = phone_mobile with a valid cell phone
        navigator.findElement(By.id("phone_mobile")).sendKeys("+5588756845555");
        //set field id = alias with an alias's adress
        navigator.findElement(By.id("alias")).sendKeys("aliasadress@email.com");

        //send the informations in a button with id = submitAccount
        navigator.findElement(By.id("submitAccount")).click();

        //To Verify the sucess in the testcase
        WebElement sucessRegister =  navigator.findElement(By.linkText("Sign out"));
        String validateSucess = sucessRegister.getText();
        assertEquals("Sign out", validateSucess);

        //Created a string to receive my save path to the screenshots and after I have a function to take the photo
        //inputing in its names the name of the testing class, date time and the format to save.
        String savePathScreenShot = "C:\\Users\\Zeus\\Documents\\studySelenium1\\testReport\\"+ TimeGenerator.dataTimeToArchive() +testName.getMethodName()+ ".png";
        ScreenshotGenerator.takePhotos(navigator, savePathScreenShot);
    }

    @Test
    public void testRegisterNewUserUnsucessNoSetFielsRequireds(){
        //Sending email to start the registration to field id = email_create
        //Update: Created the random email generator to automatize the process of validate this scenario
        navigator.findElement(By.id("email_create")).sendKeys(RandomEmailGenerator.randomEmail() +"@email.com");
        //Search and click in a button with id = SubmitCreate
        navigator.findElement(By.id("SubmitCreate")).click();

        //Into the registration window
        //select gender with id = id_gender2
        navigator.findElement(By.id("id_gender2")).click();

        //set the field id = customer_firstname
       // navigator.findElement(By.id("customer_firstname")).sendKeys("Antoni");
        //set the field id = customer_lastname
        //navigator.findElement(By.id("customer_lastname")).sendKeys("Anu");
        //set the field id = passwd
        //navigator.findElement(By.id("passwd")).sendKeys("123456");

        //set the select field id = days
        WebElement formDay = navigator.findElement(By.id("days"));
        new Select(formDay).selectByVisibleText("1  ");
        //set the select field id = months
        WebElement formMonth = navigator.findElement(By.id("months"));
        new Select(formMonth).selectByVisibleText("January ");
        //set the select field id = years
        WebElement formYear = navigator.findElement(By.id("years"));
        new Select(formYear).selectByVisibleText("2017  ");

        //set the check box
        navigator.findElement(By.id("uniform-newsletter")).click();
        navigator.findElement(By.id("uniform-optin")).click();

        //Adress
        //set the first name
        navigator.findElement(By.id("firstname")).sendKeys("A");
        //set the last name
        navigator.findElement(By.id("lastname")).sendKeys("D");
        //set fielf with id = company
        navigator.findElement(By.id("company")).sendKeys("company");
        //Set adress
        navigator.findElement(By.id("address1")).sendKeys("address1");
        //set field with id = address2
        navigator.findElement(By.id("address2")).sendKeys("address2");
        //set field with id = city
        navigator.findElement(By.id("city")).sendKeys("Cidade nova");
        //set select field with the state = Arizona
        WebElement formState = navigator.findElement(By.id("id_state"));
        new Select(formState).selectByVisibleText("Arizona");
        //set field id =postcode
        navigator.findElement(By.id("postcode")).sendKeys("00000");
        //set select field = id_country
        WebElement formCountry = navigator.findElement(By.id("id_country"));
        new Select(formCountry).selectByVisibleText("United States");
        //set field id = other
        navigator.findElement(By.id("other")).sendKeys("Yes thank you!");
        //set field id = phone with a valid phone
        navigator.findElement(By.id("phone")).sendKeys("+558899887745");
        //set field id = phone_mobile with a valid cell phone
        navigator.findElement(By.id("phone_mobile")).sendKeys("+5588756845555");
        //set field id = alias with an alias's adress
        navigator.findElement(By.id("alias")).sendKeys("aliasadress@email.com");

        //send the informations in a button with id = submitAccount
        navigator.findElement(By.id("submitAccount")).click();

        //To Verify the unsucess in the testcase
        WebDriverWait waiting = new WebDriverWait(navigator, 5);
        waiting.until(ExpectedConditions.elementToBeClickable(By.linkText("Sign in")));
    }

    @Test
    public void testloginSucess(@Param(name = "email") String email, @Param(name = "password") String password, @Param(name ="message")String expectedMessage){
        //Input a registered email in a field with id = email
        navigator.findElement(By.id("email")).sendKeys(email);
        //Input a correct passowrd in a field with id = passwd
        navigator.findElement(By.id("passwd")).sendKeys(password);
        //Find a button with id = SubmitLogin and click
        navigator.findElement(By.id("SubmitLogin")).click();

        //To Verify the sucess in the testcase
        WebElement sucessLogin =  navigator.findElement(By.linkText("Sign out"));
        String validateLogin = sucessLogin.getText();
        assertEquals(expectedMessage, validateLogin);
    }
    @Test
    public void testloginUnucessBlankFields(){
        //Input a registered email in a field with id = email
        navigator.findElement(By.id("email")).sendKeys("");
        //Input a correct passowrd in a field with id = passwd
        navigator.findElement(By.id("passwd")).sendKeys("");
        //Find a button with id = SubmitLogin and click
        navigator.findElement(By.id("SubmitLogin")).click();

        //To Verify the sucess in the testcase
        WebElement unsucessLogin =  navigator.findElement(By.linkText("Sign in"));
        String validateSucess = unsucessLogin.getText();
        assertEquals("Sign in", validateSucess);

        //Here I validate the message of return, probably its incorrect, because it would have message to passwd required too.
        WebElement uncessLoginValidate =  navigator.findElement(By.xpath(" //div//li[text() = 'An email address required.']"));
        String validateLoginFail = uncessLoginValidate.getText();
        assertEquals("An email address required.", validateLoginFail);
    }


    @Before
    public void tearDown(){
     //   navigator.quit();

    }
}
