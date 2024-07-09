package pageObject.shopTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.hook.Hook;
import pageObject.pages.PricingPage;

public class ShopPriceTest extends Hook {

    String titleTextHome = "Start and grow your e-commerce business - 3-Day Free Trial - Shopify USA";
    String urlHome="https://www.shopify.com/";

    String urlPricing="https://www.shopify.com/pricing";

    @Test
    public void pricingTest(){
        //Check the url and the title
        boolean findUrl = util.getUrl(urlHome);
        Assert.assertTrue(findUrl);

        boolean findTitle = util.getTitle(titleTextHome);
        Assert.assertTrue(findTitle);

        //Do click on the price tab menu
        PricingPage PricingPage = HomePage.clickBtnPricing();

        //Check the new url
        boolean findUrlPricing = util.getUrl(urlPricing);
        Assert.assertTrue(findUrlPricing);

        //Check exist a new specific text
        boolean exist = PricingPage.findH1();
        Assert.assertTrue(exist);
    }
}
