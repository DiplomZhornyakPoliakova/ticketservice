package ua.nure.bachelor.ticktrip.domain.seat;

import io.micronaut.data.jpa.repository.JpaRepository;
import ua.nure.bachelor.ticktrip.domain.seat.model.Seat;

import java.util.Optional;
import java.util.UUID;

public interface SeatRepository extends JpaRepository<Seat, UUID> {

    Optional<Seat> findByEvent_eventIdAndIndexInEvent(UUID eventId, Integer indexInEvent);

}
