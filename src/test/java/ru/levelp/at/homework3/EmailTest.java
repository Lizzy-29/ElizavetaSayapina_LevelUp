package ru.levelp.at.homework3;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class EmailTest {

    private static final String Email_URL = "https://accounts.google.com/";

    private WebDriver webDriver;

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.navigate().to(Email_URL);
    }

    @Test
    public void emailSeleniumTest() {
        //webDriver.manage().timeouts().implicitlyWait(Duration.ofDays(15000));
        WebElement Login  = webDriver.findElement(By.id("identifierId"));
        Login.sendKeys("litavond78@gmail.com");

        webDriver.findElement(By.cssSelector("button.VfPpkd-LgbsSe.VfPpkd-LgbsSe-OWXEXe-k8QpJ.VfPpkd-LgbsSe-OWXEXe-dgl2Hf.nCP5yc.AjY5Oe.DuMIQc.LQeN7.qIypjc.TrZEUc.lw1w4b"))
            .click();
        Assertions.assertThat(webDriver.getTitle())
                  .isEqualTo("Вход – Google Аккаунты");

        webDriver.manage().timeouts().implicitlyWait(Duration.ofDays(15000));

        WebElement Password  = webDriver.findElement(By.name("Passwd"));
            Password.sendKeys("Lita7878");

        webDriver.findElement(By.xpath("//button[@class='VfPpkd-LgbsSe VfPpkd-LgbsSe-OWXEXe-k8QpJ VfPpkd-LgbsSe-OWXEXe-dgl2Hf nCP5yc AjY5Oe DuMIQc LQeN7 qIypjc TrZEUc lw1w4b']"))
            .click();

        //WebElement Login  = webDriver.findElement(By.cssSelector("[type='text']"));
        //webDriver.findElement(By.cssSelector("input[name=‘username’]"));


        //Login.sendKeys("benke-yansen@mail.ru");



        //webDriver.findElement(By.cssSelector("span.inner-0-2-81.innerTextWrapper-0-2-82"));
                 //.click();

       // webDriver.findElement(By.cssSelector(".Textinput-Control"))
         //   .sendKeys("njanke6767");

        //WebElement Password = webDriver.findElement(By.className("Textinput-Control"));
           // Password.isEnabled();
           // Password.sendKeys("Passiflora6767");

       //webDriver.findElement(By.cssSelector("[data-t='button:action:passp:sign-in']"))
                 //.click();
    }

    @AfterMethod
    public void tearDown(){
       // webDriver.quit();

    }

}
