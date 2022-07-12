package pl.peter.tasks.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ClothesSweaterPage {
    private WebDriver driver;

    public ClothesSweaterPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[contains(text(),'Hummingbird printed sweater')]")
    private WebElement clickHPSweater;

    public void  chooseHPSweater() {clickHPSweater.click();}
}
