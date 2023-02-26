package prueba;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage{
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void open(){
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
    }

    public void enterCredentials(String user,String pwd){
        driver.findElement(By.id("user-name")).sendKeys(user);
        driver.findElement(By.id("password")).sendKeys(pwd);
        driver.findElement(By.id("login-button")).click();
    }

    public Boolean isLoadedTexBox(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login-button"))).isDisplayed();
    }

    public String isValueCorrect(){
        WebElement value = driver.findElement(By.xpath("//span[@class='title']"));
        return value.getText();
    }

    public String isValueIncorrect(){
        WebElement value= driver.findElement(By.xpath("//h3[@data-test='error']"));
        return value.getText();
    }

}
