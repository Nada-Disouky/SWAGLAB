package comswaglabs.utility;

import org.openqa.selenium.WebDriver;

import java.lang.invoke.StringConcatFactory;

public class BrowserActions {
    private BrowserActions() {

    }

    public static void navigateToURL(WebDriver driver, String url) {

        driver.get(url);
        LogsUtil.info("navigated to url",url);
    }


    public static String getCurrentURL(WebDriver driver) {
        LogsUtil.info("current url", driver.getCurrentUrl());

        return driver.getCurrentUrl();

    }
public static String getPageTitle(WebDriver driver){
    LogsUtil.info("PageTitle is", driver.getTitle());
        return driver.getTitle();
}
public static void refreshPage (WebDriver driver){

    LogsUtil.info("Refresh the page");
        driver.navigate().refresh();
}
public static void classBrowser(WebDriver driver){
    LogsUtil.info("closing thr Browser");
    driver.quit();
}
}
