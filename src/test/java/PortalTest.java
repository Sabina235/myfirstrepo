import Pages.HomePage;
import Pages.LoginPage;
import Pages.OperatorPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class PortalTest {

    private static WebDriver driver;
    public static HomePage homePage;
    public static LoginPage loginPage;
    public static OperatorPage operatorPage;

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sabina\\IdeaProjects\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://hiro-desktop.arago.klika-tech.com/");
        loginPage = new LoginPage(driver);
    }

    @AfterClass
    public void tearDown(){
        driver.close();
    }


    @Test(description = "Open HiroDesktop to Login", priority = 0)
    public void userLogin() {

        loginPage.goToLogin();
    }

    //Login to HiroDesktop

    @Test(priority = 1)
    public void loginToWso() {

        loginPage.fillUsername("dev@arago.co");
        loginPage.fillPassword("devdev");
        loginPage.loginToApp();
    }

    //Select Hiro-Operator app
    @Test(priority = 2)
        public void selectApp() {
        homePage = new HomePage(driver);
        homePage.selectApp();
        WebElement desktopAppIframe = driver.findElement(By.xpath("//iframe[@title='Application']"));
        driver.switchTo().frame(desktopAppIframe);
        operatorPage = new OperatorPage(driver);
        Assert.assertTrue(operatorPage.isOpened());
    }

    //Test Hiro-Operator app flow
    @Test(priority = 3)
    public void selectOperator() {
        operatorPage.selectInstallationApp("HIRO_Installation");
        operatorPage.selectApps();
        operatorPage.openInspector();
        Assert.assertTrue(operatorPage.buttonsDisplayed());
    }

    @Test(description = "Log out from the app", priority = 4)
    public void logOut() {
        driver.switchTo().defaultContent();
        homePage.openSideMenu();
        homePage.logoutFromApp();
        Assert.assertTrue(loginPage.loginPageOpened());
    }

}
