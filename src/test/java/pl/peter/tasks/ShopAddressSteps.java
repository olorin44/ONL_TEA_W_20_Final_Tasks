package pl.peter.tasks;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pl.peter.tasks.page.*;

import java.time.Duration;

public class ShopAddressSteps {
    private WebDriver driver;

    @Given("I go to shop main page")
    public void iGoToMainPage() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        driver.get("https://mystore-testlab.coderslab.pl/index.php");
    }

    @When("I click to sign in")
    public void iGoToSignIn() {
        MainPage mainPage = new MainPage(driver);
        mainPage.signIn();
    }


    @Then("I enter email {string} and password {string}")
    public void iLoginUsingEmailAndPasswd(String email, String passwd) {
        SignInPage signInPage = new SignInPage(driver);
        signInPage.logInData(email, passwd);
    }

    @When("I go to my account page")
    public void iGoToMyAccountPage() {
        AccountPage accountPage = new AccountPage(driver);
        accountPage.createAddress();
    }

    @And("I click on create new address")
    public void iGoToCreateNewAddress() {
        AddressPage myAddressPage = new AddressPage(driver);
        myAddressPage.setAddAddressBtn();
    }

    @And("^I enter new address data alias (.+), address (.+), city (.+), postal_code (.+), country (.+), phone (.+)$")
    public void iEnterNewAACPCP(String alias, String address, String city, String postal, String country, String phone) {
        CreateAddress createAddress = new CreateAddress(driver);
        createAddress.enterDataAddress(alias, address, city, postal, country, phone);
    }

    @Then("^I verify created address alias (.+), address (.+), city (.+), postal_code (.+), country (.+), phone (.+)$")
    public void iVerifyCreatedAACPCP(String alias, String address, String city, String postal, String country, String phone) {

        //wpisany adres
        String actualAddress = driver.findElement(By.cssSelector(".address-body")).getText();
        String fullNuname = "A" + " " + "B";
        String expectedAddress = String.join("\n", alias, fullNuname, address, city, postal, country, phone);
        Assert.assertEquals(expectedAddress, actualAddress);
    }


    @And("I close browser")
    public void CloseBrowser() {
        driver.quit();
    }
}
