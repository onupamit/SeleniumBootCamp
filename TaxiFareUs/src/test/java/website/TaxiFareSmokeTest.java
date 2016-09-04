package website;

import base.baseApi.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;




public class TaxiFareSmokeTest extends Base{
//   public WebDriver driver = null;

/*
    @BeforeMethod
    public void beforeMethod() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       // driver.navigate().to("http://www.taxifare.us/");
        driver.manage().window().maximize();

    }
*/

    @Test
    public  void test() throws InterruptedException, IOException {


        String url = driver.getCurrentUrl();
        System.out.println(url);
//        Thread.sleep(1000);
//        driver.navigate().back();
//        Thread.sleep(1000);

        int i = 0;

        String title = driver.getTitle();


        System.out.println("The Title of The web is (Smoke_test) " + title);

        Thread.sleep(1000);
        new Select(driver.findElement(By.id("countrySelect"))).selectByVisibleText(" United States of America ");
        driver.findElement(By.id("fromAddress")).clear();
        driver.findElement(By.id("fromAddress")).sendKeys("1000, 5th ave, ny");

        new Select(driver.findElement(By.id("toDirectory"))).selectByVisibleText("Shea Stadium");
        driver.findElement(By.name("submit")).click();





        Thread.sleep(1000);

        driver.findElement(By.linkText("Mobile")).click();
        Thread.sleep(2000);
        new Select(driver.findElement(By.name("countrySelect"))).selectByVisibleText("United States of America");
        driver.findElement(By.cssSelector("option[value=\"438 8th Ave New York, NY 10001\"]")).click();
        driver.findElement(By.cssSelector("#toDirectory > option[value=\"1000 Fifth Avenue, New York, NY 10028\"]")).click();
        driver.findElement(By.name("submit")).click();
      Thread.sleep(1000);

        driver.findElement(By.id("fromAddress")).clear();
        driver.findElement(By.id("fromAddress")).sendKeys("2053 McGraw Ave, Bornx, NY");

        driver.findElement(By.id("toAddress")).clear();
        driver.findElement(By.id("toAddress")).sendKeys("JFK International Airport, Queens, NY");
        driver.findElement(By.name("submit")).click();




        driver.findElement(By.linkText("Home")).click();
        driver.findElement(By.cssSelector("img[alt=\"Home\"]")).click();

        Thread.sleep(1000);

        driver.findElement(By.linkText("Rules")).click();
        Thread.sleep(1000);

        driver.findElement(By.linkText("Home")).click();
        Thread.sleep(1000);


    }



    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }

}
