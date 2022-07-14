package pl.peter.tasks.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SweaterDetails {
    private WebDriver driver;

    public SweaterDetails (WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy (xpath = "//option[@title='M']")
    private WebElement size;

    public void chooseSize () {
        size.click();
    }

    @FindBy(xpath = "//input[@name='qty']")
    private WebElement quantity;

    @FindBy(xpath = "//*[contains(@class,'touchspin-up')]")
    private WebElement upArrowBtn;

    public void chooseQty () {
        for (int i = 0; i <= 6; i++) {
            upArrowBtn.click();
        }
    }

    @FindBy (xpath = "//*[contains(@data-button-action,'add-to-cart')]")
    private WebElement addCartBtn;

    public void addCart () {
        addCartBtn.click();
    }

    @FindBy (xpath = "//*[contains(text(),'Proceed to checkout')]")
    private WebElement proceedToCheckout;

    public void btnProceedToCheckout (){
        proceedToCheckout.click();
    }
}
