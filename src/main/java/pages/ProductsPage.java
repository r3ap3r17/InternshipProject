package pages;

import org.openqa.selenium.WebDriver;
import utils.BaseActions;

public class ProductsPage extends BaseActions {
    private final String URL = "https://www.saucedemo.com/inventory.html";
    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public boolean verifyProductsPage() {
        return getCurrentUrl().equals(URL);
    }
}
