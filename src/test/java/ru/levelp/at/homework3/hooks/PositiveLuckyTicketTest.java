package ru.levelp.at.homework3.hooks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.levelp.at.homework3.LuckyTicket;

public class PositiveLuckyTicketTest extends BaseLuckyTicketTest {

    private static final String INPUT = String.valueOf("123006");
    private static final String WRONG_INPUT = String.valueOf("346279");
    private static final String EMPTY_INPUT = String.valueOf(null);
    private static final String EXPECTED_OUTPUT = String.valueOf("true");

    private ru.levelp.at.homework3.LuckyTicket luckyTicket = new LuckyTicket();

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
}




