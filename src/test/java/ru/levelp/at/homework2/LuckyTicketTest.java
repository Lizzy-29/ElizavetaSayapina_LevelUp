package ru.levelp.at.homework2;

import org.assertj.core.api.Assertions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LuckyTicketTest {

    public static  String INPUT = String.valueOf("123006");
    public static final String WRONG_INPUT = String.valueOf("346279");
    public static final String EXPECTED_OUTPUT = String.valueOf("true");

    public LuckyTicket luckyTicket = new LuckyTicket();

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

            Assertions.assertThat(actualOutput).isEqualTo(EXPECTED_OUTPUT);
        }
    }

    @Test
    public void positiveTest2ForLuckyTicket() {
        System.out.println("positiveTest2ForLuckyTicket");
        String actualOutput;

        if (LuckyTicket.isMyTicketLucky(Integer.parseInt(new String(INPUT)))) {
            actualOutput = String.valueOf(true);
        } else {
            actualOutput = String.valueOf(false);

            Assertions.assertThat(actualOutput).isNotEqualTo(EXPECTED_OUTPUT);
        }
    }

}
