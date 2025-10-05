package org.lecture;

import org.lecture.ticket.Ticket;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter ticket number:");
        String inputTicketNumber = scanner.nextLine();

        Ticket ticket = new Ticket(inputTicketNumber);

        ticket.payTicket();
        ticket.validateTicket();
        ticket.closeTicket();

        ticket.printStatus();

        ticket.cancelTicket();
    }
}
