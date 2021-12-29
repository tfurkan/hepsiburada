package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.util.Set;

public class ProductsPage extends BasePage{
    public ProductsPage(WebDriver driver, WebDriverWait wait, SoftAssert sa) {
        super(driver, wait, sa);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "addToCart")
    public WebElement btnAddToBasket;
    @FindBy(id = "shoppingCart")
    public WebElement btnSepetim;
    @FindBy(xpath = "//body/div[5]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/h1[1]/a[1]")
    public WebElement btnX;

    public void clickAddToBasket() throws InterruptedException {
        Set<String> handles = driver.getWindowHandles();
        String currentHandle = driver.getWindowHandle();
        for (String handle : handles) {

            if (!handle .equals(currentHandle))
            {
                driver.switchTo().window(handle);
            }
        }
        //Ürüne tıklandığında yeni sekme açıldığından dolayı açılan sekme handle edildi.
        softAssertText(btnAddToBasket.getText(),"Sepete Ekle");
        click(btnAddToBasket);
        Thread.sleep(4000);
    }
    public void clickToGoBasket() {
        click(btnSepetim);
        softAssertText(driver.getCurrentUrl(), "https://checkout.hepsiburada.com/sepetim");
    }
    public void clickBtnX() throws InterruptedException {
        Thread.sleep(3000);
        click(btnX);
    }
}
