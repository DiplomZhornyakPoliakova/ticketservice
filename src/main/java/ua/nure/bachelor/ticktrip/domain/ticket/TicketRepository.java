package ua.nure.bachelor.ticktrip.domain.ticket;

import io.micronaut.data.jpa.repository.JpaRepository;
import ua.nure.bachelor.ticktrip.domain.ticket.model.Ticket;
import java.util.List;
import java.util.UUID;

public interface TicketRepository extends JpaRepository<Ticket, UUID> {

    @SuppressWarnings("MicronautDataMethodInconsistency")
    List<Ticket> findByEventId(UUID eventId);

    List<Ticket> findByUserId(String userId);

}
