
package apTests;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
//Selenium Imports
import java.util.logging.Level;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.BrowserType;
///
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class TestCases {
    RemoteWebDriver driver;

    public TestCases() throws MalformedURLException {
        System.out.println("Constructor: TestCases");

        final DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName(BrowserType.CHROME);
        driver = new RemoteWebDriver(new URL("http://localhost:8082/wd/hub"), capabilities);


        // Set browser to maximize and wait
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    public void endTest() {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    public void testCase01() {
         System.out.println("Start test case: testCase01");

         driver.get("https://www.amazon.in/");

         String currentUrl = driver.getCurrentUrl();

         String expectedTitle ="amazon";

         if(currentUrl.contains(expectedTitle)){

            System.out.println("Printing the title of page: " + expectedTitle);

         }
         else{

            System.out.println("Page not contains: " + expectedTitle);

         }

        System.out.println("End Test case: testCase01");
    }


    public void testCase02(){

        System.out.println("Start testcase: testCase02");
        
        WebElement searchbox = driver.findElement(By.id("twotabsearchtextbox"));

        searchbox.sendKeys("laptop");

        searchbox.submit();

        List<WebElement> productTitles = driver.findElements(By.xpath("//span[text()='Results']//ancestor::div[@data-index='1']//following-sibling::div"));

        //"//span[text()='Results']//ancestor::div[@data-index='1']//following-sibling::div"

        String searchitem="laptop";


        for(WebElement productTitle:productTitles){

            //String txttitle = productTitles.getText().toLowerCase();

            if(productTitle.getText().contains(searchitem)){
               
                //or if(productTitle.getText().equalsIgnoreCase.contains("laptop")){
                System.out.println("Printing the searchitem: " + searchitem);

                break;
            }
        }

        System.out.println("End Test case: testCase02");
     }

     



     public void testcase03(){

        System.out.println("Start testcase: testcase03");

       WebElement navgmenu = driver.findElement(By.xpath("//div[@id='nav-xshop']/a[7]"));
          
       navgmenu.click();

       String searchUrlterm = "electronics";


        String currentUrl = driver.getCurrentUrl();

        //String searchUrlterm = "electronics";

        //String currentUrl = navgmenu.getAttribute("href");


        if(currentUrl.contains(searchUrlterm)){

          System.out.println("Page url contains: " + searchUrlterm);
          

        }

        else{

            System.out.println("Page url doesnt contains: " + searchUrlterm);
        
         }

         System.out.println("End testcase: testcase03");
        
        }
    }
      






