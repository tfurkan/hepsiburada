package tests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.*;

@Listeners(tests.Listeners.class)
public class TC01_Bank extends BaseTest{

    HomePage homePage;
    LoginPage loginPage;
    BooksPage booksPage;
    ProductsPage productsPage;
    BasketPage basketPage;
    BasePage basePage;


    @Test (priority = 0)
    public void checkTrueSelectedBank() throws InterruptedException {
        homePage = new HomePage(driver, wait, sa);
        loginPage = new LoginPage(driver, wait, sa);
        booksPage = new BooksPage(driver, wait, sa);
        productsPage = new ProductsPage(driver, wait, sa);
        basketPage = new BasketPage(driver, wait, sa);
        basePage = new BasePage(driver,wait,sa);

        homePage.goToHepsiBurada();
        homePage.clickSignIn();
        loginPage.oneWayLogin("tahafurkan994@gmail.com", "tahaf123");
        homePage.goToBookAndMagazine();
        booksPage.clickSelectedBook();
        productsPage.clickAddToBasket();
        try {
            productsPage.clickBtnX();
            //Ürün sepete eklendikten sonra bazı durumlarda açılan pop-up'ı kapatmak için fonksiyon tanımlandı.
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        productsPage.clickToGoBasket();
        basketPage.clickAlisverisiTamamla();
        basketPage.clickDevamEt();
        basketPage.clickAnindaHavale();
        String bankName = basketPage.clickAndReadBank();
        basketPage.clickDevamEtGoToSiparisOzeti();
        basketPage.assertBankName(bankName);
        basePage.softAssertAll();
    }
}
