package pl.bnowakowski.playstation.ps_plus_claimer.page_object.object;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class PageObjectObject {

    @Getter
    @Setter
    WebDriver driver;

    public PageObjectObject(WebDriver driver) {
        this.driver = driver;
    }

    public PageObjectObject() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();

//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
}
