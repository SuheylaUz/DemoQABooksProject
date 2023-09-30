package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;

import java.util.concurrent.TimeUnit;

public class Driver {

    private Driver(){

    }
    static private WebDriver driver;

    public static WebDriver getDriver (){

        if(driver==null){

            switch (ConfigReader.getProperty("browser")){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions options = new ChromeOptions();
                    options.setHeadless(false);
                    options.addArguments("start-maximized"); // open Browser in maximized mode
                    options.addArguments("disable-infobars"); // disabling infobars
                    options.addArguments("--disable-extensions"); // disabling extensions
                    options.addArguments("--disable-gpu"); // applicable to Windows os only
                    options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
                    options.addArguments("--no-sandbox"); // Bypass OS security model
                    options.addArguments("--disable-in-process-stack-traces");
                    options.addArguments("--disable-logging");
                    options.addArguments("--log-level=3");
                    options.addArguments("--remote-allow-origins=*");
                    driver = new ChromeDriver(options);
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case "opera":
                    WebDriverManager.operadriver().setup();
                    driver = new OperaDriver();
                    break;
                case "safari":
                    WebDriverManager.getInstance(SafariDriver.class);
                    driver = new SafariDriver();
                    break;
            }
        }

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        return driver;
    }

    public static void closeDriver(){

        if (driver != null) {
            driver.close();
            driver = null;
        }
    }
}
