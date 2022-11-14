package ru.levelp.at.homework4.technical_classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DeleteLetter {

    private static final String Email_BOX = "https://mail.google.com/mail/u/0/#inbox";

    private WebDriver driver;
    private final WebDriverWait wait;

    @FindBy(xpath = "//div//div//div//div//div//div//div//div//div//div[@data-tooltip=\"Выбрать\"]//span")
    private WebElement selectLetters;

    @FindBy(xpath ="//body/div[7]/div[3]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]")
    private WebElement delete;

    public DeleteLetter(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofMillis(10000));
        PageFactory.initElements(driver, this);
    }

    public void setSelectLetters(){
        wait.until(ExpectedConditions.elementToBeClickable(selectLetters)).click();
    }

    public void setDelete(){
        wait.until(ExpectedConditions.elementToBeClickable(delete)).click();
    }

}
