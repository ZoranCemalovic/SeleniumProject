package SeleniumOsnove;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;

public class Zadatak5 {
    public static void main(String[] args) throws InterruptedException {

        //Zadatak 2
//Na sajtu https://cms.demo.katalon.com/ dodati u korpu "Patient ninja" proizvod i proveriti da li je dodat u korpu

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.navigate().to("https://cms.demo.katalon.com/");

        WebElement patientNinja = driver.findElement(By.cssSelector(".product.type-product.post-66.status-publish.last.instock.product_cat-clothing.product_cat-hoodies.has-post-thumbnail.taxable.shipping-taxable.purchasable.product-type-simple"));
        patientNinja.click();

        /*List<WebElement> patientNinja = driver.findElements(By.className("woocommerce-loop-product__title"));
        for (int i = 0 ; i < patientNinja.size(); i++) {
            if (patientNinja.get(i).getText().equals("Patient Ninja")) {
                patientNinja.get(i).click();
                break;
            }
        }*/

        //U prethodnoj petlji smo napravili listu svih elemenata (lista svih item-a na stranici)
        //Selenium je prosao kroz html, pronasao svaki element koji sadrzi dat lokator i smestio je
        //taj element u kreiranu listu web elemenata
        //Nakon toga napravili smo petlju koja ce proci kroz tu listu web elemenata
        //i dali smo komandu: Izvuci mi naziv svakog elementa i ako je taj naziv jednak "Patient Ninja" onda klikni na taj element

        WebElement addToCartButton = driver.findElement(By.name("add-to-cart"));
        addToCartButton.click();

        WebElement notification = driver.findElement(By.className("woocommerce-message"));
        Assert.assertTrue(notification.isDisplayed());

        WebElement cartButton = driver.findElement(By.cssSelector(".button.wc-forward"));
        cartButton.click();

        WebElement itemTitle = driver.findElement(By.xpath("//*[@id=\"post-8\"]/div/div/form/table/tbody/tr[1]/td[3]/a"));
        String actualTitle = itemTitle.getText();

        String expectedTitle = "Patient Ninja";

        Assert.assertEquals(actualTitle, expectedTitle);




    }
}