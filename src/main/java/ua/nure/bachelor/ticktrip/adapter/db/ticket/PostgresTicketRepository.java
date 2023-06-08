package ua.nure.bachelor.ticktrip.adapter.db.ticket;

import io.micronaut.data.annotation.Repository;
import io.micronaut.transaction.annotation.ReadOnly;
import ua.nure.bachelor.ticktrip.domain.ticket.TicketRepository;
import ua.nure.bachelor.ticktrip.domain.ticket.model.Ticket;
import ua.nure.bachelor.ticktrip.domain.ticket.model.TicketState;
import javax.persistence.EntityManager;
import java.util.List;
import java.util.UUID;

@Repository
public abstract class PostgresTicketRepository implements TicketRepository {

    private final EntityManager entityManager;

    protected PostgresTicketRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @ReadOnly
    @SuppressWarnings("MicronautDataMethodInconsistency")
    public List<Ticket> findByEventId(UUID eventId) {

        String queryString = """
                FROM Ticket t
                WHERE t.seat.event.id = :eventId
                """;

        return entityManager
                .createQuery(queryString, Ticket.class)
                .setParameter("eventId", eventId)
                .getResultList();
    }

    @Override
    @ReadOnly
    public Long countSeatsInSoldTickets(UUID eventId) {

        TicketState booked = TicketState.booked;
        TicketState bought = TicketState.bought;

        String queryString = """
                SELECT COUNT (t)
                FROM Ticket t
                WHERE t.seat.event.id = :eventId
                AND t.state = :booked OR t.state = :bought
                """;

        return entityManager
                .createQuery(queryString, Long.class)
                .setParameter("eventId", eventId)
                .setParameter("booked", booked)
                .setParameter("bought", bought)
                .getSingleResult();
    }
}
