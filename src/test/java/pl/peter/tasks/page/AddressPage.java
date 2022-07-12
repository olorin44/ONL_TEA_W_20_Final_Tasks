package pl.peter.tasks.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddressPage {
    private WebDriver driver;

    public AddressPage (WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "a[data-link-action='add-address']")
    WebElement AddAddressBtn;

    public void setAddAddressBtn(){AddAddressBtn.click();}
}
