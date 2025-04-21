package comswaglabs.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Waits {
    private Waits(){

    }
    // present  visible  clickable
    public static WebElement waitForElementPresent(WebDriver driver, By locator){
        LogsUtil.info("waitForElementPresent", locator.toString());
        return new  WebDriverWait(driver, Duration.ofSeconds(10)).
                until(driver1 ->

                driver1.findElement(locator));


    }

    public static WebElement waitForElementVisible(WebDriver driver, By locator){
        LogsUtil.info("waitForElementVisible", locator.toString());
        return new  WebDriverWait(driver, Duration.ofSeconds(10)).
                until(driver1 ->
                {

                    WebElement element = waitForElementPresent( driver,  locator);
                   return element.isDisplayed() ? element :null;
    }
                );
        }

    public static WebElement waitForElementClickable(WebDriver driver, By locator){
        LogsUtil.info("waitForElementClickable", locator.toString());
        return new  WebDriverWait(driver, Duration.ofSeconds(10)).
                until(driver1 ->
                        {
                            WebElement element = waitForElementPresent( driver,  locator);
                            return element.isEnabled() ? element :null;
                        }
                );
                        }

}
