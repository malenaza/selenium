package sweeper.login.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {

    @FindBy(how = How.ID, using = "username")
    private WebElement usernameTextBox;

    @FindBy(how = How.ID, using = "password")
    private WebElement passwordTextBox;

    @FindBy(how = How.CLASS_NAME, using = "c-button")
    private WebElement loginButton;

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void goToPage(String url){
        driver.get(url);
        if (!driver.getTitle().equalsIgnoreCase("SWEEPR.ai")) throw new RuntimeException("Page is not correctly displayed!");
    }
    
    public SecureAreaPage login(String user, String pass){
        usernameTextBox.sendKeys(user);
        passwordTextBox.sendKeys(pass);
        loginButton.click();
        return new SecureAreaPage(this.driver);
    }
}
