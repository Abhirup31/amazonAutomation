
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Googletest {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.google.co.in/");
        driver.findElement(By.className("gLFyf")).sendKeys("Online shopping");
        driver.findElement(By.className("gLFyf")).submit();
        Thread.sleep(2000);

        List<WebElement> weblist = driver.findElements(By.cssSelector("span.VuuXrf"));

        for (int a = 0; a < weblist.size(); a++) {
            String webname = weblist.get(a).getText();
            if (webname.contains("Amazon.in")) {
                driver.findElements(By.cssSelector("span.VuuXrf")).get(a).click();
                break;
            }
        }

        driver.manage().window().maximize();
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Bike helmet for men");
        driver.findElement(By.id("nav-search-submit-button")).click();
        Thread.sleep(2000);

        List<WebElement> deliverylist = driver.findElements(By.cssSelector("span.a-size-base"));

        for (int a = 0; a < deliverylist.size(); a++) {
            String delivery = deliverylist.get(a).getText();
            if (delivery.contains("Get It in 2 Days")) { // Enter delivery time
                driver.findElements(By.cssSelector("span.a-size-base")).get(a).click();
                break;
            }
        }

        Thread.sleep(5000);

        List<WebElement> brandlist = driver.findElements(By.cssSelector("span.a-size-base"));

        for (int a = 0; a < brandlist.size(); a++) {
            String brand = brandlist.get(a).getText();
            if (brand.contains("Studds")) { // Enter brand name which you want
                driver.findElements(By.cssSelector("span.a-size-base")).get(a).click();
                break;
            }
        }

        Thread.sleep(5000);

        List<WebElement> helmetlist = driver.findElements(By.cssSelector("span.a-size-base-plus"));

        for (int a = 0; a < helmetlist.size(); a++) {
            String helmet = helmetlist.get(a).getText();
            if (helmet.contains(
                    "Thunder") && helmet.contains("Graphic")) { // Enter keywords mentioned in product name

                /* (If want to open product) */
                // driver.findElements(By.cssSelector("span.a-size-base-plus")).get(a).click();

                driver.findElements(By.xpath("//button[text()='Add to cart']")).get(a).click();
                ;
                break;
            }
        }

        Thread.sleep(5000);
        driver.findElement(By.id("nav-cart")).click();
        driver.findElement(By.name("proceedToRetailCheckout")).click();
        Thread.sleep(2000);
        driver.findElement(By.name("email")).sendKeys("abc@yopmail.com");
        driver.findElement(By.id("continue")).click();
        Thread.sleep(2000);
        driver.findElement(By.name("password")).sendKeys("....");
        driver.findElement(By.id("signInSubmit")).click();
        Thread.sleep(2000);

        /*
         * Below code will work after logging in. Amazon will detect automation and it
         * will throw captcha.
         */
        driver.findElement(By.cssSelector("input[aria-labelledby ='orderSummaryPrimaryActionBtn-announce']")).click();

    }

}
