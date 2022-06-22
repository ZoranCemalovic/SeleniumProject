package SeleniumOsnove;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class Demoqa {
    public static void main(String[] args) {
        //Zadatak 2 - Ulogovati se na sajt https://demoqa.com/ preko kolacica, izlogovati se i asertovati da je korisnik izlogovan

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait wdwait=new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.navigate().to("https://demoqa.com/login");

        Cookie username=new Cookie("userName", "pera");
        driver.manage().addCookie(username);
        Cookie token=new Cookie("token", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyTmFtZSI6InBlcmEiLCJwYXNzd29yZCI6IlBldGFyMTIzISIsImlhdCI6MTY1NDE5NTcxN30.hyk2Tkim0B_5nWdy1WhdEpKz8QN_WHLuAuiPtpBbU-U");
        driver.manage().addCookie(token);
        Cookie expires=new Cookie("expires", "2022-06-09T18%3A48%3A37.478Z");
        driver.manage().addCookie(expires);
        driver.navigate().refresh();

        WebElement ulogovan= driver.findElement(By.id("userName-value"));
        String actualUlogovan= ulogovan.getText();
        Assert.assertEquals(actualUlogovan, "pera");

        driver.manage().deleteAllCookies();
        driver.navigate().refresh();

        WebElement login= driver.findElement(By.id("login"));
        Assert.assertTrue(login.isDisplayed());

        WebElement usernameField= driver.findElement(By.id("userName-wrapper"));
        Assert.assertTrue(usernameField.isDisplayed());


    }
}
