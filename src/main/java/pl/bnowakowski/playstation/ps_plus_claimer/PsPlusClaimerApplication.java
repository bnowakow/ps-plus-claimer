package pl.bnowakowski.playstation.ps_plus_claimer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.bnowakowski.playstation.ps_plus_claimer.page_object.object.GameObject;
import pl.bnowakowski.playstation.ps_plus_claimer.page_object.object.PageObjectObject;

@SpringBootApplication
public class PsPlusClaimerApplication {

	public static void main(String[] args) {
//		SpringApplication.run(PsPlusClaimerApplication.class, args);

		PageObjectObject gameObject = new GameObject();
		gameObject.getDriver().close();
	}

}
