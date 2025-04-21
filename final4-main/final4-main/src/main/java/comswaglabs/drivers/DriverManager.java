package comswaglabs.drivers;

import comswaglabs.utility.LogsUtil;
import org.openqa.selenium.WebDriver;

import static org.testng.AssertJUnit.fail;

public class DriverManager {
    private static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    private DriverManager() {
        super();
    }

    public static WebDriver createInstance(String browserName) {
        WebDriver driver = BrowserFactory.getBrowser(browserName);
        LogsUtil.info("Driver Created on :",browserName);
        setDriver(driver);
        return getDriver();
    }

    public static WebDriver getDriver() {
        if (DriverManager.driverThreadLocal.get() == null) {
            LogsUtil.error("Driver is null");
            fail("Driver is null");
        }
        return DriverManager.driverThreadLocal.get();
    }

    public static void setDriver(WebDriver driver) {
        driverThreadLocal.set(driver);
    }
}
