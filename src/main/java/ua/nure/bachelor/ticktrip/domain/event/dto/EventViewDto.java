package ua.nure.bachelor.ticktrip.domain.event.dto;

import lombok.Data;
import ua.nure.bachelor.ticktrip.domain.event.model.Addition;
import ua.nure.bachelor.ticktrip.domain.event.model.EventType;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Data
public class EventViewDto {

    private UUID id;

    private String title;

    private String description;

    private String venue;

    private String photo;

    private EventType typeName;

    private Set<Addition> additions = new HashSet<>();

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    private Double price;

}
