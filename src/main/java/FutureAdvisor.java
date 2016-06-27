import com.google.common.annotations.VisibleForTesting;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

/**
 * Created by evgenyshpak on 6/25/16.
 */
public class FutureAdvisor {

    static WebDriver driver = new FirefoxDriver();


    public static void sendKey() {

        // Then, let's start our WebDriver and navigate to google

        driver.get("http://www.google.com");
        driver.manage().window().maximize();



    }


}