package SeleniumOsnove;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Comment {
    public static void main(String[] args) throws InterruptedException {
        //Zadatak za domaci
        //Otici na sajt https://s1.demo.opensourcecms.com/wordpress/
        //Naci comment sekciju. Ostaviti komentar. Assertovati da li je komentar prikazan na stranici.
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();

        String name="Petar";
        String email="petar.petrovic@gmail.com";
        String commentText= "His";

        driver.navigate().to("https://s1.demo.opensourcecms.com/wordpress/");
        /*WebElement helloWorld= driver.findElement(By.xpath("/html/body/div/main/ul/li/div/h2/a"));
        helloWorld.click();*/
        WebElement helloWorld= driver.findElement(By.linkText("Hello world!"));
        helloWorld.click();

        WebElement commentField= driver.findElement(By.id("comment"));
        commentField.sendKeys(commentText);

        WebElement nameField= driver.findElement(By.id("author"));
        nameField.sendKeys(name);

        WebElement emailField= driver.findElement(By.id("email"));
        emailField.sendKeys(email);

        WebElement postCommentButton= driver.findElement(By.id("submit"));
        postCommentButton.click();

        String actualCommentText=driver.findElement(By.cssSelector(".comment.odd.alt.thread-odd.thread-alt.depth-1")).findElement(By.className("comment-content")).getText();
        Assert.assertEquals(actualCommentText, commentText);

        String actualName=driver.findElement(By.cssSelector(".comment.odd.alt.thread-odd.thread-alt.depth-1")).findElement(By.className("fn")).getText();
        Assert.assertEquals(actualName, name);

    }
}
