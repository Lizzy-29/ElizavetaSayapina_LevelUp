package ru.levelp.at.homework2.hooks;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import ru.levelp.at.homework2.LuckyTicket;

public abstract class BaseLuckyTicketTest {

    protected ru.levelp.at.homework2.LuckyTicket luckyTicket = new LuckyTicket();

    @BeforeClass
    public void beforeClass() {
        System.out.println(this.getClass().getName() + "before class");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println(this.getClass().getName() + "before method");
        LuckyTicket luckyTicket = new LuckyTicket();
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println(this.getClass().getName() + "afterMethod");
        luckyTicket = null;
    }

    @AfterClass
    public void afterClass() {
        System.out.println(this.getClass().getName() + "after class");
    }
}

