package comswaglabs.pages;
import comswaglabs.utility.BrowserActions;
import comswaglabs.utility.CustomsoftAssertion;
import comswaglabs.utility.ElementActions;
import comswaglabs.utility.Validation;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;


public class LoginPage {
    //locators
    private final WebDriver driver;
    private final By username = By.id("user-name");
    private final By password = By.id("password");
    private final By loginButton = By.id("login-button");
    private final By errorMessage= By.cssSelector("[data-test='error']");

    //consrtructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
public void navigateToLoginPage(){
       BrowserActions.navigateToURL(driver,"https://www.saucedemo.com/");
}

    //actions
    public LoginPage enterUsername(String username) {
        ElementActions.sendData(driver, this.username, username);
        return this;
    }

    public LoginPage enterPassword(String password) {
        ElementActions.sendData(driver, this.password, password);
        return this;
    }

    public LoginPage clickLoginButton() {
        ElementActions.clickElement (driver, loginButton);
        return this;
    }
    public  String getErrorMessage(){
      return ElementActions.getText(driver, errorMessage);
    }

public LoginPage assertLoginPageURL(){
    CustomsoftAssertion.SoftAssertion.assertEquals(BrowserActions.getCurrentURL(driver),"https://www.saucedemo.com/inventory.html","url is not expected");
    return this;
}
    public LoginPage assertSuccessFullLoginSoft(){
       assertLoginPageURL().assertLoginPageTitle();
      return this;
    }
    public LoginPage assertLoginPageTitle(){
        CustomsoftAssertion.SoftAssertion.assertEquals(BrowserActions.getPageTitle(driver),"Swag Labs","title isnot expected");
       return this;
    }
public LoginPage assertSuccessFullLogin(){
    Validation.validatePageUrl(driver,"https://www.saucedemo.com/inventory.html");
    return this;
    }



    public LoginPage assertUnSuccessFullLogin(){
      Validation.validateEqual(getErrorMessage(),"Epic Sadface :Username and password do not match any user in this service","error message is not as expected");
        return this;
    }
}
