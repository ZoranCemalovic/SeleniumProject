package SeleniumOsnove;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Selenium13 {
    //https://imgflip.com/memegenerator
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        WebDriverWait wdwait=new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.navigate().to("https://imgflip.com/memegenerator");
        WebElement showUploadButton= driver.findElement(By.id("mm-show-upload"));
        showUploadButton.click();
        Thread.sleep(1000);
        WebElement uploadButton= driver.findElement(By.id("mm-upload-file"));
        uploadButton.sendKeys("C:\\Users\\Zoran\\Music\\buggy.png");
        Thread.sleep(1000);
        WebElement upload=driver.findElement(By.id("mm-upload-btn"));
        upload.click();
        WebElement addText= driver.findElement(By.cssSelector(".mm-add-text.l.but.sml"));
        addText.click();
        addText.click();

        wdwait.until(ExpectedConditions.elementToBeClickable(By.className("mm-text")));
        WebElement text = driver.findElement(By.className("mm-text"));
        text.sendKeys("Code is buggy  Test is buggy");

        WebElement generateMeme = driver.findElement(By.cssSelector(".mm-generate.b.but"));
        generateMeme.click();

    }
}
