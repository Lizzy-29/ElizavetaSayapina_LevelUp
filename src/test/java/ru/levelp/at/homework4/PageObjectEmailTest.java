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
        var authPage = new AuthPage(webDriver);
        authPage.open();
        authPage.setFillLogin();
        authPage.setFillContinue();
        Assertions.assertThat(webDriver.getTitle())
                  .isEqualTo("Вход – Google Аккаунты");
        webDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        authPage.setFillPassword();
        webDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        authPage.setContinueAuthorization();
        Assertions.assertThat(webDriver.findElement(By.cssSelector(".g3lg0e")).isEnabled());

        System.out.println("Создать новое письмо (заполнить адресата, тему письма и тело)");
        var createLetter = new CreateLetter(webDriver);
        createLetter.open();
        createLetter.newMessage();
        createLetter.fillTheme();
        createLetter.choiceAddress();
        createLetter.choiceTo();
        createLetter.fillAddress();
        createLetter.textOfLetter();

        System.out.println("Проверяем что письмо сохранено в черновиках");
        createLetter.draft();

        System.out.println("Проверяем контент, адресата и тему письма");
        var checks= new Checks(webDriver);
        checks.setEmail();
        checks.setText();
        checks.setTheme();

        System.out.println("Отправление письма");
        createLetter.sendLetter();

        System.out.println("Письмо исчезло из черновиков");
        var packagesForLetter = new PackagesForLetter(webDriver);
        packagesForLetter.setDrafts();
        packagesForLetter.setEmptyDrafts();

        System.out.println("Письмо появилось в папке отправленные");
        packagesForLetter.setSentLetters();
        packagesForLetter.setCheckSentTestLetter();

        System.out.println("Выйти из учётной записи");
        authPage.setLogOut();
    }

    @Test
    public void Task2(){

        System.out.println("Проверка успешности авторизации");
        var authPage = new AuthPage(webDriver);
        authPage.open();
        authPage.setFillLogin();
        authPage.setFillContinue();
        Assertions.assertThat(webDriver.getTitle())
                  .isEqualTo("Вход – Google Аккаунты");
        webDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        authPage.setFillPassword();
        webDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        authPage.setContinueAuthorization();
        Assertions.assertThat(webDriver.findElement(By.cssSelector(".g3lg0e")).isEnabled());

        System.out.println("Создать новое письмо (заполнить адресата, тему письма и тело)");
        var createLetter = new CreateLetter(webDriver);
        createLetter.open();
        createLetter.newMessage();
        createLetter.fillTheme();
        createLetter.choiceAddress();
        createLetter.choiceTo();
        createLetter.fillAddress();
        createLetter.textOfLetter();

        System.out.println("Отправление письма");
        createLetter.sendLetter();

        System.out.println("Письмо появилось в папке отправленные");
        var packagesForLetter = new PackagesForLetter(webDriver);
        packagesForLetter.setSentLetters();
        packagesForLetter.setCheckSentTestLetter();

        System.out.println("Письмо появилось в папке Test");
        var checks = new Checks(webDriver);
        packagesForLetter.setTestPackage();
        checks.setEmail();
        checks.setText();
        checks.setTheme();

        System.out.println("Выйти из учётной записи");
        authPage.setLogOut();
    }

    @Test
    public void Task3(){

        System.out.println("Проверка успешности авторизации");
        var authPage = new AuthPage(webDriver);
        authPage.open();
        authPage.setFillLogin();
        authPage.setFillContinue();
        Assertions.assertThat(webDriver.getTitle())
                  .isEqualTo("Вход – Google Аккаунты");
        webDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        authPage.setFillPassword();
        webDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        authPage.setContinueAuthorization();
        Assertions.assertThat(webDriver.findElement(By.cssSelector(".g3lg0e")).isEnabled());

        System.out.println("Создать новое письмо (заполнить адресата, тему письма и тело)");
        var createLetter = new CreateLetter(webDriver);
        createLetter.open();
        createLetter.newMessage();
        createLetter.fillTheme();
        createLetter.choiceAddress();
        createLetter.choiceTo();
        createLetter.fillTestAddress();
        createLetter.textOfLetter();

        System.out.println("Отправление письма");
        createLetter.sendLetter();

        System.out.println("Письмо появилось в папке Входящие");
        var packagesForLetter = new PackagesForLetter(webDriver);
        var checks = new Checks(webDriver);
        packagesForLetter.setIncomingLetters();
        webDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        checks.setText();

        System.out.println("Проверяем что контент, адресата и тему письма");
        checks.setText();
        checks.setEmail();
        checks.setTheme();

        System.out.println("Удалить письмо");
        var deleteLetter = new DeleteLetter(webDriver);
        deleteLetter.setSelectLetters();
        deleteLetter.setDelete();

        System.out.println("Письмо появилось в папке Корзина");
        packagesForLetter.setToBasket();
        packagesForLetter.setBasket();
        checks.setText();

        System.out.println("Выйти из учётной записи");
        authPage.setLogOut();
    }

    @AfterMethod
    public void tearDown(){
        webDriver.quit();
    }
}
