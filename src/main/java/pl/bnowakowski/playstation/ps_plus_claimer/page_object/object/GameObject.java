package pl.bnowakowski.playstation.ps_plus_claimer.page_object.object;

import org.openqa.selenium.WebDriver;
import pl.bnowakowski.playstation.ps_plus_claimer.page_object.page.GamePage;

public class GameObject extends PageObjectObject {

    public GameObject() {
        super();
        initialize();
    }

    public GameObject(WebDriver driver) {
        super(driver);
        initialize();
    }

    private void initialize() {
        GamePage gamePage = new GamePage(driver, "https://store.playstation.com/pl-pl/product/EP2333-PPSA01832_00-MAQUETTESIEE0000");
        gamePage.clickAddToCartButton();
    }
}
