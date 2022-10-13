package ru.levelp.at.homework3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LuckyTicketTest {

    private static final String INPUT = String.valueOf("123006");
    private static final String EMPTY_INPUT = String.valueOf(null);
    private static final String EXPECTED_OUTPUT = String.valueOf("true");

    @Test
    public void positiveTestForLuckyTicket() {
        luckyTicket luckyTicket = new luckyTicket();

        String ACTUAL_OUTPUT;
        if (luckyTicket.isMyTicketLucky(Integer.parseInt(new String(INPUT)))) {
            ACTUAL_OUTPUT = String.valueOf(true);
        } else {
            ACTUAL_OUTPUT = String.valueOf(false);

            Assertions.assertEquals(EXPECTED_OUTPUT,ACTUAL_OUTPUT);
        }
    }

    @Test
    public void EmptyInputTest(){
        luckyTicket luckyTicket = new luckyTicket();
        String ACTUAL_RESULT;

        if (luckyTicket.isMyTicketLucky(Integer.parseInt(new String(EMPTY_INPUT)))) {
            ACTUAL_RESULT = String.valueOf(true);
        } else {
            ACTUAL_RESULT = String.valueOf(false);

            Assertions.assertTrue(ACTUAL_RESULT.isEmpty());
        }
    }

    @Test
    public void NullInputTest(){
        luckyTicket luckyTicket = new luckyTicket();
        String ACTUAL_RESULT;

        if (luckyTicket.isMyTicketLucky(Integer.parseInt(new String((String) null)))) {
            ACTUAL_RESULT = String.valueOf(true);
        } else {
            ACTUAL_RESULT = String.valueOf(false);

            Assertions.assertTrue(ACTUAL_RESULT.isEmpty());
        }
    }
}



