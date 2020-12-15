import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;

public class singUp {

    WebDriver driver =  new ChromeDriver();
    WebDriver driver2 =  new ChromeDriver();

    public void doAtumation()
    {
        driver.get("https://www.linkedin.com/");

//      Check for Sing Up
        WebElement createAccountStatus = driver.findElement(By.xpath("/html/body/nav/a[2]"));
        if (createAccountStatus.isDisplayed())
        {
            driver.findElement(By.xpath("/html/body/nav/a[2]")).click();
        }else {
            System.out.println("Create New Account Button Not Found");
        }

//      Get the Temp email address
        driver2.get("https://temp-mail.org/en/");
        WebDriverWait waitForTempMail = new WebDriverWait(driver2,10);
        waitForTempMail.until(ExpectedConditions.elementToBeClickable(By.id("click-to-copy")));

//      take the email as String
        String getMail = driver2.findElement(By.id("mail")).getAttribute("value");

        WebDriverWait waitForPageLoad = new WebDriverWait(driver,10);
        driver2.quit();
        waitForPageLoad.until(ExpectedConditions.visibilityOfElementLocated(By.id("email-address")));
        driver.findElement(By.id("email-address")).sendKeys(getMail);
        driver.findElement(By.id("password")).sendKeys("pa88w0rdg1v3n");


//      Click pn Agree and Join
        driver.findElement(By.id("join-form-submit")).click();

//      3rd page of Name , first wait to page Load
        waitForPageLoad.until(ExpectedConditions.visibilityOfElementLocated(By.id("join-form-submit")));

//      filling out First and last name
        driver.findElement(By.id("first-name")).sendKeys("Naam");
        driver.findElement(By.id("last-name")).sendKeys("Janina");

//      Click on Continue
        driver.findElement(By.id("join-form-submit")).click();

        WebDriverWait waitForVerifications = new WebDriverWait(driver,50);
        waitForVerifications.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("iframe")));

//        WebElement iframeSU = driver.findElement(By.xpath("/html/body/div/main/section/iframe"));

        int size = driver.findElements(By.tagName("iframe")).size();

        System.out.println("iframe size is : "+ size);
        driver.switchTo().frame(0);

        System.out.println(driver.getPageSource());

        driver.findElement(By.name("phoneNumber")).sendKeys("1777889966");
        driver.findElement(By.id("register-phone-submit-button")).click();


    }




}
