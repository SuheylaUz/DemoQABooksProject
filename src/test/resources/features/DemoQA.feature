Feature: DemoQABooks

  @validCredentialLogin
  Scenario: TC01_Demo_QA_Books_Login
    Given Kullanici demoqa.com books sayfasina gider.
    And Kullanici anasayfada oldugunu dogrular.
    And Kullanici login butonuna tiklar.
    And Kullanici user name textbox alanina tiklar.
    And Kullanici password textbox alanina tiklar.
    And Kullanici login butonuna tiklar.
    And Kullanici login oldugunu dogrular.
    Then Kullanici sayfayi kapatir.

  @invalidCredentialLogin
  Scenario: TC02_Demo_QA_Books_Invalid_Login
    Given Kullanici demoqa.com books sayfasina gider.
    And Kullanici anasayfada oldugunu dogrular.
    And Kullanici login butonuna tiklar.
    And Kullanici user name textbox alanina gecersiz username girer.
    And Kullanici password textbox alanina gecersiz password girer.
    And Kullanici login butonuna tiklar.
    And Kullanici hata mesajini gorur.
    Then Kullanici sayfayi kapatir.

  @logout
  Scenario: TC03_Demo_QA_Books_Logout
    Given Kullanici demoqa.com books sayfasina gider.
    And Kullanici anasayfada oldugunu dogrular.
    And Kullanici login butonuna tiklar.
    And Kullanici user name textbox alanina tiklar.
    And Kullanici password textbox alanina tiklar.
    And Kullanici login butonuna tiklar.
    And Kullanici login oldugunu dogrular.
    And Kullanici logout butonuna tiklar.
    And Kullanici login sayfada oldugunu dogrular.
    Then Kullanici sayfayi kapatir.

  @searchBook
  Scenario: TC04_Demo_QA_Books_Search_Book
    Given Kullanici demoqa.com books sayfasina gider.
    And Kullanici anasayfada oldugunu dogrular.
    And Kullanici search textbox alanina <"Java"> yazar.
    And Kullanici acilan sayfada "Java" icin sonuc bulundugunu dogrular.
    Then Kullanici sayfayi kapatir.

  @bookAddDelete
  Scenario: TC05_Demo_QA_Books_Books_Add_Delete
    Given Kullanici demoqa.com books sayfasina gider.
    And Kullanici anasayfada oldugunu dogrular.
    And Kullanici login butonuna tiklar.
    And Kullanici user name textbox alanina tiklar.
    And Kullanici password textbox alanina tiklar.
    And Kullanici login butonuna tiklar.
    And Kullanici login oldugunu dogrular.
    And Kullanici bir kitaba tiklar.
    And Kullanici add to your collection butonuna tiklar.
    And Kullanici popup mesajini gorur onaylar.
    And Kullanici menude bulunan profile linkine tiklar.
    And Kullanici profile sayfasinda oldugunu dogrular.
    And Kullanici acilan sayfada delete ikonuna tiklar.
    And Kullanici acilan popupda ok butonuna tiklar.
    And Kullanici popup mesajini gorur onaylar.
    And Kullanici ekledigi urunun silindigini dogrular.
    Then Kullanici sayfayi kapatir.

  @changeRowNumber
  Scenario: TC06_Demo_QA_Books_Change_Row_Number
    Given Kullanici demoqa.com books sayfasina gider.
    And Kullanici anasayfada oldugunu dogrular.
    And Kullanici login butonuna tiklar.
    And Kullanici user name textbox alanina tiklar.
    And Kullanici password textbox alanina tiklar.
    And Kullanici login butonuna tiklar.
    And Kullanici login oldugunu dogrular.
    And Kullanici menude bulunan profile linkine tiklar.
    And Kullanici sayfa numarasini degistirir.
    And Kullanici sayfa numarasini degistirdigini dogrular.
    Then Kullanici sayfayi kapatir.
