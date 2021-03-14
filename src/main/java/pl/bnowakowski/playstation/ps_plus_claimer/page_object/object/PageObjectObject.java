package pl.bnowakowski.playstation.ps_plus_claimer.page_object.object;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.Getter;
import lombok.Setter;
import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.client.ClientUtil;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.concurrent.TimeUnit;

@RestController
public class PageObjectObject {

    @Getter
    @Setter
    WebDriver driver;

    @Value("${psn.user.token}")
    protected String userToken;

    public PageObjectObject(WebDriver driver) {
        this.driver = driver;
    }

    public PageObjectObject() {
        WebDriverManager.firefoxdriver().setup();
//        driver = new FirefoxDriver();

        // https://webelement.click/en/http_header_selenium_webdriver_basic_authorization

        FirefoxOptions ffOptions = new FirefoxOptions();
//        BrowserMobProxyServer proxy = setUpProxy();
//        ffOptions.setProxy(ClientUtil.createSeleniumProxy(proxy));
        driver = new FirefoxDriver(ffOptions);

//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void setupCookie() {
        Cookie cookie = new Cookie("pdccws_p", userToken);
        driver.manage().addCookie(cookie);
    }

    // https://webelement.click/en/http_header_selenium_webdriver_basic_authorization
    public BrowserMobProxyServer setUpProxy(){
        BrowserMobProxyServer proxy = new BrowserMobProxyServer();
//        try {
            String authHeader = "Bearer " + userToken;
            proxy.addHeader("Authorization", authHeader);
            proxy.setTrustAllServers(true);
//        } catch (UnsupportedEncodingException e) {
//            System.err.println("Couldn't add authorization header..");
//            e.printStackTrace();
//        }
        proxy.start(0);
        return proxy;
    }
}
