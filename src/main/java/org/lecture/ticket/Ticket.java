package org.lecture.ticket;

public class Ticket {
    /**
     * A unique identifier for each ticket. Stored in upper case.
     * Can't be changed after creating the object.
     */
    final String ticketNumber;
    /**
     * The current status of the ticket.
     */
    TicketStatus ticketStatus;


    /**
     * Constructor for an instance of Ticket class.
     * Sets ticketStatus to ISSUED.
     *
     * @param ticketNumber Input -> any combination of characters & numbers allowed.
     */

    public Ticket(String ticketNumber) {
        this.ticketNumber = ticketNumber.toUpperCase();
        this.ticketStatus = TicketStatus.ISSUED;
        System.out.printf("Ticket (%s) has been issued.\n", this.ticketNumber);
    }

    /**
     * Changes the ticketStatus from ISSUED -> PAID. Only allowed if current ticketStatus is ISSUED.
     *
     */
    public void payTicket() {
        if (this.ticketStatus == TicketStatus.ISSUED) {
            this.ticketStatus = TicketStatus.PAID;
            System.out.printf("Ticket (%s) has been paid.\n", this.ticketNumber);
        } else if (this.ticketStatus == TicketStatus.PAID) {
            System.out.printf("Ticket (%s) has been already been paid. We still take donations?\n", this.ticketNumber);
        } else if (this.ticketStatus == TicketStatus.CLOSED || this.ticketStatus == TicketStatus.CANCELLED) {
            System.out.printf("Ticket (%s) has already been closed / canceled. Please issue a new ticket.\n", this.ticketNumber);
        } else if (this.ticketStatus == TicketStatus.VALIDATED) {
            System.out.printf("Ticket (%s) already has been validated. Please issue a new ticket.\n", this.ticketNumber);
        }
    }

    /**
     * Changes the status from PAID -> VALIDATED. Only allowed if current status is PAID.
     */
    public void validateTicket() {
        if (this.ticketStatus == TicketStatus.PAID) {
            this.ticketStatus = TicketStatus.VALIDATED;
            System.out.printf("Ticket (%s) was successfully validated.\n", this.ticketNumber);
        } else if (this.ticketStatus == TicketStatus.ISSUED) {
            System.out.printf("Ticket (%s) has not been paid yet. 💸", this.ticketNumber);
        } else if (this.ticketStatus == TicketStatus.CLOSED || this.ticketStatus == TicketStatus.CANCELLED) {
            System.out.printf("Ticket (%s) has already been closed / canceled. Please issue a new ticket.\n", this.ticketNumber);
        } else if (this.ticketStatus == TicketStatus.VALIDATED) {
            System.out.printf("Ticket (%s) already has been validated. Please issue a new ticket.\n", this.ticketNumber);
        }
    }

    /**
     * Changes the status from VALIDATED -> CLOSED. Only allowed if current status is VALIDATED.
     */
    public void closeTicket() {
        if (this.ticketStatus == TicketStatus.VALIDATED) {
            this.ticketStatus = TicketStatus.CLOSED;
            System.out.printf("Ticket (%s) was successfully closed.", this.ticketNumber);
        } else if (this.ticketStatus == TicketStatus.CLOSED || this.ticketStatus == TicketStatus.CANCELLED) {
            System.out.printf("Ticket (%s) is already closed / cancelled. Please issue a new ticket.\n", this.ticketNumber);
        } else if (this.ticketStatus == TicketStatus.PAID) {
            System.out.printf("Ticket (%s) has been paid but not yet validated. Please validate your ticket in order to continue.\n", this.ticketNumber);
        } else if (this.ticketStatus == TicketStatus.ISSUED) {
            System.out.printf("Ticket (%s) has has not been paid yet. Please pay & validate your ticket first in order to continue.\n", this.ticketNumber);
        }
    }

    /**
     * Changes the status to CANCELLED. Only allowed if current status is ISSUED.
     */
    public void cancelTicket() {
        if (this.ticketStatus == TicketStatus.ISSUED) {
            this.ticketStatus = TicketStatus.CANCELLED;
            System.out.printf("Ticket (%s) was successfully cancelled.", this.ticketNumber);
        } else if (this.ticketStatus == TicketStatus.PAID) {
            System.out.printf("Ticket (%s) has already been paid and can not be canceled at this point. Please continue with validation at the exit gate.\n", this.ticketNumber);
        } else if (this.ticketStatus == TicketStatus.VALIDATED || this.ticketStatus == TicketStatus.CANCELLED || this.ticketStatus == TicketStatus.CLOSED) {
            System.out.printf("Ticket (%s) has already been closed / canceled / validated. Please issue a new ticket.\n", this.ticketNumber);
        }
    }

    /**
     * Displays the current status of the ticket.
     */
    public void printStatus() {
        System.out.printf("Ticket Status for '%s' is '%s'.\n", ticketNumber, ticketStatus);
    }


}
