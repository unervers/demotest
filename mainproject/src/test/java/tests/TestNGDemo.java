package tests;

import ddt.LogPassXLSProvider;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import poms.LoginPageFactory;


public class TestNGDemo {
    private static WebDriver driver;
    private static String ADDRESS = "https://travel.agileway.net/";
    private static String SHEET = "logpass";
    private static LoginPageFactory loginPage;
    
    public TestNGDemo() {
    }

    
    
    @Test (dataProvider = "testdata")
    public void loginAndPass(String login, String pass) {  
        loginPage.sendLogin(login);
        loginPage.sendPassword(pass);
        loginPage.clickSignIn();
        Assert.assertTrue(driver.getPageSource().contains("Signed in"));
    }
    


    @BeforeClass
    public static void setUpClass() throws Exception {
        System.setProperty("webdriver.chrome.driver", ".//chromedriver.exe");
        driver = new ChromeDriver();
        loginPage = new LoginPageFactory(driver);
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
        driver.navigate().to(ADDRESS);
        PageFactory.initElements(driver,loginPage );
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
        driver.findElement(By.xpath("//a[contains(text(),'Sign off')]")).click();
    }
    
    
    @DataProvider(name = "testdata")
    public Object[][] testData() throws IOException {

        LogPassXLSProvider provider = new LogPassXLSProvider("data.xlsx");
        int rows = provider.getRowCount(SHEET);
        Object[][] data = new Object[rows][2];
        for (int i = 0; i < rows; i++) {
            data[i][0] = provider.getCellData(SHEET, i, 0);
            data[i][1] = provider.getCellData(SHEET, i, 1);
        }
        return data;
    }
}
