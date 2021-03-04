package pl.bnowakowski.playstation.ps_plus_claimer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.bnowakowski.playstation.ps_plus_claimer.page_object.object.GameObject;
import pl.bnowakowski.playstation.ps_plus_claimer.page_object.object.LoginObject;
import pl.bnowakowski.playstation.ps_plus_claimer.page_object.object.PageObjectObject;

@SpringBootApplication
public class PsPlusClaimerApplication {

    public static void main(String[] args) {
		SpringApplication.run(PsPlusClaimerApplication.class, args);

//        LoginObject loginObject = new LoginObject();
//		GameObject gameObject = new GameObject(loginObject.getDriver());
//        loginObject.getDriver().close();

//        GameObject gameObject = new GameObject();
//        LoginObject loginObject = new LoginObject(gameObject.getDriver());
//        gameObject.getDriver().close();
	}
}
