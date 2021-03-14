package pl.bnowakowski.playstation.ps_plus_claimer.page_object.object;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.bnowakowski.playstation.ps_plus_claimer.page_object.page.LoginPage;

//@RestController
public class LoginObject extends PageObjectObject {

    protected LoginPage loginPage;

    @Value("${psn.user.name}")
    protected String userName;

    @Value("${psn.user.password}")
    protected String userPassword;

    public LoginObject() {
        super();
        loginPage = new LoginPage(driver, "https://my.account.sony.com/central/signin/?response_type=code&client_id=e4a62faf-4b87-4fea-8565-caaabb3ac918&scope=web%3Acore&access_type=offline&state=a9555ef72687ff82888272b7b7c9ba80a4d63641d42fa531a61579df88f3c81a&service_entity=urn%3Aservice-entity%3Apsn&ui=pr&smcid=web%3Astore&redirect_uri=https%3A%2F%2Fweb.np.playstation.com%2Fapi%2Fsession%2Fv1%2Fsession%3Fredirect_uri%3Dhttps%253A%252F%252Fstore.playstation.com%252Fpl-pl%252Flatest%26x-psn-app-ver%3D%2540sie-ppr-web-session%252Fsession%252Fv5.4.0&auth_ver=v3&error=login_required&error_code=4165&error_description=User+is+not+authenticated&no_captcha=true/signin/ca?entry=ca#/signin/ca?entry=ca");
        initialize();
    }

    public LoginObject(WebDriver driver) {
        super(driver);
        loginPage = new LoginPage(driver);
        initialize();
    }

    private void initialize() {

        // moved to RequestMapping to get username and password from properties
//        loginPage.fillUsernameAndPasswordAndSubmit(userName, userPassword);
    }

    @RequestMapping(value = "/login")
    public String login() {

        loginPage.fillUsernameAndPasswordAndSubmit(userName, userPassword);
        return "foo";
    }
}
