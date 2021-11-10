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
        Cookie cookie;

        cookie = new Cookie("isSigned", "true");
        driver.manage().addCookie(cookie);

        cookie = new Cookie("mbox", "PC#39fdc612f9a046b49b2c0bb95498d0ce.35_0#1678783792|session#58a75da4fd584433840eea6b9905dbd5#1616183432");
        driver.manage().addCookie(cookie);

        cookie = new Cookie("pdc_custage", "m");
        driver.manage().addCookie(cookie);

        cookie = new Cookie("pdccws_p", "s%3AaKbG8t1aMndeWJajNErSrWSF_cZQq6Mo.UsPWUw8M7lxRMWuHuj%2Bk37K5gGij0%2B5IgCQSLhjNUL8");
        driver.manage().addCookie(cookie);

        cookie = new Cookie("s_cc", "true");
        driver.manage().addCookie(cookie);

        cookie = new Cookie("s_ecid", "MCMID%7C17586022103806991802880536921346660212");
        driver.manage().addCookie(cookie);

        cookie = new Cookie("s_fid", "0F80D731A3A56686-306C8A536B079D1B");
        driver.manage().addCookie(cookie);

        cookie = new Cookie("s_sq", "snepsnsocial-prod%3D%2526c.%2526a.%2526activitymap.%2526page%253Dhttps%25253A%25252F%25252Fmy.playstation.com%25252F%2526link%253DOK%2526region%253Dember590%2526.activitymap%2526.a%2526.c%26snepdcglobal-prod%3D%2526c.%2526a.%2526activitymap.%2526page%253Dweb%25253Apdc%25253Aplaystation-network%2526link%253DBartek%252520Nowakowski%252520supach_%2526region%253Dsb-social-toolbar-root%2526pageIDType%253D1%2526.activitymap%2526.a%2526.c%2526pid%253Dweb%25253Apdc%25253Aplaystation-network%2526pidt%253D1%2526oid%253Dhttps%25253A%25252F%25252Fmy.playstation.com%25252F%2526ot%253DA");
        driver.manage().addCookie(cookie);

        cookie = new Cookie("uh", "4c7824d882b7cb363b04f01b30af3697df7cc28ad5cafcec5b037a7057be5052\n");
        driver.manage().addCookie(cookie);

        cookie = new Cookie("at_check", "true");
        driver.manage().addCookie(cookie);

        cookie = new Cookie("euconsent-v2", "CO9K0l8PDUbyeASABCENBSCsAP_AAG_AAB5YHnQBQAiAEFAI6AjUBeYHnQAwAiAEFAXmAAA.YAAAAAAAAAAA");
        driver.manage().addCookie(cookie);

        cookie = new Cookie("eucookiepreference", "accept");
        driver.manage().addCookie(cookie);

        cookie = new Cookie("_evidon_consent_cookie", "{\"consent_date\":\"2021-03-19T18:52:00.636Z\",\"categories\":{\"18\":true},\"vendors\":{\"18\":{}},\"cookies\":{\"18\":true},\"consent_type\":1}");
        driver.manage().addCookie(cookie);

        cookie = new Cookie("AMCV_BD260C0F53C9733E0A490D45%40AdobeOrg", "-1124106680%7CMCIDTS%7C18706%7CMCMID%7C17586022103806991802880536921346660212%7CMCAAMLH-1616784714%7C6%7CMCAAMB-1616784714%7C6G1ynYcLPuiQxYZrsz_pkqfLG9yMXBpb2zX5dvJdYQJzPXImdj0y%7CMCOPTOUT-1616187114s%7CNONE%7CMCAID%7CNONE%7CMCSYNCSOP%7C411-18713%7CvVersion%7C5.2.0");
        driver.manage().addCookie(cookie);

        cookie = new Cookie("AMCVS_BD260C0F53C9733E0A490D45%40AdobeOrg", "1");
        driver.manage().addCookie(cookie);

        cookie = new Cookie("_fbp", "fb.1.1615538978843.30361724");
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
