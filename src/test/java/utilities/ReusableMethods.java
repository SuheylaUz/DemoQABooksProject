package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class ReusableMethods {


    public static void JSEScrollBy() {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollBy(0,1250)");
        waitFor(3);

    }

    public static void waitFor(int sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static WebElement waitForVisibility(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeout);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static void handleAlert(){

        try {
            System.out.println("Opening page: {}");
            Driver.getDriver().get(ConfigReader.getProperty("demoqa_url"));
            System.out.println("Wait a bit for the page to render");
            TimeUnit.SECONDS.sleep(5);
            System.out.println("Taking Screenshot");
            File outputFile = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.FILE);
            String imageDetails = "C:\\images";
            File screenShot = new File(imageDetails).getAbsoluteFile();
            FileUtils.copyFile(outputFile, screenShot);
            System.out.println("Screenshot saved: {}" + imageDetails);
        } catch (UnhandledAlertException | InterruptedException | IOException ex) {
            try {
                Alert alert = Driver.getDriver().switchTo().alert();
                String alertText = alert.getText();
                System.out.println("ERROR: (ALERT BOX DETECTED) - ALERT MSG : " + alertText);
                alert.accept();
                File outputFile = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.FILE);
                String imageDetails = "C:\\Users";
                File screenShot = new File(imageDetails).getAbsoluteFile();
                FileUtils.copyFile(outputFile, screenShot);
                System.out.println("Screenshot saved: {}" + imageDetails);
                Driver.getDriver().close();
            } catch (NoAlertPresentException | IOException e) {
                e.printStackTrace();
            }
        }
    }


    public static void clickOKAlertAccept() throws InterruptedException {

        try{
            Alert alert = Driver.getDriver().switchTo().alert();
            alert.accept();
        } catch (Exception e) {
            try {
                if(e.toString().contains("org.openqa.selenium.UnhandledAlertException"))
                {
                    Alert alert = Driver.getDriver().switchTo().alert();
                    alert.accept();
                }
            } catch (NoAlertPresentException e1) {
                e.printStackTrace();
            }
        }
    }

    public static void acceptAlertIfAvailable(long timeout)
    {
        long waitForAlert= System.currentTimeMillis() + timeout;
        boolean boolFound = false;
        do
        {
            try
            {
                Alert alert = Driver.getDriver().switchTo().alert();
                if (alert != null)
                {
                    alert.accept();
                    boolFound = true;
                }
            }
            catch (NoAlertPresentException ex) {}
        } while ((System.currentTimeMillis() < waitForAlert) && (!boolFound));
    }

}
