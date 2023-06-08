package ua.nure.bachelor.ticktrip.domain.event;

import io.micronaut.data.jpa.repository.JpaRepository;
import ua.nure.bachelor.ticktrip.domain.event.model.Event;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface EventRepository extends JpaRepository<Event, UUID> {

    List<Event> findAll();

    Optional<Event> findById(UUID id);

}
