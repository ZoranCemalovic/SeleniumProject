package SeleniumOsnove;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Wordpress {
    public static void main(String[] args) throws InterruptedException {
        //Zadatak 1 - Napraviti automatski test koji ce se ulogovati na wordpress i proveriti da li je korisnik ulogovan
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();

        driver.navigate().to("https://wordpress.com/log-in?redirect_to=https%3A%2F%2Fwordpress.com%2F");
        WebElement username=driver.findElement(By.xpath("/html/body/div/div/div[1]/div[1]/div/main/div/div/form/div[1]/div[1]/input"));
        username.sendKeys("zoranqa1");
        driver.findElement(By.xpath("/html/body/div/div/div[1]/div[1]/div/main/div/div/form/div[1]/div[2]/button")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div/div/div[1]/div[1]/div/main/div/div/form/div[1]/div[1]/div/div/input")).sendKeys("zoranqa23");
        driver.findElement(By.xpath("/html/body/div/div/div[1]/div[1]/div/main/div/div/form/div[1]/div[2]/button")).click();

        Thread.sleep(3000);
        String ocekivaniURL="https://wordpress.com/home/zoranqa1.wordpress.com";
        String dobijeniURL= driver.getCurrentUrl();
        Assert.assertEquals(dobijeniURL, ocekivaniURL);

        WebElement Email=driver.findElement(By.className("site-setup-list__nav-item-email"));
        String actualEmail= Email.getText();
        String ocekivaniEmail="zoran.cemalovic+1@gmail.com";
        Assert.assertEquals(actualEmail, ocekivaniEmail);



    }
}
