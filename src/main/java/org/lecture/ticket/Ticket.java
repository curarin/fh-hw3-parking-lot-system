package org.lecture.ticket;

public class Ticket {
    /**
     * A unique identifier for each ticket. Stored in upper case.
     * Can't be changed after creating the object.
     */
    private final String ticketNumber;
    /**
     * The current status of the ticket.
     */
    private TicketStatus ticketStatus;


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
            System.out.printf("Ticket (%s) has been already been paid (current status: %s). We still take donations?\n", this.ticketNumber, this.ticketStatus);
        } else if (this.ticketStatus == TicketStatus.CLOSED || this.ticketStatus == TicketStatus.CANCELLED) {
            System.out.printf("Ticket (%s) has already been closed / canceled (current status: %s). Please issue a new ticket.\n", this.ticketNumber, this.ticketStatus);
        } else if (this.ticketStatus == TicketStatus.VALIDATED) {
            System.out.printf("Ticket (%s) already has been validated (current status: %s). Please issue a new ticket.\n", this.ticketNumber, this.ticketStatus);
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
            System.out.printf("Ticket (%s) has not been paid yet (current status: %s). 💸\n", this.ticketNumber, this.ticketStatus);
        } else if (this.ticketStatus == TicketStatus.CLOSED || this.ticketStatus == TicketStatus.CANCELLED) {
            System.out.printf("Ticket (%s) has already been closed / canceled (current status: %s). Please issue a new ticket.\n", this.ticketNumber, this.ticketStatus);
        } else if (this.ticketStatus == TicketStatus.VALIDATED) {
            System.out.printf("Ticket (%s) already has been validated (current status: %s). Please issue a new ticket.\n", this.ticketNumber, this.ticketStatus);
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
            System.out.printf("Ticket (%s) is already closed / cancelled (current status: %s). Please issue a new ticket.\n", this.ticketNumber, this.ticketStatus);
        } else if (this.ticketStatus == TicketStatus.PAID) {
            System.out.printf("Ticket (%s) has been paid but not yet validated (current status: %s). Please validate your ticket in order to continue.\n", this.ticketNumber, this.ticketStatus);
        } else if (this.ticketStatus == TicketStatus.ISSUED) {
            System.out.printf("Ticket (%s) has has not been paid yet (current status: %s). Please pay & validate your ticket first in order to continue.\n", this.ticketNumber, this.ticketStatus);
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
            System.out.printf("Ticket (%s) has already been paid and can not be canceled at this point (current status: %s). Please continue with validation at the exit gate.\n", this.ticketNumber, this.ticketStatus);
        } else if (this.ticketStatus == TicketStatus.VALIDATED || this.ticketStatus == TicketStatus.CANCELLED || this.ticketStatus == TicketStatus.CLOSED) {
            System.out.printf("Ticket (%s) has already been closed / canceled / validated (current status: %s). Please issue a new ticket.\n", this.ticketNumber, this.ticketStatus);
        }
    }

    /**
     * Displays the current status of the ticket.
     */
    public void printStatus() {
        System.out.printf("Ticket Status for '%s' is '%s'.\n", ticketNumber, ticketStatus);
    }


}
