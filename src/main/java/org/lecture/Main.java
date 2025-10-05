package org.lecture;

import org.lecture.ticket.Ticket;

import java.util.Scanner;

public class Main {
    /*
    - Contains the main method to test the functionality of the Ticket class

    Steps:
    - Ask the user for a ticket number & create a new Ticket instance
    - Progress the ticket through its lifecycle:
        - Pay the ticket (payTicket)
        - Validate the ticket (validateTicket)
        - Close the ticket (closeTicket)
     - After closing, call printStatus() to show the final state
     - Attempt to cancel the ticket after it has been closed to demonstrate invalid transitions
     - Observe printed messages to ensure logic is enforced
     */
    public static void main(String[] args) {
        String menu = """
                Please enter your ticket number below:
                """;
        System.out.println(menu);
        Scanner scanner = new Scanner(System.in);
        String inputTicketNumber = scanner.nextLine();
        Ticket ticket = new Ticket(inputTicketNumber);
        ticket.printStatus();
        ticket.closeTicket();
        ticket.payTicket();
        ticket.validateTicket();
        ticket.closeTicket();
    }
}
