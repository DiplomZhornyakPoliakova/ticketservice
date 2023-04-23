package ua.nure.bachelor.ticktrip.domain.ticket;

import io.micronaut.data.jpa.repository.JpaRepository;
import ua.nure.bachelor.ticktrip.domain.ticket.model.Seat;
import java.util.UUID;

public interface SeatRepository extends JpaRepository<Seat, UUID> {
}
