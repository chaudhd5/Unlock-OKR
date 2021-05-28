package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import dataProvider.ConfigFileReader;
import pageObjects.HomePage;

public class DriverManager {

    public static WebDriver driver=null;
    static ConfigFileReader configsFileReader;
    
    public static WebDriver startdriver(){


       // if(browser.equalsIgnoreCase("Chrome")){

    	  configsFileReader = new ConfigFileReader();
		 System.setProperty("webdriver.chrome.driver", configsFileReader.getDriverPath());
		  driver = new ChromeDriver();

		/*
		 * }else if(browser.equals("Firefox")){
		 * 
		 * driver=new FirefoxDriver();
		 * 
		 * }
		 */
        return driver;

        }

}
