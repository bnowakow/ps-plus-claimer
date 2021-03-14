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
    }

    @RequestMapping(value = "/login")
    public String login() {
        gamePage = new GamePage(driver, "https://web.np.playstation.com/api/graphql/v1/op?operationName=oracleUserProfileRetrieve&variables=%7B%7D&extensions=%7B%22persistedQuery%22%3A%7B%22version%22%3A1%2C%22sha256Hash%22%3A%22ecebc783d1128d899231b2610d31ade32f43ddc7a86de36b219d516c9e0c21fb%22%7D%7D");
        WebDriverWait wait = new WebDriverWait(driver, 10);

        this.setupCookie();
        this.driver.get("https://web.np.playstation.com/api/graphql/v1/op?operationName=oracleUserProfileRetrieve&variables=%7B%7D&extensions=%7B%22persistedQuery%22%3A%7B%22version%22%3A1%2C%22sha256Hash%22%3A%22ecebc783d1128d899231b2610d31ade32f43ddc7a86de36b219d516c9e0c21fb%22%7D%7D");
        return "foobar";
    }

    @RequestMapping(value = "/addToCart")
    public String addToCart() {

        gamePage.clickAddToCartButton();
        return "foo";
    }
}
