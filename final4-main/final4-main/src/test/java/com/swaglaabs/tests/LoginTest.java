package git ;
import comswaglabs.drivers.DriverManager;
import comswaglabs.pages.LoginPage;
import comswaglabs.utility.BrowserActions;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class LoginTest {
    private static final Logger log = LoggerFactory.getLogger(LoginTest.class);
    //variables

    private WebDriver driver ;

    //Tests
    @Test
    public void successfulLogin(){
        new LoginPage(DriverManager.getDriver()) .enterUsername("standard_user")
                .enterPassword ("secret_sauce")
                .clickLoginButton()
                .assertSuccessFullLogin();
    }
    //configrationgit
    @BeforeMethod
    public void Setup() {
        driver= DriverManager.createInstance("edge");
        new LoginPage(DriverManager.getDriver()).navigateToLoginPage();
    }
    @AfterMethod
    public void tearDown(){
        BrowserActions.classBrowser(  DriverManager.getDriver());



    }

    }
