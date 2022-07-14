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

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class ShopOrderSteps {
    private WebDriver driver;

    @Given("I go to shop page")
    public void iGoToMainPage() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.get("https://mystore-testlab.coderslab.pl/index.php");
    }

    @When("I click sign in")
    public void iGoToSignIn() {
        MainPage mainPage = new MainPage(driver);
        mainPage.signIn();
    }


    @Then("I fill email {string} and password {string}")
    public void iLoginUsingEmailAndPasswd(String email, String passwd) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.logInData(email, passwd);
    }

    @When("I click on clothes category and on Hummingbird Printed Sweater")
    public void iOpenClothesAndSweater() {
        AccountPage accountPage = new AccountPage(driver);
        accountPage.clothes();

        ClothesSweaterPage clothesSweaterPage = new ClothesSweaterPage(driver);
        clothesSweaterPage.chooseHPSweater();
    }

    @And("I choose size and quantity and I add product")
    public void iChooseProductSizeAndQuantity() {
        SweaterDetails sweaterDetails = new SweaterDetails(driver);
        sweaterDetails.chooseSize();
        sweaterDetails.chooseQty();
        sweaterDetails.addCart();
        sweaterDetails.btnProceedToCheckout();
    }

    @Then("I confirm order")
    public void iCheckoutOrder() {

        OrderPage orderPage = new OrderPage(driver);
        orderPage.btnCheckout();
    }

    @When("I confirm address")
    public void iConfirmAddress() {
        String addressIsVisible = driver.findElement(By.xpath("//span[@class='address-alias h4']")).getText();
        Assert.assertEquals("ABuser", addressIsVisible);
        driver.findElement(By.xpath("//button[@name='confirm-addresses']")).click();
    }

    @And("I choose PrestaShop and Pay by check")
    public void iChoosePrestaAndPayByCheck() {
        ConfirmOrderDataPage confirmOrderDataPage = new ConfirmOrderDataPage(driver);

        confirmOrderDataPage.PrestaShop();
        confirmOrderDataPage.shippingContinueButton();

        confirmOrderDataPage.choosePaymentMethod();
        confirmOrderDataPage.agreedTermsAndServices();
        confirmOrderDataPage.orderObligationToPay();
    }

    @Then("I take screenshot")
    public void iTakeScreenshot() throws InterruptedException, AWTException, IOException {
        Thread.sleep(500);

        Robot r = new Robot();
        String path = "D:\\uzytki\\programowanie\\testowanie\\CodersLab\\tester_automatyzujacy\\projects\\screen.jpg";
        java.awt.Rectangle capture = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());

        BufferedImage Image = r.createScreenCapture(capture);

        ImageIO.write(Image, "jpg", new File(path));

        System.out.println("screenshot");
    }

}
