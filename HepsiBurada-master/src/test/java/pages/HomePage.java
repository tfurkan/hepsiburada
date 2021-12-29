package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

public class HomePage extends BasePage{
    public HomePage(WebDriver driver, WebDriverWait wait, SoftAssert sa) {
        super(driver, wait,sa);
        PageFactory.initElements(driver, this);
    }

    String baseURL = "https://www.hepsiburada.com/";

    @FindBy(xpath = "//span[contains(text(),'Giriş Yap')]")
    public WebElement btnGirisYap;
    @FindBy(id = "login")
    public WebElement btnSubGirisYap;
    @FindBy(xpath = "//span[contains(text(),'Kitap, Müzik, Film, Hobi')]")
    public WebElement bookMenu;
    @FindBy(xpath = "//a[contains(text(),'Kitap & Dergi')]")
    public WebElement btnBookAndMagazine;
    @FindBy(xpath = "//body/div[3]/main[1]/div[2]/div[1]/div[6]/div[2]/div[1]/div[1]/div[1]/div[2]/ul[1]/li[3]/a[1]/span[1]")
    public WebElement menuKitaplar;

    public void goToHepsiBurada(){
        driver.get(baseURL);
        softAssertText(driver.getCurrentUrl(), baseURL);
    }
    public void clickSignIn() throws InterruptedException {
        Actions actions = new Actions(driver);
        actions.moveToElement(btnGirisYap);
        actions.perform();
        click(btnSubGirisYap);
        String[] url = driver.getCurrentUrl().split("(?<=.com/)");
        softAssertText(url[0],"https://giris.hepsiburada.com/");
    }
    public void goToBookAndMagazine(){
        Actions actions = new Actions(driver);
        actions.moveToElement(bookMenu);
        actions.perform();
        click(btnBookAndMagazine);
        softAssertText(menuKitaplar.getText(),"Kitaplar");
    }
}
