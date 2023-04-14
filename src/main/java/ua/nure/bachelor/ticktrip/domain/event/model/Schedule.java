package ua.nure.bachelor.ticktrip.domain.event.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Entity
@Table(name = "event_schedule")
@Getter
@Setter
@NoArgsConstructor
public class Schedule {

    @Id
    @NotNull
    private UUID id;

    private Integer startTime;

    private Integer endTime;

}
