package pl.bnowakowski.playstation.ps_plus_claimer.page_object.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class WebPage {

    protected WebDriver driver;
    protected String pageUrl;

    //Constructor
    public WebPage(WebDriver driver, String pageUrl){
        this.driver = driver;
        this.pageUrl = pageUrl;
        driver.get(this.pageUrl);
        //Initialise Elements
        PageFactory.initElements(driver, this);
    }

    public WebPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
