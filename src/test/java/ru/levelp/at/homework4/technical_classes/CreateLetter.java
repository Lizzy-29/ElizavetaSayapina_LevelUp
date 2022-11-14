package ru.levelp.at.homework4.technical_classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CreateLetter {

    private static final String Email_BOX = "https://mail.google.com/mail/u/0/#inbox";

    private WebDriver driver;
    private final WebDriverWait wait;

    @FindBy(xpath = "//*[text()=\"Написать\"]")
    private WebElement newMessage;

    @FindBy(xpath ="//input[@aria-label='Тема']")
    private WebElement fillTheme;

    @FindBy(xpath ="//*[contains(text(),'Получатели')]")
    private WebElement choiceAddress;

    @FindBy(xpath ="//*[contains(text(),'Кому')]")
    private WebElement choiceTo;

    @FindBy(xpath ="//input[@aria-autocomplete=\"list\"]")
    private WebElement fillAddress;

    @FindBy(xpath ="//div[@aria-label=\"Текст письма\"]")
    private WebElement textOfLetter;

    @FindBy(xpath ="//span[contains(text(),'Черновик сохранен')]")
    private WebElement draft;

    @FindBy(xpath ="//tr//td//div//div[contains(text(),\"Отправить\")]")
    private WebElement sendLetter;


    public CreateLetter(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofMillis(10000));
        PageFactory.initElements(driver, this);
    }

    public void open(){
        driver.navigate().to(Email_BOX);
    }

    public void newMessage(){
        wait.until(ExpectedConditions.visibilityOf(newMessage)).click();
    }

    public void fillTheme(){
        wait.until(ExpectedConditions.elementToBeClickable(fillTheme)).sendKeys("Test");
    }

    public void choiceAddress(){
        wait.until(ExpectedConditions.visibilityOf(choiceAddress)).click();
    }

    public void choiceTo (){
        wait.until(ExpectedConditions.visibilityOf(choiceTo)).isDisplayed();
    }

    public void fillAddress (){
        wait.until(ExpectedConditions.visibilityOf(fillAddress)).sendKeys("njanke-vensen@rambler.ru");
    }

    public void fillTestAddress (){
        wait.until(ExpectedConditions.visibilityOf(fillAddress)).sendKeys("litavond78@gmail.com");
    }

    public void textOfLetter (){
        wait.until(ExpectedConditions.visibilityOf(textOfLetter)).sendKeys(" Test_Test_Test");
    }

    public void draft (){
        wait.until(ExpectedConditions.visibilityOf(draft)).isDisplayed();
    }

    public void sendLetter(){
        wait.until(ExpectedConditions.elementToBeClickable(sendLetter)).click();
    }
}
