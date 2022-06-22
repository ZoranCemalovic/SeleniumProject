package SeleniumOsnove;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class NikolaTesla {

    WebDriver driver;
    String name="Nikola Tesla";

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
    }

    @BeforeMethod
    public void pageSetUp() {
        driver.manage().window().maximize();

    }

    @Test
    public void Test1() throws InterruptedException {
        driver.navigate().to("https://www.google.com");
        WebElement searchField= driver.findElement(By.name("q"));
        searchField.sendKeys("wikipedia");
        WebElement searchButton= driver.findElement(By.className("RNmpXc"));
        Thread.sleep(1000);
        searchButton.click();
    }

    @Test
    public void Test2() {
        WebElement searchField= driver.findElement(By.id("searchInput"));
        searchField.sendKeys(name);
        WebElement searchButton= driver.findElement(By.cssSelector(".sprite.svg-search-icon"));
        searchButton.click();
    }

    @Test
    public void Test3() {
        String actualName= driver.findElement(By.id("firstHeading")).getText();
        Assert.assertEquals(actualName, name);
    }

    @Test
    public void Test4() {
        String actualName= driver.findElement(By.className("infobox-above")).getText();
        Assert.assertEquals(actualName, name);
    }

    @Test
    public void Test5() {
        String actualURL= driver.getCurrentUrl();
        Assert.assertEquals(actualURL, "https://en.wikipedia.org/wiki/Nikola_Tesla");
    }
    @AfterMethod
    public void removeCookies() {
        driver.manage().deleteAllCookies();
    }

    @AfterClass
    public void tearDown() {
        driver.close();
        driver.quit();
    }
}
