package org.example;

import org.openqa.selenium.WindowType;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class InteractingWithWebBrowser extends DriverSetup{

    @Test
    public void testInteractionWithBrowser() throws InterruptedException {
        driver.get("https://www.google.com");
        String title = driver.getTitle();
        System.out.println(title);
        String url = driver.getCurrentUrl();
        System.out.println(url);
        driver.manage().window().fullscreen();
        Thread.sleep(3000);
        driver.manage().window().minimize();
        Thread.sleep(3000);
        driver.manage().window().maximize();
        Thread.sleep(3000);
        driver.navigate().to("https://www.facebook.com");
        Thread.sleep(3000);
        driver.navigate().back();
        Thread.sleep(3000);
        driver.navigate().forward();
        Thread.sleep(3000);
        driver.navigate().refresh();
        Thread.sleep(3000);

        driver.switchTo().newWindow(WindowType.TAB);
        Thread.sleep(3000);
        driver.switchTo().newWindow(WindowType.WINDOW);
        Thread.sleep(3000);

       String windowHandle = driver.getWindowHandle();
       System.out.println(windowHandle);

       List<String> windowHandles = new ArrayList<>(driver.getWindowHandles());

       for (String handle: windowHandles){
           driver.switchTo().window(handle);
           if (driver.getTitle().equals("Facebook – log in or sign up")){
               break;
           }
           System.out.println(handle);
       }


       Thread.sleep(2000);
       driver.close();

    }
}
