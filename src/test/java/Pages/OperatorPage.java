package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OperatorPage {
    public OperatorPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

        public WebDriver driver;

        @FindBy(xpath = "//div[@class=\"Navbar\"]")
        private WebElement navbarTab;

        @FindBy(xpath = "//a[text()=\"Overview\"]")
        private WebElement overviewTab;

        @FindBy(xpath = "//a[text()=\"Architecture\"]")
        private WebElement architectureTab;

        @FindBy(xpath = "//a[text()=\"Inspector\"]")
        private WebElement inspectorTab;

        @FindBy(xpath = "//div[@class=\"InstallationPage__Cards\"]")
        private WebElement installations;

        @FindBy(className = "ChevronMenuIcon")
        private WebElement menuArrow;

        @FindBy(xpath = "//div[text()=\"HIRO-Engine-1\"]")
        private WebElement menuCheckone;

        @FindBy(xpath = "//div[text()=\"ec2-34-252-56-37.eu-west-1.compute.amazonaws.com\"]")
        private WebElement menuChecktwo;

        @FindBy(xpath = "//div[text()=\"Single Logs\"]")
        private WebElement buttonSingleLogs;

        @FindBy(xpath = "//div[text()=\"Super Logs\"]")
        private WebElement buttonSuperLogs;


//        public static void sendKeysActions (WebElement webElement, String text) {
//            Actions actions = new Actions(Driver.getDriver());
 //           actions.moveToElement(webElement);
 //           actions.click();
 //           actions.sendKeys(text);
 //           actions.build().perform();
 //       }

    public boolean isOpened(){
        return navbarTab.isDisplayed();
    }

    public void selectInstallationApp(String installationName){

        installations.findElement(By.xpath(".//div[text()='"+installationName+"']")).click();

        }

        public void selectApps(){
        WebElement checkbox = driver.findElement(By.xpath("//div[@class=\"Checkbox__Control\"]"));
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(checkbox));
        checkbox.click();
        }

        public void openInspector(){

        inspectorTab.click();
        }

        public boolean buttonsDisplayed(){
        return buttonSingleLogs.isDisplayed();
    }
}
