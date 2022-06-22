package SeleniumOsnove;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.openqa.selenium.Keys.ENTER;

public class Zadatak2 {
    public static void main(String[] args) throws InterruptedException {
        //Zadatak 2
        //Otvoriti browser, otici na google, naci wikipediu i naci clanak o Nikoli Tesli
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.google.com");
        driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input")).sendKeys("wikipedia");
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[2]/div[2]/div[5]/center/input[2]")).click();
        driver.findElement(By.xpath("/html/body/div[3]/form/fieldset/div/input")).sendKeys("Nikola Tesla");
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div[3]/form/fieldset/div/div[2]/div/a[1]/div[1]/p")).click();


    }
}
