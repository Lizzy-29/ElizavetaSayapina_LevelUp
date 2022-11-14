package ru.levelp.at.homework4;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.concurrent.TimeUnit;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.levelp.at.homework4.technical_classes.AuthPage;
import ru.levelp.at.homework4.technical_classes.Checks;
import ru.levelp.at.homework4.technical_classes.CreateLetter;
import ru.levelp.at.homework4.technical_classes.DeleteLetter;
import ru.levelp.at.homework4.technical_classes.PackagesForLetter;

public class PageObjectEmailTest {

    private WebDriverWait WebDriver;
    private ChromeDriver webDriver;
    private org.openqa.selenium.By By;

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
    }

    @Test
    public void Task1(){

        System.out.println("Проверка успешности авторизации");
        var AuthPage = new AuthPage(webDriver);
        AuthPage.open();
        AuthPage.setFillLogin();
        AuthPage.setFillContinue();
        Assertions.assertThat(webDriver.getTitle())
                  .isEqualTo("Вход – Google Аккаунты");
        webDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        AuthPage.setFillPassword();
        webDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        AuthPage.setContinueAuthorization();
        Assertions.assertThat(webDriver.findElement(By.cssSelector(".g3lg0e")).isEnabled());

        System.out.println("Создать новое письмо (заполнить адресата, тему письма и тело)");
        var CreateLetter = new CreateLetter(webDriver);
        CreateLetter.open();
        CreateLetter.newMessage();
        CreateLetter.fillTheme();
        CreateLetter.choiceAddress();
        CreateLetter.choiceTo();
        CreateLetter.fillAddress();
        CreateLetter.textOfLetter();

        System.out.println("Проверяем что письмо сохранено в черновиках");
        CreateLetter.draft();

        System.out.println("Проверяем контент, адресата и тему письма");
        var Checks= new Checks(webDriver);
        Checks.setEmail();
        Checks.setText();
        Checks.setTheme();

        System.out.println("Отправление письма");
        CreateLetter.sendLetter();

        System.out.println("Письмо исчезло из черновиков");
        var PackagesForLetter = new PackagesForLetter(webDriver);
        PackagesForLetter.setDrafts();
        PackagesForLetter.setEmptyDrafts();

        System.out.println("Письмо появилось в папке отправленные");
        PackagesForLetter.setSentLetters();
        PackagesForLetter.setCheckSentTestLetter();

        System.out.println("Выйти из учётной записи");
        AuthPage.setLogOut();
    }

    @Test
    public void Task2(){

        System.out.println("Проверка успешности авторизации");
        var AuthPage = new AuthPage(webDriver);
        AuthPage.open();
        AuthPage.setFillLogin();
        AuthPage.setFillContinue();
        Assertions.assertThat(webDriver.getTitle())
                  .isEqualTo("Вход – Google Аккаунты");
        webDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        AuthPage.setFillPassword();
        webDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        AuthPage.setContinueAuthorization();
        Assertions.assertThat(webDriver.findElement(By.cssSelector(".g3lg0e")).isEnabled());

        System.out.println("Создать новое письмо (заполнить адресата, тему письма и тело)");
        var CreateLetter = new CreateLetter(webDriver);
        CreateLetter.open();
        CreateLetter.newMessage();
        CreateLetter.fillTheme();
        CreateLetter.choiceAddress();
        CreateLetter.choiceTo();
        CreateLetter.fillAddress();
        CreateLetter.textOfLetter();

        System.out.println("Отправление письма");
        CreateLetter.sendLetter();

        System.out.println("Письмо появилось в папке отправленные");
        var PackagesForLetter = new PackagesForLetter(webDriver);
        PackagesForLetter.setSentLetters();
        PackagesForLetter.setCheckSentTestLetter();

        System.out.println("Письмо появилось в папке Test");
        var Checks = new Checks(webDriver);
        PackagesForLetter.setTestPackage();
        Checks.setEmail();
        Checks.setText();
        Checks.setTheme();

        System.out.println("Выйти из учётной записи");
        AuthPage.setLogOut();
    }

    @Test
    public void Task3(){

        System.out.println("Проверка успешности авторизации");
        var AuthPage = new AuthPage(webDriver);
        AuthPage.open();
        AuthPage.setFillLogin();
        AuthPage.setFillContinue();
        Assertions.assertThat(webDriver.getTitle())
                  .isEqualTo("Вход – Google Аккаунты");
        webDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        AuthPage.setFillPassword();
        webDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        AuthPage.setContinueAuthorization();
        Assertions.assertThat(webDriver.findElement(By.cssSelector(".g3lg0e")).isEnabled());

        System.out.println("Создать новое письмо (заполнить адресата, тему письма и тело)");
        var CreateLetter = new CreateLetter(webDriver);
        CreateLetter.open();
        CreateLetter.newMessage();
        CreateLetter.fillTheme();
        CreateLetter.choiceAddress();
        CreateLetter.choiceTo();
        CreateLetter.fillTestAddress();
        CreateLetter.textOfLetter();

        System.out.println("Отправление письма");
        CreateLetter.sendLetter();

        System.out.println("Письмо появилось в папке Входящие");
        var PackagesForLetter = new PackagesForLetter(webDriver);
        var Checks = new Checks(webDriver);
        PackagesForLetter.setIncomingLetters();
        webDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        Checks.setText();

        System.out.println("Проверяем что контент, адресата и тему письма");
        Checks.setText();
        Checks.setEmail();
        Checks.setTheme();

        System.out.println("Удалить письмо");
        var DeleteLetter = new DeleteLetter(webDriver);
        DeleteLetter.setSelectLetters();
        DeleteLetter.setDelete();

        System.out.println("Письмо появилось в папке Корзина");
        PackagesForLetter.setToBasket();
        PackagesForLetter.setBasket();
        Checks.setText();

        System.out.println("Выйти из учётной записи");
        AuthPage.setLogOut();
    }

    @AfterMethod
    public void tearDown(){
        webDriver.quit();
    }
}
