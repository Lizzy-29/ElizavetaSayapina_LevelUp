package ru.levelp.at.homework3.hooks;

import static ru.levelp.at.homework3.LuckyTicket.isMyTicketLucky;

import org.assertj.core.api.Assertions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.levelp.at.homework3.LuckyTicket;

public class NegativeLuckyTicketTest {

    private static final String INPUT = (null);
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
    public void nullInputTest() {
        System.out.println("NullInputTest");

        Throwable throwable = Assertions.catchThrowable(
            () -> isMyTicketLucky(null)
        );
        Assertions.assertThat(throwable.getClass()).isEqualTo(IllegalArgumentException.class);

    }

}


