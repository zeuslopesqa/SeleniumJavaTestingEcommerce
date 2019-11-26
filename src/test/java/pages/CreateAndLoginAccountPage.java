package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.RandomEmailGenerator;

public class CreateAndLoginAccountPage extends BasePage {
    public CreateAndLoginAccountPage(WebDriver navigator) {
        super(navigator);
    }

    //Methods to create a new register
    //structural methods
    public CreateAndLoginAccountPage typeEmail(){
        navigator.findElement(By.id("email_create")).sendKeys(RandomEmailGenerator.randomEmail() +"@email.com");
        return this;
    }

    public FormAccountPage clickSubmitCreate(){
        navigator.findElement(By.id("SubmitCreate")).click();
        return new FormAccountPage(navigator);
    }
    //functional method
    public FormAccountPage typeEmailAndClickSubmit(){
        typeEmail();
        clickSubmitCreate();
        return new FormAccountPage(navigator);
    }

    //Methods to login
    public CreateAndLoginAccountPage typeEmailLogin(String emailLogin){
        navigator.findElement(By.id("email")).sendKeys(emailLogin);
        return this;
    }
    public CreateAndLoginAccountPage typePasswordLogin(String passwordLogin){
        navigator.findElement(By.id("passwd")).sendKeys(passwordLogin);
        return this;
    }

    public MyAccountPage clickLoginButton(){
        navigator.findElement(By.id("SubmitLogin")).click();
        return new MyAccountPage(navigator);
    }
    public MyAccountPage doLogin(){
        typeEmailLogin("teste@email234.com");
        typePasswordLogin("123456");
        clickLoginButton();
        return new MyAccountPage(navigator);
    }

}
