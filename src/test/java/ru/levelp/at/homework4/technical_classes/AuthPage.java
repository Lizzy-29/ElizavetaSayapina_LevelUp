package ru.levelp.at.homework4.technical_classes;

import java.time.Duration;
import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AuthPage {
    Faker faker = new Faker();
    String email = faker.internet().emailAddress();
    String password = faker.internet().password();

    private static final String Email_URL = "https://accounts.google.com/";
    private static final String LogOut = "https://accounts.google.com/Logout?hl=ru&continue=https://mail.google.com&service=mail&timeStmp=1667864634&secTok=.AG5fkS9ikXFc0LMIHjNNRqCGLp-tvCK4Cg&ec=GAdAFw&hl=ru";

    private WebDriver driver;
    private final WebDriverWait wait;

    @FindBy(id ="identifierId")
    private WebElement loginTextField;

    @FindBy(css ="button.VfPpkd-LgbsSe.VfPpkd-LgbsSe-OWXEXe-k8QpJ.VfPpkd-LgbsSe-OWXEXe-dgl2Hf.nCP5yc.AjY5Oe.DuMIQc.LQeN7.qIypjc.TrZEUc.lw1w4b")
    private WebElement continueButton;

    @FindBy(name ="Passwd")
    private WebElement passwordTextField;

    @FindBy(xpath ="//*[@id='passwordNext']/div/button")
    private WebElement ContinueAuthorization;

    @FindBy(css ="\".g3lg0e\"")
    private WebElement getTitlePageAfterLogin;

    public AuthPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofMillis(10000));
        PageFactory.initElements(driver, this);

    }

    public void open(){
        driver.navigate().to(Email_URL);
    }

    public void setFillLogin(){
        wait.until(ExpectedConditions.visibilityOf(loginTextField)).sendKeys("litavond78@gmail.com");
    }

    public void setFillContinue(){
        wait.until(ExpectedConditions.elementToBeClickable(continueButton)).click();
    }

    public void setFillPassword(){
        wait.until(ExpectedConditions.visibilityOf(passwordTextField)).sendKeys("Lita7878");
    }

    public void setContinueAuthorization (){
        wait.until(ExpectedConditions.visibilityOf(ContinueAuthorization)).click();
    }

    public void setLogOut (){
        driver.navigate().to(LogOut);
    }

    public void getTitlePageAfterLogin (){
        wait.until(ExpectedConditions.titleContains(""));
    }
}
