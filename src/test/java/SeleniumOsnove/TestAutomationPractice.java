package SeleniumOsnove;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class TestAutomationPractice {

    WebDriver driver;
    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("https://practicetestautomation.com/");
    }

    @BeforeMethod
    public void setUpPage() {
        driver.manage().window().maximize();
        WebElement practice= driver.findElement(By.id("menu-item-20"));
        practice.click();
        WebElement loginPage= driver.findElement(By.linkText("Test Login Page"));
        loginPage.click();

    }

    @Test (priority = 10)
    public void uspesanLogin() throws InterruptedException {
        WebElement username= driver.findElement(By.id("username"));
        WebElement password= driver.findElement(By.id("password"));
        WebElement submit= driver.findElement(By.id("submit"));
        username.sendKeys("student");
        password.sendKeys("Password123");
        submit.click();
        Thread.sleep(1000);
        WebElement logOutButton= driver.findElement(By.cssSelector(".wp-block-button__link.has-text-color.has-background.has-very-dark-gray-background-color"));
        WebElement title= driver.findElement(By.className("post-title"));
        Assert.assertTrue(logOutButton.isDisplayed());
        Assert.assertEquals(title.getText(), "Logged In Successfully");
    }

    @Test (priority = 20)
    public void dobarPasswordPogresanUsername() throws InterruptedException {
        WebElement username= driver.findElement(By.id("username"));
        WebElement password= driver.findElement(By.id("password"));
        WebElement submit= driver.findElement(By.id("submit"));
        username.sendKeys("studenti");
        password.sendKeys("Password123");
        submit.click();
        Thread.sleep(1000);
        WebElement error= driver.findElement(By.id("error"));
        Assert.assertTrue(error.isDisplayed());
        Assert.assertEquals(error.getText(), "Your username is invalid!");
    }

    @Test (priority = 30)
    public void DobarUsernamePogresanPassword() throws InterruptedException {
        WebElement username= driver.findElement(By.id("username"));
        WebElement password= driver.findElement(By.id("password"));
        WebElement submit= driver.findElement(By.id("submit"));
        username.sendKeys("student");
        password.sendKeys("Password1234");
        submit.click();
        Thread.sleep(1000);
        WebElement error= driver.findElement(By.id("error"));
        Assert.assertTrue(error.isDisplayed());
        Assert.assertEquals(error.getText(), "Your password is invalid!");
    }

    @Test (priority = 40)
    public void pogresanUsernameiPassword() throws InterruptedException {
        WebElement username= driver.findElement(By.id("username"));
        WebElement password= driver.findElement(By.id("password"));
        WebElement submit= driver.findElement(By.id("submit"));
        username.sendKeys("studenti");
        password.sendKeys("Password1234");
        submit.click();
        Thread.sleep(1000);
        WebElement error= driver.findElement(By.id("error"));
        Assert.assertTrue(error.isDisplayed());
        Assert.assertEquals(error.getText(), "Your username is invalid!");
    }

    @Test (priority = 50)
    public void prazanUsernameDobarPassword() throws InterruptedException {
        WebElement username= driver.findElement(By.id("username"));
        WebElement password= driver.findElement(By.id("password"));
        WebElement submit= driver.findElement(By.id("submit"));
        username.sendKeys("");
        password.sendKeys("Password123");
        submit.click();
        Thread.sleep(1000);
        WebElement error= driver.findElement(By.id("error"));
        Assert.assertTrue(error.isDisplayed());
        Assert.assertEquals(error.getText(), "Your username is invalid!");
    }

    @Test (priority = 60)
    public void dobarUsernamePrazanPassword() throws InterruptedException {
        WebElement username= driver.findElement(By.id("username"));
        WebElement password= driver.findElement(By.id("password"));
        WebElement submit= driver.findElement(By.id("submit"));
        username.sendKeys("student");
        password.sendKeys("");
        submit.click();
        Thread.sleep(1000);
        WebElement error= driver.findElement(By.id("error"));
        Assert.assertTrue(error.isDisplayed());
        Assert.assertEquals(error.getText(), "Your password is invalid!");
    }

    @Test (priority = 70)
    public void prazanUsernameIPassword() throws InterruptedException {
        WebElement username= driver.findElement(By.id("username"));
        WebElement password= driver.findElement(By.id("password"));
        WebElement submit= driver.findElement(By.id("submit"));
        username.sendKeys("");
        password.sendKeys("");
        submit.click();
        Thread.sleep(1000);
        WebElement error= driver.findElement(By.id("error"));
        Assert.assertTrue(error.isDisplayed());
        Assert.assertEquals(error.getText(), "Your username is invalid!");
    }


    @AfterMethod
    public void deleteCookies() {
        driver.manage().deleteAllCookies();
    }

    @AfterClass
    public void quit() {
        driver.close();
        driver.quit();
    }

}
