package comswaglabs.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementActions {
    private ElementActions(){

    }

    //send keys
    public static void sendData(WebDriver driver, By locator,String data){
        Waits.waitForElementVisible(driver, locator);
        Scrolling.scrollToElement(driver, locator);
       findElement(driver, locator).sendKeys(data);
       LogsUtil.info("Data entered",data,"in the field",locator.toString());
    }
    public static void clickElement(WebDriver driver, By locator){
        Waits.waitForElementClickable(driver, locator);
        Scrolling.scrollToElement(driver, locator);
      findElement(driver, locator).click();
        LogsUtil.info("clicked on the element",locator.toString());
    }

    public static String getText(WebDriver driver,By locator ){
        Waits.waitForElementVisible(driver, locator);
        Scrolling.scrollToElement(driver, locator);
        return findElement(driver, locator).getText();
    }
    //findElement
    public static WebElement findElement(WebDriver driver,By locator ){
        return driver.findElement(locator);
    }

}



