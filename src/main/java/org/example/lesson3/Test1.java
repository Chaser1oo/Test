package org.example.lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class Test1 {
    public static void main( String[] args ) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        //options.addArguments("--headless");
        options.addArguments("--start-maximized");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://trial-sport.ru/");

        WebElement authorization = driver.findElement(By.xpath(".//span[@class='profile_lnk']"));
        authorization.click();

        WebElement authorizationLogin = driver.findElement(By.xpath(".//input[@name='email']"));
        authorizationLogin.sendKeys("namechasertest@gmail.com");
        WebElement authorizationPassword = driver.findElement(By.xpath(".//input[@name='password']"));
        authorizationPassword.sendKeys("Sport1994");
        WebElement authorizationEnter = driver.findElement(By.xpath(".//input[@value='войти']"));
        authorizationEnter.click();
        //new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(By.xpath(".//a/span[@title]")));

        //добавить выход

    }
}
