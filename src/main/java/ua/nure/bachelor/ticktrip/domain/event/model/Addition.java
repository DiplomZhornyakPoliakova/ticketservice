package ua.nure.bachelor.ticktrip.domain.event.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Entity
@Table(name = "addition")
@Getter
@Setter
@NoArgsConstructor
public class Addition {

    @Id
    @NotNull
    private String name;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "eventID")
    private Event event;
}
