package SeleniumOsnove;
//Otici na sajt https://s1.demo.opensourcecms.com/wordpress/
//Naci comment sekciju. Ostaviti komentar. Assertovati da li je komentar prikazan na stranici.
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class DomaciKomentar {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.navigate().to("https://s1.demo.opensourcecms.com/wordpress/?p=1");

        WebElement commentSection = driver.findElement(By.id ("comment"));
        commentSection.sendKeys("1");

        WebElement ime = driver.findElement(By.id("author"));
        ime.sendKeys("Vlajko");

        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys("vlajko@hhh.com");

        WebElement postItButton = driver.findElement(By.name("submit"));
        postItButton.click();

        WebElement komentar = driver.findElement(By.xpath("/html/body/div/main/div[5]/div[3]/ol/li[2]/article/div"));
                                                                       //html/body/div/main/div[5]/div[3]/ol/li[2]/article/div
                                                                       ///html/body/div/main/div[5]/div[3]/ol/li[2]/article/div
        Assert.assertTrue(komentar.isDisplayed());

    }
}
