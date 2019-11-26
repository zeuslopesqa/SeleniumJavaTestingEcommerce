package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class FormAccountPage extends BasePage{

    public FormAccountPage(WebDriver navigator) {
        super(navigator);
    }

    public FormAccountPage fillFields(){
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

        return this;
    }

    public MyAccountPage clickSubmitForm(){
        navigator.findElement(By.id("submitAccount")).click();
        return new MyAccountPage(navigator);
        }

     public MyAccountPage fillAndSubmitForm(){
        fillFields();
        clickSubmitForm();
         return new MyAccountPage(navigator);
     }
}
