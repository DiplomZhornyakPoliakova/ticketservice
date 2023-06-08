package ua.nure.bachelor.ticktrip.domain.event.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.nure.bachelor.ticktrip.domain.seat.model.Seat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "event")
@Getter
@Setter
@NoArgsConstructor
public class Event {

    @Id
    @NotNull
    private UUID id;

    private String title;

    private String description;

    private String venue;

    private String city;

    private String photo;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    private Integer numberOfTickets;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "type_name")
    private EventType typeName;

    @JsonIgnore
    @OneToMany(mappedBy = "event")
    private Set<Addition> additions = new HashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy = "event")
    private Set<Seat> seats = new HashSet<>();
}
