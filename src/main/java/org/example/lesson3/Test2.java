package org.example.lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.concurrent.TimeUnit;

public class Test2 {
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

        WebElement authorizationEnter = driver.findElement(By.xpath(".//input[@name='q'][@placeholder='поиск'] "));
        authorizationEnter.click();

        //должен появится локатор //a/span[@title]

        WebElement search1 = driver.findElement(By.xpath(".//input[@name='q'][@placeholder='поиск'] "));
        search1.sendKeys("Солнцезащитные очки Sinner SPEED SINGLE LENS");

        WebElement search2 = driver.findElement(By.xpath(".//*[@id='asc']//div[@class='search_submit']"));
        search2.click();

        WebElement product1 = driver.findElement(By.xpath(".//div[@id='obj2552244']//a[@title='SPEED SINGLE LENS']"));
        product1.click();

        WebElement addToCart1 = driver.findElement(By.xpath(".//div[@class='item_im_buy']//span"));
        addToCart1.click();

        WebElement addToCart2 = driver.findElement(By.xpath(".//div[@class='popup_content']/form//input[@value='в корзину']"));
        addToCart2.click();

        WebElement goToCart1 = driver.findElement(By.xpath(".//a[@class='button button__basket button__black']"));
        goToCart1.click();


    }
}
