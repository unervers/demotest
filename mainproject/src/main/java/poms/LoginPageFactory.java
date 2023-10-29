
package poms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;


public class LoginPageFactory {
    private WebDriver driver;
    
    @FindBy(id = "username")
    @CacheLookup
    WebElement login;
    
    @FindBy(id = "password")
    @CacheLookup
    WebElement pass;
    
    @FindBy(xpath = "//body/div[@id='container']/form[1]/div[1]/div[1]/p[4]/input[1]")
    @CacheLookup
    WebElement button;
    
    public LoginPageFactory(WebDriver driver) {
        this.driver = driver;
    }
    
    public void sendLogin(String login) {
        this.login.sendKeys(login);
    }
    
    public void sendPassword(String password) {
        pass.sendKeys(password);
    }
    
    public void clickSignIn() {
        button.click();
    }
    
          
}
