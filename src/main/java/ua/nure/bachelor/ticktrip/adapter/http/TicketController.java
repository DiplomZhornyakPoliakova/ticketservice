package ua.nure.bachelor.ticktrip.adapter.http;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import ua.nure.bachelor.ticktrip.domain.ticket.TicketRepository;
import ua.nure.bachelor.ticktrip.domain.ticket.model.Ticket;

import java.util.List;
import java.util.UUID;

@Controller("tickets")
public class TicketController {

    private final TicketRepository ticketRepository;

    public TicketController(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    @Get("/event={eventId}")
    public List<Ticket> findTicketsByEventId(UUID eventId) {

        var res = ticketRepository.findByEventId(eventId);
        return res;
    }

    @Get("/user={userId}")
    public List<Ticket> findTicketsByUserId(String userId) {

        return ticketRepository.findByUserId(userId);
    }
}
