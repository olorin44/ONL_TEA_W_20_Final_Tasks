package pl.peter.tasks.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {
    private WebDriver driver;

    public AccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "a[title='Addresses']")
    private WebElement addAddressBtn;

    public void createAddress() {
        addAddressBtn.click();
    }

    @FindBy(css = "#category-3>a")
    private WebElement filterCloth;

    public void clothes() {
        filterCloth.click();
    }

}
