package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class DemoQAPage {

    public DemoQAPage (){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (xpath = "//button[@id='login']")
    public WebElement loginButonu;

    @FindBy (xpath = "//input[@id='userName']")
    public WebElement userNameTextbox;

    @FindBy (xpath = "//input[@id='password']")
    public WebElement passwordTextbox;

    @FindBy (xpath = "(//label[@class='form-label'])[2]")
    public WebElement userNameValue;

    @FindBy (xpath = "//button[text()='Log out']")
    public  WebElement logOutButonu;

    @FindBy (xpath = "//*[@id='searchBox']")
    public  WebElement searchBox;

    @FindBy (xpath = "(//span[@class='mr-2'])[1]")
    public  WebElement listelenenUrun;

    @FindBy (xpath = "//button[text()='Add To Your Collection']")
    public  WebElement addToYourCollectionButonu;

    @FindBy (xpath = "(//*[text()='Profile'])[1]")
    public  WebElement profile;

    @FindBy (id = "delete-record-undefined")
    public WebElement deleteButonu;

    @FindBy (id = "closeSmallModal-ok")
    public WebElement deleteOkButonu;

    @FindBy (xpath = "//select[@aria-label='rows per page']")
    public WebElement changeRowButonu;

    @FindBy (xpath = "//select[@aria-label='rows per page']/option")
    public List<WebElement> rowsList;

    @FindBy (xpath = "//*[@id='name']")
    public WebElement hataMesaji;














}
