package SeleniumOsnove;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class Zadatak4 {
    public static void main(String[] args) {
        //Zadatak 1
        //Pokrenuti browser, otici na google, otvoriti jos 2 taba, u drugom otici na youtube,
        // u trecem otici na linkedin. Nakon toga zatvoriti sve tabove posebno.
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();

        String google="https://www.google.com";
        driver.navigate().to(google);

        JavascriptExecutor tab = (JavascriptExecutor) driver;
        tab.executeScript("window.open()");
        tab.executeScript("window.open()");

        ArrayList<String> listaTabova = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(listaTabova.get(1));
        driver.navigate().to("https://www.youtube.com");
        driver.switchTo().window(listaTabova.get(2));
        driver.navigate().to("https://www.linkedin.com");
        driver.close();
        driver.switchTo().window(listaTabova.get(1));
        driver.close();
        driver.switchTo().window(listaTabova.get(0));
        driver.close();
    }
}
