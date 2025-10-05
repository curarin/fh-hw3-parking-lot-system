package org.lecture;

import org.lecture.ticket.Ticket;

import java.util.Scanner;

public class InvalidBehaviour1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter ticket number:");
        String inputTicketNumber = scanner.nextLine();

        Ticket ticket = new Ticket(inputTicketNumber);

        /*
        We are testing invalid behavior as follows:
        - Canceling after Paying
         */
        ticket.payTicket();
        ticket.cancelTicket();
    }
}
