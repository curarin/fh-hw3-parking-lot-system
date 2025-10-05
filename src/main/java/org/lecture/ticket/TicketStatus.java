package org.lecture.ticket;

/**
Represents the possible States of a parking ticket.
- ISSUED: The ticket has been created but not yet paid.
- PAID: The ticket has been paid, but not validated at the gate.
- VALIDATED: The ticket has been validated at the exit gate.
- CANCELLED: The ticket has been cancelled (only possible if still ISSUED)
 */
public enum TicketStatus {
    /**
     * The ticket has been created but not yet paid.
     */
    ISSUED,
    /**
     * The ticket has been paid, but not validated at the game.
     */
    PAID,
    /**
     * The ticket has been validated at the exit gate.
     */
    VALIDATED,
    /**
     * The ticket has been closed after exit.
     */
    CLOSED,
    /**
     * The ticket has been cancelled -> only possible if still ISSUED.
     */
    CANCELLED
}
