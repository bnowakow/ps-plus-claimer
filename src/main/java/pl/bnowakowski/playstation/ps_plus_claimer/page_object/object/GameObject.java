package pl.bnowakowski.playstation.ps_plus_claimer.page_object.object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.bnowakowski.playstation.ps_plus_claimer.page_object.page.GamePage;

@RestController
public class GameObject extends PageObjectObject {

    private GamePage gamePage;

    public GameObject() {
        super();
        initialize();
    }

    public GameObject(WebDriver driver) {
        super(driver);
        initialize();
    }

    private void initialize() {
//        gamePage = new GamePage(driver, "https://store.playstation.com/pl-pl/product/EP2333-PPSA01832_00-MAQUETTESIEE0000");
//        gamePage = new GamePage(driver, "https://my.playstation.com/profile/supach_/friends");
//        gamePage = new GamePage(driver, "https://www.playstation.com/pl-pl/playstation-network/");
//        gamePage = new GamePage(driver, "https://pl-gmsg.np.community.playstation.net/groupMessaging/v1/users/supach_/systemMessages/messages?fields=%40default%2CmessageUid%2CseenFlag%2CopenFlag%2ClastCheckDate%2CurlLink%2CextendBody%2CcontentKeys&toPlatform=PS4&cacheBust=1616182098360&npLanguage=pl");
//        gamePage = new GamePage(driver, "https://web.np.playstation.com/api/graphql/v1/op?operationName=oracleUserProfileRetrieve&variables=%7B%7D&extensions=%7B%22persistedQuery%22%3A%7B%22version%22%3A1%2C%22sha256Hash%22%3A%22ecebc783d1128d899231b2610d31ade32f43ddc7a86de36b219d516c9e0c21fb%22%7D%7D");
        gamePage = new GamePage(driver, "https://store.playstation.com/");
//        gamePage = new GamePage(driver, "https://my.account.sony.com/central/signin/?client_id=e4a62faf-4b87-4fea-8565-caaabb3ac918&scope=web%3Acore&access_type=offline&state=3f07ef0430a7a1b40ac38e0fba4e9cedd8128c66f2471f86f06dd77b716e987b&service_entity=urn%3Aservice-entity%3Apsn&ui=pr&smcid=web%3Astore&redirect_uri=https%3A%2F%2Fweb.np.playstation.com%2Fapi%2Fsession%2Fv1%2Fsession%3Fredirect_uri%3Dhttps%253A%252F%252Fstore.playstation.com%252Fpl-pl%252Flatest%26x-psn-app-ver%3D%2540sie-ppr-web-session%252Fsession%252Fv5.5.0&auth_ver=v3&error=login_required&error_code=4165&no_captcha=true/signin/ca?entry=ca#/signin/ca?entry=ca");
    }

    @RequestMapping(value = "/login")
    public String login() {
//        gamePage = new GamePage(driver, "https://store.playstation.com/");
//        WebDriverWait wait = new WebDriverWait(driver, 10);

        this.setupCookie();
        this.driver.get("https://store.playstation.com/pl-pl/product/EP2333-PPSA01832_00-MAQUETTESIEE0000");
//        this.driver.get("https://my.account.sony.com/central/signin/?client_id=e4a62faf-4b87-4fea-8565-caaabb3ac918&scope=web%3Acore&access_type=offline&state=3f07ef0430a7a1b40ac38e0fba4e9cedd8128c66f2471f86f06dd77b716e987b&service_entity=urn%3Aservice-entity%3Apsn&ui=pr&smcid=web%3Astore&redirect_uri=https%3A%2F%2Fweb.np.playstation.com%2Fapi%2Fsession%2Fv1%2Fsession%3Fredirect_uri%3Dhttps%253A%252F%252Fstore.playstation.com%252Fpl-pl%252Flatest%26x-psn-app-ver%3D%2540sie-ppr-web-session%252Fsession%252Fv5.5.0&auth_ver=v3&error=login_required&error_code=4165&no_captcha=true/signin/ca?entry=ca#/signin/ca?entry=ca");
        return "foobar";
    }

    @RequestMapping(value = "/addToCart")
    public String addToCart() {

        gamePage.clickAddToCartButton();
        return "foo";
    }
}
