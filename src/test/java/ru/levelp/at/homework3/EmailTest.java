package ru.levelp.at.homework3;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.concurrent.TimeUnit;
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
    private static final String Email_BOX = "https://mail.google.com/mail/u/0/#inbox";

    private WebDriver webDriver;

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.navigate().to(Email_URL);
    }

    @Test
    public void emailSeleniumTest() {
        System.out.println("Проверка успешности авторизации");

        WebElement Login  = webDriver.findElement(By.id("identifierId"));
        Login.sendKeys("litavond78@gmail.com");

        webDriver.findElement(By.cssSelector("button.VfPpkd-LgbsSe.VfPpkd-LgbsSe-OWXEXe-k8QpJ.VfPpkd-LgbsSe-OWXEXe-dgl2Hf.nCP5yc.AjY5Oe.DuMIQc.LQeN7.qIypjc.TrZEUc.lw1w4b"))
            .click();
        Assertions.assertThat(webDriver.getTitle())
                  .isEqualTo("Вход – Google Аккаунты");

        webDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        WebElement Password  = webDriver.findElement(By.name("Passwd"));
            Password.sendKeys("Lita7878");

        webDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        WebElement Continue = webDriver.findElement(By.xpath("//*[@id=\"passwordNext\"]/div/button"));
        Continue.isEnabled();
        Continue.click();

        Assertions.assertThat(webDriver.findElement(By.cssSelector(".g3lg0e")).isEnabled());

        System.out.println("Создать новое письмо (заполнить адресата, тему письма и тело)");

        webDriver.navigate().to(Email_BOX);
        webDriver.findElement(By.xpath("//*[text()=\"Написать\"]"))
            .click();

        webDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        webDriver.findElement(By.xpath("//span[contains(text(),'Новое сообщение')]"));
        webDriver.findElement(By.xpath("//input[@aria-label='Тема']"))
            .sendKeys("Test");
        webDriver.findElement(By.xpath("//*[contains(text(),'Получатели')]"))
            .click();
       webDriver.findElement(By.xpath("//*[contains(text(),'Кому')]"))
           .isDisplayed();
        webDriver.findElement(By.xpath("//input[@aria-autocomplete=\"list\"]"))
                 .sendKeys("njanke-vensen@rambler.ru");
        webDriver.findElement(By.xpath("//div[@aria-label=\"Текст письма\"]"))
                 .sendKeys(" Test_Test_Test");

        System.out.println("Проверяем что письмо сохранено в черновиках");
        webDriver.findElement(By.xpath("//span[contains(text(),'Черновик сохранен')]"))
                 .isDisplayed();

        System.out.println("Проверяем что контент, адресата и тему письма");
        webDriver.findElement(By.xpath("//*[contains(text(),'njanke-vensen@rambler.ru')]"))
            .isDisplayed();
        webDriver.findElement(By.xpath("//*[contains(text(),'Test_Test_Test')]"))
                 .isDisplayed();
        webDriver.findElement(By.xpath("//*[contains(text(),'Test')]"))
                 .isDisplayed();

        System.out.println("Отправление письма");
        //webDriver.findElement(By.xpath("//tr//td//div//div//div[@tabindex=\"1\"]"))
        webDriver.findElement(By.xpath("/html[1]/body[1]/div[19]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[4]/table[1]/tbody[1]/tr[1]/td[2]/table[1]/tbody[1]/tr[2]/td[1]/div[1]/div[1]/div[4]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/div[2]/div[1]"))
            .click();




    }

    @AfterMethod
    public void tearDown(){
       // webDriver.quit();

    }

}
