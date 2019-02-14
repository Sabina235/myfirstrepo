package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }


    public WebDriver driver;

    @FindBy(xpath = "//img[@title='Open user profile']")
    private WebElement userIcon;

    @FindBy(xpath = "//div[@class='InstalledAppsList']")
    private WebElement appsList;

    @FindBy(xpath = "//div[@data-app-name='Operator']")
    private WebElement operatorApp;

    public void selectApp(){

        operatorApp.click();
    }


    public void openSideMenu() {
        userIcon.click();
    }

        public void logoutFromApp(){
        WebElement logoutButton = driver.findElement(By.xpath("//div[contains(@class,'bm-menu-wrap')]//div[text()='Logout']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(logoutButton).click().perform();
        }

}
