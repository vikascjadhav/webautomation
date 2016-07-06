package com.web;




import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws InterruptedException
    {
        System.setProperty("webdriver.chrome.driver", "/home/vikas/workspace/webdriver/chromedriver");
        WebDriver driver = new ChromeDriver();        
        driver.get("https://www.google.co.in");
        WebElement element = driver.findElement(By.className("gb_pc"));
        System.out.println("*********************************"+element.getText()+"**********************************");
        element.click();
        System.out.println("Waiting for some time");
        Thread.sleep(4000);
        element.click();

        element = driver.findElement(By.id("q"));
        element.sendKeys("Sellenium");
        
        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().startsWith("Sellenium");
            }
        });

        System.out.println("Page title is: " + driver.getTitle());
        
        driver.quit();
    }
}
