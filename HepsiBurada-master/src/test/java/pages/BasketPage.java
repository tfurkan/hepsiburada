package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

public class BasketPage extends BasePage{
    public BasketPage(WebDriver driver, WebDriverWait wait, SoftAssert sa) {
        super(driver, wait, sa);
        PageFactory.initElements(driver, this);
    }
    @FindBy(id = "continue_step_btn")
    public WebElement btnDevamEt;
    @FindBy(xpath = "//h3[contains(text(),'Anında Havale')]")
    public WebElement btnAnindaHavale;
    public static final String bankIndex = "div[2]";
    //Bütün bankalarda çalılabilmesi için bankIndex değeri tanımlandı. div[1]-div[5] arasında değer alabilir.
    @FindBy(xpath = "//*[@id=\"payment-money-transfer\"]/div/"+bankIndex+"/div[1]/div[2]/div/div[2]/p[1]")
    public WebElement checkBoxBank;
    @FindBy(xpath = "//*[@id=\"app\"]/div/div/div[1]/div/div[1]/section[3]/div/div/div/div[2]/ul/li/div[1]/span[2]")
    public WebElement selectedBank;
    @FindBy (xpath = "//p[contains(text(),'Anında Havale yöntemi ile ödemek için banka seçin.')]")
    public WebElement txtInfoAnindaHavale;


    public void clickAlisverisiTamamla(){
        click(btnDevamEt);
        softAssertText(driver.getCurrentUrl(), "https://checkout.hepsiburada.com/teslimat");
    }
    public void clickDevamEt(){
        click(btnDevamEt);
        softAssertText(driver.getCurrentUrl(), "https://checkout.hepsiburada.com/odeme");
    }
    public void clickDevamEtGoToSiparisOzeti(){
        click(btnDevamEt);
        softAssertText(driver.getCurrentUrl(), "https://checkout.hepsiburada.com/siparis-ozeti");
    }
    public void clickAnindaHavale() throws InterruptedException {
        Thread.sleep(3000);
        click(btnAnindaHavale);
        softAssertText(txtInfoAnindaHavale.getText(),"Anında Havale yöntemi ile ödemek için banka seçin.");
    }
    public String clickAndReadBank(){
        click(checkBoxBank);
       return readText(checkBoxBank);
    }
    public void assertBankName(String str){
        assertText(selectedBank, str);
    }
}
