package org.example.lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Test3 {
    public static void main( String[] args ) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        //options.addArguments("--headless");
        options.addArguments("--start-maximized");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://trial-sport.ru/");

        WebElement authorization = driver.findElement(By.xpath(".//span[@class='profile_lnk']"));
        authorization.click();

        WebElement authorizationLogin = driver.findElement(By.xpath(".//input[@name='email']"));
        authorizationLogin.sendKeys("namechasertest@gmail.com");

        WebElement authorizationPassword = driver.findElement(By.xpath(".//input[@name='password']"));
        authorizationPassword.sendKeys("Sport1994");

        WebElement authorizationEnter = driver.findElement(By.xpath(".//input[@value='войти']"));
        authorizationEnter.click();

        WebElement element = (new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//a/span[@title]"))));

        WebElement transitionProfile = driver.findElement(By.xpath(".//div/a[@class='profile_lnk']/span "));
        transitionProfile.click();

        WebElement transitionBasket1 = driver.findElement(By.xpath(".//div[@class='page_tabs b40']/a[@href='#1']"));
        transitionBasket1.click();
        WebElement elementBasked1 = (new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[@class='page_content'] [@pid='1']")))); //проверка открытия вкладки1

        WebElement transitionMyOrders = driver.findElement(By.xpath(".//div[@class='page_tabs b40']/a[@href='#2']"));
        transitionMyOrders.click();
        WebElement elementOrder = (new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[@class='page_content'] [@pid='2']")))); //проверка открытия вкладки2

        WebElement transitionPersonalAccount = driver.findElement(By.xpath(".//div[@class='page_tabs b40']/a[@href='#3']"));
        transitionPersonalAccount.click();
        WebElement elementAccount = (new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[@class='page_content'] [@pid='3']")))); //проверка открытия вкладки3

        WebElement TransitionSubscriptionManagement = driver.findElement(By.xpath(".//div[@class='page_tabs b40']/a[@href='#4']"));
        TransitionSubscriptionManagement.click();
        WebElement elementManagement = (new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[@class='page_content'] [@pid='4']")))); //проверка открытия вкладки4

        WebElement goFavorites = driver.findElement(By.xpath(".//div[@class='page_tabs b40']/a[@href='#5']"));
        goFavorites.click();
        WebElement elementFavorites = (new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[@class='page_content'] [@pid='5']")))); //проверка открытия вкладки5

        driver.close();

    }
}
