    package pl.bnowakowski.playstation.ps_plus_claimer.page_object.page;

    import lombok.extern.slf4j.Slf4j;
    import org.openqa.selenium.By;
    import org.openqa.selenium.JavascriptExecutor;
    import org.openqa.selenium.WebDriver;
    import org.openqa.selenium.WebElement;
    import org.openqa.selenium.support.FindBy;
    import org.openqa.selenium.support.How;
    import org.openqa.selenium.support.ui.ExpectedConditions;
    import org.openqa.selenium.support.ui.WebDriverWait;

    import java.util.List;

    @Slf4j
    public class GamePage extends WebPage {

        @FindBy(how = How.CLASS_NAME, using = "psw-h1")
        private WebElement priceSpan;

        public GamePage(WebDriver driver, String pageUrl) {
            super(driver, pageUrl);
        }

        public void clickAddToCartButton() {

            // Scroll down to game title to make sure that add to cart button is visible
            JavascriptExecutor jse = (JavascriptExecutor)driver;
            jse.executeScript("arguments[0].scrollIntoView()", priceSpan);

            // TODO for some reason below doesn't wait until object is visible or clickable therfore using janky solution below
//            WebDriverWait wait = new WebDriverWait(driver, 45);
//            wait.until(ExpectedConditions.elementToBeClickable(addToCartButtons.get(1)));
//            wait.until(ExpectedConditions.visibilityOfAllElements(addToCartButtons.get(1)));
            for (int tries = 0; tries < 20; tries++) {
                log.debug("tries=" + tries);

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                List<WebElement> addToCartButtons = driver.findElements(By.xpath("//button[contains(@class, 'psw-purchase-button')]"));
                if (addToCartButtons.get(1).isDisplayed()) {
                    log.info("addToCartButton appeared");
                    addToCartButtons.get(1).click();
                    break;
                }
            }
        }
    }
