package ua.nure.bachelor.ticktrip.domain.ticket.impl;

import ua.nure.bachelor.ticktrip.domain.ticket.TicketRepository;
import ua.nure.bachelor.ticktrip.domain.ticket.model.Ticket;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class TicketService {

    private final TicketRepository ticketRepository;

    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    private List<Ticket> getAllTickets() {

        return ticketRepository.findAll();
    }

    private Optional<Ticket> findById(UUID ticketId) {

        return ticketRepository.findById(ticketId);
    }

    private void deleteAll() {

        ticketRepository.deleteAll();
    }

    private void deleteById(UUID ticketId) {

        ticketRepository.deleteById(ticketId);
    }


}
