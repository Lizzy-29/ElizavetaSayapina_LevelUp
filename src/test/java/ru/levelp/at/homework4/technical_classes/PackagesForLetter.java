package ru.levelp.at.homework4.technical_classes;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PackagesForLetter {

    private WebDriver driver;
    private final WebDriverWait wait;

    @FindBy(xpath ="//*[contains(text(),'Отправленные')]")
    private WebElement sentLetters;

    @FindBy(xpath ="//*[contains(text(),'Test_Test_Test')]")
    private WebElement checkSentTestLetter;

    @FindBy(xpath ="//*[contains(text(),'Черновики')]")
    private WebElement drafts;

    @FindBy(xpath ="//*[contains(text(),'Нет сохраненных черновиков.')]")
    private WebElement emptyDrafts;

    @FindBy(xpath ="//*[contains(text(),'TEST')]")
    private WebElement testPackage;

    @FindBy(xpath ="//*[contains(text(),'Входящие')]")
    private WebElement incomingLetters;

    @FindBy(xpath ="//span[@role=\"button\"]")
    private WebElement toBasket;

    @FindBy(xpath ="//a[contains(text(),'Корзина')]")
    private WebElement basket;

    public PackagesForLetter(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofMillis(10000));
        PageFactory.initElements(driver, this);
    }

    public void setSentLetters(){
        wait.until(ExpectedConditions.elementToBeClickable(sentLetters)).click();
    }

    public void setCheckSentTestLetter(){
        driver.findElement(By.xpath("//*[contains(text(),'Test_Test_Test')]"))
                 .isDisplayed();
    }

    public void setDrafts(){
        wait.until(ExpectedConditions.elementToBeClickable(drafts)).click();
    }

    public void setEmptyDrafts(){
        driver.findElement(By.xpath("//*[contains(text(),'Нет сохраненных черновиков.')]"))
                 .isDisplayed();
    }

    public void setTestPackage(){
        wait.until(ExpectedConditions.elementToBeClickable(testPackage)).click();
    }

    public void setIncomingLetters(){
        driver.findElement(By.xpath("//*[contains(text(),'Входящие')]"))
                 .isDisplayed();
    }

    public void setToBasket(){
        wait.until(ExpectedConditions.elementToBeClickable(toBasket)).click();
    }

    public void setBasket(){
        wait.until(ExpectedConditions.elementToBeClickable(basket)).click();
    }
}
