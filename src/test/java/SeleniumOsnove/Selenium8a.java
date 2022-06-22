package SeleniumOsnove;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Selenium8a {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://wordpress.com/log-in?redirect_to=https%3A%2F%2Fwordpress.com%2F");

        String username="dragoljubqa";
        //Username sam sacuvao kao string jer ga takodje kasnije korisnim za assert na kraju
        WebElement emailTextbox = driver.findElement(By.xpath("/html/body/div/div/div[1]/div[1]/div/main/div/div/form/div[1]/div[1]/input"));
        emailTextbox.sendKeys(username);

        WebElement continueButton = driver.findElement(By.xpath("/html/body/div/div/div[1]/div[1]/div/main/div/div/form/div[1]/div[2]/button"));
        continueButton.click();

        Thread.sleep(2000);
        //Primetio sam da je u liniji ispod test pao jer nije mogao da nadje element pa sam dodao Thread sleep
        WebElement passwordTextbox = driver.findElement(By.xpath("/html/body/div/div/div[1]/div[1]/div/main/div/div/form/div[1]/div[1]/div/div/input"));
        passwordTextbox.sendKeys("Qwerty123");

        WebElement loginButton = driver.findElement(By.xpath("/html/body/div/div/div[1]/div[1]/div/main/div/div/form/div[1]/div[2]/button"));
        loginButton.click();

        Thread.sleep(5000);
        //U linijama ispod assertujem da li je korisniku otvoren adekvatan URL sa prosledjenim username-om
        //I moram da dodam thread sleep kako bih sacekao da se URL promeni
        String expectedURL = "https://wordpress.com/home/dragoljubqa.wordpress.com";
        //String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
        //U assertu mogu direktno da prosledim za ocekivanu vrednost da driver uhvati URL, ne moram da kreiram poseban string

        WebElement profileButton = driver.findElement(By.xpath("/html/body/div[1]/div/header/div[3]/a[1]/span/img"));
        profileButton.click();

        Thread.sleep(2000);
        WebElement logOutButton = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[1]/ul/li/div[2]/button"));
        Assert.assertTrue(logOutButton.isDisplayed());

        String actualUsername = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[1]/ul/li/div[1]/h2")).getText();
        Assert.assertEquals(actualUsername, username);

    }
}