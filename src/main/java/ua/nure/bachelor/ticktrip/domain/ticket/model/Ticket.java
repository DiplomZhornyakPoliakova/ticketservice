package ua.nure.bachelor.ticktrip.domain.ticket.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.nure.bachelor.ticktrip.domain.seat.model.Seat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "ticket")
@Getter
@Setter
@NoArgsConstructor
public class Ticket {

    @Id
    @NotNull
    private UUID id;

    private String userId;

    private LocalDateTime transactionDateTime;

    @Enumerated(EnumType.STRING)
    private TicketState state;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "sitting_id")
    private Seat seat;

}
