package com.qa.factory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {

    public WebDriver driver;

    public static ThreadLocal<WebDriver> tlDRiver = new ThreadLocal<>();

    /**
     *This method is used to initialize the threadlocal driver on the basis of given browser
     * @param browser
     * @return
     */

    public WebDriver init_driver(String browser){

        System.out.println("browser value is: "+browser);

        if(browser.equals("chrome")){
            WebDriverManager.chromedriver().setup();
            tlDRiver.set(new ChromeDriver());
        }else if(browser.equals("Firefox")){
            WebDriverManager.firefoxdriver().setup();
        }else{
            System.out.println("Please pass the correct browser value: "+ browser);
        }

        getDriver().manage().deleteAllCookies();
        getDriver().manage().window().maximize();

        return getDriver();
    }

    /**
     * This method is used to get the driver with ThreadLocal
     * @return
     */

    public static synchronized WebDriver getDriver(){
        return tlDRiver.get();
    }
}
