package ua.nure.bachelor.ticktrip.domain.ticket.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.nure.bachelor.ticktrip.domain.event.model.Event;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "sitting")
@Getter
@Setter
@NoArgsConstructor
public class Seat {

    @Id
    @NotNull
    private UUID id;

    private Integer indexInEvent;

    private Double price;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "eventID", referencedColumnName = "id")
    private Event event;

    @JsonIgnore
    @OneToMany(mappedBy = "seat")
    private Set<Ticket> tickets = new HashSet<>();
}
