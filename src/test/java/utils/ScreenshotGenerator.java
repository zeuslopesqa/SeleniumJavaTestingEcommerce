package utils;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;

public class ScreenshotGenerator {
    //Class to take photos
    public static void takePhotos(WebDriver navigator, String archive){
        //Here I need to input the navigator in a function TakesScreenshot and capturing the status with the method .getScreenshotAs(OutputType.FILE)
        File screenshot = ((TakesScreenshot)navigator).getScreenshotAs(OutputType.FILE);
        try{
            //this function needs to insert try catch
            FileUtils.copyFile(screenshot, new File(archive));
        }catch(Exception e){
            System.out.println("The screenshot couldn't take because:" + e);
        }

    }
}
