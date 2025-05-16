package webtest.stepdef;

import org.openqa.selenium.WebDriver;
import webtest.page.LoginPage;
import webtest.base.BaseStepdef;
import webtest.page.Homepage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HomepageStepdef {

    private WebDriver driver;
    private LoginPage loginPage;
    private Homepage homepage;

    @Then("user click filter dropdown")
    public void userClickFilterDropdown() {
        homepage = new Homepage(BaseStepdef.driver);
        homepage.clickFilter();
    }

    @And("user select {string} from the filter dropdown")
    public void userSelectFromTheFilterDropdown(String filterOption) {
        homepage.filterBy(filterOption);
    }

    @Then("user see the products by low price to higher price")
    public void userSeeTheProductsByLowPriceToHigherPrice() {
        List<Double> originPrice = homepage.DisplayedPrices();
        List<Double> sortedPrice = new ArrayList<>(originPrice);
        Collections.sort(sortedPrice);
        assertEquals(sortedPrice, originPrice, "Products are not sorted by price from low to high");
    }

    @Then("user see the products are not sorted correctly")
    public void userSeeTheProductsAreNotSortedCorrectly() {
        homepage = new Homepage(BaseStepdef.driver);
        List<Double> originPrice = homepage.DisplayedPrices();
        List<Double> sortedPrice = new ArrayList<>(originPrice);
        Collections.sort(sortedPrice);

        if (originPrice.equals(sortedPrice)) {
            throw new AssertionError("Products are sorted well");
        }
    }

    @Then("first product price should be the lowest")
    public void firstProductPriceShouldBeTheLowest() {
        homepage = new Homepage(BaseStepdef.driver);
        List<Double> prices = homepage.DisplayedPrices();

        double first = prices.get(0);
        double min = Collections.min(prices);

        assertEquals(min, first, "First product is not the lowest price");

    }

    @And("last product price should be the highest")
    public void lastProductPriceShouldBeTheHighest() {
        List<Double> prices = homepage.DisplayedPrices();

        double last = prices.get(prices.size() - 1);
        double max = Collections.max(prices);

        assertEquals(max, last, "Last product is not highest price");
    }

}
