package ru.levelp.at.homework3.hooks;

import org.assertj.core.api.Assertions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
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
    public void emptyInputTest() {
        System.out.println("EmptyInputTest");

        String actualResult;

        if (LuckyTicket.isMyTicketLucky(Integer.parseInt(new String(EMPTY_INPUT)))) {
            actualResult = String.valueOf(true);
        } else {
            actualResult = String.valueOf(false);

            Assertions.assertThat(actualResult.isEmpty());
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

            Assertions.assertThat(actualOutput.isEmpty());
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


