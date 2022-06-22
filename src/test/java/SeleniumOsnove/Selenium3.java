package SeleniumOsnove;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import static org.openqa.selenium.Keys.ENTER;

public class Selenium3 {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.navigate().to("https://www.google.com");
        driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input")).sendKeys("Wikipedia");
        driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input")).sendKeys(ENTER);
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div[7]/div/div[10]/div/div[2]/div[2]/div/div/div[1]/div/div/div/div/div/div[1]/a")).click();
        driver.findElement(By.xpath("/html/body/div[3]/form/fieldset/div/input")).sendKeys("Nikola Tesla");
        driver.findElement(By.xpath("/html/body/div[3]/form/fieldset/button")).click();

        Thread.sleep(2000);
        String ocekivaniNaslov = "Nikola Tesla";
        String dobijenNaslov = driver.findElement(By.xpath("/html/body/div[3]/h1")).getText();

        String ocekivaniURL = "https://en.wikipedia.org/wiki/Nikola_Tesla";
        String dobijenURL = driver.getCurrentUrl();

        Assert.assertEquals(dobijenNaslov, ocekivaniNaslov);
        Assert.assertEquals(dobijenURL, ocekivaniURL);

        WebElement slika = driver.findElement(By.xpath("/html/body/div[3]/div[3]/div[5]/div[1]/table[1]/tbody/tr[3]/td/a/img"));

        Assert.assertTrue(slika.isDisplayed());

    }
}