
package poms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;


public class TicketPageFactory {
    private WebDriver driver;
    
    @FindBy(xpath = "//tbody/tr[1]/td[2]/input[2]")
    @CacheLookup
    WebElement oneway;
    
    @FindBy (name = "fromPort")
    @CacheLookup
    WebElement origin;
    
    @FindBy (name = "toPort")
    @CacheLookup
    WebElement destination;
    
    @FindBy (xpath = "//body/div[@id='container']/form[1]/input[1]")
    @CacheLookup
    WebElement submit;
    
    public TicketPageFactory(WebDriver driver) {
        this.driver = driver;
    }
    
    public void clickOneway(){
        oneway.click();
    }
    
    public void clickSubmit(){
        submit.click();
    }
    
    public void selectorigin(String port){
        Select sydney = new Select(origin);
        sydney.selectByValue(port);
    }
    
    public void selectdestination(String port){
        Select newyork = new Select(destination);
        newyork.selectByValue(port);
    }
    
}
