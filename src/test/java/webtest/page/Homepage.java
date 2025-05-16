package webtest.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class Homepage {
    private WebDriver driver;

    private By filterDropdown = By.className("product_sort_container");

    /*
    private By addToCart = By.id("add-to-cart-sauce-labs-backpack");
    private By cartButton = By.className("shopping_cart_link");
    private By removeButton = By.id("remove-sauce-labs-backpack");

    //*[@id="header_container"]/div[2]/div/span/select
    //*[@id="header_container"]/div[2]/div/span/select/option[3]
     */

    public Homepage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickFilter() {
        driver.findElement(filterDropdown).click();
    }

    public void filterBy(String selectPriceLow) {
        Select select = new Select(driver.findElement(filterDropdown));
        select.selectByVisibleText(selectPriceLow);
    }

    public List<Double> DisplayedPrices() {
        List<WebElement> showPrice = driver.findElements(By.className("inventory_item_price"));
        List<Double> prices = new ArrayList<>();
        for (WebElement el : showPrice) {
            prices.add(Double.parseDouble(el.getText().replace("$", "")));
        }
        return prices;
    }
}


