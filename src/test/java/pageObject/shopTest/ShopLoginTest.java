package pageObject.shopTest;

import pageObject.hook.Hook;
import pageObject.pages.HomePage;
import pageObject.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ShopLoginTest extends Hook {

    String titleTextLogin = "Log in — Shopify";
    String urlLogin = "https://accounts.shopify.com/lookup";

    @Test
    public void emailErrorLoginTest() throws InterruptedException {
        //do click on the login bottom
        pageObject.pages.HomePage HomePage = new HomePage(driver);
        LoginPage LoginPage = HomePage.clickBtnLogin();

        //Check the url and the title
        boolean findUrl = util.getUrl(urlLogin);
        Assert.assertTrue(findUrl);

        boolean findTitle = util.getTitle(titleTextLogin);
        Assert.assertTrue(findTitle);

        //write a faker email and do click on next bottom
        LoginPage.sendEmailkeys();
        Thread.sleep(2000);
        LoginPage.submitNextBtn();

        //write a faker pass and do click on next bottom
        Thread.sleep(2000);
        LoginPage.sendPassKeysBtn();
        Thread.sleep(2000);
        LoginPage.submitNextBtn();

        //Check the error is deployed
        boolean exist = LoginPage.messageErrorDisplayed();
        Assert.assertTrue(exist);
    }
}
