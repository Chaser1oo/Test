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

public class Test4 {
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

        WebElement search1 = driver.findElement(By.xpath(".//input[@name='q'][@placeholder='поиск'] "));
        search1.sendKeys("Очки маска Briko BOREALIS MAGNETIC 2 LENSES");

        WebElement search2 = driver.findElement(By.xpath(".//*[@id='asc']//div[@class='search_submit']"));
        search2.click();

        WebElement selectionProduct = driver.findElement(By.xpath(".//div[@class='objects ']/div[@id='obj2177961']/span/a[@class='title']"));
        selectionProduct.click();

        WebElement availability = driver.findElement(By.xpath(".//a[@class='link_all_city']"));
        availability.click();

        WebElement show = driver.findElement(By.xpath(".//div[@class='button button_s']/div/input[@value='показать']"));
        show.click();
        WebElement element2 = (new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[@class='vida21 s25']"))));

        driver.close();

    }
}
