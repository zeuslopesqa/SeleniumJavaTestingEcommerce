package pages;

import org.openqa.selenium.WebDriver;

public class BasePage {
    protected WebDriver navigator;

    public BasePage(WebDriver navigator){
        this.navigator = navigator;
    }
}
