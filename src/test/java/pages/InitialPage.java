package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InitialPage extends BasePage{
    public InitialPage(WebDriver navigator) {
        super(navigator);
    }

    public CreateAndLoginAccountPage clickSignIn(){
        navigator.findElement(By.linkText("Sign in")).click();

        return new CreateAndLoginAccountPage(navigator);
    }
}
