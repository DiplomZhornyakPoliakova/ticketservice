package ua.nure.bachelor.ticktrip.adapter.db.seat;

import io.micronaut.data.annotation.Repository;
import ua.nure.bachelor.ticktrip.domain.seat.SeatRepository;
import javax.persistence.EntityManager;

@Repository
public abstract class PostgresSeatRepository implements SeatRepository {

    private final EntityManager entityManager;

    protected PostgresSeatRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }



}
