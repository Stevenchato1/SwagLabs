package testscases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import prueba.LoginPage;

public class SwagLabs {
    static WebDriver driver;

    public WebDriver getDriver(){
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }


    @BeforeMethod
    public void setUp(){
        driver = getDriver();
    }

    @Test
    public void login(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        Assert.assertTrue(loginPage.isLoadedTexBox());
        loginPage.enterCredentials("standard_user","secret_sauce");
        String value = loginPage.isValueCorrect();
        if (value.contains("PRODUCTS")) {
            Assert.assertTrue(true);
        }else{
            Assert.assertTrue(false);
        }
    }

    @Test
    public void loginPasswordIncorrect(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        Assert.assertTrue(loginPage.isLoadedTexBox());
        loginPage.enterCredentials("standard_user","secret_saucer");
        String value = loginPage.isValueIncorrect();
        if (value.equals("Epic sadface: Username and password do not match any user in this service")){
            Assert.assertTrue(true);
        }else{
            Assert.assertTrue(false);
        }
    }

    @AfterMethod
    public void close(){
        driver.quit();
        driver.close();
    }
}
