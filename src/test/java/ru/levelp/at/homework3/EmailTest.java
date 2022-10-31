package ru.levelp.at.homework3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class EmailTest {

    private static final String Email_URL = "https://passport.yandex.ru/auth";

    private WebDriver webDriver;

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.navigate().to(Email_URL);
    }

    @Test
    public void emailSeleniumTest() {
        //Assertions.assertThat(webDriver.getTitle()).isEqualTo("Удобная Яндекс Почта с защитой от спама");
        WebElement Login  = webDriver.findElement(By.name("login"));
        Login.sendKeys("lizzy.morisson");

        webDriver.findElement(By.id("passp:sign-in"))
            .click();

        webDriver.findElement(By.cssSelector(".Textinput-Control"))
            .sendKeys("Passiflora6767");

        //WebElement Password = webDriver.findElement(By.className("Textinput-Control"));
           // Password.isEnabled();
           // Password.sendKeys("Passiflora6767");

       webDriver.findElement(By.cssSelector("[data-t='button:action:passp:sign-in']"))
                 .click();
    }

    @AfterMethod
    public void tearDown(){
       // webDriver.quit();

    }

}
