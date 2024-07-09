

package pageObject.pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    WebDriver driver;
    Faker faker = new Faker();
    String idInputFormEmail="account_email";
    String idInputFormPass="account_password";
    String Email= "markita.leuschke@hotmail.com";
    String pass= "123";
    String nextXpath="//*[@name='commit']";
    String messErrorCss="validation-error__message";

    public LoginPage(WebDriver remoteDriver){
        driver = remoteDriver;
    }

    public void sendEmailkeys() {
        WebElement input = driver.findElement(By.id(idInputFormEmail));
        input.sendKeys(Email);
    }

    public void submitNextBtn(){
        WebElement btnNext = driver.findElement(By.xpath(nextXpath));
        btnNext.click();
    }

    public void sendPassKeysBtn() {
        WebElement input = driver.findElement(By.id(idInputFormPass));
        input.sendKeys(pass);
    }

    public boolean messageErrorDisplayed(){
        WebElement message = driver.findElement(By.className(messErrorCss));
        boolean exist = message.isDisplayed();
        return exist;
    }
}
