package bdd.tbrito.bases;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Hook {
    //contiene las configuraciones basicas de los Test a ejecutar

    //atributos
    protected static WebDriver driver;

    @Before(order =0)
    public static void initialiseBrowser() {
        WebDriverManager.chromedriver().setup();
    }

    @Before(order = 1)
    public void setupBrowser() {
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @After
    public void cleanup() {
        if (driver != null) driver.close();
    }

    public static WebDriver getDriver(){
        return driver;
    }
}
