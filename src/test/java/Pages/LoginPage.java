package Pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

    public class LoginPage {
        public LoginPage(WebDriver driver) {
            PageFactory.initElements(driver, this);
            this.driver = driver;
        }

        //hi! it's changed

        public WebDriver driver;

        @FindBy(xpath = "//button[text()='Login']")
        private WebElement openLoginForm;

        @FindBy(id = "username")
        private WebElement findUserName;

        @FindBy(id = "password")
        private WebElement findPassword;

        @FindBy(xpath = "//button[text()='Login']")
        private WebElement loginButton;

        public void goToLogin(){
            openLoginForm.click();
        }

        public void fillUsername(String string){
            findUserName.sendKeys(string);
    }
        public void fillPassword(String string) {

            findPassword.sendKeys(string);
        }
        public void loginToApp() {

            loginButton.click();
        }

        public boolean loginPageOpened() {
            return openLoginForm.isDisplayed();
        }
}

