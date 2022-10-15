package ru.levelp.at.homework3.hooks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import ru.levelp.at.homework3.LuckyTicket;


public class NegativeLuckyTicketTest {

    private static final String INPUT = String.valueOf("123006");
    private static final String EMPTY_INPUT = String.valueOf(null);
    private static final String EXPECTED_OUTPUT = String.valueOf("true");

    private ru.levelp.at.homework3.LuckyTicket luckyTicket = new LuckyTicket();

    @BeforeClass
    public void beforeClass() {
        System.out.println("before class");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("before method");
        LuckyTicket luckyTicket = new LuckyTicket();
    }

    @Test
    public void positiveTestForLuckyTicket() {
        System.out.println("positiveTestForLuckyTicket");

        String actualOutput;
        if (LuckyTicket.isMyTicketLucky(Integer.parseInt(new String(INPUT)))) {
            actualOutput = String.valueOf(true);
        } else {
            actualOutput = String.valueOf(false);

            Assertions.assertEquals(EXPECTED_OUTPUT, actualOutput);
        }
    }

    @Test
    public void emptyInputTest() {
        System.out.println("EmptyInputTest");

        String actualResult;

        if (LuckyTicket.isMyTicketLucky(Integer.parseInt(new String(EMPTY_INPUT)))) {
            actualResult = String.valueOf(true);
        } else {
            actualResult = String.valueOf(false);

            Assertions.assertTrue(actualResult.isEmpty());
        }
    }

    @Test
    public void nullInputTest() {
        System.out.println("NullInputTest");

        String actualOutput;

        if (LuckyTicket.isMyTicketLucky(Integer.parseInt(new String((String) null)))) {
            actualOutput = String.valueOf(true);
        } else {
            actualOutput = String.valueOf(false);

            Assertions.assertTrue(actualOutput.isEmpty());
        }
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("afterMethod");
        luckyTicket = null;
    }

    @AfterClass
    public void afterClass() {
        System.out.println("after class");
    }
}



