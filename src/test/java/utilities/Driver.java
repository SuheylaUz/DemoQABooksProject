package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
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
                    options.addArguments("start-maximized");
                    options.addArguments("disable-infobars");
                    options.addArguments("--disable-extensions");
                    options.addArguments("--disable-gpu");
                    options.addArguments("--disable-dev-shm-usage");
                    options.addArguments("--no-sandbox");
                    options.addArguments("--disable-in-process-stack-traces");
                    options.addArguments("--disable-logging");
                    options.addArguments("--log-level=3");
                    options.addArguments("--remote-allow-origins=*");
                    driver = new ChromeDriver(options);
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    FirefoxOptions optionsF = new FirefoxOptions();
                    optionsF.setHeadless(false);
                    optionsF.addArguments("start-maximized");
                    optionsF.addArguments("disable-infobars");
                    optionsF.addArguments("--disable-extensions");
                    optionsF.addArguments("--disable-gpu");
                    optionsF.addArguments("--disable-dev-shm-usage");
                    optionsF.addArguments("--no-sandbox");
                    optionsF.addArguments("--disable-in-process-stack-traces");
                    optionsF.addArguments("--disable-logging");
                    optionsF.addArguments("--log-level=3");
                    optionsF.addArguments("--remote-allow-origins=*");
                    driver = new FirefoxDriver(optionsF);
                    break;
                case "ie":
                    WebDriverManager.iedriver().setup();
                    driver = new InternetExplorerDriver();
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
