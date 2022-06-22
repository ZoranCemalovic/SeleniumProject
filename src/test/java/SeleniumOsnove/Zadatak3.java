package SeleniumOsnove;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import static org.openqa.selenium.Keys.ENTER;

public class Zadatak3 {
    public static void main(String[] args) {
        //Zadatak 3
        //Otvoriti browser, otici na google, pretraziti "itbootcamp", otvoriti prvi link i asertovati URL
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://google.com");
        driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input")).sendKeys("itbootcamp");
        driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input")).sendKeys(ENTER);
        driver.findElement(By.xpath("/html/body/div[7]/div/div[10]/div/div[2]/div[2]/div/div/div[1]/div/div/div/div/div/div[1]/a/h3")).click();
        String dobijenURL= driver.getCurrentUrl();
        String ocekivanURL="https://itbootcamp.rs/?script=cir";
        Assert.assertEquals(dobijenURL, ocekivanURL);
    }
}
