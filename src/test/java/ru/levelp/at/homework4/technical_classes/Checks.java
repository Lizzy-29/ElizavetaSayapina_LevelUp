package ru.levelp.at.homework4.technical_classes;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Checks {

    private static final String Email_BOX = "https://mail.google.com/mail/u/0/#inbox";

    private WebDriver driver;
    private final WebDriverWait wait;

    @FindBy(xpath = "//*[contains(text(),'njanke-vensen@rambler.ru')]")
    private WebElement email;

    @FindBy(xpath = "//*[contains(text(),'litavond78@gmail.com')]")
    private WebElement testEmail;

    @FindBy(xpath ="//*[contains(text(),'Test')]")
    private WebElement theme;

    @FindBy(xpath ="//*[contains(text(),'Test_Test_Test')]")
    private WebElement text;


    public Checks (WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofMillis(10000));
        PageFactory.initElements(driver, this);
    }

    public void setEmail (){
        driver.findElement(By.xpath("//*[contains(text(),'litavond78@gmail.com')]"))
                 .isDisplayed();
    }

    public void setTestEmail (){
        driver.findElement(By.xpath("//*[contains(text(),'njanke-vensen@rambler.ru')]"))
              .isDisplayed();
    }

    public void setTheme(){
        driver.findElement(By.xpath("//*[contains(text(),'Test')]"))
                 .isDisplayed();
    }

    public void setText(){
        driver.findElement(By.xpath("//*[contains(text(),'Test_Test_Test')]"))
                 .isDisplayed();
    }

}
