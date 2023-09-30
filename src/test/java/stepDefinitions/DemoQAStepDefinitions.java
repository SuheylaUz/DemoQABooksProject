package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.DemoQAPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class DemoQAStepDefinitions {


   String rows, rowsInput;

   DemoQAPage demoQAPage = new DemoQAPage();

   @Given("Kullanici demoqa.com books sayfasina gider.")
   public void kullaniciDemoqaComBooksSayfasinaGider() {
      Driver.getDriver().get(ConfigReader.getProperty("demoqa_url"));
   }


   @And("Kullanici anasayfada oldugunu dogrular.")
   public void kullaniciAnasayfadaOldugunuDogrular() {

      String sayfaUrl = Driver.getDriver().getCurrentUrl();
      Assert.assertTrue(sayfaUrl.equals(ConfigReader.getProperty("demoqa_url")));
   }

   @And("Kullanici login butonuna tiklar.")
   public void kullaniciLoginButonunaTiklar() {
      ReusableMethods.JSEScrollBy();
      demoQAPage.loginButonu.click();
   }


   @And("Kullanici user name textbox alanina tiklar.")
   public void kullaniciUserNameTextboxAlaninaTiklar() {
      demoQAPage.userNameTextbox.sendKeys(ConfigReader.getProperty("user_name"));
   }

   @And("Kullanici password textbox alanina tiklar.")
   public void kullaniciPasswordTextboxAlaninaTiklar() {
      demoQAPage.passwordTextbox.sendKeys(ConfigReader.getProperty("password"));
   }

   @And("Kullanici login oldugunu dogrular.")
   public void kullaniciLoginOldugunuDogrular() {
      ReusableMethods.waitFor(3);
      Assert.assertEquals(demoQAPage.userNameValue.getText(), ConfigReader.getProperty("user_name"));
   }

   @And("Kullanici logout butonuna tiklar.")
   public void kullaniciLogoutButonunaTiklar() {
      demoQAPage.logOutButonu.click();
   }

   @And("Kullanici login sayfada oldugunu dogrular.")
   public void kullaniciLoginSayfadaOldugunuDogrular() {

      String sayfaUrl = Driver.getDriver().getCurrentUrl();
      Assert.assertTrue(sayfaUrl.equals(ConfigReader.getProperty("demoqa_login_url")));
   }

   @Then("Kullanici sayfayi kapatir.")
   public void kullaniciSayfayiKapatir() {

      Driver.getDriver().close();
   }

   @And("Kullanici search textbox alanina <{string}> yazar.")
   public void kullaniciSearchTextboxAlaninaYazar(String arananUrun) {

      demoQAPage.searchBox.sendKeys(arananUrun);
   }

   @And("Kullanici acilan sayfada {string} icin sonuc bulundugunu dogrular.")
   public void kullaniciAcilanSayfadaIcinSonucBulundugunuDogrular(String arananUrun) {
      Assert.assertTrue(demoQAPage.listelenenUrun.getText().contains(arananUrun));
   }

   @And("Kullanici bir kitaba tiklar.")
   public void kullaniciBirKitabaTiklar() {
      ReusableMethods.waitFor(3);
      demoQAPage.listelenenUrun.click();
      ReusableMethods.waitFor(3);
   }

   @And("Kullanici add to your collection butonuna tiklar.")
   public void kullaniciAddToYourCollectionButonunaTiklar() {
      ReusableMethods.JSEScrollBy();
      demoQAPage.addToYourCollectionButonu.click();
      ReusableMethods.waitFor(3);

   }

   @And("Kullanici popup mesajini gorur onaylar.")
   public void kullaniciPopupMesajiniGorurOnaylar() throws InterruptedException {
      try{
      } catch (Exception e) {
         if(e.toString().contains("org.openqa.selenium.UnhandledAlertException"))
         {
            Alert alert = Driver.getDriver().switchTo().alert();
            alert.accept();
         }
      }
      ReusableMethods.waitFor(5);

   }

   @And("Kullanici menude bulunan profile linkine tiklar.")
   public void kullaniciMenudeBulunanProfileLinkineTiklar() {
      ReusableMethods.JSEScrollBy();
      demoQAPage.profile.click();
   }

   @And("Kullanici profile sayfasinda oldugunu dogrular.")
   public void kullaniciProfileSayfasindaOldugunuDogrular() {

      Assert.assertTrue(demoQAPage.profile.isDisplayed());
   }

   @And("Kullanici acilan sayfada delete ikonuna tiklar.")
   public void kullaniciAcilanSayfadaDeleteIkonunaTiklar() {

      demoQAPage.deleteButonu.click();
   }

   @And("Kullanici acilan popupda ok butonuna tiklar.")
   public void kullaniciAcilanPopupdaOkButonunaTiklar() {

      demoQAPage.deleteOkButonu.click();
   }


   @And("Kullanici ekledigi urunun silindigini dogrular.")
   public void kullaniciEkledigiUrununSilindiginiDogrular() {
      Assert.assertFalse(demoQAPage.listelenenUrun.isDisplayed());

   }

   @And("Kullanici sayfa numarasini degistirir.")
   public void kullaniciSayfaNumarasiniDegistirir() {
      ReusableMethods.JSEScrollBy();
      Select select = new Select(demoQAPage.changeRowButonu);
      select.selectByIndex(2);
      rows=demoQAPage.rowsList.get(2).getText();
   }

   @And("Kullanici sayfa numarasini degistirdigini dogrular.")
   public void kullaniciSayfaNumarasiniDegistirdiginiDogrular() {
      ReusableMethods.JSEScrollBy();
      Assert.assertEquals(rows,"20 rows");

   }


}
