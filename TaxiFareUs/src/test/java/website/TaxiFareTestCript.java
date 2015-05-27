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




public class TaxiFareTestCript extends Base{
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
        Thread.sleep(4000);
        driver.navigate().back();
        Thread.sleep(4000);

        int i = 0;

        String title = driver.getTitle();


        System.out.println("The Title of The web is " + title);

        Thread.sleep(3000);
        new Select(driver.findElement(By.id("countrySelect"))).selectByVisibleText("United States of America");
        driver.findElement(By.id("fromAddress")).clear();
        driver.findElement(By.id("fromAddress")).sendKeys("1000, 5th ave, ny");

        new Select(driver.findElement(By.id("toDirectory"))).selectByVisibleText("Shea Stadium");
        driver.findElement(By.name("submit")).click();

        Thread.sleep(2000);

        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        //The below method will save the screen shot in d drive with name "screenshot.png"
        FileUtils.copyFile(scrFile, new File("/Users/shamimchy/Documents/screenshot/screenshot"+i+".png"));
        i++;

        Thread.sleep(2000);

        driver.findElement(By.linkText("Mobile")).click();
        new Select(driver.findElement(By.name("countrySelect"))).selectByVisibleText("United States of America");
        driver.findElement(By.cssSelector("option[value=\"438 8th Ave New York, NY 10001\"]")).click();
        driver.findElement(By.cssSelector("#toDirectory > option[value=\"1000 Fifth Avenue, New York, NY 10028\"]")).click();
        driver.findElement(By.name("submit")).click();
        Thread.sleep(2000);
        File scrFile1 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        //The below method will save the screen shot in d drive with name "screenshot.png"
        FileUtils.copyFile(scrFile1, new File("/Users/shamimchy/Documents/screenshot/screenshot"+i+".png"));


        driver.findElement(By.id("fromAddress")).clear();
        driver.findElement(By.id("fromAddress")).sendKeys("2053 McGraw Ave, Bornx, NY");

        driver.findElement(By.id("toAddress")).clear();
        driver.findElement(By.id("toAddress")).sendKeys("JFK International Airport, Queens, NY");
        driver.findElement(By.name("submit")).click();

        Thread.sleep(4000);

        //  new Select(driver.findElement(By.id("fromDirectory"))).selectByVisibleText("Penn Station");

        //   new Select(driver.findElement(By.id("toDirectory"))).selectByVisibleText("Metropolitan Museum of Arts (MET)");

        //   driver.findElement(By.name("submit")).click();
        //    Thread.sleep(6000);

        driver.findElement(By.linkText("Home")).click();
        driver.findElement(By.cssSelector("img[alt=\"Home\"]")).click();
        driver.findElement(By.linkText("Rules")).click();
        driver.findElement(By.linkText("Home")).click();

        //  driver .findElement(By.cssSelector(".login_btn")).click();
        //  Thread.sleep(4000);
        // WebElement frame1 = driver.findElement(By.cssSelector("#fromAddress"));
        // driver.switchTo().frame(frame1);
        // WebElement frame2 = driver.findElement(By.cssSelector("#toAddress"));
        // driver.switchTo().frame(frame2);
        //  driver.findElement(By.cssSelector("input#input_username")).sendKeys("Selenium");
        // driver.findElement(By.cssSelector("input#input_password")).sendKeys("Maven", Keys.ENTER);
        // driver.findElement(By.cssSelector("#countrySelect")).getAttribute("japan");
        //  driver.findElement(By.cssSelector("#countrySelect").tagName("usa"));
	/*
	  Select dropdown = new Select(driver.findElement(By.id("countrySelect")));
	  dropdown.deselectByVisibleText("United States of America");
	  // I collect this from from the web
	  */
        // .getTagName();.sendKeys("Maven", Keys.ENTER);
        //  driver.findElement(By.cssSelector("button#button_submit")).click();
        //  driver.switchTo().defaultContent();
        Thread.sleep(4000);

    }



    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }

}
