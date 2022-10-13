package ru.levelp.at.homework3;

public class luckyTicket {
    public String isMyTicketLucky;

    static boolean isMyTicketLucky(int ticketNumber) {

        int number1 = ticketNumber / 100000;
        int number2 = (ticketNumber / 10000) % 10;
        int number3 = (ticketNumber / 1000) % 10;
        int number4 = (ticketNumber / 100) % 10;
        int number5 = (ticketNumber / 10) % 10;
        int number6 = ticketNumber % 10;

        return number1 + number2 + number3 == number4 + number5 + number6;
    }

    public static void main(String[] args) {
        //isMyTicketLucky("123006");
        System.out.println(isMyTicketLucky(Integer.parseInt("123006")));
        System.out.println(isMyTicketLucky(Integer.parseInt("555599")));
    }
}
