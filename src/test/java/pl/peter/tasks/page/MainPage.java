package pl.peter.tasks.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    private WebDriver driver;

    public MainPage (WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@title='Log in to your customer account']")
    private WebElement btn;

    public void signIn(){
        btn.click();
    }

    @FindBy (xpath = "//*[contains(text(),'Clothes')]")
    private WebElement clothesfilter;

    public void  clothes() {clothesfilter.click();}
}
