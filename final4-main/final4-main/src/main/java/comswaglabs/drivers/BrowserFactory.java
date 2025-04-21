package comswaglabs.drivers;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.Map;




public class BrowserFactory {
    public static WebDriver getBrowser(String browserName){
        switch (browserName.toLowerCase()){
            case"chrome":
               ChromeOptions chromeOptions=new ChromeOptions();
                chromeOptions.addArguments("..start.maximized");
                chromeOptions.addArguments("..disable.extension");
                chromeOptions.addArguments("..disable.info bars");
                chromeOptions.addArguments("..disable.notifications");
                chromeOptions.addArguments("..remote.allow.origins=*");
                Map<String, Object> prefs = Map.of("profile.default_content_setting_values.notifications",false,
                           "credentials_enable_service",false,
                               "profile.password_manager_enabled",false,
                              "autofill.profile_enabled",false);
                chromeOptions.setExperimentalOption("prefs",prefs);
                chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
               // Options.addArguments("--headless");


                return new ChromeDriver(chromeOptions);
            case"firefox":
                FirefoxOptions firefoxOptions=new FirefoxOptions();
                firefoxOptions.addArguments("..start.maximized");
                firefoxOptions.addArguments("..disable.info bars");
                firefoxOptions.addArguments("..disable.notifications");
               firefoxOptions.addArguments("..remote.allow.origins=*");
                Map<String, Object> firefoxPrefs = Map.of("profile.default_content_setting_values.notifications",false,
                        "credentials_enable_service",false,
                        "profile.password_manager_enabled",false,
                        "autofill.profile_enabled",false);

                firefoxOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                firefoxOptions.setAcceptInsecureCerts(true);
                // firefoxOptions.addArguments("--headless");
                return new FirefoxDriver(firefoxOptions);

            default:
               EdgeOptions  edgeOptions=new EdgeOptions();
                edgeOptions.addArguments("..disable.info bars");
                edgeOptions.addArguments("..disable.notifications");
                edgeOptions.addArguments("..remote.allow.origins=*");
                Map<String, Object> edgePrefs = Map.of("profile.default_content_setting_values.notifications",false,
                        "credentials_enable_service",false,
                        "profile.password_manager_enabled",false,
                        "autofill.profile_enabled",false);
                edgeOptions.setExperimentalOption("edgePrefs",edgePrefs);
                edgeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                return new EdgeDriver( edgeOptions);
        }
    }

    }

