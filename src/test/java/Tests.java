import com.google.common.annotations.VisibleForTesting;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.HasInputDevices;
import org.openqa.selenium.interactions.Mouse;
import org.openqa.selenium.internal.Locatable;
import org.testng.Assert;
import org.testng.annotations.*;
import java.util.concurrent.TimeUnit;

/**
 * Created by evgenyshpak on 6/26/16.
 */
public class Tests {

    WebDriver driver;

    @BeforeClass
    public void loadPage() {
        driver = new FirefoxDriver();

    }

    @Test
    public void test001() throws InterruptedException {
        driver.get("http://www.google.com");
        driver.manage().window().maximize();
        WebElement searchField = driver.findElement(By.name("q"));
        searchField.sendKeys("futureadvisor.com");
        searchField.submit();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        driver.findElement(By.xpath(".//*[@id='rso']/div[1]/div/div/h3/a")).click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        String actual_title = driver.getTitle();
        String expected_title = "futureadvisor.com - Google Search";
        Assert.assertEquals(actual_title, expected_title, "FAIL: Expected " + expected_title + " Actual: " + actual_title);

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

         WebElement element = driver.findElement(By.xpath("//*[@id='header']/div/nav/ul/li[1]/a"));
         Locatable hoverItem = (Locatable) element;
         Mouse mouse = ((HasInputDevices) driver).getMouse();
         mouse.mouseMove(hoverItem.getCoordinates());
          driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

          driver.findElement(By.xpath("//div/nav/ul/li[1]/ul/li[1]/a")).click();

                   Thread.sleep(5000);

             Actions action = new Actions(driver);
                 action.sendKeys(Keys.PAGE_DOWN);
                 Thread.sleep(6000);
                 action.click(driver.findElement(By.partialLinkText("log in"))).perform();

        Thread.sleep(3000);
       				driver.findElement(By.xpath("//*[@id='user_session_user_name']")).sendKeys("nobody.@gmail.com");
         Thread.sleep(3000);
       				driver.findElement(By.xpath("//*[@id='user_session_password']")).sendKeys("12345");
         Thread.sleep(3000);
       				driver.findElement(By.xpath("//*[@id='user_session_submit']")).click();
         Thread.sleep(3000);

        String err = driver.findElement(By.xpath(".//*[@id='main-content-container']/div[1]/div[1]/div[2]/div")).getText();
        String error_expected = "Either your email or password were incorrect.";
        Assert.assertEquals(err, error_expected, "PASS");

        driver.quit();


    }


}








