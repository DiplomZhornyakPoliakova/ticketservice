package ua.nure.bachelor.ticktrip.adapter.db.ticket;

import io.micronaut.data.annotation.Repository;
import io.micronaut.transaction.annotation.ReadOnly;
import ua.nure.bachelor.ticktrip.domain.ticket.TicketRepository;
import ua.nure.bachelor.ticktrip.domain.ticket.model.Ticket;

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
}
