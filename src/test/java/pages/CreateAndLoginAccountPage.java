package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.RandomEmailGenerator;

public class CreateAccountPage extends BasePage {
    public CreateAccountPage(WebDriver navigator) {
        super(navigator);
    }
    //structural methods
    public CreateAccountPage typeEmail(){
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
}
