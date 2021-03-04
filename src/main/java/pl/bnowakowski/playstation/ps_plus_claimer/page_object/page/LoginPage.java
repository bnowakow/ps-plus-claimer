package pl.bnowakowski.playstation.ps_plus_claimer.page_object.page;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

@Slf4j
public class LoginPage extends WebPage {

    public LoginPage(WebDriver driver, String pageUrl) {
        super(driver, pageUrl);
    }

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(how = How.CLASS_NAME, using = "textfield")
    private WebElement usernameInput;

    @FindBy(how = How.CLASS_NAME, using = "textfield")
    private WebElement passwordInput;

    @FindBy(how = How.CLASS_NAME, using = "primary-button")
    private WebElement nextButton;


    public void fillUsernameAndPasswordAndSubmit(String username, String password) {
        usernameInput.clear();
        usernameInput.sendKeys(username);

        nextButton.click();

        passwordInput.clear();
        passwordInput.sendKeys(password);

        nextButton.click();

        System.out.println();
    }
}
